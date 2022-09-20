package pages;

import models.Objective;
import panels.Big3Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.List;

public class MainPagePanel extends JPanel {
    private JPanel buttonPanel;
    private CardLayout pages;
    private JPanel contentPanel;

    public MainPagePanel(CardLayout pages, JPanel contentPanel) {
        this.pages = pages;
        this.contentPanel = contentPanel;

        this.setLayout(new BorderLayout());

        initBig3Panel();
        initButtonPanel();
    }

    private void initBig3Panel() {
        List<Objective> objectives = loadObjectives();

        this.add(new Big3Panel(objectives));
    }


    public List<Objective> loadObjectives() {
        return List.of(
                new Objective("강의 반복 과제", 0),
                new Objective("코딩 도장", 0),
                new Objective("투두 리스트 과제", 0)
        );
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
