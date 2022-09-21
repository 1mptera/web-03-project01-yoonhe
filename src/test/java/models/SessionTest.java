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
}
