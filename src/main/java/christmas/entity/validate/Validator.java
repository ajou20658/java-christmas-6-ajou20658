package christmas.entity.validate;

import christmas.entity.menu.MenuItem;

import java.util.List;

public class Validator {
    private int MIN_DATE = 1;
    private int MAX_DATE = 31;
    private int MIN_ORDER = 1;
    private String numberRegex = "^[0-9]*";
    private String orderRegex = "^([가-힣]+-[0-9]+,)+[가-힣]+-[0-9]+$";
    List<String> menuList;
    public Validator(){
        menuList = MenuItem.getMenuNames();
    }
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
    public void orderCheck(String rawInput){
        if(!rawInput.matches(orderRegex)){
            throw new IllegalArgumentException("[ERROR] 올바른 메뉴를 입력하세요.");
        }
    }
    public void orderRangeCheck(Integer input){
        if(input<MIN_ORDER){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    public void orderNameCheck(String rawInput){
        if(!menuList.contains(rawInput)){
            throw new IllegalArgumentException("[ERROR] 올바른 메뉴를 입력하세요.");
        }
    }


}
