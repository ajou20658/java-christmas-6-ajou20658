package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.List;

public interface Discount<T extends Menu>{
    public void setDiscount(int day);
    public boolean condition(int day);
    public Integer totalDiscount(List<T> menuList);
}
