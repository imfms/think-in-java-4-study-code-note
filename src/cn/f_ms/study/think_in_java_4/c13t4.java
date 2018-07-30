package cn.f_ms.study.think_in_java_4;

import java.util.Formatter;

class c13t4 {
}

class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    private static final int ITEM_WIDTH = 15;
    private static final int ITEM_QTY = 5;
    private static final int ITEM_PRICE = 10;

    public void printTitle() {
        f.format(String.format("%%-%ds %%%ds %%%ds\n", ITEM_WIDTH, ITEM_QTY, ITEM_PRICE), "Item", "Qty", "Price");
        f.format(String.format("%%-%ds %%%ds %%%ds\n", ITEM_WIDTH, ITEM_QTY, ITEM_PRICE), "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(String.format("%%-%1$d.%1$ds %%%2$dd %%%3$d.2f\n", ITEM_WIDTH, ITEM_QTY, ITEM_PRICE), name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format(String.format("%%-%ds %%%ds %%%d.2f\n", ITEM_WIDTH, ITEM_QTY, ITEM_PRICE), "Tax", "", total * 0.06);
        f.format(String.format("%%-%ds %%%ds %%%ds\n", ITEM_WIDTH, ITEM_QTY, ITEM_PRICE), "", "", "-----");
        f.format(String.format("%%-%ds %%%ds %%%d.2f\n", ITEM_WIDTH, ITEM_QTY, ITEM_PRICE), "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
