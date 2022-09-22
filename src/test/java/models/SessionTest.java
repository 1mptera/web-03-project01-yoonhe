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

        assertEquals(new Objective("강의 반복 과제 완료하기", 0), session.objective());
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

        Task task = new Task("마뱅", true);

        ConcentrationLevel concentrationLevel = new ConcentrationLevel();
        concentrationLevel.setLevel("높음");

        Review review = new Review(
                task,
                concentrationLevel,
                "객체 지향에 대해 알게되었다",
                "목표와 정렬되지 않은 일을 했다",
                "목표와 정렬된 일을 고르자"
        );

        session.setReview(review);

        assertArrayEquals(new String[]{
                "작업: 마뱅 / 완료 여부: 성공",
                "집중도: 높음",
                "새로 알게된 것: 객체 지향에 대해 알게되었다",
                "아쉬원던 점: 목표와 정렬되지 않은 일을 했다",
                "개선시킬 점: 목표와 정렬된 일을 고르자"
        }, session.review().values());
    }
}
