package christmas.entity.gift;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {
    @Test
    @DisplayName("종류별 뱃지 발급")
    void publishBadge1() {
        assertThat(Badge.publishBadge(5001))
                .isEqualTo(Badge.STAR);
    }
    @Test
    @DisplayName("종류별 뱃지 발급")
    void publishBadge2() {
        assertThat(Badge.publishBadge(10001))
                .isEqualTo(Badge.TREE);
    }@Test
    @DisplayName("종류별 뱃지 발급")
    void publishBadge3() {
        assertThat(Badge.publishBadge(20001))
                .isEqualTo(Badge.SANTA);
    }
}