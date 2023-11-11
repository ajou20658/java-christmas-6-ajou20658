package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.List;

public class DDayDiscount implements Discount {
    private final Integer discountAmount;
    private final Integer EndDate;
    private Integer realDiscount;
    public DDayDiscount(Integer discountAmount,Integer endDate){
        this.discountAmount=discountAmount;
        this.EndDate = endDate;
    }
    @Override
    public boolean condition(int day){
        return day <= EndDate;
    }
    @Override
    public Integer totalDiscount(List<Menu> menuList) {
        return realDiscount;
    }

    @Override
    public void setDiscount(int day) {
        realDiscount = 0;
        if(condition(day)){
            realDiscount = discountAmount+(day-1)*100;
        }
    }
}
