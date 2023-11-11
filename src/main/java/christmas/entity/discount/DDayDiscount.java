package christmas.entity.discount;

public class DDayDiscount implements Discount {
    private final Integer discountAmount;
    private final Integer EndDate;
    public DDayDiscount(Integer discountAmount,Integer endDate){
        this.discountAmount=discountAmount;
        this.EndDate = endDate;
    }
    @Override
    public boolean condition(int day){
        return day <= EndDate;
    }
    @Override
    public Integer discount(int day) {
        if(condition(day)){
            return this.discountAmount+(day-1)*100;
        }
        return 0;
    }
}
