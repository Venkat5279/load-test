package com.test.data;

import com.test.model.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class DataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);
    private List<TestData> testData = new ArrayList<>();

    public DataLoader() {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            final URL url = classLoader.getResource("testData.csv");
            if (url != null) {
                try (Stream<String> stream = Files.lines(Paths.get(url.getPath())).skip(1)) {
                    stream.forEach(line -> {
                        String[] columns = line.split(",");
                        if (columns.length >= 5) {
                            testData.add(new TestData(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]));
                        }
                    });
                } catch (IOException e) {
                    LOGGER.error("Error occurred while getting test data - {} {}", e.getMessage(), e);
                }
            }
        }
    }

    public List<TestData> getTestData() {
        return testData;
    }
}
