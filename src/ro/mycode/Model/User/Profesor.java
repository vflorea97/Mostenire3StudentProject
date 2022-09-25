package ro.mycode.Model.User;

import ro.mycode.Model.User.User;

public class Profesor extends User {

    private String specialitate;
    private int salariu;
    private String grad;
    private int nrCursuri;

    public Profesor (){
        super("Profesor",0,"Popescu","Tudor","tdr@gmail.com","tudorel14");
        this.specialitate = "";
        this.salariu = 0;
        this.grad = "";
        this.nrCursuri = 0;
    }

    public Profesor(String tip, int id, String nume, String prenume, String email, String parola, String specialitate, int salariu, String grad, int nrCursuri) {
        super(tip, id, nume, prenume, email, parola);
        this.specialitate = specialitate;
        this.salariu = salariu;
        this.grad = grad;
        this.nrCursuri = nrCursuri;
    }

    public Profesor (String text){
        super(text);
        String [] prop = text.split(",");
        this.specialitate = prop[6];
        this.salariu = Integer.parseInt(prop[7]);
        this.grad = prop[8];
        this.nrCursuri = Integer.parseInt(prop[9]);
    }
    @Override
    public String descriere (){
        String text = "";
        text += super.descriere();
        text += "Specialitate: " + this.specialitate + "\n";
        text += "Grad: " + this.grad + "\n";
        text += "Numar cursuri: " + this.nrCursuri + "\n";
        return text;
    }

    @Override
    public String toSave (){
        return super.toSave()+","+this.specialitate+","+this.salariu+","+this.grad+","+this.nrCursuri;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getNrCursuri() {
        return nrCursuri;
    }

    public void setNrCursuri(int nrCursuri) {
        this.nrCursuri = nrCursuri;
    }
}
