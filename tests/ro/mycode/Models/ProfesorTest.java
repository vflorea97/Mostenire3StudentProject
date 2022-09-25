package ro.mycode.Models;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.User.Profesor;

import static org.junit.jupiter.api.Assertions.*;


class ProfesorTest {

    @Test
    void getProfesor() {
        Profesor profesor = new Profesor("Profesor",202,"Mican","Radu","radu.radu87@gmail.com","radMic4","Matematica",5000,"Lector",3);

        assertEquals("Profesor",profesor.getTip());
        assertEquals(202,profesor.getId());
        assertEquals("Mican",profesor.getNume());
        assertEquals("Radu",profesor.getPrenume());
        assertEquals("radu.radu87@gmail.com",profesor.getEmail());
        assertEquals("radMic4",profesor.getParola());
        assertEquals("Matematica",profesor.getSpecialitate());
        assertEquals(5000,profesor.getSalariu());
        assertEquals("Lector",profesor.getGrad());
        assertEquals(3,profesor.getNrCursuri());
    }

    @Test
    void setProfesor() {
        Profesor profesor = new Profesor("Profesor",202,"Mican","Radu","radu.radu87@gmail.com","radMic4","Matematica",5000,"Lector",2);

        profesor.setTip("a");
        profesor.setId(1);
        profesor.setNume("a");
        profesor.setPrenume("a");
        profesor.setEmail("a");
        profesor.setParola("a");
        profesor.setSpecialitate("a");
        profesor.setSalariu(1);
        profesor.setGrad("a");
        profesor.setNrCursuri(1);

        assertEquals("a",profesor.getTip());
        assertEquals(1,profesor.getId());
        assertEquals("a",profesor.getNume());
        assertEquals("a",profesor.getPrenume());
        assertEquals("a",profesor.getEmail());
        assertEquals("a",profesor.getParola());
        assertEquals("a",profesor.getSpecialitate());
        assertEquals(1,profesor.getSalariu());
        assertEquals("a",profesor.getGrad());
        assertEquals(1,profesor.getNrCursuri());

    }
}