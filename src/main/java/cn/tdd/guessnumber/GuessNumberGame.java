package cn.tdd.guessnumber;

import java.util.Scanner;

public class GuessNumberGame {

  public void start() {
    String answer = answerGenerator.generate();
    guessMatcher = new GuessMatcher(answer);
    boolean isGameOver = false;

    Scanner scanner = new Scanner(System.in);
    do {
      String userInput = scanner.nextLine();

      String guessMatchResult;
      guessMatchResult = guessMatcher.matchGuess(userInput);

      if (guessMatchResult.equals("4A0B")) {
        System.out.println(userInput + " -> " + guessMatchResult);
        System.out.println("Correct!");
        isGameOver = true;
      }
    } while (!isGameOver);
  }

  private RandomAnswerGenerator answerGenerator = new RandomAnswerGenerator();

  private GuessMatcher guessMatcher;
}
