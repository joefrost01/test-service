package com.lbg.utils.testservice.service;

import com.lbg.utils.testservice.component.BatchTriggerTestInvoker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrchestrator {

    private final BatchTriggerTestInvoker batchTriggerTestInvoker;

    public void runAllTests() {

        batchTriggerTestInvoker.invokeTests();

    }
}
