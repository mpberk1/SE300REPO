public class Genericdetails {
    
    private String name;
    private  String date;
    private String history;
    private String size;

public Genericdetails (String name, String date, String history, String size){

    this.name = name;
    this.date = date;
    this.history = history;
    this.size = size;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHistory() {
        return this.history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }





}
