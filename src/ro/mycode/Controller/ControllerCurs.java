package ro.mycode.Controller;

import ro.mycode.Model.Curs;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerCurs {
    private ArrayList<Curs> cursuri;

    public ControllerCurs (){
        cursuri = new ArrayList<>();
        this.load();

    }
    public ControllerCurs (String text){
        cursuri = new ArrayList<>();
    }

    public void load (){
        try{
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\Curs.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String text = scanner.nextLine();
                Curs curs = new Curs(text);
                this.cursuri.add(curs);
            }
            scanner.close();
        }catch (Exception e){

        }
    }
    public void save (){
        try{
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\Curs.txt");
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
        for (i = 0; i < cursuri.size() - 1; i++){
            text += this.cursuri.get(i).toSave() + "\n";
        }
        text += this.cursuri.get(i).toSave();
        return text;
    }

    public void afisare (){
        for (int i = 0; i < cursuri.size(); i++){
            System.out.println(cursuri.get(i).descriere());
        }
    }

    public Curs getCursByCursName (String text){
        for (int i = 0; i < cursuri.size(); i++){
            if (cursuri.get(i).getName().equals(text)){
                return cursuri.get(i);
            }
        }
        return null;
    }

    public void addCurs (Curs curs){
        if (getCursByCursName(curs.getName()) == null) {
            this.cursuri.add(curs);
        }
    }

    public int pozitie (String nume){
        for (int i = 0; i < cursuri.size(); i++){
            if (cursuri.get(i).getName().equals(nume)){
                return i;
            }
        }
        return -1;
    }
    public void removeCurs (String nume){
        int poz = pozitie(nume);
        if (poz != -1){
            this.cursuri.remove(poz);
        }

    }

    public void upDate (String nume,Curs c){
        int poz = pozitie(nume);
        Curs curs = this.cursuri.get(poz);
        if (c.getId() != 0){
            curs.setId(c.getId());
        }
        if (!c.getName().equals("")){
            curs.setName(c.getName());
        }
        if (!c.getDepartment().equals("")){
            curs.setDepartment(c.getDepartment());
        }
    }

    public boolean verificareNume (String nume){
        for (int i = 0; i < cursuri.size(); i++){
            if (cursuri.get(i).getName().equals(nume)){
                return true;
            }
        }
        return false;
    }
    public void verificare (String nume){
        if (!verificareNume(nume)){
            System.out.println("Nu exista acest curs, introdu al nume!");
        }
    }

    public Curs findCourseById (int courseId){
        for (int i = 0; i < cursuri.size(); i++){
            if (cursuri.get(i).getId() == courseId){
                return  cursuri.get(i);
            }
        }
        return null;
    }

    public ArrayList<Curs> curs (String nume){
        ArrayList<Curs> cursuriDep = new ArrayList<>();
        for (int i = 0; i < cursuri.size(); i++){
            if (cursuri.get(i).getDepartment().equals(nume)){
                cursuriDep.add(cursuri.get(i));
            }
        }
        return cursuriDep;
    }

    public ArrayList<Integer> idCurs (){
        ArrayList<Integer> id = new ArrayList<>();
        for (Curs curs: cursuri) {
            if (!id.contains(curs.getId())) {
                id.add(curs.getId());

            }
        }
        return id;
    }

    public ArrayList<Curs> cursuriPopulare (ArrayList<Integer> idCurs){
        ArrayList<Curs> cursPop = new ArrayList<>();
        for (int i = 0; i < cursuri.size(); i++){
            for (int i1 = 0; i1 < cursuri.size(); i1++) {
                if (cursuri.get(i1).getId() == idCurs.get(i)) {
                    cursPop.add(cursuri.get(i1));
                }
            }
        }
        return cursPop;
    }

    public int generareId(){
        if (cursuri.size() > 0){
            return cursuri.get(cursuri.size() - 1).getId() + 1;
        }
        return -1;
    }
}
