package com.lbg.utils.testservice.service;

import com.lbg.utils.testservice.component.BatchTriggerTestInvoker;
import com.lbg.utils.testservice.component.OutputReconciliationTestInvoker;
import com.lbg.utils.testservice.component.UILoadingTestInvoker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrchestrator {

    private final BatchTriggerTestInvoker batchTriggerTestInvoker;
    private final OutputReconciliationTestInvoker outputReconciliationTestInvoker;
    private final UILoadingTestInvoker uiLoadingTestInvoker;

    public void runAllTests() {

        batchTriggerTestInvoker.invokeTests();

    }
}
