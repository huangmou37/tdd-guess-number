package cn.tdd.guessnumber;

import cn.tdd.guessnumber.exception.WrongInputException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GuessMatcherTest {

  @Mock
  private InputValidator inputValidator;

  @InjectMocks
  private GuessMatcher guessMatcher;

  @Before
  public void init() {
    this.guessMatcher = new GuessMatcher("1234");
  }

  @Test
  public void should_return_4A0B_when_match_guess_given_input_with_all_correct() {
    String matchResult = guessMatcher.matchGuess("1234");

    assertEquals("4A0B", matchResult);
  }

  @Test
  public void should_return_1A2B_when_match_guess_given_input_with_1_correct_and_2_wrong_position() {
    String matchResult = guessMatcher.matchGuess("0324");

    assertEquals("1A2B", matchResult);
  }

  @Test
  public void should_return_0A0B_when_match_guess_given_input_with_all_wrong() {
    String matchResult = guessMatcher.matchGuess("5678");

    assertEquals("0A0B", matchResult);
  }

  @Test
  public void should_return_0A0B_when_match_guess_given_input_with_0_correct_and_4_wrong_position() {
    String matchResult = guessMatcher.matchGuess("4321");

    assertEquals("0A4B", matchResult);
  }

  @Test(expected = WrongInputException.class)
  public void should_throw_wrong_input_exception_when_match_guess_given_invalid_input() {
    when(inputValidator.validate(any())).thenReturn(false);

    guessMatcher.matchGuess("abcd");
  }
}