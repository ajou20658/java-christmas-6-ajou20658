package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.List;

public class SpecialDiscount implements Discount{
    private final Integer discountAmount;
    private final List<Integer> specialDay;
    private Integer realDiscount;
    public SpecialDiscount(Integer discountAmount,List<Integer> specialDay){
        this.specialDay = specialDay;
        this.discountAmount = discountAmount;
    }
    @Override
    public boolean condition(int day){
        return specialDay.contains(day);
    }

    @Override
    public Integer totalDiscount(List<Menu> menuList) {
        return realDiscount;
    }

    @Override
    public void setDiscount(int day) {
        realDiscount = 0;
        if(condition(day)){
            realDiscount = discountAmount;
        }
    }
}
