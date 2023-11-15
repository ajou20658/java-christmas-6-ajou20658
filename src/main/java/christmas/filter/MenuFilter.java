package christmas.filter;

import christmas.entity.discount.Discount;
import christmas.entity.menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuFilter {

    public static <T extends Menu, V> Map<Menu, Integer> filterByType(Map<? extends Menu, Integer> map, Class<T> type) {
        return map.entrySet().stream()
                .filter(entry -> type.isInstance(entry.getKey()))
                .collect(Collectors.toMap(entry -> type.cast(entry.getKey()), Map.Entry::getValue));
    }
}
