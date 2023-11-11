package christmas.entity.validate;

public class Validator {
    private int MIN_DATE = 1;
    private int MAX_DATE = 31;
    private String numberRegex = "^[0-9]*";
    private String koreanRegex = "^[가-힣]";
    public void numberCheck(String rawInput){
        if(!rawInput.matches(numberRegex)){
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }
    public void decemberDateRangeCheck(Integer input){
        if(input>MAX_DATE){
            throw new IllegalArgumentException("[ERROR] 올바른 날짜를 입력하세요.");
        }
        if(input<MIN_DATE){
            throw new IllegalArgumentException("[ERROR] 올바른 날짜를 입력하세요.");
        }
    }
    public void koreanCheck(String rawInput){
        if(!rawInput.matches(koreanRegex)){
            throw new IllegalArgumentException("[ERROR] 올바른 메뉴를 입력하세요.");
        }
    }

}
