package com.lbg.utils.testservice.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbg.utils.testservice.entity.CucumberReport;
import io.cucumber.core.cli.Main;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class BatchTriggerTestInvoker {

    private final ObjectMapper objectMapper;

    public List<CucumberReport.Feature> invokeTests() {
        // Generate a timestamp-based filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String jsonFilename = "target/cucumber-batch-trigger-" + timestamp + ".json";

        String[] arguments = new String[]{
                "--glue", "com.lbg.utils.testservice.stepdefs",
                "classpath:features/batch_triggering",  // Use classpath to reference the features
                "--plugin", "json:" + jsonFilename  // Specify the custom JSON file name
        };
        try {
            Main.run(arguments, Thread.currentThread().getContextClassLoader());
            byte[] jsonBytes = Files.readAllBytes(Paths.get(jsonFilename));
            return objectMapper.readValue(jsonBytes, new TypeReference<List<CucumberReport.Feature>>() {});
        } catch (Exception e) {
            log.error("Error running batch trigger tests", e);
        }
        return null;
    }

}
