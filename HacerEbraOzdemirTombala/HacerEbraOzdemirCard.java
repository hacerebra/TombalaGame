/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HacerEbraOzdemirTombala;

import java.util.Random;

/**
 *
 * @author hacerebra
 */
//Card class
class HacerEbraOzdemirCard<T> {

    HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>>> card;
    boolean numberExistsInCard;

    // Constructor to generate a bingo card
    public HacerEbraOzdemirCard() {
        this.card = new HacerEbraOzdemirMultiLinkedList<>();
        generateCard();
        this.numberExistsInCard = false;
    }

    // Generate a bingo card
    private void generateCard() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>> row = new HacerEbraOzdemirMultiLinkedList<>();
            HacerEbraOzdemirMultiLinkedList<Integer> emptyIndexes = generateEmptyIndexes();
            HacerEbraOzdemirMultiLinkedList<T> usedNumbers = new HacerEbraOzdemirMultiLinkedList<>();
            for (int j = 0; j < 9; j++) {
                HacerEbraOzdemirNode<T> node;
                if (emptyIndexes.contains(j)) {
                    node = new HacerEbraOzdemirNode<>((T) "x");
                } else {
                    T randomNumber;
                    do {
                        randomNumber = generateRandomNumber(j);
                    } while (usedNumbers.contains(randomNumber) || isNumberExistsInCard(randomNumber));
                    usedNumbers.addLast(randomNumber);
                    node = new HacerEbraOzdemirNode<>(randomNumber);
                }
                if (row.tail != null) {
                    node.prev = (HacerEbraOzdemirNode<T>) row.tail;
                    row.tail.next = (HacerEbraOzdemirNode<HacerEbraOzdemirNode<T>>) node;
                }
                row.addLast(node);
            }
            card.addLast(row);
        }
    }

    // Check if a number exists in the card
    public boolean isNumberExistsInCard(T number) {
        HacerEbraOzdemirNode<HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>>> current = card.head;
        while (current != null) {
            HacerEbraOzdemirNode<HacerEbraOzdemirNode<T>> innerCurrent = current.data.head;
            while (innerCurrent != null) {
                if (innerCurrent.data.data.equals(number)) {
                    return true;
                }
                innerCurrent = innerCurrent.next;
            }
            current = current.next;
        }
        return false;
    }

    // Generate indexes for empty cells
    private HacerEbraOzdemirMultiLinkedList<Integer> generateEmptyIndexes() {
        HacerEbraOzdemirMultiLinkedList<Integer> indexes = new HacerEbraOzdemirMultiLinkedList<>();
        Random random = new Random();
        while (indexes.size() < 4) {
            int index = random.nextInt(9);
            if (!indexes.contains(index)) {
                indexes.addLast(index);
            }
        }
        return indexes;
    }

    // Generate a random number for a specific column
    private T generateRandomNumber(int columnIndex) {
        Random random = new Random();
        int lowerBound = columnIndex * 10;
        int upperBound = lowerBound + 9;
        if (columnIndex == 0) {
            lowerBound += 1;
            upperBound -= 1;
        }
        if (columnIndex == 8) {
            upperBound += 1;
        }
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        return (T) Integer.valueOf(randomNumber);
    }

    // Print the bingo card
    public void printCard() {
        HacerEbraOzdemirNode<HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>>> current = card.head;
        while (current != null) {
            HacerEbraOzdemirNode<HacerEbraOzdemirNode<T>> innerCurrent = current.data.head;
            while (innerCurrent != null) {
                System.out.print(String.format(" %4s ", innerCurrent.data.data));
                innerCurrent = innerCurrent.next;
            }
            System.out.println();
            current = current.next;
        }
    }

    // Set the card manually
    public void setCard(T[][] manuallyEnteredCard) {
        if (manuallyEnteredCard.length != 3 || manuallyEnteredCard[0].length != 9) {
            System.out.println("Incorrect input: Matrix dimensions are not correct!");
            return;
        }

        card = new HacerEbraOzdemirMultiLinkedList<>(); //Reset card
        HacerEbraOzdemirMultiLinkedList<String> errors = new HacerEbraOzdemirMultiLinkedList<>();
        for (int i = 0; i < 3; i++) {
            HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>> row = new HacerEbraOzdemirMultiLinkedList<>();
            for (int j = 0; j < 9; j++) {
                T value = manuallyEnteredCard[i][j];
                if (value.equals(-1)) {
                    row.addLast(new HacerEbraOzdemirNode<T>((T) "x"));
                } else {
                    int intValue = Integer.parseInt(value.toString());
                    int column = j + 1;
                    switch (column) {
                        case 1: // 1. column: 1-9
                            if (intValue < 1 || intValue > 9) {
                                errors.addLast("Incorrect entry: There should be numbers 1-9 in column 1!!");
                            }
                            break;
                        case 2: // 2. column: 10-19
                            if (intValue < 10 || intValue > 19) {
                                errors.addLast("Incorrect entry: There should be numbers 10-19 in column 2!");
                            }
                            break;
                        case 3: // 3. column: 20-29
                            if (intValue < 20 || intValue > 29) {
                                errors.addLast("Incorrect entry: There should be numbers 20-29 in column 3!");
                            }
                            break;
                        case 4: // 4. column: 30-39
                            if (intValue < 30 || intValue > 39) {
                                errors.addLast("Incorrect entry: There should be numbers 30-39 in column 4!");
                            }
                            break;
                        case 5: // 5. column: 40-49
                            if (intValue < 40 || intValue > 49) {
                                errors.addLast("Incorrect entry: There should be numbers 40-49 in column 5!");
                            }
                            break;
                        case 6: // 6. column: 50-59
                            if (intValue < 50 || intValue > 59) {
                                errors.addLast("Incorrect entry: There should be numbers 50-59 in column 6!");
                            }
                            break;
                        case 7: // 7. column: 60-69
                            if (intValue < 60 || intValue > 69) {
                                errors.addLast("Incorrect entry: There should be numbers 60-69 in column 7!");
                            }
                            break;
                        case 8: // 8. column: 70-79
                            if (intValue < 70 || intValue > 79) {
                                errors.addLast("Incorrect entry: There should be numbers 70-79 in column 8!");
                            }
                            break;
                        case 9: // 9. column: 80-90
                            if (intValue < 80 || intValue > 90) {
                                errors.addLast("Incorrect entry: There should be numbers 80-89 in column 9!");
                            }
                            break;
                        default:
                            errors.addLast("Incorrect entry: Unknown column number!");
                            break;
                    }
                    row.addLast(new HacerEbraOzdemirNode<T>(value));
                }
            }
        }

        if (!errors.isEmpty()) {
            errors.printList();
            return;
        }

        for (int i = 0; i < 3; i++) {
            HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>> row = new HacerEbraOzdemirMultiLinkedList<>();
            for (int j = 0; j < 9; j++) {
                T value = manuallyEnteredCard[i][j];
                if (value.equals(-1)) {
                    row.addLast(new HacerEbraOzdemirNode<T>((T) "x"));
                } else {
                    row.addLast(new HacerEbraOzdemirNode<T>(value));
                }
            }
            card.addLast(row);
        }
    }

    // Mark a number on the card
    public void markNumber(T number) {
        HacerEbraOzdemirNode<HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>>> current = card.head;
        while (current != null) {
            HacerEbraOzdemirNode<HacerEbraOzdemirNode<T>> innerCurrent = current.data.head;
            while (innerCurrent != null) {
                if (innerCurrent.data.data.equals(number)) {
                    innerCurrent.data.data = (T) ("[" + number.toString() + "]");
                }
                innerCurrent = innerCurrent.next;
            }
            current = current.next;
        }
    }

    // Check for the first bingo
    public boolean hasFirstBingo() {
        HacerEbraOzdemirNode<HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>>> current = card.head;
        while (current != null) {
            if (checkBingo(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Check for the second bingo
    public boolean hasSecondBingo() {
        int count = 0;
        HacerEbraOzdemirNode<HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>>> current = card.head;
        while (current != null) {
            if (checkBingo(current.data)) {
                count++;
            }
            current = current.next;
        }
        return count >= 2;
    }

    // Check for tombala
    public boolean hasTombala() {

        int count = 0;
        HacerEbraOzdemirNode<HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>>> current = card.head;
        while (current != null) {
            if (checkBingo(current.data)) {
                count++;
            }
            current = current.next;
        }
        return count == 3;
    }

    // Check for bingo or tombala in a specific row
    private boolean checkBingo(HacerEbraOzdemirMultiLinkedList<HacerEbraOzdemirNode<T>> row) {
        int markedCount = 0;
        HacerEbraOzdemirNode<HacerEbraOzdemirNode<T>> current = row.head;
        while (current != null) {
            if (current.data.data.toString().contains("[")) {
                markedCount++;
            }
            current = current.next;
        }
        return markedCount == 5;
    }

}
