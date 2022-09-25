package ro.mycode.Model;

public class Enrolment {
    private int id;
    private int studentId;
    private int cursId;

    public Enrolment (){
        this.id = 0;
        this.studentId = 0;
        this.cursId = 0;
    }

    public Enrolment (int id,int studentId,int cursId){
        this.id = id;
        this.studentId = studentId;
        this.cursId = cursId;
    }

    public Enrolment (String text){
        String [] proprietati = text.split(",");
        this.id = Integer.parseInt(proprietati[0]);
        this.studentId = Integer.parseInt(proprietati[1]);
        this.cursId = Integer.parseInt(proprietati[2]);
    }

    public String descriere (){
        String text = "";
        text += "ID: " + id + "\n";
        text += "Student ID: " + studentId + "\n";
        text += "Curs ID: " + cursId + "\n";
        return text;
    }

    public String toSave(){
        return this.id+","+this.studentId+","+this.cursId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCursId() {
        return cursId;
    }

    public void setCursId(int cursId) {
        this.cursId = cursId;
    }

}
