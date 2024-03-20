import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRollSimulator extends JFrame implements ActionListener {
    private JLabel resultLabel;
    private JButton rollButton;
    private Random random;

    public DiceRollSimulator() {
        setTitle("Dice Roll Simulator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        resultLabel = new JLabel("Click 'Roll' to roll the dice");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel, BorderLayout.CENTER);

        rollButton = new JButton("Roll");
        rollButton.addActionListener(this);
        add(rollButton, BorderLayout.SOUTH);

        random = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollButton) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int total = dice1 + dice2;

            resultLabel.setText("Dice 1: " + dice1 + " | Dice 2: " + dice2 + " | Total: " + total);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DiceRollSimulator().setVisible(true);
            }
        });
    }
}
