package cn.tdd.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomAnswerGeneratorTest {

  @Test
  public void should_return_answer_with_length_4_when_generate() {
    RandomAnswerGenerator answerGenerator = new RandomAnswerGenerator();

    String answer = answerGenerator.generate();

    assertEquals(4, answer.length());
  }
}