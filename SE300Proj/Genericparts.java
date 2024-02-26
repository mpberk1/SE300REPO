public class Genericparts{
     String Fuslage;
     String Engine;
     String Empanage;

     public Genericparts(String Fuslage, String Engine, String Empanage){

        this.Fuslage = Fuslage;
        this.Engine = Engine;
        this.Empanage = Empanage;

     }

    public void details () {
        String name;
        String date;
        String history;
        String size;
        }

    public String getFuslage() {
        return Fuslage;
    }

    public void setFuslage(String Fuslage) {
        this.Fuslage = Fuslage;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String Engine) {
        this.Engine = Engine;
    }

    public String getEmpanage() {
        return Empanage;
    }

    public void setEmpanage(String Empanage) {
        this.Empanage = Empanage;
    }


}