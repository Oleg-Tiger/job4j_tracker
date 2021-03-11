package ru.job4j.oop;

public final class LiquidationProduct {
    private Product product;
    private int discount = 90;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price - getDiscount());
    }

    public Product getProduct() {
        return product;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String label() {
        return product.label();
    }
}