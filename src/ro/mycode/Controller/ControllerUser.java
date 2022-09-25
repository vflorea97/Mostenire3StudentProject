package ro.mycode.Controller;

import ro.mycode.Model.User.Profesor;
import ro.mycode.Model.User.Student;
import ro.mycode.Model.User.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerUser {

    private ArrayList<User> users;
    private Scanner scanner;

    public ControllerUser (){
        users = new ArrayList<>();
        this.load();
    }
    public ControllerUser (String text){
        users = new ArrayList<>();
    }
    public void load (){
        try{
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\User.txt");
            scanner = new Scanner(file);
            while (scanner.hasNext()){
                String text = scanner.nextLine();
                switch (text.split(",")[0]){
                    case "Student":
                        this.users.add(new Student(text));
                        break;
                    case "Profesor":
                        this.users.add(new Profesor(text));
                    default:
                        break;
                }
            }
            scanner.close();
        }catch (Exception e){

        }
    }
    public void save (){
        try{
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\User.txt");
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(this.toSave());
            printWriter.close();

        }catch (Exception e){

        }
    }
    public String toSave(){
        String text = "";
        int i;
        for (i = 0; i < users.size() - 1; i++){
            text += this.users.get(i).toSave() + "\n";
        }
        text += this.users.get(i).toSave();
        return text;
    }

    public void afisare (){
        for (int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).descriere());
        }
    }
    public void afisare (String tip){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getTip().equals(tip)) {
                System.out.println(users.get(i).descriere());
            }
        }
    }

    public User getUserByEmail (String email){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                return users.get(i);
            }
        }
        return null;
    }
    public void addUser(User user){
        if (getUserByEmail(user.getEmail()) == null) {
            if (user instanceof Student) {
                Student student = (Student) user;
                this.users.add(student);
            } else if (user instanceof Profesor) {
                Profesor profesor = (Profesor) user;
                this.users.add(profesor);
            }
        }
    }
    public int pozitie (int id){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void removeUser (int id){
        int poz = pozitie(id);
        if (poz != -1){
            this.users.remove(poz);
        }
    }
    public void ordineAlfabetica (){
        boolean run = false;
        do {
            run = true;
            for (int i = 0; i < users.size() - 1; i++){
                if (users.get(i).getNume().compareTo(users.get(i + 1).getNume()) > 0 && users.get(i) instanceof Student){
                    Student element = (Student)users.get(i);
                    users.set(i, users.get(i + 1));
                    users.set(i + 1, element);
                    run = false;
                }
            }
        }
        while (!run);
    }
    public User acelasiCurs (int studentId){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == studentId){
                return users.get(i);
            }
        }
        return null;
    }
    public boolean verificareStudent (int id){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public void verificare (int id){
        if (!verificareStudent(id)){
            System.out.println("Nu exista acest student, inrodu alt id!");
        }
    }
    public User user (String username, String parola){
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(username) && users.get(i).getParola().equals(parola)){
                return users.get(i);
            }
        }
        return null;
    }
    public int generareId (){

        if(this.users.size()>0){

            return  users.get(users.size()-1).getId()+1;
        }

        return 1;
    }
    public boolean isEmail(String mail){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(mail))
                return true;
        }
        return false;
    }
}
