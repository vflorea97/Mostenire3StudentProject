package ro.mycode.View;

import ro.mycode.Controller.ControllerBook;
import ro.mycode.Controller.ControllerCurs;
import ro.mycode.Controller.ControllerUser;
import ro.mycode.Model.Curs;
import ro.mycode.Model.User.User;

import java.util.Scanner;

public class ViewProfesor {

    private ControllerUser controllerUser;
    private ControllerCurs controllerCurs;
    private Scanner scanner;
//    private Profesor profesor;
    private User user;

    public ViewProfesor(User user){
        controllerUser = new ControllerUser();
        controllerCurs = new ControllerCurs();
        scanner = new Scanner(System.in);
        this.user = user;
    }
//    public ViewProfesor (){
//        controllerUser = new ControllerUser();
//        controllerCurs = new ControllerCurs();
//        scanner = new Scanner(System.in);
//        this.profesor = new Profesor("Profesor",202,"Mican","Radu","radu.radu87@gmail.com","radMic4","Matematica",5000,"Lector",2);
//
//    }
    public void meniu(){
        System.out.println("Bine ai venit " + user.getNume() + " " + user.getPrenume() + "!");
//        System.out.println("Bine ai venit " + profesor.getPrenume() + "!");
        System.out.println("Apasa 1 pentru a afisa profesorii");
        System.out.println("Apasa 2 pentru a afisa cursurile");
        System.out.println("Apasa 3 pentru a adauga un curs");
        System.out.println("Apasa 4 pentru a updata un curs");
        System.out.println("Apasa 5 pentru a sterge un curs");
        System.out.println("Apasa 6 pentru a reafisa meniul");
        System.out.println("Apasa 0 pentru a iesi din meniu");
    }
    public void meniuCurs (){
        System.out.println("Apasa 1 pentru a updata numele cursului: ");
        System.out.println("Apasa 2 pentru a updata numele departamentului: ");
        System.out.println("Apasa 3 pentru a reafisa meniul curent");
        System.out.println("Apasa 0 pentru a reveni la meniul anterior");
    }
    public void startProfesor (){
        boolean run = true;
        meniu();
        while(run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    controllerUser.afisare(user.getTip());
                    break;
                case 2:
                    controllerCurs.afisare();
                    break;
                case 3:
                    addCurs();
                    break;
                case 4:
                    upDateCurs();
                    break;
                case 5:
                    removeCurs();
                    break;
                case 0:
                    run = false;
                    ViewLogin viewLogin = new ViewLogin();
                    viewLogin.meniu();
                    break;
                default:
                    meniu();
                    break;
            }
        }
    }
    public void addCurs (){
        int id = controllerCurs.generareId();
        System.out.println("Nume curs: ");
        String nume= scanner.nextLine();
        System.out.println("Nume departament: ");
        String numeDep = scanner.nextLine();
        Curs curs = new Curs(id,nume,numeDep);
        controllerCurs.addCurs(curs);
        controllerCurs.save();
        System.out.println("Ai adaugat cu succes un curs!");
        meniu();

    }
    public void removeCurs () {
        System.out.println("Introdu numele cursului pe care vrei sa il stergi: ");
        boolean run = true;
        while (run) {
            String nume = scanner.nextLine();
            if (controllerCurs.verificareNume(nume)) {
                controllerCurs.removeCurs(nume);
                controllerCurs.save();
                run = false;
                System.out.println("Ai sters cu succes cursul!" + "\n");
                meniu();
            } else {
                controllerCurs.verificare(nume);
            }
        }
    }
    public void upDateCurs (){
        Curs curs = new Curs();
        System.out.println("Introdu numele cursului: ");
        boolean back = true;
        while (back){
            String nume = scanner.nextLine();
            boolean mod = controllerCurs.verificareNume(nume);
            controllerCurs.verificare(nume);
            if (mod){
                meniuCurs();
                boolean run = true;
                while (run){
                    int buton = Integer.parseInt(scanner.nextLine());
                    switch (buton){
                        case 1:
                            System.out.println("Introdu nou nume: ");
                            String numeCurs = scanner.nextLine();
                            curs.setName(numeCurs);
                            System.out.println("Ai updata cu succesc acesta proprietate!" + " \n");
                            meniuCurs();
                            break;
                        case 2:
                            System.out.println("Introdu noul departament: ");
                            String numeDep = scanner.nextLine();
                            curs.setDepartment(numeDep);
                            System.out.println("Ai updata cu succesc acesta proprietate!" + "\n");
                            meniuCurs();
                            break;
                        case 0:
                            back = false;
                            run = false;
                            meniu();
                            break;
                        default:
                            meniuCurs();
                            break;
                    }
                }
                controllerCurs.upDate(nume,curs);
                controllerCurs.save();
            }
        }
    }
}
