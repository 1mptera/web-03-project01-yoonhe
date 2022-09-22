package models;

public class ConcentrationLevel {
    private String[] levels = {"낮음", "보통", "높음"};
    private String level = "낮음";

    public String[] levels() {
        return levels;
    }

    public String level() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
