package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.List;

public class WeekDayDiscount implements Discount{
    private final Integer discountAmount;
    private final List<Integer> weekDay;
    private Integer realDiscount;
    public WeekDayDiscount(Integer discountAmount,List<Integer> weekDay){
        this.discountAmount=discountAmount;
        this.weekDay = weekDay;

    }
    @Override
    public boolean condition(int day){
        return weekDay.contains(day%7);
    }

    @Override
    public Integer totalDiscount(List<Menu> menuList) {
        return menuList.size()*realDiscount;
    }

    @Override
    public void setDiscount(int day) {
        realDiscount = 0;
        if(condition(day)){
            realDiscount = discountAmount;
        }
    }
}
