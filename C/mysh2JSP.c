/* Homework4
jinsoo park
03/24/2024
credit_Erick Samuel*/


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>



int Tokencount(char * cmdCpy);
void setArgv(char ** argv, char * cmd);
void dump(char ** argv);
int process(char *);
void spacing(char ** argv);

int main(int argc, char * argv[])
{
    char cmd[256];

    printf("Welcome to our shell.\n");

    do
    {
        printf("%% ");
        fgets(cmd, 255, stdin);
        cmd[strlen(cmd)-1] = '\0';


        if(strcmp("exit", cmd)==0)
        {
            printf("Bye!\n");
        } else
        {
            int status = process(cmd);
            if (status == -1)
            {
                printf("Error executing %s\n", cmd);
            }

        }
    } while(strcmp("exit", cmd)!=0);

    return 0;
}

int process( char * cmd)
{
	char ** argv;
	char cmdCpy[256];
	strcpy(cmdCpy, cmd);
	int count = Tokencount(cmdCpy);
    if(count == 0)
        return 0;
    strcpy(cmdCpy, cmd);
	argv = (char **) malloc(sizeof(char *) * (count + 1));
	argv[count] = NULL;
	setArgv(argv, cmdCpy);


     char cmdPath[256];
     char * path;
     if (strcmp(argv[0], "calc")==0){
        path = "./";
     }
     else if (strcmp(argv[0], "factorial2")==0){
        path = "./";
     } else{
         path = "/bin/";
     }

     strcpy(cmdPath, path);
     strcat(cmdPath, argv[0]);
       
        int pid = fork();
        if(pid == 0)
        {
        execv(cmdPath, argv);
        return -1;
        }
        int status = 0;
        wait(&status);

    spacing(argv);
    return 0;
}

void setArgv(char ** argv, char * cmd)
{
	char * token;
	char * s = " ";
    int i = 0;
 
   token = strtok(cmd, s);


   while( token != NULL ) {
      int strlength = strlen(token);
      argv[i] = (char *) malloc(sizeof(char) * strlength + 1);
      strcpy(argv[i], token);
      argv[i][strlength] = '\0';
      token = strtok(NULL, s);
      i++;
   }

}

int Tokencount(char * cmdCpy)
{
	char * token;
	int count = 0;
	char * s = " ";
  
   token = strtok(cmdCpy, s);

 
   while( token != NULL ) {
      count++;

      token = strtok(NULL, s);
   }

   return count;


}

void dump(char ** argv)
{
    int i = 0;
    while(argv[i])
    {
        printf("%s\n", argv[i]);
        i++;
    }
}

void spacing(char ** argv)
{
    int i = 0;
    while(argv[i])
    {
        free(argv[i]);
        i++;
    }
    free(argv);
}


