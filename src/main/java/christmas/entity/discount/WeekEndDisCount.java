package christmas.entity.discount;

import christmas.entity.menu.Menu;
import christmas.entity.menu.main.Main;

import java.util.List;
import java.util.Map;

public class WeekEndDisCount implements Discount<Main> {
    private final String eventName;
    private final Integer discountAmount;
    private final List<Integer> weekEnd;
    private final Integer minCost;
    private Integer realDiscount;
    private Integer totalDiscount;
    public WeekEndDisCount(String name, Integer discountAmount, List<Integer> weekEnd, Integer minCost){
        this.eventName = name;
        this.discountAmount=discountAmount;
        this.weekEnd = weekEnd;
        this.minCost = minCost;
    }
    @Override
    public void setDiscount(int day,int totalCost) {
        this.realDiscount = 0;
        if(condition(day,totalCost)){
            this.realDiscount = discountAmount;
        }
    }

    @Override
    public boolean condition(int day, int totalCost) {
        return weekEnd.contains(day)&&totalCost>=minCost;
    }

    @Override
    public void setTotalDiscount(Map<? extends Menu, Integer> menuList) {
        int totalCount = 0;
        for(Menu i:menuList.keySet()){
            totalCount += menuList.get(i);
        }
        this.totalDiscount = totalCount*realDiscount;
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
    public Class<Main> getDiscountMenuType() {
        return Main.class;
    }
}
