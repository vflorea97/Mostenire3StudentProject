package ro.mycode.Model.User;

import ro.mycode.Model.User.User;

public class Student extends User {

    private int note;
    private int absente;
    private String idLegitimatie;
    private int numarulDeCursuriInscris;
    private String tipBursa;

    public Student (){
        super("Student",0,"Micu","Mihai","mm@gmail.com","mihai777");
        this.note = 0;
        this.absente = 0;
        this.idLegitimatie = "";
        this.numarulDeCursuriInscris = 0;
        this.tipBursa = "";
    }

    public Student(String tip, int id, String nume, String prenume, String email, String parola, int note, int absente, String idLegitimatie, int numarulDeCursuriInscris, String tipBursa) {
        super(tip, id, nume, prenume, email, parola);
        this.note = note;
        this.absente = absente;
        this.idLegitimatie = idLegitimatie;
        this.numarulDeCursuriInscris = numarulDeCursuriInscris;
        this.tipBursa = tipBursa;
    }

    public Student (String text){

        super(text);
        String [] prop = text.split(",");
        this.note = Integer.parseInt(prop[6]);
        this.absente = Integer.parseInt(prop[7]);
        this.idLegitimatie = prop[8];
        this.numarulDeCursuriInscris = Integer.parseInt(prop[9]);
        this.tipBursa = prop[10];
    }

    @Override
    public String descriere (){
        String text = "";
        text += super.descriere();
        text += "Note: " + this.note + "\n";
        text += "Absente: " + this.absente + "\n";
        text += "Id legitimatie: " + this.idLegitimatie + "\n";
        text += "Inscrieri cursuri: " + this.numarulDeCursuriInscris + "\n";
        text += "Tip bursa: " + this.tipBursa + "\n";
        return text;
    }

    @Override
    public String toSave (){
        return super.toSave()+","+this.note+","+this.absente+","+this.idLegitimatie+","+this.numarulDeCursuriInscris+","+this.tipBursa;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getAbsente() {
        return absente;
    }

    public void setAbsente(int absente) {
        this.absente = absente;
    }

    public String getIdLegitimatie() {
        return idLegitimatie;
    }

    public void setIdLegitimatie(String idLegitimatie) {
        this.idLegitimatie = idLegitimatie;
    }

    public int getNumarulDeCursuriInscris() {
        return numarulDeCursuriInscris;
    }

    public void setNumarulDeCursuriInscris(int numarulDeCursuriInscris) {
        this.numarulDeCursuriInscris = numarulDeCursuriInscris;
    }

    public String getTipBursa() {
        return tipBursa;
    }

    public void setTipBursa(String tipBursa) {
        this.tipBursa = tipBursa;
    }
}
