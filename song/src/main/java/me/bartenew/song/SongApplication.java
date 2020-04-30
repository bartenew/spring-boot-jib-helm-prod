package me.bartenew.song;

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

    @GetMapping("/song")
    public String getSong() {
      return "Born to code; my first words were “Hello World”\n"
          + "Since 95, been JAVA codin’ stayin’ proud\n"
          + "Started on floppy disks, now we take it to the cloud.\n"
          + "On my desktop, JAVA’s what’s bobbin’ and weavin’\n"
          + "We got another winning app before I get to OddEven.\n"
          + "Blazin’ code like a forest fire, climbin’ a tree\n"
          + "Setting standards like I Triple E….";
    }
  }
}
