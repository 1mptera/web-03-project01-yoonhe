package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void creation() {
        new Task("강의 반복 과제", false);
    }

    @Test
    void getTitle() {
        Task task = new Task("강의 반복 과제", false);

        assertEquals("강의 반복 과제", task.getTitle());
    }
}
