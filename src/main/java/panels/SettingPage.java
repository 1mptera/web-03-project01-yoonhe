package panels;

import models.Pomodoro;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SettingPage extends JPanel {
    private Pomodoro pomodoro;

    public SettingPage(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;

        this.setOpaque(false);

        this.setLayout(new BorderLayout());

        this.add(new Big3Panel(pomodoro), BorderLayout.PAGE_START);
        this.add(new SettingPomodoroQuantityPanel(pomodoro));
        this.add(new SettingTaskPanel(pomodoro), BorderLayout.PAGE_END);
    }
}
