package models;

import models.Task;

public class Review {
    private Task task;
    private ConcentrationLevel concentrationLevel;
    private String newPoint;
    private String improvementPoint;
    private String regretPoint;

    public Review(
            Task task, ConcentrationLevel concentrationLevel,
            String newPoint, String improvementPoint, String regretPoint
    ) {
        this.task = task;
        this.concentrationLevel = concentrationLevel;
        this.newPoint = newPoint;
        this.improvementPoint = improvementPoint;
        this.regretPoint = regretPoint;
    }

    public String[] values() {
        return new String[]{
                task.toString(),
                "집중도: " + concentrationLevel.level(),
                "새로 알게된 것: " + newPoint,
                "아쉬원던 점: " + improvementPoint,
                "개선시킬 점: " + regretPoint
        };
    }
}
