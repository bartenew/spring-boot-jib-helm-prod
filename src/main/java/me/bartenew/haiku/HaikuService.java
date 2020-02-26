package me.bartenew.haiku;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class HaikuService {


    private List<String> haikus;

    public String getRandom() {
        Random random = new Random();
        return haikus.get(random.nextInt(haikus.size()));
    }

    public HaikuService(@Value("classpath:haikus.txt") Resource resourceFile) throws IOException {
        String text = Files.readString(Paths.get(resourceFile.getURI()));
        haikus = Arrays.stream(text.split("\n\n")).collect(Collectors.toList());
    }
}
