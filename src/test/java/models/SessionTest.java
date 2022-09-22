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
    void setReview() {
        Session session = new Session();

        session.setReview(true, "높음", "새로 알게된 것", "아쉬원던 점", "개선시킬 점");

        assertArrayEquals(new String[]{
                "완료", "높음", "새로 알게된 것", "아쉬원던 점", "개선시킬 점"
        }, session.reviews());
    }
}
