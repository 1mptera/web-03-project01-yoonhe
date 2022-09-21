package pages;

import models.Pomodoro;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class PomodoroQuantityPage extends JPanel {
    private CardLayout pages;
    private JPanel contentPanel;
    private Pomodoro pomodoro;
    private JPanel comboBoxPanel;

    public PomodoroQuantityPage(
            CardLayout pages,
            JPanel contentPanel,
            Pomodoro pomodoro
    ) {
        this.pages = pages;
        this.contentPanel = contentPanel;
        this.pomodoro = pomodoro;

        this.setLayout(new BorderLayout());

        createTitlePanel();

        createDropBox();

        createPaginationPanel(pages, contentPanel);
    }

    private void createDropBox() {
        comboBoxPanel = new JPanel();
        this.add(comboBoxPanel);

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

        this.add(titlePanel, BorderLayout.PAGE_START);
    }

    private void createPaginationPanel(CardLayout pages, JPanel contentPanel) {
        this.add(new PaginationPanel(pages, contentPanel), BorderLayout.PAGE_END);
    }
}
