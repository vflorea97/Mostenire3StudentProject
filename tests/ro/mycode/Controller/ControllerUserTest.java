package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.User.Profesor;
import ro.mycode.Model.User.Student;
import ro.mycode.Model.User.User;

import java.sql.Struct;
import static org.junit.jupiter.api.Assertions.*;


class ControllerUserTest {

    @Test
    public void afisare (){
        ControllerUser controllerUser = new ControllerUser();
        controllerUser.afisare();
    }

    @Test
    public void toSave (){
        ControllerUser controllerUser = new ControllerUser();
        Student student = new Student("Student",100,"p","p","p","p",0,0,"p",0,"p");
        Profesor profesor = new Profesor("Profesor",200,"p","p","p","p","P",0,"p",0);
        controllerUser.addUser(student);
        controllerUser.addUser(profesor);
        controllerUser.save();
        controllerUser.afisare();
    }

    @Test
    public void pozitie (){
        ControllerUser controllerUser = new ControllerUser();
        Student student = new Student("Student",100,"p","p","p","p",0,0,"p",0,"p");
        controllerUser.addUser(student);

        controllerUser.pozitie(student.getId());

        assertEquals(0,controllerUser.pozitie(student.getId()));
    }

    @Test
    public void removeUser (){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",100,"p","p","p","p",0,0,"p",0,"p");
        controllerUser.addUser(student);

        controllerUser.removeUser(student.getId());

        assertEquals(-1, controllerUser.pozitie(student.getId()));
    }

    @Test
    public void addUser (){
        ControllerUser controllerUser = new ControllerUser();
        Student student = new Student("Student",100,"p","p","p","p",0,0,"p",0,"p");
        controllerUser.addUser(student);

        assertEquals(true,controllerUser.getUserByEmail(student.getEmail()) != null);
    }

    @Test
    public void getUserByEmail (){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        controllerUser.addUser(student);

        User user = controllerUser.getUserByEmail(student.getEmail());

        assertEquals("bgd5@gmail.com",user.getEmail());
    }

    @Test
    public void oridneAlfabetica (){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        Student student1 = new Student("Student",100,"Misu","Alexandru","alex@gmail.com","alx1234",0,0,"LXS0001",0,"Merit");
        Student student2 = new Student("Student",101,"Dragan","Mihai","dgrmh@gmail.com","mihai001",0,0,"LXS0002",0,"Medicala");
        Student student3 = new Student("Student",102,"Soru","Tudor","sorut6@gmail.com","pisica",0,0,"LXS0003",0,"Merit");
        Student student4 = new Student("Student",104,"Popescu","Silviu","slv4@gmail.com","copac2",0,0,"LXS0005",0,"Merit");
        controllerUser.addUser(student);
        controllerUser.addUser(student1);
        controllerUser.addUser(student2);
        controllerUser.addUser(student3);
        controllerUser.addUser(student4);

        controllerUser.ordineAlfabetica();
        controllerUser.afisare();
    }

    @Test
    public void acelasiCurs(){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        controllerUser.addUser(student);

        User user = controllerUser.acelasiCurs(student.getId());

        assertEquals(103,user.getId());
    }

    @Test
    public void verificareStudent(){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        controllerUser.addUser(student);

        boolean pass = controllerUser.verificareStudent(student.getId());

        assertEquals(true,pass);
    }

    @Test
    public void verificare(){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        controllerUser.addUser(student);

        controllerUser.verificare(student.getId());

        assertEquals(true,controllerUser.getUserByEmail(student.getEmail()) != null);
    }

    @Test
    public void user (){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        controllerUser.addUser(student);

        controllerUser.user(student.getEmail(), student.getParola());

        assertEquals(true,controllerUser.getUserByEmail(student.getEmail()) != null);
    }

    @Test
    public void generareId (){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        controllerUser.addUser(student);

        int idUser = controllerUser.generareId();

        assertEquals(104,idUser);
    }

    @Test
    public void isEmail (){
        ControllerUser controllerUser = new ControllerUser("new");
        Student student = new Student("Student",103,"Gimin","Bogdan","bgd5@gmail.com","poc",0,0,"LXS0004",0,"Sociala");
        controllerUser.addUser(student);

        boolean pass = controllerUser.isEmail(student.getEmail());

        assertEquals(true,pass);
    }


}