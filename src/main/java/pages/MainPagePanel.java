package pages;

import models.Objective;
import models.Pomodoro;
import panels.Big3Panel;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.List;

public class MainPagePanel extends JPanel {
    private Pomodoro pomodoro;

    private JPanel buttonPanel;
    private CardLayout pages;
    private JPanel contentPanel;

    private List<Objective> objectives;

    public MainPagePanel(CardLayout pages, JPanel contentPanel, Pomodoro pomodoro) {
        this.pages = pages;
        this.contentPanel = contentPanel;
        this.pomodoro = pomodoro;

        this.setLayout(new BorderLayout());

        initBig3Panel();
        initButtonPanel();
    }

    private void initBig3Panel() {
        objectives = pomodoro.getObjectives();

        createObjectives();

        this.add(new Big3Panel(objectives));
    }

    private void createObjectives() {
        pomodoro.addObjective(new Objective("강의 반복 과제", 0));
        pomodoro.addObjective(new Objective("코딩 도장", 0));
        pomodoro.addObjective(new Objective("투두리스트", 0));
    }

    public void initButtonPanel() {
        buttonPanel = new JPanel();

        this.add(buttonPanel, BorderLayout.PAGE_END);

        createStartButton();
    }

    public void createStartButton() {
        JButton button = new JButton("시작하기");
        button.addActionListener(event -> {
            pages.show(contentPanel, "AddTaskPage");
        });
        buttonPanel.add(button);
    }
}
