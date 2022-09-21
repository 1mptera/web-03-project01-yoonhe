package pages;

import models.Pomodoro;
import models.Session;
import panels.ObjectiveSelectBoxPanel;
import panels.TaskSelectBoxPanel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

public class SessionPage extends JPanel {
    private Session session;
    private Pomodoro pomodoro;

    public SessionPage(Pomodoro pomodoro) {
        session = new Session();

        this.pomodoro = pomodoro;

        if (pomodoro.getQuantity() == 0) {
            createLabel(this, "뽀모도로를 먼저 생성하세요");
            return;
        }

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createQuantity();

        this.add(new ObjectiveSelectBoxPanel(session, pomodoro.getObjectives()));

        this.add(new TaskSelectBoxPanel(session, pomodoro.getTasks()));
    }

    public void createQuantity() {
        JLabel label = new JLabel("1 / " + pomodoro.getQuantity());

        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(label);
    }

    private void createLabel(JPanel target, String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBackground(Color.white);
        target.add(label);
    }
}
