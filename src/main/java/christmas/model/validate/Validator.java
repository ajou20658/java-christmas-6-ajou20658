package christmas.model.validate;

import christmas.entity.menu.Menu;
import christmas.entity.menu.MenuItem;
import christmas.entity.menu.drink.Drink;

import java.util.List;
import java.util.Map;

public class Validator {
    private int MIN_DATE = 1;
    private int MAX_DATE = 31;
    private int MIN_ORDER = 1;
    private int MAX_ORDER = 20;
    private String numberRegex = "^[0-9]*";
    private String orderRegex = "^[가-힣]+-[0-9]+(,[가-힣]+-[0-9]+)*$";
    List<String> menuList;
    public static final String error = "[ERROR] ";
    public static final String dayError = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String orderError = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public Validator(){
        menuList = MenuItem.getMenuNames();
    }
    public void numberCheck(String rawInput){
        if(!rawInput.matches(numberRegex)){
            throw new IllegalArgumentException(error+dayError);
        }
    }
    public void decemberDateRangeCheck(Integer input){
        if(input>MAX_DATE){
            throw new IllegalArgumentException(error+dayError);
        }
        if(input<MIN_DATE){
            throw new IllegalArgumentException(error+dayError);
        }
    }
    public void orderCheck(String rawInput){
        if(!rawInput.matches(orderRegex)){
            throw new IllegalArgumentException(error+orderError);
        }
    }
    public void orderListCheck(Map<Menu,Integer> orderList){
        orderOnlyDrinkAndTotalCount(orderList);
        for(Menu i : orderList.keySet()){
            orderRangeCheck(orderList.get(i));
        }


    }
    public void orderRangeCheck(Integer input){
        if(input<MIN_ORDER){
            throw new IllegalArgumentException(error+orderError);
        }
    }

//    public void orderDuplicateCheck(Map<>)
    public void orderOnlyDrinkAndTotalCount(Map<Menu,Integer> orderList){
        int allCount = 0;
        int drinkCount = 0;
        for(Menu i: orderList.keySet()){
            if(i.getClass()== Drink.class){
                drinkCount += orderList.get(i);
            }
            allCount += orderList.get(i);
        }
        if(drinkCount==allCount){
            throw new IllegalArgumentException(error+orderError);
        }
        if(allCount>MAX_ORDER){

        }
    }
    public void orderNameCheck(String rawInput){
        if(!menuList.contains(rawInput)){
            throw new IllegalArgumentException(error+orderError);
        }
    }


}
