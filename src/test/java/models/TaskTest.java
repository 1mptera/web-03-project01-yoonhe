package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void creation() {
        new Task("강의 반복 과제", false);
    }

    @Test
    void string() {
        Task task = new Task("강의 반복 과제", false);

        assertEquals("작업: 강의 반복 과제 / 완료 여부: 실패", task.toString());
    }

    @Test
    void getTitle() {
        Task task = new Task("강의 반복 과제", false);

        assertEquals("강의 반복 과제", task.title());
    }

    @Test
    void editTitle() {
        Task task = new Task("강의 반복 과제", false);

        task.editTitle("수정 강의 반복 과제");

        assertEquals("수정 강의 반복 과제", task.title());
    }

    @Test
    void completedToString() {
        Task task = new Task("강의 반복 과제", false);

        assertEquals("실패", task.completedToString());

        task.complete();

        assertEquals("성공", task.completedToString());
    }

    @Test
    void complete() {
        Task task = new Task("강의 반복 과제", false);

        task.complete();

        assertTrue(task.completed());
    }

    @Test
    void incomplete() {
        Task task = new Task("강의 반복 과제", true);

        task.incomplete();

        assertFalse(task.completed());
    }
}
