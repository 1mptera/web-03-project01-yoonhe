package panels;

import models.Session;
import models.Task;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

public class TaskSelectBoxPanel extends JPanel {
    private Session session;
    private List<Task> tasks;

    public TaskSelectBoxPanel(Session session, List<Task> tasks) {
        this.session = session;
        this.tasks = tasks;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(20, 0, 50, 0));
        this.setOpaque(false);

        createLabel(this, "작업을 고르세요");

        createObjectiveComboBox();
    }

    private void createObjectiveComboBox() {
        JComboBox comboBox = new JComboBox();

        this.add(comboBox);

        for (Task task : tasks) {
            comboBox.addItem(task.title());
        }

        comboBox.addActionListener(event -> {
            Task task = new Task((String) comboBox.getSelectedItem(), false);

            session.setTask(task);
        });
    }


    private void createLabel(JPanel target, String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBackground(Color.white);
        target.add(label);
    }
}
