package cn.tdd.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuessMatcherTest {

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
}