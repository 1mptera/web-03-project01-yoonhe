package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcentrationLevelTest {
    @Test
    void creation() {
        ConcentrationLevel concentrationLevel = new ConcentrationLevel();

        assertArrayEquals(new String[]{"낮음", "보통", "높음"},
                concentrationLevel.levels());

        assertEquals("낮음", concentrationLevel.level());
    }

    @Test
    void setLevel() {
        ConcentrationLevel concentrationLevel = new ConcentrationLevel();

        assertEquals("낮음", concentrationLevel.level());

        concentrationLevel.setLevel("보통");

        assertEquals("보통", concentrationLevel.level());
    }
}
