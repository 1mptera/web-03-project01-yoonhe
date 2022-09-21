package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectiveTest {
    @Test
    void creation() {
        new Objective("강의 반복 과제 완료 하기", 0);
    }

    @Test
    void equals() {
        Objective objective = new Objective("강의 반복 과제 완료 하기", 0);

        assertEquals(new Objective("강의 반복 과제 완료 하기", 0), objective);
    }

    @Test
    void string() {
        Objective objective = new Objective("강의 반복 과제 완료 하기", 0);

        assertEquals("강의 반복 과제 완료 하기 (0%)", objective.toString());
    }
}
