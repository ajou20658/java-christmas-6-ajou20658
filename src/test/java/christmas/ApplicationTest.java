package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }
    @Test
    @DisplayName("총 주문 메뉴가 20을 넘길경우")
    void test_main1() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-5,바비큐립-5,초코케이크-5,제로콜라-6");
            assertThat(output()).contains(
                    "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
            );
        });
    }
    @Test
    @DisplayName("주문 메뉴중 0인 메뉴가 있는 경우")
    void test_main2() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-0,바비큐립-5,초코케이크-5,제로콜라-6");
            assertThat(output()).contains(
                    "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
            );
        });
    }
    @Test
    @DisplayName("음료 메뉴만 주문한 경우")
    void test_main3() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-4");
            assertThat(output()).contains(
                    "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
            );
        });
    }
    @Test
    @DisplayName("금액 합이 10000원 미만인 경우")
    void test_main4() {
        assertSimpleTest(() -> {
            run("3", "제로콜라-1,양송이수프-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "<할인 전 총주문 금액>",
                    "<증정 메뉴>",
                    "<혜택 내역>",
                    "<총혜택 금액>",
                    "<할인 후 예상 결제 금액>",
                    "<12월 이벤트 배지>"
            );
        });
    }
    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
