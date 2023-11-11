package christmas.entity.discount;

import java.util.List;

public class SpecialDiscount implements Discount{
    private final Integer discountAmount;
    private final List<Integer> specialDay;
    public SpecialDiscount(Integer discountAmount,List<Integer> specialDay){
        this.specialDay = specialDay;
        this.discountAmount = discountAmount;
    }
    @Override
    public boolean condition(int day){
        return specialDay.contains(day);
    }
    @Override
    public Integer discount(int day) {
        if(condition(day)){
            return discountAmount;
        }
        return 0;
    }
}
