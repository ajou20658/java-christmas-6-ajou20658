package christmas.entity.discount;

import christmas.entity.menu.Menu;
import christmas.entity.menu.dessert.Dessert;

import java.util.List;
import java.util.Map;

public class WeekDayDiscount implements Discount<Dessert>{
    private final String eventName;
    private final Integer discountAmount;
    private final List<Integer> weekDay;
    private final Integer minCost;
    private Integer realDiscount;
    private Integer totalDiscount;
    public WeekDayDiscount(String name, Integer discountAmount, List<Integer> weekDay, Integer minCost){
        this.eventName = name;
        this.discountAmount=discountAmount;
        this.weekDay = weekDay;
        this.minCost = minCost;

    }
    @Override
    public boolean condition(int day,int totalCost){
        return weekDay.contains(day%7)&&totalCost>=minCost;
    }

    @Override
    public void setTotalDiscount(Map<? extends Menu, Integer> menuList) {
        int totalCount = 0;
        for(Menu i:menuList.keySet()){
            totalCount += menuList.get(i);
        }
        this.totalDiscount = totalCount*realDiscount;
        System.out.println(this.totalDiscount);
    }

    @Override
    public void setDiscount(int day,int totalCost) {
        this.realDiscount = 0;
        if(condition(day,totalCost)){
            this.realDiscount = discountAmount;
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
    public Class<Dessert> getDiscountMenuType() {
        return Dessert.class;
    }
}
