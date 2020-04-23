package com.test;

import com.test.service.LoadRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoadTestApplication implements CommandLineRunner {

    @Autowired
    private LoadRunner loadRunner;

    public static void main(String[] args) {
        SpringApplication.run(LoadTestApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        loadRunner.execute();
    }
}
