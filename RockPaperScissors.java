import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {
    private final String[] choices = {"rock", "paper", "scissors"};
    private final Random random = new Random();
    private final JLabel resultLabel;
    
    public RockPaperScissors() {
        setTitle("Rock Paper Scissors");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        resultLabel = new JLabel("", SwingConstants.CENTER);
        panel.add(resultLabel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        for (String choice : choices) {
            JButton button = new JButton(choice);
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(panel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String userChoice = ((JButton) e.getSource()).getText();
        int computerIndex = random.nextInt(3);
        String computerChoice = choices[computerIndex];
        
        String result;
        if (userChoice.equals(computerChoice)) {
            result = "It's a tie!";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            result = "You win!";
        } else {
            result = "You lose!";
        }
        resultLabel.setText(result);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissors::new);
    }
}
