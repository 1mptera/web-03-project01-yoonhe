package panels;

import models.Pomodoro;
import models.Task;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.util.List;

public class SettingTaskPanel extends JPanel {
    private List<Task> tasks;

    private TasksPanel tasksPanel;

    private JTextField textField;
    private JPanel inputFieldPanel;

    public SettingTaskPanel(Pomodoro pomodoro) {
        this.tasks = pomodoro.getTasks();

        this.setOpaque(false);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(20, 0, 0, 0));

        JLabel label = new JLabel("< 할 일 추 가 >");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label);

        createInputFieldPanel();

        createTasksPanel();
    }

    public void createInputFieldPanel() {
        inputFieldPanel = new JPanel();
        this.add(inputFieldPanel);

        inputFieldPanel.setOpaque(false);

        textField = new JTextField(10);

        inputFieldPanel.add(textField);

        createAddButton();
    }

    private void createTasksPanel() {
        tasksPanel = new TasksPanel(tasks);

        this.add(tasksPanel);
    }

    public void createAddButton() {
        JButton button = new JButton("추가");
        button.addActionListener(event -> {
            String text = textField.getText();

            if (text.equals("")) {
                return;
            }

            tasks.add(new Task(text, false));

            cleatTextField();

            tasksPanel.update();
        });
        inputFieldPanel.add(button);
    }

    public void cleatTextField() {
        textField.setText("");
    }
}
