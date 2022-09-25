package ro.mycode.View;

import ro.mycode.Controller.ControllerUser;
import ro.mycode.Controller.ControllerUser;
import ro.mycode.Model.User.Profesor;
import ro.mycode.Model.User.Student;
import ro.mycode.Model.User.User;

import java.util.Scanner;

public class ViewLogin {

    private ControllerUser controllerUser;
    private Scanner scanner;

    public ViewLogin (){
        controllerUser = new ControllerUser();
        scanner = new Scanner(System.in);
    }

    public void meniu (){
        System.out.println("Apasati tasta 1 pentru login");
        System.out.println("Apasati tasta 2 pentru a te inregistra ca student");
        System.out.println("Apasati tasta 3 pentru a te inregistra ca profesor");
        System.out.println("Apasa 0 pentru a inchide aplicatia.");

    }

    public void play (){
        boolean run = true;
        meniu();
        while (run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    login();
                    break;
                case 2:
                    inregistrareStudent();
                    break;
                case 3:
                    inregistrareProfesor();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    meniu();
                    break;
            }
        }
    }
    public void login () {
        System.out.println("Introduceti username-ul si parola");
        boolean run = true;
        while (run) {
            System.out.println("Username: ");
            String username = scanner.nextLine();
            System.out.println("Parola: ");
            String parola = scanner.nextLine();
            if (controllerUser.user(username, parola) != null) {
                User user = controllerUser.user(username, parola);
                if (user.getTip().equals("Student")) {
                    ViewStudent viewStudent = new ViewStudent(user);
                    viewStudent.startStudent();
                    run = false;
                } else if (user.getTip().equals("Profesor")) {
                    ViewProfesor viewProfesor = new ViewProfesor(user);
                    viewProfesor.startProfesor();
                    run = false;
                }
            }else {
                System.out.println("Credentiale incorecte" + "\n" + "Reintrodu username-ul si parola");
            }
        }
    }
    public void inregistrareStudent (){
        String tip = "Student";
        int id = controllerUser.generareId();
        System.out.println("Introdu prenume:");
        String nume = scanner.nextLine();
        System.out.println("Introdu adresa de mail:");
        String prenume = scanner.nextLine();
        System.out.println("Introdu nume:");
        String adresaMail = scanner.nextLine();
        while (controllerUser.isEmail(adresaMail)){
            System.out.println("Adresa de mail introdusa este deja asociata altui student. Introdu alta adresa:");
            adresaMail =scanner.nextLine();
        }
        System.out.println("Introdu o parola: ");
        String parola = scanner.nextLine();
        String idUnic = String.valueOf(id);
        String idLegitimatie = "UNIBUC" + idUnic;
        Student student = new Student(tip,id,nume,prenume,adresaMail,parola,0,0,idLegitimatie,0,"");
        controllerUser.addUser(student);
        controllerUser.save();

        ViewStudent viewStudent = new ViewStudent(student);
        viewStudent.startStudent();
    }
    public void inregistrareProfesor (){
        String tip = "Profesor";
        int id = controllerUser.generareId();
        System.out.println("Introdu nume:");
        String nume = scanner.nextLine();
        System.out.println("Introdu prenume:");
        String prenume = scanner.nextLine();
        System.out.println("Introdu adresa de mail:");
        String adresaMail = scanner.nextLine();
        while (controllerUser.isEmail(adresaMail)){
            System.out.println("Adresa de mail introdusa este deja asociata altui profesor. Introdu alta adresa:");
            adresaMail =scanner.nextLine();
        }
        System.out.println("Introdu o parola: ");
        String parola = scanner.nextLine();
        System.out.println("Introdu specialitatea: ");
        String specialitate = scanner.nextLine();
        Profesor profesor = new Profesor(tip,id,nume,prenume,adresaMail,parola,specialitate,0,"",0);
        controllerUser.addUser(profesor);
        controllerUser.save();

        ViewProfesor viewProfesor = new ViewProfesor(profesor);
        viewProfesor.startProfesor();

    }
}
