/* Homework4
jinsoo park
03/24/2024
credit_Erick Samuel*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h> 

float calc (float operand1, float operand2, char * oper,);

int main(int argc, char ** argv) {
    float operand1, operand2;
    char * oper;
	if (argc !=4)
    {
        printf("Usage: %s operand1 / operand2 / operator\n", argv[0]);
        printf("Legal operators: +,-,*,/\n");
        return 0;
    }
    operand1 = atof (argv[1]);
    operand2 = atof (argv[3]);
    oper = argv[2];
    float result = calc(operand1, operand2, oper);
    printf("%f \n", result );
	return 0;
}

float calc (float operand1, float operand2, char * oper)
{
    float result = 0;
  char op = oper[0];
  switch (op)
  {
   case '+':
     result = operand1 + operand2;
     break;
   case '-':
     result = operand1 - operand2;
     break;
   case '*':
     result = operand1 * operand2;
     break;
   case '/':
     result = operand1 / operand2;
     break;

   default:
    result = INFINITY;

    }
    return result;
}

