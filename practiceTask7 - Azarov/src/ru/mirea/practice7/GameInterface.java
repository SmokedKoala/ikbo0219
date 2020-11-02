package ru.mirea.practice7;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GameInterface extends JFrame {
    private JLabel card1, card2, winner1, winner2, cardsLeft1, cardsLeft2, botva, versus;
    private JButton nextButton, resetButton;
    private StackGame cards;

    public GameInterface() {
        cards = new StackGame(true);
        initWindow();
    }

    private void initWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(450, 250));
        setSize(600, 300);
        setLayout(new BorderLayout());

        JPanel cardsPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel resultPanel = new JPanel(new GridLayout(1, 3));


        card1 = new JLabel(cards.getFirstPlayerCard());
        card1.setBorder(BorderFactory.createEmptyBorder(0,50, 0, 0));
        add(card1, BorderLayout.WEST);
        card2 = new JLabel(cards.getSecondPlayerCard());
        card2.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 50));
        add(card2, BorderLayout.EAST);
        winner1 = new JLabel("");
        winner2 = new JLabel("");
        versus = new JLabel("VS", SwingConstants.CENTER);
        versus.setBorder(BorderFactory.createEmptyBorder(0,0, 50, 0));
        botva = new JLabel("BOTVA");
        cardsLeft1 = new JLabel("Cards left: " + cards.getNumOfFirstPlayerCards());
        cardsLeft2 = new JLabel("Cards left: " + cards.getNumOfSecondPlayerCards());


        card1.setFont(new Font("Arial", Font.BOLD, 80));
        card2.setFont(new Font("Arial", Font.BOLD, 80));
        versus.setFont(new Font("Arial", Font.BOLD, 40));
        versus.setForeground(Color.GRAY);
        winner1.setFont(new Font("Arial", Font.BOLD, 25));
        winner1.setForeground(Color.GREEN);
        winner2.setFont(new Font("Arial", Font.BOLD, 25));
        winner2.setForeground(Color.GREEN);
        winner1.setVisible(false);
        winner2.setVisible(false);
        botva.setFont(new Font("Arial", Font.BOLD, 25));
        botva.setVisible(false);
        botva.setForeground(Color.CYAN);
        cardsLeft1.setFont(new Font("Arial", Font.BOLD, 20));
        cardsLeft2.setFont(new Font("Arial", Font.BOLD, 20));


        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(10, 30));

        resetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                resetGame();
            }
        });
        resetButton.setVisible(false);

        nextButton = new JButton("Next");

        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                nextCard();
            }
        });


        cardsPanel.setBorder(BorderFactory.createEmptyBorder(0,20, 0, 20));
        cardsPanel.add(cardsLeft1);
        cardsPanel.add(nextButton);
        cardsPanel.add(cardsLeft2);


        mainPanel.add(resetButton, BorderLayout.NORTH);
        mainPanel.add(versus, BorderLayout.SOUTH);

        resultPanel.add(winner1);
        resultPanel.add(botva);
        resultPanel.add(winner2);

        add(cardsPanel, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.NORTH);
        pack();
        setVisible(true);
    }

    private void resetGame() {
        cards = new StackGame(true);
        card1.setText(cards.getFirstPlayerCard());
        card2.setText(cards.getSecondPlayerCard());
        winner1.setVisible(false);
        winner2.setVisible(false);
        botva.setVisible(false);
        showLeftCards();
        resetButton.setVisible(false);
        nextButton.setVisible(true);
    }

    private void nextCard() {
        if (cards.compareCards()) {
            if (!cards.isFirstPlayerIsOutOfCards()) {
                card1.setText(cards.getFirstPlayerCard());
                showLeftCards();
            } else {
                winner2.setText("WINNER " + cards.getMovesCounter());
                winner2.setVisible(true);
                resetButton.setVisible(true);
                nextButton.setVisible(false);
            }
            if (!cards.isSecondPlayerIsOutOfCards()) {
                card2.setText(cards.getSecondPlayerCard());
                showLeftCards();
            } else {
                winner1.setText("WINNER " + cards.getMovesCounter());
                winner1.setVisible(true);
                resetButton.setVisible(true);
                nextButton.setVisible(false);
            }
        } else if (cards.getMovesCounter() >= 106) {
            botva.setVisible(true);
            resetButton.setVisible(true);
        }
    }

    private void showLeftCards() {
        cardsLeft1.setText("Cards left: " + cards.getNumOfFirstPlayerCards());
        cardsLeft2.setText("Cards left: " + cards.getNumOfSecondPlayerCards());
    }
}
