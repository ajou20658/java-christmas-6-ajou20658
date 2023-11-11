package christmas.entity.discount;

import java.util.List;

public class WeekDayDiscount implements Discount{
    private final Integer discountAmount;
    private final List<Integer> weekDay;
    public WeekDayDiscount(Integer discountAmount,List<Integer> weekDay){
        this.discountAmount=discountAmount;
        this.weekDay = weekDay;

    }
    @Override
    public boolean condition(int day){
        return weekDay.contains(day%7);
    }
    @Override
    public Integer discount(int day) {
        if(condition(day)){
            return discountAmount;
        }
        return 0;
    }
}
