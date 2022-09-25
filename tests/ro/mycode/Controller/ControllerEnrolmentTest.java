package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.Enrolment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerEnrolmentTest {

    @Test
    void toSave() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("new");
        Enrolment enrolment = new Enrolment(501,101,402);
        Enrolment enrolment1 = new Enrolment(502,101,405);
        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.addEnrolment(enrolment1);
        controllerEnrolment.afisare();
    }
    @Test
    public void addEnrolment() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(501,101,402);

        controllerEnrolment.addEnrolment(enrolment);

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void pozitie() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(501,101,402);

        controllerEnrolment.pozitie(enrolment.getId());

        assertEquals(0,controllerEnrolment.pozitie(enrolment.getId()));
    }

    @Test
    public void removeEnrolment() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(501,101,402);

        controllerEnrolment.removeEnrolment(enrolment.getId());

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) == null);
    }

    @Test
    public void upDate() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(501,101,402);

        controllerEnrolment.upDate(enrolment.getId(),enrolment);

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void verificareEnrolment() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(501,101,402);

        controllerEnrolment.verificareEnrolment(enrolment.getId());

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void verificare() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(501,101,402);

        controllerEnrolment.verificare(enrolment.getId());

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void findEnrolmentsByUserId() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(501,101,402);
        controllerEnrolment.addEnrolment(enrolment);

        ArrayList<Enrolment> enr = new ArrayList<>();
        enr.add(enrolment);

        controllerEnrolment.findEnrolmentsByUserId(enrolment.getId());

        assertEquals(enrolment.descriere(),enr.get(0).descriere());
    }

    @Test
    public void idCurs() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("new");
        Enrolment enrolment = new Enrolment(501,101,402);
        controllerEnrolment.addEnrolment(enrolment);

        int idCurs = controllerEnrolment.idCurs(enrolment.getStudentId());

        assertEquals(enrolment.getCursId(),idCurs);
    }

    @Test
    public void totiInscrisii() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("new");
        Enrolment enrolment = new Enrolment(501,101,402);
        Enrolment enrolment1 = new Enrolment(502,102,402);
        Enrolment enrolment2 = new Enrolment(503,103,402);

        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.addEnrolment(enrolment1);
        controllerEnrolment.addEnrolment(enrolment2);

        ArrayList<Integer> cursId = new ArrayList<>();

        cursId.add(402);

        assertEquals(3,controllerEnrolment.totiInscrisii(enrolment.getCursId()).size());
    }

    @Test
    public void contorStudenti() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("new");
        Enrolment enrolment = new Enrolment(501,101,402);

        controllerEnrolment.addEnrolment(enrolment);

        int contor = controllerEnrolment.contorStudenti(enrolment.getCursId());

        assertEquals(1,contor);
    }

    @Test
    public void contor() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("poc");
        Enrolment enrolment = new Enrolment(501,101,402);
        Enrolment enrolment1 = new Enrolment(502,102,403);
        Enrolment enrolment2 = new Enrolment(503,103,402);
        Enrolment enrolment3 = new Enrolment(504,104,405);
        Enrolment enrolment4 = new Enrolment(505,105,406);
        Enrolment enrolment5 = new Enrolment(506,106,402);
        Enrolment enrolment6 = new Enrolment(507,107,402);
        Enrolment enrolment7 = new Enrolment(508,108,409);
        Enrolment enrolment8 = new Enrolment(509,109,402);
        Enrolment enrolment9 = new Enrolment(510,110,411);

        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.addEnrolment(enrolment1);
        controllerEnrolment.addEnrolment(enrolment2);
        controllerEnrolment.addEnrolment(enrolment3);
        controllerEnrolment.addEnrolment(enrolment4);
        controllerEnrolment.addEnrolment(enrolment5);
        controllerEnrolment.addEnrolment(enrolment6);
        controllerEnrolment.addEnrolment(enrolment7);
        controllerEnrolment.addEnrolment(enrolment8);
        controllerEnrolment.addEnrolment(enrolment9);

        ArrayList<Integer> courseIds= new ArrayList<>();

        courseIds.add(402);
        courseIds.add(409);

        assertEquals(5,controllerEnrolment.contor(courseIds)[0]);

    }

    @Test
    public void ordineDescrescatoare() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("poc");
        Enrolment enrolment = new Enrolment(501, 101,403 );
        Enrolment enrolment1 = new Enrolment(502, 102, 403);
        Enrolment enrolment2 = new Enrolment(503, 103, 403);
        Enrolment enrolment3 = new Enrolment(504, 104, 402);
        Enrolment enrolment4 = new Enrolment(505,105,402);
        Enrolment enrolment5 = new Enrolment(506,106,403);

        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.addEnrolment(enrolment1);
        controllerEnrolment.addEnrolment(enrolment2);
        controllerEnrolment.addEnrolment(enrolment3);
        controllerEnrolment.addEnrolment(enrolment4);
        controllerEnrolment.addEnrolment(enrolment5);

        ArrayList<Integer> cursId = new ArrayList<>();

        cursId.add(401);
        cursId.add(402);
        cursId.add(403);

        int [] contro = controllerEnrolment.contor(cursId);

        controllerEnrolment.ordineDescrescatoare(cursId,contro);

        assertEquals(4,controllerEnrolment.contor(cursId)[0]);
        assertEquals(2,controllerEnrolment.contor(cursId)[1]);
        assertEquals(0,controllerEnrolment.contor(cursId)[2]);
    }

    @Test
    public void getEnrolmentById (){
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("new");
        Enrolment enrolment = new Enrolment(501,101,403);
        controllerEnrolment.addEnrolment(enrolment);

        Enrolment enrolment1 = controllerEnrolment.getEnrolemntById(enrolment.getId());

        assertEquals(501,enrolment1.getId());
    }


}