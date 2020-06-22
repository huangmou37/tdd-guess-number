package cn.tdd.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuessMatcherTest {

  @Test
  public void should_return_4A0B_when_match_guess_given_input_with_all_correct() {
    GuessMatcher guessMatcher = new GuessMatcher("1234");

    assertEquals("4A0B", guessMatcher.matchGuess("1234"));
  }

  @Test
  public void should_return_1A2B_when_match_guess_given_input_with_1_correct_and_2_wrong_position() {
    GuessMatcher guessMatcher = new GuessMatcher("1234");

    assertEquals("1A2B", guessMatcher.matchGuess("0324"));
  }
}