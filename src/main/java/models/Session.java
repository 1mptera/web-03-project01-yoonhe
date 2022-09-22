package models;

public class Session {
    private Objective objective;
    private Task task;
    private Review review;

    private String status;

    public Session() {
        this.status = "Waiting";
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Objective objective() {
        return objective;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task task() {
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

    public void setReview(
            Review review
    ) {
        this.review = review;
    }

    public Review review() {
        return review;
    }
}
