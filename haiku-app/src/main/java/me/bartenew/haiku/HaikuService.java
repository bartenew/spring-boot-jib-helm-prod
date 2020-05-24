package me.bartenew.haiku;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HaikuService {

  private List<String> haikus;

  public String getRandom() {
    Random random = new Random();
    return haikus.get(random.nextInt(haikus.size()));
  }

  public HaikuService(@Value("${haikus}") String haikusString) throws IOException {
    this.haikus = Arrays.stream(haikusString.split("---")).collect(Collectors.toList());
  }
}
