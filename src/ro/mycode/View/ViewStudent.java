package ro.mycode.View;

import ro.mycode.Controller.ControllerBook;
import ro.mycode.Controller.ControllerCurs;
import ro.mycode.Controller.ControllerEnrolment;
import ro.mycode.Controller.ControllerUser;
import ro.mycode.Model.Book;
import ro.mycode.Model.Curs;
import ro.mycode.Model.Enrolment;
import ro.mycode.Model.User.Student;
import ro.mycode.Model.User.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private ControllerCurs controllerCurs;
    private ControllerUser controllerUser;
    private ControllerBook controllerBook;
    private ControllerEnrolment controllerEnrolment;
    private Scanner scanner;
    private User user;
//    private Student student;

//    public ViewStudent() {
//        controllerCurs = new ControllerCurs();
//        controllerUser = new ControllerUser();
//        controllerBook = new ControllerBook();
//        controllerEnrolment = new ControllerEnrolment();
//        Student student = new Student("Student", 100, "Misu", "Alexandru", "alex@gmail.com", "alx1234", 0, 0, "LXS0001", 0, "Merit");
//        this.student = student;
//        scanner = new Scanner(System.in);
//    }

    public ViewStudent(User user) {
        controllerCurs = new ControllerCurs();
        controllerUser = new ControllerUser();
        controllerBook = new ControllerBook();
        controllerEnrolment = new ControllerEnrolment();
        scanner = new Scanner(System.in);

        this.user = user;
    }

    public void meniuStudent() {
        System.out.println("Bine ai venit " + user.getNume() + " " + user.getPrenume() + " !");
//        System.out.println("Bine ai venit " + student.getNume() + " !");
        System.out.println("Apasa 1 pentru a afisa toate cartile");
        System.out.println("Apasa 2 pentru a afisa toate cursurile");
        System.out.println("Apasa 3 pentru a afisa toti studentii in ordine alfabetica");
        System.out.println("Apasa 4 pentru a afisa cine iti este coleg la curs");
        System.out.println("Apasa 5 pentru a imprumuta o carte");
        System.out.println("Apasa 6 pentru a afisa cursurile la care sunteti inscris");
        System.out.println("Apasa 7 pentru a afisa cartile studentului");
        System.out.println("Apasa 8 pentru a te inscrie la un curs");
        System.out.println("Apasa 9 pentru a te retrage de la un curs");
        System.out.println("Apasa 10 pentru a afisa cursurile in functie de departament");
        System.out.println("Apasa 11 pentru a afisa cursurile in ordinea popularitatii");
        System.out.println("Apasa 12 pentru a reafisa meniul.");
        System.out.println("Apasa 0 pentru a te deloga.");

    }

    public void startStudent() {
        boolean run = true;
        meniuStudent();
        while (run) {
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton) {
                case 1:
                    controllerBook.afisare();
                    break;
                case 2:
                    controllerCurs.afisare();
                    break;
                case 3:
                    System.out.println("Ordinea alfabetica este: ");
                    controllerUser.ordineAlfabetica();
                    controllerUser.afisare(user.getTip());
                    break;
                case 4:
                    colegiCurs();
                    break;
                case 5:
                    imprumutCarte();
                    break;
                case 6:
                    showCourses();
                    break;
                case 7:
                    showBooks();
                    break;
                case 8:
                    inscriereCurs();
                    break;
                case 9:
                    removeEnrolment();
                    break;
                case 10:
                    cursuriDepartament();
                    break;
                case 11:
                    cursuriPopulare();
                    break;
                case 0:
                    run = false;
                    ViewLogin viewLogin = new ViewLogin();
                    viewLogin.meniu();
                    break;
                default:
                    meniuStudent();
                    break;
            }
        }
    }

    private void showBooks() {
        ArrayList<Book> books = controllerBook.fiindBooksByUserId(user.getId());
        for (Book b : books) {

            System.out.println(b.descriere());
        }
    }

    private void showCourses() {
        int id = user.getId();
        ArrayList<Enrolment> enrolments = controllerEnrolment.findEnrolmentsByUserId(id);

        for (Enrolment enrolment : enrolments) {

            System.out.println(controllerCurs.findCourseById(enrolment.getCursId()).descriere());
        }
    }

    private void colegiCurs() {
        int id = user.getId();
        int idCurs = controllerEnrolment.idCurs(id);
        ArrayList<Enrolment> enrolments = controllerEnrolment.totiInscrisii(idCurs);
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getStudentId() != id)
                System.out.println(controllerUser.acelasiCurs(enrolments.get(i).getStudentId()).descriere());
        }
    }

    public void imprumutCarte() {
        int id = user.getId();
        boolean student = controllerUser.verificareStudent(id);
        controllerUser.verificare(id);
        System.out.println("Introdu numele cartii pe care vrei sa o imprumuti: ");
        while (student) {
            String carte = scanner.nextLine();
            boolean pass = controllerBook.verificareNume(carte);
            controllerBook.verificare(carte);
            if (pass) {
                controllerBook.cartiImprumutate(id, carte);
                controllerBook.save();
                student = false;
                System.out.println("Ai imprumutat cartea cu succes!!");
                System.out.println();
                startStudent();
            }

        }
    }

    public void inscriereCurs() {
        System.out.println("Introdu ID-ul cursului:");
        boolean run = true;
        while (run) {
            int idCurs = Integer.parseInt(scanner.nextLine());
            if (controllerCurs.findCourseById(idCurs) != null) {
                for (int i = 0; i < controllerCurs.idCurs().size(); i++) {
                    if (idCurs == controllerCurs.idCurs().get(i)) {
                        int id = controllerEnrolment.generareId();
                        int idStudent = user.getId();
                        int idCursEnr = controllerCurs.idCurs().get(i);
                        Enrolment enrolment = new Enrolment(id, idStudent, idCursEnr);
                        controllerEnrolment.addEnrolment(enrolment);
                        controllerEnrolment.save();
                        run = false;
                        System.out.println("Te-ai inscris cu succes la curs!!");
                        System.out.println();
                        startStudent();
                    }
                }
            }else{
                System.out.println("Acest curs nu exista. Introdu alt ID:");
            }
        }
    }

    public void cursuriDepartament (){
        System.out.println("Introdu numele departamentului:");
        String nume = scanner.nextLine();
        ArrayList<Curs> cursuriDep = controllerCurs.curs(nume);
        for (Curs c:cursuriDep){
            System.out.println(c.descriere());
        }
    }
    public void cursuriPopulare (){
        ArrayList<Integer> curs = controllerCurs.idCurs();
        int [] contor = controllerEnrolment.contor(curs);
        controllerEnrolment.ordineDescrescatoare(curs,contor);
        ArrayList<Curs> cursuriPopulare = controllerCurs.cursuriPopulare(curs);
        for (int i = 0; i < cursuriPopulare.size(); i++){
            System.out.println("Departament cu " + contor[i] + " studenti.");
            System.out.println(cursuriPopulare.get(i).descriere());

        }
    }
    public void removeEnrolment (){
        System.out.println("Intordu id-ul inscrierii pe care vrei sa o stergi: ");
        boolean run = true;
        while (run) {
            int id = Integer.parseInt(scanner.nextLine());
            if (controllerEnrolment.getEnrolemntById(id) != null && controllerEnrolment.getEnrolemntById(id).getStudentId() == user.getId()) {
                controllerEnrolment.removeEnrolment(id);
                controllerEnrolment.save();
                run = false;
                System.out.println("Te-ai retras cu succes de la curs!!");
                System.out.println();
                startStudent();
            }else{
                System.out.println("Aceasta inscriere nu exista. Introdu alt ID: ");
            }
        }
    }



}
