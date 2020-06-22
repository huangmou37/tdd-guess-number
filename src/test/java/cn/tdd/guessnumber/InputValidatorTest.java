package cn.tdd.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InputValidatorTest {

  @Test
  public void should_return_true_when_validate_given_valid_input() {
    InputValidator validator = new InputValidator();

    String input = "1234";

    assertTrue(validator.validate(input));
  }
}