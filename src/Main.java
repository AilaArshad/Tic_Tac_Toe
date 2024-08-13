import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JLabel label = new JLabel();
    private static JPanel panel = new JPanel();
    private static JPanel panel1 = new JPanel();
    private static JFrame frame = new JFrame();
    private static JButton[][] border = new JButton[3][3];
    private static String playerX = "X";
    private static String playerO = "O";
    private static String currentplayer = playerX;
    private static boolean gameOver = false;
    private static int turns = 0;

    public static void main(String[] args) {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        label.setBackground(new Color(134, 68, 162));
        label.setForeground(Color.CYAN);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic Tac Toe");
        label.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(label);

        panel1.setLayout(new GridLayout(3, 3, 2, 2));
        panel1.setBackground(new Color(134, 68, 162));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton title = new JButton();
                border[i][j] = title;
                panel1.add(title);

                // title.setForeground(Color.CYAN);
                title.setBackground(new Color(134, 68, 162));
                title.setFont(new Font("Arial", Font.BOLD, 130));
                title.setFocusable(false);

                title.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton title = (JButton) e.getSource();
                        if (gameOver) return;
                        if (title.getText() == "") {
                            if (currentplayer == playerX) {
                                label.setForeground(new Color(255, 175, 0));
                                title.setForeground(Color.CYAN);
                                title.setText(currentplayer);
                            } else {
                                label.setForeground(Color.CYAN);
                                title.setForeground(new Color(255, 175, 0));
                                title.setText(currentplayer);
                            }
                            turns++;
                            checkWinner();
                            if (!gameOver) {
                                currentplayer = currentplayer == playerX ? playerO : playerX;
                                label.setText(currentplayer + "'s turn.");
                            }
                        }
                    }
                });
            }
        }
        frame.add(panel1);
        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private static void checkWinner() {
        //horizontal
        for (int i = 0; i < 3; i++) {
            if (border[i][0].getText() == "") continue;
            if (border[i][0].getText() == border[i][1].getText() && border[i][1].getText() == border[i][2].getText()) {
                for (int j = 0; j < 3; j++) {
                    setWinner(border[i][j]);
                }
                gameOver = true;
                return;
            }

            //vertical
            if (border[0][i].getText() == "") continue;
            if (border[0][i].getText() == border[1][i].getText() && border[1][i].getText() == border[2][i].getText()) {
                for (int j = 0; j < 3; j++) {
                    setWinner(border[j][i]);
                }
                gameOver = true;
                return;
            }
        }

        //diagonal
        if (border[0][0].getText() == border[1][1].getText() &&
                border[1][1].getText() == border[2][2].getText() && border[0][0].getText() != "") {
            for (int i = 0; i < 3; i++) {
                setWinner(border[i][i]);
            }
            gameOver = true;
            return;
        }

        //anti diagonal
        if (border[0][2].getText() == border[1][1].getText() &&
                border[1][1].getText() == border[2][0].getText() && border[0][2].getText() != "") {
            setWinner(border[0][2]);
            setWinner(border[1][1]);
            setWinner(border[2][0]);
            gameOver = true;
            return;
        }

        if (turns == 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tieGame(border[i][j]);
                }
            }
            gameOver = true;
        }
    }


    private static void setWinner(JButton btn) {
        if (currentplayer == playerX) {
            btn.setBackground(Color.CYAN);
            btn.setForeground(Color.WHITE);
            label.setForeground(Color.CYAN);
        } else {
            btn.setBackground(new Color(255, 175, 0));
            btn.setForeground(Color.WHITE);
            label.setForeground(new Color(255, 175, 0));
        }
        label.setText(currentplayer + " is winner");
    }

    private static void tieGame(JButton btn) {
        btn.setBackground(Color.ORANGE);
        btn.setForeground(Color.red);
        label.setText("Game tie!");
    }
}
