package be.ucll.craftmanship.stockmarket.observer;

public class InstitutionalInvestor implements Investor {
    private String firmName;

    public InstitutionalInvestor(String firmName){
        this.firmName = firmName;

    }

    @Override
    public void update(String stockSymbol, double price){
        String action = (price > 180 ) ? "Initiating portfolio review:" : "Holding current position"; 
        System.out.printf(" [InstitutionalInvestor: %s] received update:%n", firmName);
        System.out.printf("  -> %s price: $%.2f. %s%n", stockSymbol, price, action);
    }
}
