package panels;

import models.Task;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskPanel extends JPanel {
    private Task task;

    private JPanel taskTitlePanel;
    private JPanel taskFieldPanel;
    private TasksPanel tasksPanel;

    private JTextField textField;

    public TaskPanel(Task task, TasksPanel tasksPanel) {
        this.task = task;
        this.tasksPanel = tasksPanel;

        createTaskTitlePanel();
        createTaskFieldPanel();
    }

    public void createTaskTitlePanel() {
        taskTitlePanel = new JPanel();

        this.add(taskTitlePanel);

        displayTaskTitle();
    }

    private void updateTaskTitlePanel() {
        taskTitlePanel.removeAll();

        displayTaskTitle();

        taskTitlePanel.setVisible(false);
        taskTitlePanel.setVisible(true);
    }

    private void displayTaskTitle() {
        taskTitlePanel.add(new JLabel("- " + task.getTitle()));

        taskTitlePanel.add(createEditButton());
        taskTitlePanel.add(createDeleteButton());
    }

    private JButton createDeleteButton() {
        JButton button = new JButton("삭제");
        button.addActionListener(event -> {
            tasksPanel.deleteTasks(task);
        });
        return button;
    }

    private JButton createEditButton() {
        JButton button = new JButton("수정");
        button.addActionListener(event -> {
            textField.setText(task.getTitle());

            onEditMode();
        });
        return button;
    }

    private void onEditMode() {
        taskTitlePanel.setVisible(false);
        taskFieldPanel.setVisible(true);
    }

    public void createTaskFieldPanel() {
        taskFieldPanel = new JPanel();
        this.add(taskFieldPanel);

        textField = new JTextField(15);
        taskFieldPanel.add(textField);

        taskFieldPanel.add(createConfirmButton());

        taskFieldPanel.setVisible(false);
    }

    private JButton createConfirmButton() {
        JButton button = new JButton("확인");
        button.addActionListener(event -> {
            String text = textField.getText();

            task.editTitle(text);

            onReadMode();
        });
        return button;
    }

    private void onReadMode() {
        taskFieldPanel.setVisible(false);

        updateTaskTitlePanel();
    }
}
