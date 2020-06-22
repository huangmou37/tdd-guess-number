package cn.tdd.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidatorTest {

  @Test
  public void should_return_true_when_validate_given_valid_input() {
    InputValidator validator = new InputValidator();

    String input = "1234";

    assertTrue(validator.validate(input));
  }

  @Test
  public void should_return_true_when_validate_given_invalid_input_with_duplicated_numbers() {
    InputValidator validator = new InputValidator();

    String input = "1123";

    assertFalse(validator.validate(input));
  }

  @Test
  public void should_return_true_when_validate_given_invalid_input_with_non_numeric_characters() {
    InputValidator validator = new InputValidator();

    String input = "a123";

    assertFalse(validator.validate(input));
  }

  @Test
  public void should_return_true_when_validate_given_invalid_input_with_less_than_4_characters() {
    InputValidator validator = new InputValidator();

    String input = "12";

    assertFalse(validator.validate(input));
  }

  @Test
  public void should_return_true_when_validate_given_invalid_input_with_more_than_4_characters() {
    InputValidator validator = new InputValidator();

    String input = "12345";

    assertFalse(validator.validate(input));
  }
}