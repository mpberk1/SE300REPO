public class Genericparts extends Genericdetails{
    String Fuslage;
    String Engine;
    String Empanage;
    String Wing;

    public Genericdetails(String name, String date, String history, String size) {
            super(name, date, history, size);
    }



    public Genericparts(String Fuslage, String Engine, String Empanage, String Wing){

       this.Fuslage = Fuslage;
       this.Engine = Engine;
       this.Empanage = Empanage;
       this.Wing = Wing;

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

   public String getWing() {
    return Wing;
    }

public void setWing(String Wing) {
    this.Wing = Wing;

    }

}
