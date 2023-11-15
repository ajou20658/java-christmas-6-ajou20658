package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.Map;

public interface Discount<T extends Menu>{
    public void setDiscount(int day,int totalCost);
    public boolean condition(int day,int totalCost);
    public void setTotalDiscount(Map<? extends Menu, Integer> menuList);
    public Integer getTotalDiscount();
    public String getName();
    Class<T> getDiscountMenuType();

}
