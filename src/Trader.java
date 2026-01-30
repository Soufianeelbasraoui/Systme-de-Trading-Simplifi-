import java.util.ArrayList;
import java.util.List;

public class Trader extends Person {
    private double solde;
    private Portfolio portfolio; //
    private List<Transaction> transactions;


    public Trader(int id, String nom, double soldeInitial) {
        super(id, nom);
        this.solde = soldeInitial;

        this.portfolio = new Portfolio<>(id, "Portefeuille de " + nom);
        this.transactions = new ArrayList<>();
    }

    public double getSolde() {
        return solde;
    }


    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Portfolio<Asset> getPortfolio() {
        return portfolio;
    }

    public void ajouterTransaction(Transaction t) {
        this.transactions.add(t);
    }

//    public void enregistrerTransaction(){
//        for (Transaction t:transactions){
//            t.afficherTransaction();
//        }
//
//    }

    public List<Transaction> getHistorique() {
        return transactions;
    }

    public void setPortfolio(Portfolio<Asset> portfolio) {
        this.portfolio = portfolio;
    }
}