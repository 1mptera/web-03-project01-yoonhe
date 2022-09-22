package models;

public class Session {
    private Objective objective;
    private Task task;

    private String status;
    private boolean completed;
    private String concentrationLevel;
    private String newPoint;
    private String improvementPoint;
    private String regretPoint;

    public Session() {
        this.completed = false;
        this.status = "Waiting";
        this.concentrationLevel = "보통";
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void start() {
        status = "InProgress";
    }

    public String status() {
        return status;
    }

    public void end() {
        status = "Exit";
    }

    public boolean isCompleted() {
        return completed;
    }

    public String concentrationLevel() {
        return concentrationLevel;
    }

    public void setReview(
            boolean completed,
            String concentrationLevel,
            String newPoint,
            String improvementPoint,
            String regretPoint
    ) {
        this.completed = completed;
        this.concentrationLevel = concentrationLevel;
        this.newPoint = newPoint;
        this.improvementPoint = improvementPoint;
        this.regretPoint = regretPoint;
    }

    public String[] reviews(
    ) {
        return new String[]{"완료", "높음", "새로 알게된 것", "아쉬원던 점", "개선시킬 점"};
    }
}
