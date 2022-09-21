package panels;

import models.Task;

import javax.swing.BoxLayout;

import javax.swing.JPanel;

import java.util.List;

public class TasksPanel extends JPanel {
    private List<Task> tasks;

    public TasksPanel(List<Task> tasks) {
        this.tasks = tasks;
        
        this.setOpaque(false);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        displayTasks();
    }

    public void deleteTasks(Task task) {
        tasks.remove(task);

        update();
    }

    public void update() {
        this.removeAll();

        displayTasks();

        this.setVisible(false);
        this.setVisible(true);
    }

    public void displayTasks() {
        for (Task task : tasks) {
            this.add(new TaskPanel(task, this));
        }
    }
}
