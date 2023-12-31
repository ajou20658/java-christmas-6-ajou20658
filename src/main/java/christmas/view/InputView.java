package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.entity.menu.Menu;
import christmas.entity.menu.MenuItem;
import christmas.model.validate.Validator;

import java.util.*;

public class InputView {
    Validator validator = new Validator();
    public int readDate()throws IllegalArgumentException{
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String rawInput = Console.readLine();
            try {
                validator.numberCheck(rawInput);
                int intInput = Integer.parseInt(rawInput);
                validator.decemberDateRangeCheck(intInput);
                return intInput;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public Map<Menu,Integer> readOrder(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while(true) {
            try{
                String rawInput = Console.readLine();
                validator.orderCheck(rawInput);
                List<String> menuList = List.of(rawInput.split(","));
                Map<Menu,Integer> result = orderToList(menuList);
                validator.orderListCheck(result);
                return result;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    //메뉴의 개수대로 리스트를 반환해주는 함수
    private Map<Menu,Integer> orderToList(List<String> rawInput){
        Map<Menu,Integer> menuList = new HashMap<>();
        for(String input:rawInput){
            String[] split = input.split("-");
            validator.orderNameCheck(split[0]);
            Menu menu = menuMapping(split[0]);
            menuList.putAll(menuCount(menu,Integer.parseInt(split[1])));
        }
        return menuList;
    }
    private Map<Menu,Integer> menuCount(Menu name,Integer count){
        Map<Menu,Integer> menuList = new HashMap<>();
        menuList.put(name,count);
        return menuList;
    }
    private Menu menuMapping(String rawMenu){
        Menu menu = null;
        for(MenuItem i :MenuItem.values()){
            if(i.getName().equals(rawMenu)){
                menu = i.getMenu();
                break;
            }
        }
        return menu;
    }
}
