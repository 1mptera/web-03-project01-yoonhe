import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class AddTaskPagePanel extends JPanel {
    private CardLayout pages;

    public AddTaskPagePanel(CardLayout pages, JPanel contentPanel) {
        this.pages = pages;

        create(pages, contentPanel);

        this.add(new JLabel("작업 추가 페이지"));
    }

    private void create(CardLayout pages, JPanel contentPanel) {
        JButton button = new JButton("뒤로가기 버튼");
        button.addActionListener(event -> {
            pages.show(contentPanel, "MainPage");
        });
        this.add(button);
    }
}
