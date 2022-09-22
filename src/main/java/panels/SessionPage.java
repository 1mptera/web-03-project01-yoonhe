package panels;

import models.Pomodoro;
import models.Session;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;

public class SessionPage extends JPanel {
    private ReviewFieldsContainerPanel reviewFieldContainerPanel;

    private Session session;
    private Pomodoro pomodoro;
    private JPanel sessionMainButtonPanel;

    public SessionPage(Pomodoro pomodoro) {
        session = new Session();

        this.pomodoro = pomodoro;

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createQuantity();

        createObjectiveSelectBoxPanel();

        createTaskSelectBoxPanel();

        createButtonPanel();

        createReviewFieldContainerPanel();
    }

    public void createQuantity() {
        JLabel label = new JLabel("1 / " + pomodoro.getQuantity());

        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(label);
    }

    public void createObjectiveSelectBoxPanel() {
        this.add(new ObjectiveSelectBoxPanel(session, pomodoro.getObjectives()));
    }

    public void createTaskSelectBoxPanel() {
        this.add(new TaskSelectBoxPanel(session, pomodoro.getTasks()));
    }

    public void createReviewFieldContainerPanel() {
        reviewFieldContainerPanel = new ReviewFieldsContainerPanel(session);
        this.add(reviewFieldContainerPanel);
    }

    public void createButtonPanel() {
        sessionMainButtonPanel = new JPanel();

        this.add(sessionMainButtonPanel);

        sessionMainButtonPanel.add(createStartButton());
    }

    public Component createStartButton() {
        JButton button = new JButton("세션 시작");

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(event -> {
            session.start();

            sessionMainButtonPanel.removeAll();
            sessionMainButtonPanel.add(createEndButton());
            sessionMainButtonPanel.setVisible(false);
            sessionMainButtonPanel.setVisible(true);
        });

        return button;
    }

    public Component createEndButton() {
        JButton button = new JButton("세션 종료");

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(event -> {
            sessionMainButtonPanel.setVisible(false);
            reviewFieldContainerPanel.setVisible(true);
        });

        return button;
    }
}
