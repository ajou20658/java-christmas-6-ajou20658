package christmas.view;

import christmas.entity.gift.ChampagneGift;
import christmas.model.Receipt;
import christmas.entity.discount.Discount;
import christmas.entity.gift.Badge;
import christmas.entity.menu.Menu;
import christmas.entity.menu.MenuItem;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String orderMenu = "<주문 메뉴>";
    public static final String beforeTotalAmount = "<할인 전 총주문 금액>";
    public static final String giftMenu = "<증정 메뉴>";
    public static final String eventList = "<혜택 내역>";
    public static final String none = "없음";
    public static final String totalDiscount = "<총혜택 금액>";
    public static final String afterTotalAmount = "<할인 후 예상 결제 금액>";
    public static final String badgeEvent = "<12월 이벤트 배지>";
    public static final String previewMent = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    public static final String wonFormat = "%,d원\n";

    public void printDailyEvent(int day){
        System.out.printf(previewMent,day);
        System.out.println();
    }
    public void printMenu(Map<? extends Menu,Integer> menuList) {
        System.out.println(orderMenu);
        for(Menu i:menuList.keySet()){
            System.out.println(MenuItem.findMenuName(i)+" "+menuList.get(i));
        }
        System.out.println();
        // ...
    }
    public void printBeforeTotalCost(Integer cost){
        System.out.println(beforeTotalAmount);
        System.out.printf(wonFormat,cost);
        System.out.println();
    }
    public void printGift(String gift){
        System.out.println(giftMenu);
        if(gift.isEmpty()){
            System.out.println(none);
            return;
        }
        System.out.println(gift+" 1개");
        System.out.println();
    }
    public void printDiscount(Receipt receipt){
        int total = receipt.getDiscountedAmount();
        System.out.println(eventList);
        if(total != 0){
            printDiscountDetail(receipt.getDiscountList(), receipt.getGift());

            System.out.println(totalDiscount);
            System.out.printf(wonFormat,(-1)*total);
            System.out.println();
            return;
        }
        System.out.println(none);
        System.out.println(totalDiscount);
        System.out.printf(wonFormat,(-1)*total);
        System.out.println();
    }
    public void printDiscountDetail(List<Discount<? extends Menu>> discountList,boolean isChampagneGifted){
        for(Discount<? extends Menu> i : discountList){
            if(i.getTotalDiscount()>0){
//                System.out.println(i.getName()+": "+i.getTotalDiscount()+"원");
                System.out.printf("%s: "+wonFormat,i.getName(),(-1)*i.getTotalDiscount());
            }
        }
        printChampagneGiftDetail(isChampagneGifted);
        System.out.println();
    }
    public void printChampagneGiftDetail(boolean isChampagneGifted){
        if(isChampagneGifted){
            System.out.printf("%s: "+wonFormat,ChampagneGift.getName(),(-1)*MenuItem.CHAMPAGNE.getPrice());
        }
    }
    public void printAfterTotalCost(Integer cost){
        System.out.println(afterTotalAmount);
        System.out.printf(wonFormat,cost);
        System.out.println();
    }
    public void printBadge(String badge){
        System.out.println(badgeEvent);
        if(badge!=null){
            System.out.println(badge);
            System.out.println();
            return;
        }
        System.out.println(none);
        System.out.println();
    }
}
