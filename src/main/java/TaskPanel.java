import models.Task;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskPanel extends JPanel {
    public TaskPanel(Task task) {
        JLabel label = new JLabel("- " + task.getTitle());
        this.add(label);

        this.add(new JButton("삭제"));
        this.add(new JButton("수정"));
    }
}
