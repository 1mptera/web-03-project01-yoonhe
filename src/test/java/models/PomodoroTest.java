package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PomodoroTest {
    @Test
    void creation() {
        new Pomodoro();
    }

    @Test
    void getObjectives() {
        Pomodoro pomodoro = new Pomodoro();

        assertNotNull(pomodoro.objectives());
    }

    @Test
    void addObjective() {
        Pomodoro pomodoro = new Pomodoro();

        List<Objective> objectives = pomodoro.objectives();

        objectives.add(new Objective("강의 반복 과제", 0));
        objectives.add(new Objective("강의 반복 과제", 0));
        objectives.add(new Objective("강의 반복 과제", 0));

        assertEquals(3, pomodoro.objectives().size());
    }

    @Test
    void getTasks() {
        Pomodoro pomodoro = new Pomodoro();

        assertNotNull(pomodoro.tasks());
    }

    @Test
    void addTasks() {
        Pomodoro pomodoro = new Pomodoro();

        List<Task> tasks = pomodoro.tasks();

        tasks.add(new Task("강의 반복 과제", false));

        assertEquals(1, tasks.size());
    }

    @Test
    void setQuantity() {
        Pomodoro pomodoro = new Pomodoro();

        pomodoro.setQuantity(5);

        assertEquals(5, pomodoro.quantity());

        pomodoro.setQuantity(8);

        assertEquals(8, pomodoro.quantity());
    }

    @Test
    void addSession() {
        Pomodoro pomodoro = new Pomodoro();

        pomodoro.setQuantity(2);

        assertEquals(1, pomodoro.currentInProgressSessionIndex());

        Session session = new Session();

        Task task = new Task("작업1", true);
        ConcentrationLevel concentrationLevel = new ConcentrationLevel();

        Review review = new Review(
                task,
                concentrationLevel,
                "객체 지향에 대해 알게되었다",
                "목표와 정렬되지 않은 일을 했다",
                "목표와 정렬된 일을 고르자"
        );

        session.setReview(review);

        pomodoro.addSession(session);

        assertEquals(2, pomodoro.currentInProgressSessionIndex());

        assertEquals(1, pomodoro.sessions().size());
    }
}
