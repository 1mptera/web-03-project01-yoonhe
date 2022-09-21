package panels;

import models.Objective;
import models.Pomodoro;
import models.Session;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import java.util.List;

public class ObjectiveSelectBoxPanel extends JPanel {
    private Session session;
    private List<Objective> objectives;

    public ObjectiveSelectBoxPanel(Session session, List<Objective> objectives) {
        this.session = session;
        this.objectives = objectives;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(20, 0, 0, 0));
        this.setOpaque(false);

        createLabel(this, "목표를 고르세요");

        createObjectiveComboBox();
    }

    private void createObjectiveComboBox() {
        JComboBox comboBox = new JComboBox();

        this.add(comboBox);

        for (Objective objective : objectives) {
            comboBox.addItem(objective.getTitle());
        }

        comboBox.addActionListener(event -> {
            session.setObjective(comboBox.getSelectedItem().toString());
        });
    }


    private void createLabel(JPanel target, String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBackground(Color.white);
        target.add(label);
    }
}
