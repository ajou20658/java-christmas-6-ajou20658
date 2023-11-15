package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.List;
import java.util.Map;

public class SpecialDiscount implements Discount<Menu>{
    private final String eventName;
    private final Integer discountAmount;
    private final List<Integer> specialDay;
    private final Integer minCost;
    private Integer realDiscount;
    private Integer totalDiscount;
    public SpecialDiscount(String name, Integer discountAmount,List<Integer> specialDay,Integer minCost){
        this.eventName = name;
        this.specialDay = specialDay;
        this.discountAmount = discountAmount;
        this.minCost = minCost;
    }
    @Override
    public boolean condition(int day,int totalCost){

        return specialDay.contains(day)&&totalCost>=minCost;
    }

    @Override
    public void setTotalDiscount(Map<? extends Menu, Integer> menuList) {
        totalDiscount = realDiscount;
    }

    @Override
    public void setDiscount(int day,int totalCost) {
        realDiscount = 0;
        if(condition(day,totalCost)){
            realDiscount = discountAmount;
        }
    }
    @Override
    public Integer getTotalDiscount(){
        return totalDiscount;
    }

    @Override
    public String getName() {
        return eventName;
    }

    @Override
    public Class<Menu> getDiscountMenuType() {
        return Menu.class;
    }

}
