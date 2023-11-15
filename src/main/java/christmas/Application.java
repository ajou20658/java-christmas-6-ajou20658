package christmas;

import christmas.controller.Controller;
import christmas.entity.discount.*;
import christmas.entity.menu.Menu;
import christmas.entity.menu.dessert.Dessert;
import christmas.entity.menu.main.Main;

import java.util.Dictionary;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Discount<Menu> dday = new DDayDiscount(
                EventList.DDAY.getName(),
                EventList.DDAY.getDiscount(),
                EventList.DDAY.getEndDay(),
                EventList.DDAY.getMinCost()
                );
        Discount<Dessert> weekday = new WeekDayDiscount(
                EventList.WEEKDAY.getName(),
                EventList.WEEKDAY.getDiscount(),
                EventList.WEEKDAY.getTargetDay(),
                EventList.WEEKDAY.getMinCost()
        );
        Discount<Main> weekend = new WeekEndDisCount(
                EventList.WEEKEND.getName(),
                EventList.WEEKEND.getDiscount(),
                EventList.WEEKEND.getTargetDay(),
                EventList.WEEKEND.getMinCost()
        );
        Discount<Menu> special = new SpecialDiscount(
                EventList.SPECIAL.getName(),
                EventList.SPECIAL.getDiscount(),
                EventList.SPECIAL.getTargetDay(),
                EventList.SPECIAL.getMinCost()

                );
        Controller controller = new Controller(
                List.of(dday,weekday,weekend,special)
        );
        controller.userOrder();
    }
}
