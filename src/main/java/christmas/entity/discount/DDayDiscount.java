package christmas.entity.discount;

import christmas.entity.menu.Menu;

import java.util.Map;
public class DDayDiscount implements Discount<Menu> {
    private final String eventName;
    private final Integer discountAmount;
    private final Integer endDate;
    private final Integer minCost;
    private Integer realDiscount;
    private Integer totalDiscount;
    public DDayDiscount(String name, Integer discountAmount,Integer endDate,Integer minCost){
        this.eventName = name;
        this.discountAmount=discountAmount;
        this.endDate = endDate;
        this.minCost = minCost;
    }

    @Override
    public boolean condition(int day,int cost){
        return (day <= endDate)&&cost>=minCost;
    }
    @Override
    public void setTotalDiscount(Map<? extends Menu, Integer> menuList) {
        this.totalDiscount = realDiscount;
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


    @Override
    public void setDiscount(int day,int totalCost) {
        this.realDiscount = 0;
        if(condition(day,totalCost)){
            this.realDiscount = discountAmount+(day-1)*100;
        }
    }
}
