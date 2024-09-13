package baloro;

import java.util.Scanner;

class Reciept {
    public void getReceipt(Scanner input) {
        String fname, pname;
        int quan, price, cash, totald, change;

        System.out.println("Customer name:");
        fname = input.nextLine();
        
        System.out.println("Product Name:");
        pname = input.nextLine();
        
        System.out.println("Quantity:");
        quan = input.nextInt();
        
        System.out.println("Price:");
        price = input.nextInt();
        
        System.out.println("Cash:");
        cash = input.nextInt();
        
        totald = quan * price;

        System.out.println("________________________");
        System.out.println("Receipt");
        System.out.println("________________________");
        System.out.println("Name: " + fname);
        System.out.println("Item: " + pname);
        System.out.println("Quantity: " + quan);
        System.out.println("Total due: " + totald);
        System.out.println("Cash: " + cash);
        
        change = cash - totald;
        System.out.println("Change: " + change);
        System.out.println("________________________");
    }
}

