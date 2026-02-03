import java.util.ArrayList;
import java.util.List;

public class Trader extends Person {
    private double solde;
    private List<Transaction> transactions; ;
    private TradingPlatform tradingPlatform;
    private  Portfolio portfolio;

    public Trader(int id, String nom, double solde) {
        super(id, nom);
        this.solde = solde;
        this.transactions =new ArrayList<>();
        this.tradingPlatform = tradingPlatform;
        this.portfolio =new Portfolio<>(id, nom + "_Portfolio");
    }


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public TradingPlatform getTradingPlatform() {
        return tradingPlatform;
    }

    public void setTradingPlatform(TradingPlatform tradingPlatform) {
        this.tradingPlatform = tradingPlatform;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
    //methode ajouter transaction
    public void ajouterTransatction(Transaction t){
        transactions.add(t);

    }

}
