package panels;

import models.Objective;
import models.Pomodoro;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

public class Big3Panel extends JPanel {
    public Big3Panel(Pomodoro pomodoro) {
        List<Objective> objectives = pomodoro.getObjectives();

        this.setOpaque(false);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("< 오늘의 big 3 >");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);

        title.setBorder(new EmptyBorder(0, 0, 20, 0));

        objectives.removeAll(objectives);

        objectives.add(new Objective("강의 반복 과제", 0));
        objectives.add(new Objective("코딩 도장", 0));
        objectives.add(new Objective("퀘스트 과제", 0));

        for (Objective objective : objectives) {
            JLabel label = new JLabel(objective.toString());
            label.setBorder(new EmptyBorder(0, 0, 5, 0));

            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            this.add(label);
        }
    }
}
