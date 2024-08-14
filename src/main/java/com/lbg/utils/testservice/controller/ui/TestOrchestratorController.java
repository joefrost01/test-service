package com.lbg.utils.testservice.controller.ui;

import com.lbg.utils.testservice.component.BatchTriggerTestInvoker;
import com.lbg.utils.testservice.service.TestOrchestrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestOrchestratorController {

    private final TestOrchestrator testOrchestrator;
    private final BatchTriggerTestInvoker batchTriggerTestInvoker;

    @GetMapping("/run-tests")
    public String runTests(Model model) {
        model.addAttribute("features", batchTriggerTestInvoker.invokeTests());
        return "report";
    }
}
