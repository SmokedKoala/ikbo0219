package ru.mirea.practice7;

import java.util.*;

public class StackGame {

    private int movesCounter;
    protected Stack<String> firstPlayerCards;
    protected Stack<String> secondPlayerCards;

    public StackGame(boolean interactive) {
        movesCounter = 0;
        if (interactive) {
            interactiveGame();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        firstPlayerCards = createDeck(scanner);
        secondPlayerCards = createDeck(scanner);
    }

    public void play() {
        while (!isFirstPlayerIsOutOfCards() && !isSecondPlayerIsOutOfCards() && movesCounter < 106) {
            compareCards();
        }
        System.out.println(movesCounter >= 106 ? "botva" : (isSecondPlayerIsOutOfCards() ? "first " : "second ") + movesCounter);
    }

    public boolean compareCards() {
        if (isFirstPlayerIsOutOfCards() || isSecondPlayerIsOutOfCards() || movesCounter > 106) {
            return false;
        }
        String card1 = getFirstPlayerCard();
        String card2 = getSecondPlayerCard();
        if ((Integer.parseInt(card1) > Integer.parseInt(card2)&& (!card1.equals("9") || !card2.equals("0") ))
                || (card1.equals("0") && card2.equals("9"))) {
            moveCard(secondPlayerCards, firstPlayerCards);
        } else {
            moveCard(firstPlayerCards, secondPlayerCards);
        }
        movesCounter++;
        return true;
    }

    private void interactiveGame() {
        List<String> temp = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            temp.add(String.valueOf(i));
        }
        Collections.shuffle(temp);
        firstPlayerCards = createDeck(temp.subList(0, temp.size() / 2));
        secondPlayerCards = createDeck(temp.subList(temp.size() / 2, temp.size()));
    }

    public int getMovesCounter() {
        return movesCounter;
    }

    public Stack<String> createDeck(Scanner scanner) {
        Stack<String> cards = new Stack<>();
        Arrays.stream(Arrays.stream(
                scanner.nextLine().split(" "))
                .toArray())
                .map(Object::toString)
                .forEach(cards::push);
        Collections.reverse(cards);
        return cards;
    }

    public Stack<String> createDeck(List<String> list) {
        Stack<String> cards = new Stack<>();
        list.forEach(cards::push);
        Collections.reverse(cards);
        return cards;
    }

    public void moveCard(Stack<String> from, Stack<String> to) {
        String winnerCard = to.pop();
        Collections.reverse(to);
        to.push(winnerCard);
        to.push(from.pop());
        Collections.reverse(to);
    }

    public String getFirstPlayerCard() {
        return firstPlayerCards.peek();
    }

    public String getSecondPlayerCard() {
        return secondPlayerCards.peek();
    }

    public Boolean isFirstPlayerIsOutOfCards() {
        return firstPlayerCards.isEmpty();
    }

    public Boolean isSecondPlayerIsOutOfCards() {
        return secondPlayerCards.isEmpty();
    }

    public Integer getNumOfFirstPlayerCards() {
        return firstPlayerCards.size();
    }

    public Integer getNumOfSecondPlayerCards() {
        return secondPlayerCards.size();
    }
}
