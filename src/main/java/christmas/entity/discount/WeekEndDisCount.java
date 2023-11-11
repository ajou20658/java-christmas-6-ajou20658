package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.List;

public class WeekEndDisCount implements Discount{
    private final Integer discountAmount;
    private final List<Integer> weekEnd;
    private Integer realDiscount;
    public WeekEndDisCount(Integer discountAmount,List<Integer> weekEnd){
        this.discountAmount=discountAmount;
        this.weekEnd = weekEnd;

    }
    @Override
    public void setDiscount(int day) {
        realDiscount = 0;
        if(condition(day)){
            realDiscount = discountAmount;
        }
    }

    @Override
    public boolean condition(int day) {
        return weekEnd.contains(day);
    }

    @Override
    public Integer totalDiscount(List<Menu> menuList) {
        return menuList.size()*realDiscount;
    }
}
