package be.ucll.craftmanship.stockmarket.observer;

// Main Class
public class StockMarketSimulation {
    public static void main(String[] args){
        //1. Create Concrete Stock object
        //Initializes AAPL stock at 175
        ConcreteStock applStock = new ConcreteStock("AAPL",175);

        //Create Investor objects
        Investor investor1 = new IndividualInvestor("Romiya");
        Investor investor2 = new IndividualInvestor("Nina");
        Investor investor3 = new IndividualInvestor("Fleur");

        //Subs inv to stocks
        applStock.addInvestor(investor1);
        applStock.addInvestor(investor2);
        applStock.addInvestor(investor3);

        //Price Increase
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Price Increase (from 175 to 182.5");
        System.out.println("=".repeat(50));
        applStock.setPrice(182.5);


        System.out.println("\n--- Removal Phase ---");
        applStock.removeInvestor(investor3);

        //Price Drop (Expected: Only 2 investors notified)
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Price Drop (from 182.50 to 169.99)");
        System.out.println("=".repeat(50));
        applStock.setPrice(169.99);
        
        //No Change (Expected: No notification to investors)
        System.out.println("\n" + "=".repeat(50));
        System.out.println("No Change (Price remains 169.99)");
        System.out.println("=".repeat(50));
        applStock.setPrice(169.99);


    }
    
}
