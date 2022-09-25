package ro.mycode.Model;

public class Curs {
    private int id;
    private String name;
    private String department;


    public Curs (){
        this.id = 0;
        this.name = "";
        this.department = "";
    }

    public Curs (int id,String name,String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Curs (String text){
        String [] proprietati = text.split(",");
        this.id = Integer.parseInt(proprietati[0]);
        this.name = proprietati[1];
        this.department = proprietati[2];
    }

    public String descriere (){
        String text = "";
        text += "ID: " + id +"\n";
        text += "Name: " + name + "\n";
        text += "Department: " + department + "\n";
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String toSave (){
        return this.id+","+this.name+","+this.department;
    }
}
