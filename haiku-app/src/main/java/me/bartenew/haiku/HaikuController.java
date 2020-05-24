package me.bartenew.haiku;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaikuController {

  private HaikuService haikuService;

  public HaikuController(HaikuService haikuService) {
    this.haikuService = haikuService;
  }

  @PostMapping("/validate")
  public boolean validate(@RequestBody String haiku) {
    String[] lines = haiku.split("\\n");
    return lines.length == 3
        && countSyllables(lines[0]) == 5
        && countSyllables(lines[1]) == 7
        && countSyllables(lines[2]) == 5;
  }

  @GetMapping("/random")
  public String getRandomHaiku() {
    return haikuService.getRandom();
  }

  private int countSyllables(String word) {
    String i = "[aeiouy]+[^$e(,.:;!?)]";
    Matcher m = Pattern.compile(i, CASE_INSENSITIVE).matcher(word);
    int count = 0;
    while (m.find()) {
      count++;
    }

    return Math.max(count, 1);
  }
}
