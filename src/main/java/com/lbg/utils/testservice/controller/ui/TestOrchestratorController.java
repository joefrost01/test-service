package com.lbg.utils.testservice.controller.ui;

import com.lbg.utils.testservice.component.BatchTriggerTestInvoker;
import com.lbg.utils.testservice.service.TestOrchestrator;
import io.cucumber.core.cli.Main;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestOrchestratorController {

    private final TestOrchestrator testOrchestrator;
    private final BatchTriggerTestInvoker batchTriggerTestInvoker;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/run-tests")
    public String runTests(Model model) {
        model.addAttribute("features", batchTriggerTestInvoker.invokeTests());
        return "report";
    }

    @GetMapping("/runBatchTests")
    public String runBatchTests(@RequestParam("batchDate") String batchDate, Model model) {
        model.addAttribute("features", batchTriggerTestInvoker.invokeTests2(batchDate));
        return "report";
    }
}
