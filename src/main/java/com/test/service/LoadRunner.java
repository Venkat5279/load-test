package com.test.service;

import com.test.model.channelbound.UpgradeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@Service
public class LoadRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadRunner.class);
    private static final int NUMBER_OF_LOOPS = 10000;
    private static final int NUMBER_OF_THREADS = 1;
    private static final int DURATION_IN_MINUTES = 0;
    private LocalTime endTime;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CreatePayload createPayload;

    public void execute() {
        LOGGER.info("Load test started!");
        endTime = LocalTime.now().plusMinutes(DURATION_IN_MINUTES);
        ExecutorService executors = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        try {
            for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
                if (getDurationInMinutes() < 0) {
                    break;
                }
                final List<Callable<ResponseEntity<UpgradeResponse>>> tasks = createPayload.createTasks();
                executors.invokeAll(tasks)
                        .stream()
                        .map(f -> {
                            try {
                                return f.get();
                            } catch (final Exception e) {
                                LOGGER.error("Error occurred while executing task - {}", e.getMessage());
                                writeError(e.getMessage());
                            }
                            return null;
                        })
                        .forEach(this::writeBody);
            }
            LOGGER.info("Successful completed!");
            executors.shutdownNow();
        } catch (final Exception e) {
            LOGGER.error("Error occurred while executing load test - {} {}", e.getMessage(), e);
        }
    }

    private long getDurationInMinutes() {
        return Duration.between(LocalTime.now(), endTime).toMinutes();
    }

    private void writeBody(ResponseEntity<UpgradeResponse> e) {
        try {
            if (e != null) {
                Files.write(Paths.get("results.txt"),
                        (objectMapper.writeValueAsString(e.getBody()) + System.lineSeparator()).getBytes(),
                        CREATE,
                        APPEND);
            }
        } catch (final Exception ex) {
            LOGGER.error("Error occurred while writing data to file - {} {}", ex.getMessage(), ex);
        }
    }

    private void writeError(final String error) {
        try {
            Files.write(Paths.get("errors.txt"),
                    (objectMapper.writeValueAsString(error) + System.lineSeparator()).getBytes(),
                    CREATE,
                    APPEND);
        } catch (final Exception ex) {
            LOGGER.error("Error occurred while writing errors to file - {} {}", ex.getMessage(), ex);
        }
    }
}
