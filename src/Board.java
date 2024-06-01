import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame{
    private JPanel TicTacBoard;
    private JButton R1C1;
    private JButton R3C3;
    private JButton R1C2;
    private JButton R1C3;
    private JButton R2C1;
    private JButton R2C2;
    private JButton R2C3;
    private JButton R3C1;
    private JButton R3C2;
    private JLabel playerTurn;
    private JLabel WinnerLabel;
    private JButton resetButton;

    int player = 1;
    int filled = 0;

    TicTac game = new TicTac();

    Board(){
        loadValue();
        playerTurn.setText(String.valueOf(player));
        setContentPane(TicTacBoard);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        R1C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(0,player);
                R1C1.setText(setButton());
                R1C1.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R1C2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(1,player);
                R1C2.setText(setButton());
                R1C2.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R1C3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(2,player);
                R1C3.setText(setButton());
                R1C3.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R2C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(3,player);
                R2C1.setText(setButton());
                R2C1.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R2C2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(4,player);
                R2C2.setText(setButton());
                R2C2.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R2C3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(5,player);
                R2C3.setText(setButton());
                R2C3.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R3C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(6,player);
                R3C1.setText(setButton());
                R3C1.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R3C2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(7,player);
                R3C2.setText(setButton());
                R3C2.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        R3C3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled++;
                game.setIndex(8,player);
                R3C3.setText(setButton());
                R3C3.setEnabled(false);
                checkColumn();
                gameOver();
                switchPlayer();
                playerTurn.setText(String.valueOf(player));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled=0;
                clearButton();
                clearValue();
                WinnerLabel.setText("Tic Tac Toe");
                player = 1;
                playerTurn.setText(String.valueOf(player));
                enableAllButton();
                loadValue();
            }
        });
    }

    public void checkColumn(){
        if (game.linedHorizontal() != 0 || game.linedVertical() != 0 || game.linedDiagonal() != 0){
            disableAllButton();
            setLabel("Player "+player+" Wins!");
        }
    }

    public void gameOver(){
        if (isAllFilled() && game.linedHorizontal() == 0 || isAllFilled() && game.linedVertical() == 0 || isAllFilled() && game.linedDiagonal() == 0){
            disableAllButton();
            setLabel("Tie!");
        }
    }

    public String setButton(){
        if (player == 1){
            return "X";
        }
        return "O";
    }

    public void setLabel(String text){
        WinnerLabel.setText(text);
    }

    public void switchPlayer(){
        if (player == 1){
            player = 2;
            return;
        }
        player = 1;
    }

    public boolean isAllFilled(){
        if (filled == 9) return true;
        return false;
    }

    public void disableAllButton(){
        R1C1.setEnabled(false);
        R1C2.setEnabled(false);
        R1C3.setEnabled(false);
        R2C1.setEnabled(false);
        R2C2.setEnabled(false);
        R2C3.setEnabled(false);
        R3C1.setEnabled(false);
        R3C2.setEnabled(false);
        R3C3.setEnabled(false);
    }

    public void enableAllButton(){
        R1C1.setEnabled(true);
        R1C2.setEnabled(true);
        R1C3.setEnabled(true);
        R2C1.setEnabled(true);
        R2C2.setEnabled(true);
        R2C3.setEnabled(true);
        R3C1.setEnabled(true);
        R3C2.setEnabled(true);
        R3C3.setEnabled(true);
    }

    public void clearButton(){
        R1C1.setText("");
        R1C2.setText("");
        R1C3.setText("");
        R2C1.setText("");
        R2C2.setText("");
        R2C3.setText("");
        R3C1.setText("");
        R3C2.setText("");
        R3C3.setText("");
    }

    public void clearValue(){
        game.clear();
    }

    public void loadValue(){
        game.insert(0);
        game.insert(0);
        game.insert(0);
        game.insert(0);
        game.insert(0);
        game.insert(0);
        game.insert(0);
        game.insert(0);
        game.insert(0);
    }

    public static void main(String[] args) {
        Board b = new Board();
    }
}
