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

        session.setObjective("강의 반복 과제 완료하기");

        assertEquals("강의 반복 과제 완료하기", session.getObjective());
    }
}
