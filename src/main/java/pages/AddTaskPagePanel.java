package pages;

import models.Task;
import panels.TasksPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.List;

public class AddTaskPagePanel extends JPanel {
    private List<Task> tasks;

    private CardLayout pages;
    private TasksPanel tasksPanel;
    private JPanel contentPanel;
    private JPanel headPanel;
    private JTextField textField;

    public AddTaskPagePanel(CardLayout pages, JPanel contentPanel) {
        this.pages = pages;
        this.contentPanel = contentPanel;

        this.setLayout(new BorderLayout());

        createInputFieldPanel();

        createTasksPanel();

        createPaginationPanel(pages, contentPanel);
    }

    public void createInputFieldPanel() {
        headPanel = new JPanel();
        this.add(headPanel, BorderLayout.PAGE_START);

        headPanel.add(new JLabel("할 일 추가"));

        textField = new JTextField(15);
        headPanel.add(textField);

        createAddButton();
    }

    private void createTasksPanel() {
        tasks = new ArrayList<>();

        tasksPanel = new TasksPanel(tasks);

        this.add(tasksPanel);
    }

    private void createPaginationPanel(CardLayout pages, JPanel contentPanel) {
        this.add(
                new PaginationPanel(pages, contentPanel),
                BorderLayout.PAGE_END
        );
    }

    public void createAddButton() {
        JButton button = new JButton("추가");
        button.addActionListener(event -> {
            String text = textField.getText();

            tasks.add(new Task(text, false));

            cleatTextField();

            tasksPanel.update();
        });
        headPanel.add(button);
    }

    public void cleatTextField() {
        textField.setText("");
    }
}
