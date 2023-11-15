package christmas.model;

import christmas.entity.discount.Discount;
import christmas.entity.gift.Badge;
import christmas.entity.gift.ChampagneGift;
import christmas.entity.menu.Menu;
import christmas.entity.menu.MenuItem;
import christmas.filter.MenuFilter;

import java.util.List;
import java.util.Map;

import static christmas.entity.menu.MenuItem.findPrice;

public class Receipt {
    private final List<Discount<? extends Menu>> discountList;
    private Integer day;
    private final Map<? extends Menu,Integer> menuList;
    private Integer beforeTotalCost;    //total cost
    private Integer afterTotalCost;     //discounted cost
    private Menu gift; //증정 메뉴
    private Badge badge; //2024년 이벤트 뱃지
    public Receipt(List<Discount<? extends Menu>> discountList,Map<Menu,Integer> menuList,Integer day){
        this.discountList = discountList;
        this.menuList = menuList;
        this.day = day;
        this.beforeTotalCost=0;
        this.afterTotalCost=0;
    }
    public void setTotalCost(){
        this.beforeTotalCost=0;
        for(Menu i : menuList.keySet()){
            this.beforeTotalCost+=findPrice(i)*menuList.get(i);
            //메뉴 종류별 가격 * 메뉴 종류 갯수만큼
        }
    }
    public void setGift(){
        boolean isValid = ChampagneGift.wineValidate(beforeTotalCost);
        if(isValid){
            this.gift = ChampagneGift.give();
            this.afterTotalCost -= MenuItem.findPrice(gift);
        }
    }
    public void setBadge(){
        int input = beforeTotalCost - afterTotalCost;
        this.badge = Badge.publishBadge(input);
    }
    public void setDiscount() {
        this.afterTotalCost = beforeTotalCost;
        for (Discount<? extends Menu> discount : discountList) {
            Class<? extends Menu> menuType = discount.getDiscountMenuType();
            Map<Menu, Integer> tmp = MenuFilter.filterByType(menuList, menuType);

            discount.setDiscount(day,beforeTotalCost);
            discount.setTotalDiscount(tmp);
            this.afterTotalCost -= discount.getTotalDiscount();
        }
    }
    public Integer getAfterTotalCost(){
        return afterTotalCost;
    }
    public Integer getBeforeTotalCost(){
        return beforeTotalCost;
    }
    public String getChampagne(){
        return MenuItem.findMenuName(gift);
    }
    public String getBadgetName(){
        if(badge==null){
            return null;
        }
        return badge.getName();
    }
    public Integer getDay(){
        return day;
    }
    public Map<? extends Menu,Integer> getMenuList(){
        return menuList;
    }
    public List<Discount<? extends Menu>> getDiscountList(){
        return discountList;
    }
    public Integer getDiscountedAmount(){
        return afterTotalCost-beforeTotalCost;
    }
}
