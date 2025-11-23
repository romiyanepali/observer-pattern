package be.ucll.craftmanship.stockmarket.observer;

public interface Stock {
    void addInvestor (Investor investor);

    void removeInvestor (Investor investor);

    void notifyInvestors();
}
