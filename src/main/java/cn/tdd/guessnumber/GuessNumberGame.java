package cn.tdd.guessnumber;

import cn.tdd.guessnumber.exception.WrongInputException;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessNumberGame {

  public void start() {
    String answer = answerGenerator.generate();
    guessMatcher = new GuessMatcher(answer);
    guessHistory = new ArrayList<>();
    boolean isGameOver = false;

    Scanner scanner = new Scanner(System.in);
    do {
      String userInput = scanner.nextLine();

      String guessMatchResult;
      try {
        guessMatchResult = guessMatcher.matchGuess(userInput);
      } catch (WrongInputException e) {
        guessMatchResult = WRONG_INPUT;
      }

      guessHistory.add(new SimpleEntry<>(userInput, guessMatchResult));

      if (guessMatchResult.equals("4A0B")) {
        System.out.println(userInput + " -> " + guessMatchResult);
        System.out.println("Correct!");
        isGameOver = true;
      } else if (guessHistory.size() == RETRY_TIMES) {
        System.out.println(userInput + " -> " + guessMatchResult);
        System.out.println("Sorry, game over!");
        isGameOver = true;
      }

      if (!isGameOver) {
        for (SimpleEntry<String, String> historyEntry: guessHistory) {
          System.out.println(historyEntry.getKey() + " -> " + historyEntry.getValue());
        }
        System.out.println("Please try again:");
      }
    } while (!isGameOver);
  }

  private static final String WRONG_INPUT = "Wrong Input，Input again";

  private static final int RETRY_TIMES = 6;

  private RandomAnswerGenerator answerGenerator = new RandomAnswerGenerator();

  private GuessMatcher guessMatcher;

  private List<SimpleEntry<String, String>> guessHistory;
}
