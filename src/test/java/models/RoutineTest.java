package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoutineTest {
    @Test
    void defaultCreation() {
        new Routine();
    }

    @Test
    void defaultValues() {
        Routine routine = new Routine();

        List<Objective> objectives = routine.objectives();

        assertEquals("주말", routine.type());

        assertNotNull(objectives);

        assertEquals("강의 노트 작성하기", objectives.get(0).title());
        assertEquals("개념 노트 작성하기", objectives.get(1).title());
        assertEquals("개념 노트 나만의 언어로 정제하기", objectives.get(2).title());

        List<Task> tasks = routine.tasks();

        assertEquals("첫번째 강의 노트 작성", tasks.get(0).title());
        assertEquals("두번째 강의 노트 작성", tasks.get(1).title());
        assertEquals("첫번째 강의 개념 노트 작성", tasks.get(2).title());
        assertEquals("두번째 강의 개념 노트 작성", tasks.get(3).title());

        assertEquals(2, routine.quantity());
    }

    @Test
    void weeklyCreation() {
        new Routine("주간");
    }

    @Test
    void weeklyValues() {
        Routine routine = new Routine("주간");

        List<Objective> objectives = routine.objectives();

        assertEquals("주간", routine.type());

        assertNotNull(objectives);

        assertEquals("코딩 테스트", objectives.get(0).title());
        assertEquals("강의 반복 과제", objectives.get(1).title());
        assertEquals("퀘스트 과제", objectives.get(2).title());

        List<Task> tasks = routine.tasks();

        assertNotNull(tasks);

        assertEquals("30분안에 못풀면 답지 보고 이해하기", tasks.get(0).title());
        assertEquals("왜를 생각하며 인출하기", tasks.get(1).title());
        assertEquals("과제하면서 강의 코드를 대입할 부분을 찾아 적용하기", tasks.get(2).title());

        assertEquals(10, routine.quantity());
    }
}
