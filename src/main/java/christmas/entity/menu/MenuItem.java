package christmas.entity.menu;

import christmas.entity.menu.appetite.Salad;
import christmas.entity.menu.appetite.Soup;
import christmas.entity.menu.appetite.Tapas;
import christmas.entity.menu.dessert.ChocoCake;
import christmas.entity.menu.dessert.IceCream;
import christmas.entity.menu.drink.Champagne;
import christmas.entity.menu.drink.RedWine;
import christmas.entity.menu.drink.ZeroCoke;
import christmas.entity.menu.main.ChristmasPasta;
import christmas.entity.menu.main.Rip;
import christmas.entity.menu.main.SeaFoodPasta;
import christmas.entity.menu.main.Steak;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MenuItem {
    SOUP("양송이수프",6000,new Soup()),
    SALAD("시저샐러드",8000,new Salad()),
    TAPAS("타파스",5500,new Tapas()),
    STEAK("티본스테이크",55000,new Steak()),
    RIP("바비큐립",54000,new Rip()),
    SEAFOODPASTA("해산물파스타",35000,new SeaFoodPasta()),
    CHRISTMASPASTA("크리스마스파스타",25000,new ChristmasPasta()),
    CHOCOCAKE("초코케이크",15000,new ChocoCake()),
    ICECREAM("아이스크림",5000,new IceCream()),
    ZEROCOKE("제로콜라",3000,new ZeroCoke()),
    REDWINE("레드와인",60000,new RedWine()),
    CHAMPAGNE("샴페인",25000,new Champagne());

    private final String name;
    private final Integer price;
    private final Menu menu;
    MenuItem(String name,Integer price,Menu menu){
        this.name = name;
        this.price = price;
        this.menu = menu;
    }
    public String getName(){
        return this.name;
    }
    public Integer getPrice(){
        return this.price;
    }
    public Menu getMenu(){
        return this.menu;
    }
    public static List<String> getMenuNames(){
        return Arrays.stream(MenuItem.values())
                .map(MenuItem::getName)
                .toList();
    }
    public static Integer findPrice(Menu menu) {
        for (MenuItem item : MenuItem.values()) {
            if (item.getMenu().equals(menu)) {
                return item.getPrice();
            }
        }
        return 0;
    }
    public static String findMenuName(Menu menu){
        for (MenuItem item : MenuItem.values()) {
            if (item.getMenu().equals(menu)) {
                return item.getName();
            }
        }
        return "";
    }
}
