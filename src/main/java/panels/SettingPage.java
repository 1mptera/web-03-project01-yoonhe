package panels;

import models.Objective;
import models.Pomodoro;
import models.Routine;
import models.SetUpPomodoro;
import models.Task;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class SettingPage extends JPanel {
    private SetUpPomodoro setUpPomodoro;
    private Pomodoro pomodoro;

    public SettingPage(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;

        this.setOpaque(false);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setUp();

        createRoutinePanel();

        createMainPanels(pomodoro);
    }

    private void setUp() {
        Routine routine = new Routine();

        setUpPomodoro = new SetUpPomodoro(
                routine.quantity(), routine.objectives(), routine.tasks()
        );

        pomodoro.setQuantity(
                pomodoro.quantity() > 0 ?
                        pomodoro.quantity() : setUpPomodoro.quantity()
        );

        pomodoro.setObjectives(setUpPomodoro.objectives());
        pomodoro.setTasks(
                pomodoro.tasks().size() > 0 ?
                        pomodoro.tasks() : setUpPomodoro.tasks()
        );
    }

    public void createRoutinePanel() {
        JPanel panel = new JPanel();
        this.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("루틴 선택"));

        panel.add(createWeeklyRoutineButton());
        panel.add(createWeekendRoutineButton());
    }

    private void createMainPanels(Pomodoro pomodoro) {
        this.add(new SettingPomodoroQuantityPanel(pomodoro));
        this.add(new Big3Panel(pomodoro));
        this.add(new SettingTaskPanel(pomodoro));
    }

    private JButton createWeeklyRoutineButton() {
        Routine routine = new Routine("주간");

        JButton button = new JButton("주간 루틴");

        button.addActionListener(event -> {
            int quantity = routine.quantity();
            List<Objective> objectives = routine.objectives();
            List<Task> tasks = routine.tasks();

            this.removeAll();

            setUpPomodoro = new SetUpPomodoro(quantity, objectives, tasks);

            updatePomodoroSetting(quantity, objectives, tasks);
        });

        return button;
    }

    private JButton createWeekendRoutineButton() {
        Routine routine = new Routine();

        JButton button = new JButton("주말 루틴");

        button.addActionListener(event -> {
            int quantity = routine.quantity();
            List<Objective> objectives = routine.objectives();
            List<Task> tasks = routine.tasks();

            this.removeAll();

            setUpPomodoro = new SetUpPomodoro(quantity, objectives, tasks);

            updatePomodoroSetting(quantity, objectives, tasks);
        });

        return button;
    }

    public void updatePomodoroSetting(
            int quantity, List<Objective> objectives, List<Task> tasks) {
        pomodoro.setQuantity(quantity);
        pomodoro.setObjectives(objectives);
        pomodoro.setTasks(tasks);

        createRoutinePanel();

        createMainPanels(pomodoro);

        this.setVisible(false);
        this.setVisible(true);
    }
}
