package panels;

import models.Objective;
import models.Pomodoro;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.util.List;

public class Big3Panel extends JPanel {
    private List<Objective> objectives;

    public Big3Panel(Pomodoro pomodoro) {
        this.objectives = pomodoro.objectives();

        pomodoro.setObjectives(objectives);

        this.setOpaque(false);

        this.setBorder(new EmptyBorder(30, 0, 30, 0));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("< 오늘의 big 3 >");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);

        title.setBorder(new EmptyBorder(0, 0, 20, 0));

        for (Objective objective : objectives) {
            JLabel label = new JLabel(objective.toString());
            label.setBorder(new EmptyBorder(0, 0, 5, 0));

            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            this.add(label);
        }
    }
}
