package christmas.entity.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Validator validator = new Validator();
    @ParameterizedTest
    @DisplayName("요일의 입력이 올바르지 않은 경우")
    @ValueSource(strings = {"0","32","-1"})
    void rangeTest1(Integer integer){
        assertThatThrownBy(()->validator.decemberDateRangeCheck(integer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 날짜를 입력하세요.");
    }
    @ParameterizedTest
    @DisplayName("요일의 입력이 올바른 경우")
    @ValueSource(strings = {"1","31"})
    void rangeTest2(Integer integer){
        assertThatCode(()->validator.decemberDateRangeCheck(integer))
                .doesNotThrowAnyException();

    }
    @ParameterizedTest
    @DisplayName("올바르지 않은 주문이 들어온경우")
    @ValueSource(strings = {"타파스-1,제로콜라-1 " //공백 들어간경우
            ,"티본스테이크-1,바비큐립-1,초코케이크-2,제로d라-1"//영어 들어간경우
            ,"티본스테이크-1,바비큐립-1,초코케이크-2,,제로콜라-1"//콤마가 여러 개
            ,"티본스테이크--1,바비큐립-1,초코케이크-2,제로콜라-1"//하이픈이 여러개
            ,"\n"//아무입력없는경우
            ,"티본스테이크--1,-1,초코케이크-2,제로콜라-1"//메뉴입력안한경우

    })
    void orderTest1(String order){
        assertThatThrownBy(()->validator.orderCheck(order))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @DisplayName("숫자가 맞는지 확인")
    @ValueSource(strings = {
            "티본스테이쿠","바베큐립","쵸코케이크","제로코라"//유효하지만 메뉴에 없는 경우
    })
    void orderTest2(String order){
        assertThatThrownBy(()->validator.orderNameCheck(order))
                .isInstanceOf(IllegalArgumentException.class);

    }
}