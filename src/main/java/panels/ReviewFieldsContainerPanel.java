package panels;

import models.Session;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

public class ReviewFieldsContainerPanel extends JPanel {
    private Session session;

    public ReviewFieldsContainerPanel(Session session) {
        this.session = session;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(false);

        createTitlePanel();

        createTaskCompletedCheckPanel();
        createConcentrationLevelCheckPanel();
        createTextField("새로 알게된 것");
        createTextField("아쉬운 점");
        createTextField("다음 세션에서 개선시킬 점");
        createSubmitButton();
    }

    private void createTitlePanel() {
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setBorder(new EmptyBorder(20, 0, 20, 0));

        createTitleLabel("이번 세션에서 무엇을 배우셨나요?", panel);
    }

    private void createTaskCompletedCheckPanel() {
        JPanel panel = new JPanel();
        this.add(panel);

        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        createTitleLabel("작업 완료 했나요?", panel);

        createTaskCheckBox(panel);
    }

    private void createTaskCheckBox(JPanel panel) {
        JCheckBox checkBox = new JCheckBox("당연하죠!");

        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(checkBox);
    }

    public void createConcentrationLevelCheckPanel() {
        JPanel panel = new JPanel();
        this.add(panel);

        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        createTitleLabel("스스로의 집중도를 평가해봅시다", panel);

        createConcentrationSelectBox(panel);
    }

    public void createConcentrationSelectBox(JPanel panel) {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("보통");
        comboBox.addItem("중간");
        comboBox.addItem("높음");

        panel.add(comboBox);
    }

    public void createTextField(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.add(panel);

        panel.add(new JLabel(title));

        JTextField textField = new JTextField(20);
        panel.add(textField);
    }

    public void createSubmitButton() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 0, 20, 0));
        this.add(panel);

        JButton button = new JButton("제출하기");
        button.addActionListener(event -> {

        });
        panel.add(button);

        this.add(button);
    }

    private void createTitleLabel(String text, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
    }
}
