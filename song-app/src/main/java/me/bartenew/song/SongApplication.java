package me.bartenew.song;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SongApplication {

  public static void main(String[] args) {
    SpringApplication.run(SongApplication.class, args);
  }

  @RestController
  class SongController {

    @Value("${song}")
    private String song;

    @GetMapping("/song")
    public String getSong() {
      return song;
    }
  }
}
