package christmas.entity.gift;

import christmas.entity.menu.Menu;
import christmas.entity.menu.MenuItem;
import christmas.entity.menu.drink.Champagne;

public class ChampagneGift {
    public static final Integer MIN = 120000;
    public static boolean wineValidate(Integer beforeTotalCost){
        return MIN<beforeTotalCost;
    }
    public static Menu give(){
        return MenuItem.CHAMPAGNE.getMenu();
    }
}
