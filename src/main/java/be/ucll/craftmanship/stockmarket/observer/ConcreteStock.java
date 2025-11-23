package be.ucll.craftmanship.stockmarket.observer;
import java.util.ArrayList;
import java.util.List;

public class ConcreteStock implements Stock{
    private String symbol;
    private double price;
    private List<Investor> investors = new ArrayList<>();

   
    public ConcreteStock(String symbol, double initialPrice){
        this.symbol = symbol;
        this.price = initialPrice;
        System.out.printf("%s at $%.2f%n", symbol, price);
    }

    @Override
    public void addInvestor(Investor investor) {
        investors.add(investor);
        System.out.printf(investor.getClass().getSimpleName(), symbol);

    }

    @Override
    public void removeInvestor(Investor investor) {
        if(investors.remove(investor)){
            System.out.printf(investor.getClass().getSimpleName(), symbol);
        }
    }

    @Override
    public void notifyInvestors() {
        System.out.printf("Notfying %d investors for %s...%n", investors.size(), symbol);
        for (Investor investor : investors) {
            investor.update(symbol, price);
        }
    }

    public void setPrice(double newPrice){
        if (newPrice != this.price){
            System.out.println("\n--- Price Change Alert");
            System.out.printf("%s: Price changing from $%.2f to %.2f%n", this.symbol, this.price, newPrice);
            this.price = newPrice;
            this.notifyInvestors();
        
        } else{
            System.out.printf("Price of %s did not change ($%.2f). No notification sent.%n", this.symbol, newPrice);
        }
    }


}
