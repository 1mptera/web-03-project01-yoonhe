import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class PomodoroQuantityPage extends JPanel {
    private CardLayout pages;
    private JPanel contentPanel;

    public PomodoroQuantityPage(CardLayout pages, JPanel contentPanel) {
        this.pages = pages;
        this.contentPanel = contentPanel;

        this.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();

        titlePanel.add(new JLabel("뽀모도로 수량 설정 페이지"));

        this.add(titlePanel, BorderLayout.PAGE_START);

        this.add(new PaginationPanel(pages, contentPanel), BorderLayout.PAGE_END);
    }
}
