package be.ucll.craftmanship.stockmarket.observer;

public interface Investor {
    void update (String stockSymbol, double price);
}
