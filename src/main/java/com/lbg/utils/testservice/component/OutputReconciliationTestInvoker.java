package com.lbg.utils.testservice.component;

import io.cucumber.core.cli.Main;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class OutputReconciliationTestInvoker {

    public void invokeTests() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String jsonFilename = "target/cucumber-output-reconciliation-" + timestamp + ".json";

        String[] arguments = new String[]{
                "--glue", "com.lbg.utils.testservice.stepdefs.reconciliation",
                "classpath:features/output_reconciliation",
                "--plugin", "json:" + jsonFilename
        };

        try {
            Main.run(arguments, Thread.currentThread().getContextClassLoader());
        } catch (Exception e) {
            log.error("Error running output reconciliation tests", e);
        }
    }

}
