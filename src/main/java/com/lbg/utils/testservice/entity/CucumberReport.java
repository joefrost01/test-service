package com.lbg.utils.testservice.entity;

import lombok.Data;
import java.util.List;

@Data
public class CucumberReport {
    private List<Feature> features;

    @Data
    public static class Feature {
        private int line;
        private List<Scenario> elements;
        private String name;
        private String description;
        private String id;
        private String keyword;
        private String uri;
        private List<String> tags;
    }

    @Data
    public static class Scenario {
        private String startTimestamp;
        private int line;
        private String name;
        private String description;
        private String id;
        private String type;
        private String keyword;
        private List<Step> steps;
    }

    @Data
    public static class Step {
        private Result result;
        private int line;
        private String name;
        private Match match;
        private String keyword;
    }

    @Data
    public static class Match {
        private List<Argument> arguments;
        private String location;
    }

    @Data
    public static class Argument {
        private String val;
        private int offset;
    }

    @Data
    public static class Result {
        private String errorMessage;
        private long duration;
        private String status;
    }
}

