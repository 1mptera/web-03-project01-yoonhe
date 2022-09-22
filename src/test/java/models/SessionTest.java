package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    @Test
    void creation() {
        new Session();
    }

    @Test
    void setObject() {
        Session session = new Session();

        session.setObjective(new Objective("강의 반복 과제 완료하기", 0));

        assertEquals(new Objective("강의 반복 과제 완료하기", 0), session.getObjective());
    }

    @Test
    void start() {
        Session session = new Session();

        assertEquals("Waiting", session.status());

        session.start();

        assertEquals("InProgress", session.status());

        session.end();

        assertEquals("Exit", session.status());
    }

    @Test
    void completed() {
        Session session = new Session();

        assertFalse(session.isCompleted());

        session.completed();

        assertTrue(session.isCompleted());
    }

    @Test
    void setConcentrationLevel() {
        Session session = new Session();

        assertEquals("보통", session.getConcentrationLabel());

        session.setConcentrationLevel("높음");

        assertEquals("높음", session.getConcentrationLabel());
    }
}
