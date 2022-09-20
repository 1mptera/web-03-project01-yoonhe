package pages;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class PaginationPanel extends JPanel {
    private JPanel contentPanel;

    public PaginationPanel(CardLayout pages, JPanel contentPanel) {
        this.contentPanel = contentPanel;

        this.add(createPreviousButton(pages));
        this.add(createNextButton(pages));
    }

    public JButton createNextButton(CardLayout pages) {
        JButton button = new JButton("다음");
        button.addActionListener(event -> {
            pages.next(contentPanel);
        });
        return button;
    }

    public JButton createPreviousButton(CardLayout pages) {
        JButton button = new JButton("이전");
        button.addActionListener(event -> {
            pages.previous(contentPanel);
        });
        return button;
    }
}
