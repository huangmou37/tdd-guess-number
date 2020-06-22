package cn.tdd.guessnumber;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

  public boolean validate(String input) {
    return !hasDuplicates(input) && !hasNonNumeric(input) && !hasLengthLessThan4(input);
  }

  private boolean hasDuplicates(String input) {
    char[] inputNumbers = input.toCharArray();

    Set<Character> distinctNumbers = new HashSet<>();
    for (char c: inputNumbers) {
      if (!distinctNumbers.contains(c)) {
        distinctNumbers.add(c);
      } else {
        return true;
      }
    }
    return false;
  }

  private boolean hasNonNumeric(String input) {
    char[] inputNumbers = input.toCharArray();

    for (char c: inputNumbers) {
      if (!Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  private boolean hasLengthLessThan4(String input) {
    return input.length() < 4;
  }
}
