package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.List;

public interface Discount{
    public void setDiscount(int day);
    public boolean condition(int day);
    public Integer totalDiscount(List<Menu> menuList);
}
