import models.Task;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.List;

public class AddTaskPagePanel extends JPanel {
    private List<Task> tasks;

    private CardLayout pages;

    private JPanel contentPanel;
    private JPanel headPanel;
    private JPanel tasksPanel;
    private JPanel buttonsPanel;

    private JTextField textField;

    public AddTaskPagePanel(CardLayout pages, JPanel contentPanel) {
        tasks = new ArrayList<>();

        this.pages = pages;
        this.contentPanel = contentPanel;

        this.setLayout(new BorderLayout());

        createInputFieldPanel();

        createTasksPanel();

        createButtonsPanel();
    }

    private void createInputFieldPanel() {
        headPanel = new JPanel();
        this.add(headPanel, BorderLayout.PAGE_START);
        headPanel.add(new JLabel("할 일 추가"));

        textField = new JTextField(10);
        headPanel.add(textField);

        createAddButton();
    }

    private void createAddButton() {
        JButton button = new JButton("추가");
        button.addActionListener(event -> {
            String text = textField.getText();

            tasks.add(new Task(text, false));

            cleatTextField();

            updateTasksPanel();
        });
        headPanel.add(button);
    }

    private void cleatTextField() {
        textField.setText("");
    }

    public void createTasksPanel() {
        tasksPanel = new JPanel();
        tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.Y_AXIS));
        this.add(tasksPanel);

        displayTasks();
    }

    public void updateTasksPanel() {
        tasksPanel.removeAll();

        displayTasks();

        tasksPanel.setVisible(false);
        tasksPanel.setVisible(true);
    }

    private void displayTasks() {
        for (Task task : tasks) {
            tasksPanel.add(new TaskPanel(task));
        }
    }

    public void createButtonsPanel() {
        buttonsPanel = new JPanel();
        this.add(buttonsPanel, BorderLayout.PAGE_END);

        buttonsPanel.add(createPreviousButton(pages));
        buttonsPanel.add(createNextButton());
    }

    private JButton createNextButton() {
        JButton button = new JButton("다음");
        button.addActionListener(event -> {

        });
        return button;
    }

    private JButton createPreviousButton(CardLayout pages) {
        JButton button = new JButton("이전");
        button.addActionListener(event -> {
            pages.previous(contentPanel);
        });
        return button;
    }
}
