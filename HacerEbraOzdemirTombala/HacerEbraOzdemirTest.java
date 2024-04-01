/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HacerEbraOzdemirTombala;

/**
 *
 * @author hacerebra
 */
public class HacerEbraOzdemirTest<T> {

    public static void main(String[] args) {

        // Create player cards
        HacerEbraOzdemirCard<Integer> randomCard1 = new HacerEbraOzdemirCard<>();
        HacerEbraOzdemirCard<Integer> randomCard2 = new HacerEbraOzdemirCard<>();

        // Define manually entered cards (FOR TEST) 
        /*Integer[][] manuallyEnteredCard1 = {{5, -1, 22, -1, 45, -1, 60, 73, -1},
        {-1, 10, -1, 31, 47, 58, 68, -1, -1},
        {-1, 17, 26, 38, -1, -1, -1, 79, 86}};

        Integer[][] manuallyEnteredCard2 = {{-1, 17, -1, 34, -1, 51, 60, -1, 80},
        {4, -1, 27, -1, 45, -1, -1, 74, 86},
        {-1, -1, 29, 38, 49, -1, 65, 77, -1}};*/
        Integer[][] manuallyEnteredCard1 = null;
        Integer[][] manuallyEnteredCard2 = null;

        //If manuallyEnteredCards are null, the cards are randomly generated.
        HacerEbraOzdemirGame game;
        if (manuallyEnteredCard1 == null && manuallyEnteredCard2 == null) {
            game = new HacerEbraOzdemirGame(randomCard1, randomCard2);
        } else if (manuallyEnteredCard1 == null) {
            randomCard2.setCard(manuallyEnteredCard2);
            game = new HacerEbraOzdemirGame(randomCard1, randomCard2);
        } else if (manuallyEnteredCard2 == null) {
            randomCard1.setCard(manuallyEnteredCard1);
            game = new HacerEbraOzdemirGame(randomCard1, randomCard2);
        } else {
            randomCard1.setCard(manuallyEnteredCard1);
            randomCard2.setCard(manuallyEnteredCard2);
            game = new HacerEbraOzdemirGame(randomCard1, randomCard2);
        }

        // Print the initial game state
        System.out.println("Initial Game State:");
        game.printGameState();

        //Draw random numbers and check cards while the game is in progress
        while (!game.isGameOver()) {
            int number = game.drawNumber();
            System.out.println("\nDrawn Number: " + number);
            game.checkNumberOnCards(number);
            System.out.println("Updated Game State:");
            game.printGameState();

            // Check for winners after each draw
            game.checkWinner(game.player1Card, "Player 1");
            game.checkWinner(game.player2Card, "Player 2");
        }

        // Print the final results
        System.out.println("\nGame Over! Final Results:");
        game.printWinner();

    }

}
 