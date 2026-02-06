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
    public double getVolumeTotal() {
        return transactions.stream()
                .mapToDouble(tr -> tr.getQuantite() * tr.getPrix())
                .sum();
    }
    public void afficherTrader() {
        System.out.println("========= PROFIL TRADER =========");
        System.out.println("ID     : " + getId());
        System.out.println("Nom    : " + getNom());
        System.out.println("Solde  : " + String.format("%.2f", solde) + " $");

        System.out.println("Volume : " + String.format("%.2f", getVolumeTotal()) + " $");
        if (portfolio != null) {
            System.out.println("Portfolio : " + portfolio.getNom());
        }

        System.out.println("Nombre de transactions : " + transactions.size());
        System.out.println("---------------------------------");
    }




}
