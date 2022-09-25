package ro.mycode.Model.User;

public class User {

    private String tip;
    private int id;
    private String nume;
    private String prenume;
    private String email;
    private String parola;

    public User(String tip, int id, String nume, String prenume, String email, String parola) {
        this.tip = tip;
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
    }

    public User (String text){
        String [] prop = text.split(",");
        this.tip = prop[0];
        this.id = Integer.parseInt(prop[1]);
        this.nume = prop[2];
        this.prenume = prop[3];
        this.email = prop[4];
        this.parola = prop[5];
    }

    public String descriere (){
        String text = "";
        text += "Id: " + this.id + "\n";
        text += "Nume: " + this.nume + "\n";
        text += "Prenume: " + this.prenume + "\n";
        text += "Email: " + this.email + "\n";
        return text;
    }

    public String toSave (){
        return this.tip+","+this.id+","+this.nume+","+this.prenume+","+this.email+","+this.parola;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
