package panels;

import models.Pomodoro;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SettingPomodoroQuantityPanel extends JPanel {
    private Pomodoro pomodoro;
    private JPanel comboBoxPanel;

    public SettingPomodoroQuantityPanel(
            Pomodoro pomodoro
    ) {
        this.pomodoro = pomodoro;

        this.setOpaque(false);

        this.setLayout(new BorderLayout());

        createTitlePanel();

        createDropBox();
    }

    private void createDropBox() {
        comboBoxPanel = new JPanel();
        this.add(comboBoxPanel);

        comboBoxPanel.setOpaque(false);

        JComboBox comboBox = new JComboBox();

        for (int i = 1; i <= 10; i += 1) {
            comboBox.addItem(i);
        }

        comboBox.addActionListener(event -> {
            pomodoro.setQuantity(5);
        });

        comboBoxPanel.add(comboBox);
    }

    private void createTitlePanel() {
        JPanel titlePanel = new JPanel();

        titlePanel.add(new JLabel("뽀모도로 수량 설정"));
        titlePanel.setOpaque(false);

        this.add(titlePanel, BorderLayout.PAGE_START);
    }
}
