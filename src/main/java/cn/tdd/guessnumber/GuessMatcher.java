package cn.tdd.guessnumber;

import cn.tdd.guessnumber.exception.WrongInputException;

public class GuessMatcher {

  public GuessMatcher(String answer) {
    this.answer = answer;
    this.inputValidator = new InputValidator();
  }

  public String matchGuess(String guess) throws WrongInputException {
    if (!inputValidator.validate(guess)) {
      throw new WrongInputException();
    }

    int numberOfCorrect = 0;
    int numberOfWrongPosition = 0;

    for (int i = 0; i < guess.length(); i ++) {
      char guessNum = guess.charAt(i);

      if (guessNum == answer.charAt(i)) {
        numberOfCorrect ++;
      } else if (answer.indexOf(guessNum) > -1) {
        numberOfWrongPosition ++;
      }
    }

    return String.format("%dA%dB", numberOfCorrect, numberOfWrongPosition);
  }

  private String answer;

  private InputValidator inputValidator;
}
