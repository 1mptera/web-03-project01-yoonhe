package models;

import models.ConcentrationLevel;
import models.Review;
import models.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {
    @Test
    void creation() {
        Task task = new Task("마카오 뱅크 100% 인출", true);

        ConcentrationLevel ConcentrationLevel = new ConcentrationLevel();

        ConcentrationLevel.setLevel("보통");

        Review review = new Review(
                task,
                ConcentrationLevel,
                "객체 지향에 대해 알게되었다",
                "목표와 정렬되지 않은 일을 했다",
                "목표와 정렬된 일을 고르자"
        );

        assertArrayEquals(new String[]{
                "작업: 마카오 뱅크 100% 인출 / 완료 여부: 성공",
                "집중도: 보통",
                "새로 알게된 것: 객체 지향에 대해 알게되었다",
                "아쉬원던 점: 목표와 정렬되지 않은 일을 했다",
                "개선시킬 점: 목표와 정렬된 일을 고르자"
        }, review.values());
    }
}
