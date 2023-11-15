package christmas.view;

import christmas.model.Receipt;
import christmas.entity.discount.Discount;
import christmas.entity.gift.Badge;
import christmas.entity.menu.Menu;
import christmas.entity.menu.MenuItem;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printDailyEvent(int day){
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n",day);
        System.out.println();
    }
    public void printMenu(Map<? extends Menu,Integer> menuList) {
        System.out.println("<주문 메뉴>");
        for(Menu i:menuList.keySet()){
            System.out.println(MenuItem.findMenuName(i)+" "+menuList.get(i));
        }
        System.out.println();
        // ...
    }
    public void printBeforeTotalCost(Integer cost){
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원",cost);
        System.out.println();
    }
    public void printGift(String gift){
        System.out.println("<증정 메뉴>");
        if(gift.isEmpty()){
            System.out.println("없음");
            return;
        }
        System.out.println(gift+" 1개");
    }
    public void printDiscount(Receipt receipt){
        int total = receipt.getDiscountedAmount();
        System.out.println("<혜택 내역>");
        if(total != 0){
            printDiscountDetail(receipt.getDiscountList());
            System.out.println("<총혜택 금액>");
            System.out.printf("%,d원\n",total);
            System.out.println();
            return;
        }
        System.out.println("없음");
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n",total);
        System.out.println();
    }
    public void printDiscountDetail(List<Discount<? extends Menu>> discountList){
        for(Discount<? extends Menu> i : discountList){
            if(i.getTotalDiscount()>0){
//                System.out.println(i.getName()+": "+i.getTotalDiscount()+"원");
                System.out.printf("%s: %,d원\n",i.getName(),i.getTotalDiscount());
            }
        }
        System.out.println();
    }
    public void printAfterTotalCost(Integer cost){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원",cost);
        System.out.println();
    }
    public void printBadge(String badge){
        System.out.println("<12월 이벤트 배지>");
        if(badge!=null){
            System.out.println(badge);
            System.out.println();
            return;
        }
        System.out.println("없음");
    }
}
