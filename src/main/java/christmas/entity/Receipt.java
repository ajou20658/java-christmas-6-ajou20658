package christmas.entity;

import christmas.entity.discount.Discount;
import christmas.entity.menu.Menu;
import christmas.filter.MenuFilter;

import java.util.List;

import static christmas.entity.menu.MenuItem.findPrice;

public class Receipt {
    private final List<Discount<Menu>> discountList;
    private final List<Menu> menuList;
    private Integer day;
//    private final List<Main> mainMenuList;
//    private final List<Drink> drinkMenuList;
//    private final List<Dessert> dessertMenuList;
//    private final List<Appetite> appetiteMenuList;
//    this.mainMenuList = MenuFilter.filterByType(menuList,Main.class);
//        this.drinkMenuList = MenuFilter.filterByType(menuList,Drink.class);
//        this.dessertMenuList = MenuFilter.filterByType(menuList, Dessert.class);
//        this.appetiteMenuList = MenuFilter.filterByType(menuList, Appetite.class);
    private Integer beforeTotalCost;
    private Integer afterTotalCost;
    public Receipt(List<Discount<Menu>> discountList,List<Menu> menuList,Integer day){
        this.discountList = discountList;
        this.menuList = menuList;
        this.day = day;
    }
    public void setTotalCost(){
        for(Menu i : menuList){
            beforeTotalCost+=findPrice(i);
        }
    }
    public void SetDiscount(){
        afterTotalCost = beforeTotalCost;
        for(Discount<Menu> i : discountList){
            List<Menu> tmp = MenuFilter.filterByType(menuList, (Class<? extends Discount<?>>) i.getClass());
            i.setDiscount(day);
            afterTotalCost -= i.totalDiscount(tmp);
        }
    }
    public Integer getAfterTotalCost(){
        return afterTotalCost;
    }
    public Integer getBeforeTotalCost(){
        return beforeTotalCost;
    }

}
