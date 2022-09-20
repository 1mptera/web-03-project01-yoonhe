import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Pomodoro {
    private JFrame frame;
    private JPanel contentPanel;

    private CardLayout pages;

    public static void main(String[] args) {
        Pomodoro application = new Pomodoro();
        application.run();
    }

    private void run() {
        initFrame();

        initContentPanel();

        frame.setVisible(true);
    }

    private void initFrame() {
        frame = new JFrame("Pomodoro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
    }

    public void initContentPanel() {
        contentPanel = new JPanel();

        frame.add(contentPanel);

        pages = new CardLayout();

        contentPanel.setLayout(pages);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        setPages();
    }

    public void setPages() {
        contentPanel.add("MainPage",
                new MainPagePanel(pages, contentPanel));
        contentPanel.add("CreateTaskPage",
                new AddTaskPagePanel(pages, contentPanel));
    }
}
