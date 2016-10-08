package com.epam.training.second.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadToursFromFile {
    private static Logger logger = Logger.getLogger(ReadToursFromFile.class);

    public static List<String[]> readToursFromFile(String filepath) {
        List<String[]> tourList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
            tourList = stream
                    .map(String::toLowerCase)
                    .filter(line -> line.startsWith("festival") || line.startsWith("adventure") || line.startsWith("recreational"))
                    .map(line -> line.split(", "))
                    .collect(Collectors.toList());

        } catch (NoSuchFileException e) {
            logger.fatal(e);
            throw new RuntimeException();
        } catch (IOException e) {
            logger.error(e, e);
        }
        return tourList;
    }
}
