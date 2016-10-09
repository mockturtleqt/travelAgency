package com.epam.training.second.action;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TourDataReaderFromFile {
    private static Logger logger = Logger.getLogger(TourDataReaderFromFile.class);

    public static List<String[]> readTourDataFromFile(String filepath) {
        List<String[]> tourDataList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
            tourDataList = stream
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
        return tourDataList;
    }

}
