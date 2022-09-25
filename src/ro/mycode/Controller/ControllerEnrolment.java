package ro.mycode.Controller;

import ro.mycode.Model.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerEnrolment {

    private ArrayList<Enrolment> enrolments;

    public ControllerEnrolment (){
        enrolments = new ArrayList<>();
        this.load();
    }
    public ControllerEnrolment (String text){
        enrolments = new ArrayList<>();
    }

    public void load (){
        try{
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\Enrolment.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String text = scanner.nextLine();
                Enrolment enrolment = new Enrolment(text);
                this.enrolments.add(enrolment);
            }
            scanner.close();

        }catch (Exception e){

        }
    }
    public void save (){
        try {
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\Enrolment.txt");
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(this.toSave());
            printWriter.close();

        }catch (Exception e){

        }
    }
    public String toSave (){
        String text = "";
        int i = 0;
        for (i = 0; i < enrolments.size() - 1; i++){
            text += this.enrolments.get(i).toSave() + "\n";
        }
        text += this.enrolments.get(i).toSave();
        return text;
    }

    public  void afisare (){
        for (int i = 0; i < enrolments.size(); i++){
            System.out.println(enrolments.get(i).descriere());
        }
    }

    public Enrolment getEnrolemntById(int id){
        for (int i = 0; i < enrolments.size(); i++){
            if(enrolments.get(i).getId() == id){
                return enrolments.get(i);
            }
        }
        return null;
    }

    public void addEnrolment (Enrolment enrolment){
        if (getEnrolemntById(enrolment.getId()) == null) {
            this.enrolments.add(enrolment);
        }
    }

    public int pozitie (int id){
        for (int i = 0; i < enrolments.size(); i++){
            if (enrolments.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void removeEnrolment (int id){
        int poz = pozitie(id);
        if (poz != -1){
            this.enrolments.remove(poz);
        }
    }

    public void upDate(int id, Enrolment e){
        int poz = pozitie(id);
        Enrolment enrolment = this.enrolments.get(poz);
        if (e.getId() != 0){
            enrolment.setId(e.getId());
        }
        if (e.getStudentId() != 0){
            enrolment.setStudentId(e.getStudentId());
        }
        if (e.getCursId() != 0){
            enrolment.setCursId(e.getStudentId());
        }

    }

    public boolean verificareEnrolment (int id){
        for (int i = 0; i < enrolments.size(); i++){
            if(enrolments.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public void verificare (int id){
        if(!verificareEnrolment(id)){
            System.out.println("Nu exista acest id de inscriere, incearca alt id!");
        }
    }

    public ArrayList<Enrolment> findEnrolmentsByUserId(int id){
        ArrayList<Enrolment> enrolment = new ArrayList<>();
        for (int i = 0; i < enrolments.size(); i++){
            if (enrolments.get(i).getStudentId() == id){
                enrolment.add(enrolments.get(i));
            }
        }
        return enrolment;
    }
    public int idCurs (int id){
        int idCurs = 0;
        for (int i = 0; i < enrolments.size(); i++){
            if(enrolments.get(i).getStudentId() == id){
                idCurs = enrolments.get(i).getCursId();
            }
        }
        return idCurs;
    }

    public ArrayList<Enrolment> totiInscrisii (int idCurs) {
        ArrayList<Enrolment> enrolment = new ArrayList<>();
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getCursId() == idCurs) {
                enrolment.add(enrolments.get(i));
            }
        }
        return enrolment;
    }

    public int contorStudenti (int idCurs){
        int ct = 0;
        for (int i = 0; i < enrolments.size(); i++){
            if(enrolments.get(i).getCursId() == idCurs){
                ct++;
            }
        }
        return ct;
    }

    public int [] contor (ArrayList<Integer> curs){
        int [] contor = new int[curs.size()];
        for (int i = 0; i < curs.size(); i++){
            contor[i] = contorStudenti(curs.get(i));
        }
        return contor;
    }
    public void ordineDescrescatoare (ArrayList<Integer> curs, int [] contor){
        boolean run = false;
        do {
            run = true;
            for (int i = 0; i < curs.size() - 1; i++){
                if (contor[i] < contor[i + 1]){
                    int element = contor[i];
                    int element2 = curs.get(i);
                    contor[i] = contor[i + 1];
                    curs.set(i, curs.get(i + 1));
                    contor[i + 1] = element;
                    curs.set(i + 1, element2);
                    run = false;
                }
            }
        }
        while (!run);

    }
    public int generareId (){
        if (enrolments.size() > 0){
            return enrolments.get(enrolments.size() - 1).getId() + 1;
        }
        return -1;
    }
}
