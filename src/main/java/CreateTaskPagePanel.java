import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class CreateTaskPagePanel extends JPanel {
    private CardLayout pages;

    public CreateTaskPagePanel(CardLayout pages, JPanel contentPanel) {
        this.pages = pages;

        JButton button = new JButton("이전 화면으로 가기 버튼");
        button.addActionListener(event -> {
            pages.show(contentPanel, "MainPage");
        });
        this.add(button);

        this.add(new JLabel("작업 추가 페이지"));
    }
}
