import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private JLabel statusLabel;
    private boolean playerX;
    private int movesLeft;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 3));

        buttons = new JButton[3][3];
        playerX = true;
        movesLeft = 9;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player X's turn");
        add(statusLabel);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton.getText().isEmpty() && movesLeft > 0) {
            clickedButton.setText(playerX ? "X" : "O");
            statusLabel.setText(playerX ? "Player O's turn" : "Player X's turn");
            playerX = !playerX;
            movesLeft--;

            checkWinner();
        }
    }

    private void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().isEmpty() && buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][0].getText().equals(buttons[i][2].getText())) {
                showWinner(buttons[i][0].getText());
                return;
            }
            if (!buttons[0][i].getText().isEmpty() && buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[0][i].getText().equals(buttons[2][i].getText())) {
                showWinner(buttons[0][i].getText());
                return;
            }
        }
        if (!buttons[0][0].getText().isEmpty() && buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText())) {
            showWinner(buttons[0][0].getText());
            return;
        }
        if (!buttons[0][2].getText().isEmpty() && buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText())) {
            showWinner(buttons[0][2].getText());
            return;
        }

        if (movesLeft == 0) {
            statusLabel.setText("It's a draw!");
        }
    }

    private void showWinner(String winner) {
        statusLabel.setText("Player " + winner + " wins!");
        disableButtons();
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }
}
