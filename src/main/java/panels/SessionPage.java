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

    private ObjectiveSelectBoxPanel objectiveSelectBoxPanel;
    private TaskSelectBoxPanel taskSelectBoxPanel;
    private JPanel beforeStartingSettingPanel;
    private ContentPanel contentPanel;

    public SessionPage(Pomodoro pomodoro, ContentPanel contentPanel) {
        session = new Session();

        this.pomodoro = pomodoro;

        this.contentPanel = contentPanel;

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createQuantity();

        createBeforeStartingSettingPanel();
    }

    public void createBeforeStartingSettingPanel() {
        beforeStartingSettingPanel = new JPanel();
        beforeStartingSettingPanel.setLayout(
                new BoxLayout(beforeStartingSettingPanel, BoxLayout.Y_AXIS)
        );
        this.add(beforeStartingSettingPanel);

        createObjectiveSelectBoxPanel();

        createTaskSelectBoxPanel();

        createButtonPanel();
    }

    public void createQuantity() {
        JLabel label =
                new JLabel(pomodoro.currentInProgressSessionIndex() +
                        " / " + pomodoro.quantity());

        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(label);
    }

    public void createObjectiveSelectBoxPanel() {
        objectiveSelectBoxPanel
                = new ObjectiveSelectBoxPanel(session, pomodoro.objectives());

        beforeStartingSettingPanel.add(objectiveSelectBoxPanel);
    }

    public void createTaskSelectBoxPanel() {
        taskSelectBoxPanel
                = new TaskSelectBoxPanel(session, pomodoro.tasks());

        beforeStartingSettingPanel.add(taskSelectBoxPanel);
    }

    public void createReviewFieldContainerPanel() {
        reviewFieldContainerPanel =
                new ReviewFieldsContainerPanel(pomodoro, session, contentPanel);
        this.add(reviewFieldContainerPanel);
    }

    public void createButtonPanel() {
        sessionMainButtonPanel = new JPanel();

        beforeStartingSettingPanel.add(sessionMainButtonPanel);

        sessionMainButtonPanel.add(createStartButton());
    }

    public Component createStartButton() {
        JButton button = new JButton("세션 시작");

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(event -> {
            if (session.objective() == null) {
                session.setObjective(pomodoro.objectives().get(0));
            }

            if (session.task() == null) {
                session.setTask(pomodoro.tasks().get(0));
            }

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
            session.end();

            beforeStartingSettingPanel.setVisible(false);
            sessionMainButtonPanel.setVisible(false);
            createReviewFieldContainerPanel();
        });

        return button;
    }
}
