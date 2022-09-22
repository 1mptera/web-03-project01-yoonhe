package models;

public class Objective {
    private String title;
    private int achievementRate;

    public Objective(String title, int achievementRate) {
        this.title = title;
        this.achievementRate = achievementRate;
    }

    @Override
    public String toString() {
        return title + " (" + achievementRate + "%)";
    }

    public String title() {
        return title;
    }

    @Override
    public boolean equals(Object other) {
        Objective otherObjective = (Objective) other;

        return title == otherObjective.title
                && achievementRate == otherObjective.achievementRate;
    }
}
