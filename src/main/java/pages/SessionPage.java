package pages;

import models.Objective;
import models.Pomodoro;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

public class SessionPage extends JPanel {
    private Pomodoro pomodoro;

    private JPanel objectiveFieldPanel;

    public SessionPage(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;

        if (pomodoro.getQuantity() == 0) {
            createLabel(this, "뽀모도로를 먼저 생성하세요");
            return;
        }

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createQuantity();

        createObjectiveSelectBox();
    }

    public void createQuantity() {
        JLabel label = new JLabel("1 / " + pomodoro.getQuantity());

        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(label);
    }

    public void createObjectiveSelectBox() {
        objectiveFieldPanel = new JPanel();

        this.add(objectiveFieldPanel);

        objectiveFieldPanel.setLayout(new BoxLayout(objectiveFieldPanel, BoxLayout.Y_AXIS));
        objectiveFieldPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        objectiveFieldPanel.setOpaque(false);

        createLabel(objectiveFieldPanel, "목표를 고르세요");

        createObjectiveComboBox();
    }

    private void createObjectiveComboBox() {
        JComboBox comboBox = new JComboBox();

        comboBox.setModel(new DefaultComboBoxModel(
                        new String[]{
                                new Objective("강의 반복 과제", 0).getTitle(),
                                new Objective("개념 공부", 0).getTitle(),
                        }
                )
        );

        objectiveFieldPanel.add(comboBox);
    }


    private void createLabel(JPanel target, String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBackground(Color.white);
        target.add(label);
    }
}
