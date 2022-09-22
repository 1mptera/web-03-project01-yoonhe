package panels;

import models.Pomodoro;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class ContentPanel extends JPanel {
    private Pomodoro pomodoro;

    public ContentPanel(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;

        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        this.add(new SettingPage(pomodoro));
    }

    public void update(JPanel panel) {
        this.removeAll();

        this.add(panel);

        this.setVisible(false);
        this.setVisible(true);
    }
}
