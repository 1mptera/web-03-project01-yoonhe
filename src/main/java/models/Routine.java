package models;

import java.util.ArrayList;
import java.util.List;

public class Routine {
    private String type;
    private List<Objective> objectives = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public Routine() {
        this.type = "주말";

        objectives.add(new Objective("강의 노트 작성하기", 0));
        objectives.add(new Objective("개념 노트 작성하기", 0));
        objectives.add(new Objective("개념 노트 나만의 언어로 정제하기", 0));

        tasks.add(new Task("첫번째 강의 노트 작성", false));
        tasks.add(new Task("두번째 강의 노트 작성", false));
        tasks.add(new Task("첫번째 강의 개념 노트 작성", false));
        tasks.add(new Task("두번째 강의 개념 노트 작성", false));
    }

    public Routine(String type) {
        this.type = type;

        if (type.equals("주간")) {
            objectives.add(new Objective("코딩 테스트", 0));
            objectives.add(new Objective("강의 반복 과제", 0));
            objectives.add(new Objective("퀘스트 과제", 0));

            tasks.add(new Task("30분안에 못풀면 답지 보고 이해하기", false));
            tasks.add(new Task("왜를 생각하며 인출하기", false));
            tasks.add(new Task("과제하면서 강의 코드를 대입할 부분을 찾아 적용하기", false));
        }
    }

    public String type() {
        return type;
    }

    public int quantity() {
        if (type.equals("주간")) {
            return 10;
        }

        return 2;
    }

    public List<Objective> objectives() {
        return objectives;
    }

    public List<Task> tasks() {
        return tasks;
    }
}
