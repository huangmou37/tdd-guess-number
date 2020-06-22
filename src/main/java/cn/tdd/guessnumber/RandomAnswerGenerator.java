package cn.tdd.guessnumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomAnswerGenerator {

  public String generate() {
    List<Integer> solution = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    Collections.shuffle(solution);
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      answer.append(solution.get(i));
    }
    return answer.toString();
  }
}
