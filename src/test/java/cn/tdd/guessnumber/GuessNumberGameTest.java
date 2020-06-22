package cn.tdd.guessnumber;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GuessNumberGameTest {

  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @Mock
  private RandomAnswerGenerator answerGenerator;

  @InjectMocks
  private GuessNumberGame guessNumberGame;

  @Before
  public void init() {
    when(answerGenerator.generate()).thenReturn("1234");
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  public void should_end_game_and_print_guess_history_when_running_game_given_correct_guess_in_1st_try() {
    ByteArrayInputStream in = new ByteArrayInputStream("1234\n".getBytes());
    System.setIn(in);

    guessNumberGame.start();

    assertEquals("1234 -> 4A0B\nCorrect!\n", outputStream.toString());
  }

  @Test
  public void should_end_game_and_print_guess_history_when_running_game_given_6_wrong_guess() {
    ByteArrayInputStream in = new ByteArrayInputStream("abcd\n2345\n3456\n4567\n5678\n6789\n".getBytes());
    System.setIn(in);

    guessNumberGame.start();

    assertEquals(
        "abcd -> Wrong Input，Input again\n"
            + "Please try again:\n"
            + "abcd -> Wrong Input，Input again\n"
            + "2345 -> 0A3B\n"
            + "Please try again:\n"
            + "abcd -> Wrong Input，Input again\n"
            + "2345 -> 0A3B\n"
            + "3456 -> 0A2B\n"
            + "Please try again:\n"
            + "abcd -> Wrong Input，Input again\n"
            + "2345 -> 0A3B\n"
            + "3456 -> 0A2B\n"
            + "4567 -> 0A1B\n"
            + "Please try again:\n"
            + "abcd -> Wrong Input，Input again\n"
            + "2345 -> 0A3B\n"
            + "3456 -> 0A2B\n"
            + "4567 -> 0A1B\n"
            + "5678 -> 0A0B\n"
            + "Please try again:\n"
            + "6789 -> 0A0B\n"
            + "Sorry, game over!\n", outputStream.toString());
  }
}
