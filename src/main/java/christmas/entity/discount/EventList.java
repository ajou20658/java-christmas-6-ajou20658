package christmas.entity.discount;

import christmas.entity.menu.Menu;
import christmas.entity.menu.MenuItem;

import java.util.*;

public enum EventList {
    DDAY("크리스마스 디데이 할인",1000,25, List.of(),10000),
    WEEKDAY("평일 할인",2023,31,List.of(3,4,5,6,7),10000),
    WEEKEND("주말 할인",2023,31,List.of(1,2),10000),
    SPECIAL("특별 할인",1000,31,List.of(3,10,17,24,25,31),10000)
    ;

    private String name;
    private Integer discount;
    private Integer endDay;
    private List<Integer> targetDay;
    private Integer minCost;
    EventList(String name, Integer discount, Integer endDay, List<Integer> targetDay,Integer minCost) {
        this.name = name;
        this.discount = discount;
        this.endDay = endDay;
        this.targetDay = targetDay;
        this.minCost = minCost;
    }
    public Integer getDiscount(){
        return this.discount;
    }
    public String getName(){
        return this.name;
    }
    public Integer getEndDay(){
        return this.endDay;
    }
    public List<Integer> getTargetDay(){
        return this.targetDay;
    }
    public Integer getMinCost(){
        return this.minCost;
    }
}
