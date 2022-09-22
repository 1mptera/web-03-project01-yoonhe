import models.Pomodoro;

import panels.ContentPanel;
import panels.ReviewListPage;
import panels.SessionPage;
import panels.SettingPage;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

public class PomodoroChecker {
    private JFrame frame;
    private ContentPanel contentPanel;

    private Pomodoro pomodoro;

    public static void main(String[] args) {
        PomodoroChecker application = new PomodoroChecker();
        application.run();
    }

    private void run() {
        pomodoro = new Pomodoro();

        initFrame();

        initNavigationPanel();

        initContentPanel();

        frame.setVisible(true);
    }

    public void initFrame() {
        frame = new JFrame("Pomodoro");
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initNavigationPanel() {
        JPanel navigationPanel = new JPanel();

        frame.add(navigationPanel, BorderLayout.WEST);

        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS));
        navigationPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        navigationPanel.setBackground(Color.orange);

        navigationPanel.add(createSettingButton());
        navigationPanel.add(createSessionButton());
        navigationPanel.add(createReviewButton());
    }

    public void initContentPanel() {
        contentPanel = new ContentPanel(pomodoro);

        frame.add(contentPanel, BorderLayout.CENTER);
    }

    private JButton createSettingButton() {
        JButton button = new JButton("설정");
        button.addActionListener(event -> {
            contentPanel.update(new SettingPage(pomodoro));
        });
        return button;
    }

    private JButton createSessionButton() {
        JButton button = new JButton("세션");
        button.addActionListener(event -> {
            contentPanel.update(new SessionPage(pomodoro, contentPanel));
        });
        return button;
    }

    private JButton createReviewButton() {
        JButton button = new JButton("리뷰");
        button.addActionListener(event -> {
            contentPanel.update(new ReviewListPage(pomodoro, contentPanel));
        });
        return button;
    }
}
