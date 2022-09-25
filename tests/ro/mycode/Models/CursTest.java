package ro.mycode.Models;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.Curs;
import static org.junit.jupiter.api.Assertions.*;

class CursTest {

    @Test
    void getCurs() {
        Curs curs = new Curs(101,"Geometrie","Matematica");

        assertEquals(101,curs.getId());
        assertEquals("Geometrie",curs.getName());
        assertEquals("Matematica",curs.getDepartment());
    }

    @Test
    void setCurs() {
        Curs curs = new Curs(101,"Geometrie","Matematica");

        curs.setId(100);
        curs.setName("Geo");
        curs.setDepartment("Mate");

        assertEquals(100,curs.getId());
        assertEquals("Geo",curs.getName());
        assertEquals("Mate",curs.getDepartment());
    }
}