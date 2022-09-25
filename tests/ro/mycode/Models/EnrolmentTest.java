package ro.mycode.Models;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.Enrolment;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentTest {

    @Test
    void getEnrolment() {
        Enrolment enrolment = new Enrolment(401,201,102);

        assertEquals(401,enrolment.getId());
        assertEquals(201,enrolment.getStudentId());
        assertEquals(102,enrolment.getCursId());
    }

    @Test
    void setEnrolement() {
        Enrolment enrolment = new Enrolment(401,201,102);

        enrolment.setId(400);
        enrolment.setStudentId(200);
        enrolment.setCursId(100);

        assertEquals(400,enrolment.getId());
        assertEquals(200,enrolment.getStudentId());
        assertEquals(100,enrolment.getCursId());

    }
}