package christmas.model;

import christmas.view.OutputView;

public class ReceiptPrinter {
    private static final OutputView outputView = new OutputView();
    private final Receipt receipt;
    public ReceiptPrinter(Receipt receipt){
        this.receipt = receipt;
    }
    public void printReceipt(){
        outputView.printDailyEvent(receipt.getDay());
        outputView.printMenu(receipt.getMenuList());
        outputView.printBeforeTotalCost(receipt.getBeforeTotalCost());
        outputView.printGift(receipt.getChampagne());
        outputView.printDiscount(receipt);
        outputView.printAfterTotalCost(receipt.getAfterTotalCost());
        outputView.printBadge(receipt.getBadgetName());
    }
}
