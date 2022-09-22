package models;

public class Task {
    private String title;
    private boolean completed;

    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String title() {
        return title;
    }

    public void editTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "작업: " + title + " / 완료 여부: " + completedToString();
    }

    public void complete() {
        completed = true;
    }

    public void incomplete() {
        completed = false;
    }

    public boolean completed() {
        return completed;
    }

    public String completedToString() {
        return completed ? "성공" : "실패";
    }
}
