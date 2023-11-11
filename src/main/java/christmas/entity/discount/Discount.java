package christmas.entity.discount;

public interface Discount{
    public Integer discount(int day);
    public boolean condition(int day);
}
