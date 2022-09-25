package ro.mycode.Models;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.User.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getStudent() {
        Student student = new Student("Student",104,"Popescu","Silviu","slv4@gmail.com","copac2",0,0,"LXS0005",0,"Merit");

        assertEquals("Student",student.getTip());
        assertEquals(104,student.getId());
        assertEquals("Popescu",student.getNume());
        assertEquals("Silviu",student.getPrenume());
        assertEquals("slv4@gmail.com",student.getEmail());
        assertEquals("copac2",student.getParola());
        assertEquals(0,student.getNote());
        assertEquals(0, student.getAbsente());
        assertEquals("LXS0005",student.getIdLegitimatie());
        assertEquals(0,student.getNumarulDeCursuriInscris());
        assertEquals("Merit",student.getTipBursa());

    }

    @Test
    void setStudent() {
        Student student = new Student("Student",104,"Popescu","Silviu","slv4@gmail.com","copac2",0,0,"LXS0005",0,"Merit");

        student.setTip("a");
        student.setId(1);
        student.setNume("a");
        student.setPrenume("a");
        student.setEmail("a");
        student.setParola("a");
        student.setNote(0);
        student.setAbsente(0);
        student.setIdLegitimatie("a");
        student.setNumarulDeCursuriInscris(0);
        student.setTipBursa("a");

        assertEquals("a",student.getTip());
        assertEquals(1,student.getId());
        assertEquals("a",student.getNume());
        assertEquals("a",student.getPrenume());
        assertEquals("a",student.getEmail());
        assertEquals("a",student.getParola());
        assertEquals("a",student.getParola());
        assertEquals(0,student.getNote());
        assertEquals(0, student.getAbsente());
        assertEquals("a",student.getIdLegitimatie());
        assertEquals(0,student.getNumarulDeCursuriInscris());
        assertEquals("a",student.getTipBursa());
    }
}