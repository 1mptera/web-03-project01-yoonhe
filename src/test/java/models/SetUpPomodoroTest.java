package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetUpPomodoroTest {
    @Test
    void creation() {
        Routine routine = new Routine();

        SetUpPomodoro setUpPomodoro = new SetUpPomodoro(
                routine.quantity(), routine.objectives(), routine.tasks()
        );

        assertEquals(2, setUpPomodoro.quantity());
        assertEquals(routine.objectives(), setUpPomodoro.objectives());
        assertEquals(routine.tasks(), setUpPomodoro.tasks());

        List<Objective> otherObjectives = List.of(
                new Objective("강의 노트 작성하기", 0),
                new Objective("개념 노트 작성하기", 0),
                new Objective("개념 노트 나만의 언어로 정제하기", 0)
        );

        List<Task> otherTasks = List.of(
                new Task("첫번째 강의 노트 작성", false),
                new Task("두번째 강의 노트 작성", false),
                new Task("첫번째 강의 개념 노트 작성", false),
                new Task("두번째 강의 개념 노트 작성", false)
        );

        assertEquals(2, setUpPomodoro.quantity());
        assertEquals(otherObjectives, setUpPomodoro.objectives());
        assertEquals(otherTasks, setUpPomodoro.tasks());
    }
}
