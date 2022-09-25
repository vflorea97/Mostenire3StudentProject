package ro.mycode.Model;

public class Book {
    private int id;
    private int studentId;
    private String bookName;

    public Book (){
        this.id = 0;
        this.studentId = 0;
        this.bookName = "";
    }

    public Book (int id,int studentId,String bookName){
        this.id = id;
        this.studentId = studentId;
        this.bookName = bookName;
    }

    public Book (String text){
        String [] proprietati = text.split(",");
        this.id = Integer.parseInt(proprietati[0]);
        this.studentId = Integer.parseInt(proprietati[1]);
        this.bookName =proprietati[2];

    }

    public String descriere (){
        String text = "";
        text += "ID: " + id + "\n";
        text += "Student ID: " + studentId + "\n";
        text += "Book name: " + bookName + "\n";
        return text;
    }

    public String toSave (){
        return this.id+","+this.studentId+","+this.bookName;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
