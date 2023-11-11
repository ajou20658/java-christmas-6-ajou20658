package christmas.entity.discount;

import java.util.List;

public class WeekEndDisCount implements Discount{
    private final Integer discountAmount;
    private final List<Integer> weekEnd;
    public WeekEndDisCount(Integer discountAmount,List<Integer> weekEnd){
        this.discountAmount=discountAmount;
        this.weekEnd = weekEnd;

    }
    @Override
    public Integer discount(int day) {
        if(condition(day)){
            return discountAmount;
        }
        return 0;
    }

    @Override
    public boolean condition(int day) {
        return weekEnd.contains(day);
    }
}
