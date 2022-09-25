package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.Curs;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerCursTest {

    @Test
    void toSave() {
        ControllerCurs controllerCurs = new ControllerCurs();
        Curs curs = new Curs(407,"Geometrie","Matematica");
        Curs curs1 = new Curs(402,"Gramatica","Limba Romana");
        controllerCurs.addCurs(curs);
        controllerCurs.addCurs(curs1);
        controllerCurs.afisare();

    }
    @Test
    public void addCurs() {
        ControllerCurs controllerCurs = new ControllerCurs();
        Curs curs = new Curs(401,"Geometrie","Matematica");

        controllerCurs.addCurs(curs);

        assertEquals(true,controllerCurs.getCursByCursName(curs.getName()) != null);
    }

    @Test
    public void pozitie() {
        ControllerCurs controllerCurs = new ControllerCurs("new");
        Curs curs = new Curs(401,"Geometrie","Matematica");
        controllerCurs.addCurs(curs);

        controllerCurs.pozitie(curs.getName());

        assertEquals(0,controllerCurs.pozitie(curs.getName()));
    }

    @Test
    public void removeCurs() {
        ControllerCurs controllerCurs = new ControllerCurs();
        Curs curs = new Curs(401,"Geometrie","Matematica");

        controllerCurs.removeCurs(curs.getName());

        assertEquals(true,controllerCurs.getCursByCursName(curs.getName()) == null);
    }

    @Test
    public void upDate() {
        ControllerCurs controllerCurs = new ControllerCurs();
        Curs curs = new Curs(401,"Geometrie","Matematica");

        controllerCurs.upDate(curs.getName(),curs);

        assertEquals(true,controllerCurs.getCursByCursName(curs.getName()) != null);
    }

    @Test
    public void verificareNume() {
        ControllerCurs controllerCurs = new ControllerCurs();
        Curs curs = new Curs(401,"Geometrie","Matematica");

        controllerCurs.verificareNume(curs.getName());

        assertEquals(true,controllerCurs.getCursByCursName(curs.getName()) != null);
    }

    @Test
    public void verificare() {
        ControllerCurs controllerCurs = new ControllerCurs();
        Curs curs =new Curs(401,"Geometrie","Matematica");

        controllerCurs.verificare(curs.getName());

        assertEquals(true,controllerCurs.getCursByCursName(curs.getName()) != null);
    }

    @Test
    public void findCourseById() {
        ControllerCurs controllerCurs = new ControllerCurs("new");
        Curs curs = new Curs(401,"Geometrie","Matematica");
        Curs curs1 = new Curs(402,"Gramatica","Limba Romana");

        controllerCurs.addCurs(curs);
        controllerCurs.addCurs(curs1);

        ArrayList<String> cursName = new ArrayList<>();
        cursName.add("Geometrie");
        cursName.add("Gramatica");

        controllerCurs.findCourseById(curs.getId());

        assertEquals(curs,controllerCurs.getCursByCursName(cursName.get(0)));
    }

    @Test
    public void curs() {
        ControllerCurs controllerCurs = new ControllerCurs("new");
        Curs curs = new Curs(401,"Geometrie","Matematica");
        Curs curs1 = new Curs(402,"Gramatica","Limba Romana");

        controllerCurs.addCurs(curs);
        controllerCurs.addCurs(curs1);

        ArrayList<Curs> curs2 = controllerCurs.curs(curs.getDepartment());

        assertEquals(curs,curs2.get(0));
    }

    @Test
    public void idCurs() {
        ControllerCurs controllerCurs = new ControllerCurs("new");
        Curs curs = new Curs(401,"Geometrie","Matematica");

        controllerCurs.addCurs(curs);

        ArrayList <Integer> idCurs = controllerCurs.idCurs();

        assertEquals(401,idCurs.get(0));
    }

    @Test
    public void cursuriPopulare() {
        ControllerCurs controllerCurs = new ControllerCurs("new");
        Curs curs = new Curs(401,"Geometrie","Matematica");
        controllerCurs.addCurs(curs);

        ArrayList<Integer> idCurs = controllerCurs.idCurs();

        ArrayList<Curs> curs1 = controllerCurs.cursuriPopulare(idCurs);

        assertEquals(curs,curs1.get(0));

    }

    @Test
    public void generareId(){
        ControllerCurs controllerCurs = new ControllerCurs("new");
        Curs curs = new Curs(401,"Geometrie","Matematica");
        controllerCurs.addCurs(curs);

        controllerCurs.generareId();

        assertEquals(402,controllerCurs.generareId());
    }

    @Test
    public void getCursByCursName(){
        ControllerCurs controllerCurs = new ControllerCurs("new");
        Curs curs = new Curs(401,"Geometrie","Matematica");
        controllerCurs.addCurs(curs);

        Curs curs1 = controllerCurs.getCursByCursName(curs.getName());

        assertEquals("Geometrie",curs1.getName());
    }

}