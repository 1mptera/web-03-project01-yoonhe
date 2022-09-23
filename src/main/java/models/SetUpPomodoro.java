package models;


import java.util.List;

public class SetUpPomodoro {
    private int quantity;
    private List<Objective> objectives;
    private List<Task> tasks;

    public SetUpPomodoro(
            int quantity,
            List<Objective> objectives,
            List<Task> tasks
    ) {
        this.quantity = quantity;

        this.objectives = objectives;

        this.tasks = tasks;
    }

    public int quantity() {
        return quantity;
    }

    public List<Objective> objectives() {
        return objectives;
    }

    public List<Task> tasks() {
        return tasks;
    }
}
