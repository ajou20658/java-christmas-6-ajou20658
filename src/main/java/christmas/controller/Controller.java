package christmas.controller;

import christmas.entity.discount.Discount;
import christmas.entity.menu.Menu;
import christmas.model.Receipt;
import christmas.model.ReceiptPrinter;
import christmas.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    public static final InputView inputView = new InputView();
    public final List<Discount<? extends Menu>> disCountList;
    public Controller(List<Discount<? extends Menu>> discountList){
        this.disCountList = discountList;
    }
    public void userOrder(){
        int date = inputView.readDate();
        Map<Menu,Integer> order = inputView.readOrder();
        Receipt receipt = new Receipt(disCountList,order,date);
        receipt.setTotalCost();
        receipt.setDiscount();

        receipt.setGift();
        receipt.setBadge();
        ReceiptPrinter receiptPrinter = new ReceiptPrinter(receipt);
        receiptPrinter.printReceipt();
    }
}
