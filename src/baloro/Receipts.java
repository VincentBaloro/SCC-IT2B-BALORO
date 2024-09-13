package baloro;

import java.util.ArrayList;

class Receipts {
    
    private ArrayList<Receipt> receipts;

    public Receipts() {
        receipts = new ArrayList<>();
    }

    public void addReceipt(String customerName, String productName, int quantity, int price, int cash) {
        Receipt receipt = new Receipt(customerName, productName, quantity, price, cash);
        receipts.add(receipt);
    }

    public void viewReceipts() {
        if (receipts.isEmpty()) {
            System.out.println("No receipts available.");
            return;
        }
        for (Receipt receipt : receipts) {
            receipt.display();
        }
    }
}


