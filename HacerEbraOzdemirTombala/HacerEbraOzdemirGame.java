/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HacerEbraOzdemirTombala;

/**
 *
 * @author hacerebra
 */
//Game class
import java.util.Random;

public class HacerEbraOzdemirGame<T> {

    HacerEbraOzdemirCard<Integer> player1Card;
    HacerEbraOzdemirCard<Integer> player2Card;
    private HacerEbraOzdemirMultiLinkedList<Integer> drawnNumbers;
    private boolean gameOver;

    // Constructor to start the game with player cards
    public HacerEbraOzdemirGame(HacerEbraOzdemirCard<Integer> player1Card, HacerEbraOzdemirCard<Integer> player2Card) {
        this.player1Card = player1Card;
        this.player2Card = player2Card;
        this.drawnNumbers = new HacerEbraOzdemirMultiLinkedList<>();
        this.gameOver = false;
    }

    int[] randomPermutation = generatePermutation(90);
    //int[] randomPermutation = {5,  22,  45, 60, 73, 10, 31, 47, 58, 68, 17, 26, 38, 79, 86}; //For test 

    // Generate a random permutation for drawing numbers
    public int[] generatePermutation(int range) {
        int[] permutation = new int[range];
        for (int i = 0; i < range; i++) {
            permutation[i] = i + 1;
        }
        Random random = new Random();
        for (int i = range - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap
            int temp = permutation[index];
            permutation[index] = permutation[i];
            permutation[i] = temp;
        }
        return permutation;
    }

    // Draw a number
    public int drawNumber() {
        if (drawnNumbers.size() == 90) {
            System.out.println("All numbers have been drawn");
        }
        int number;
        do {
            number = randomPermutation[drawnNumbers.size()];
        } while (drawnNumbers.contains(number));
        drawnNumbers.addLast(number);
        return number;
    }

    // Check numbers on cards
    public void checkNumberOnCards(int number) {
        player1Card.markNumber(number);
        player2Card.markNumber(number);
    }

    // Check if a player has won
    public void checkWinner(HacerEbraOzdemirCard<Integer> card, String playerName) {
        if (card.hasFirstBingo()) {
            System.out.println(playerName + " made the first bingo!");
        }
        if (card.hasSecondBingo()) {
            System.out.println(playerName + " made the second bingo!");
        }
        if (card.hasTombala()) {
            System.out.println(playerName + " made tombala and won the game!");
            gameOver = true;
        }
    }

    // Check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Print the current game state
    public void printGameState() {
        System.out.println("Player 1's Card:");
        player1Card.printCard();
        System.out.println();
        System.out.println("Player 2's Card:");
        player2Card.printCard();
        System.out.println();
    }

    // Print the winner of the game
    public void printWinner() {
        if (player1Card.hasTombala() && player2Card.hasTombala()) {
            System.out.println("It's a tie! Both players made tombala and the game ended in a draw.");
        } else if (player1Card.hasTombala()) {
            System.out.println("Player 1 made tombala and won the game!");
        } else if (player2Card.hasTombala()) {
            System.out.println("Player 2 made tombala and won the game!");
        }
    }
}
