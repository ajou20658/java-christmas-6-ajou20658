package christmas.filter;

import christmas.entity.discount.Discount;
import christmas.entity.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuFilter {
    public static <T extends Menu> List<T> filterByType(
            List<Menu> menuList, Class<? extends Discount<?>> type){
    List<T> filteredList = new ArrayList<>();
    for(Menu menu:menuList){
        if(type.isInstance(menu)){
            filteredList.add((T) menu);
        }
    }
    return filteredList;
    }
}
