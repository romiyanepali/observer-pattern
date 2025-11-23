package be.ucll.craftmanship.stockmarket.observer;

public class IndividualInvestor implements Investor{
    private String name;

    public IndividualInvestor(String name){
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price){
        System.out.printf("[IndividualInvestor: %s] received update:%n", name);
        System.out.printf("  -> %s is now trading at $%.2f. Considering a personal trade.%n", stockSymbol, price);
    }
    
}
