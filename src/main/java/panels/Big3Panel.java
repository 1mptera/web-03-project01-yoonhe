package panels;

import models.Objective;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.util.List;

public class Big3Panel extends JPanel {
    public Big3Panel(List<Objective> objectives) {
        this.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        this.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("< 오늘의 big 3 >");

        panel.add(title);

        title.setBorder(new EmptyBorder(0, 0, 20, 0));

        for (Objective objective : objectives) {
            JLabel label = new JLabel(objective.toString());
            label.setBorder(new EmptyBorder(0, 0, 5, 0));

            panel.add(label);
        }
    }
}
