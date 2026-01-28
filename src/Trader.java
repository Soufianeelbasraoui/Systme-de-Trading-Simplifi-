import java.util.ArrayList;
import java.util.List;

public class Trader extends Person {
    private double solde;
    private Portfolio<Asset> portfolio; //
    private List<Transaction> historique;

    public Trader(int id, String nom, double soldeInitial) {
        super(id, nom);
        this.solde = soldeInitial;

        this.portfolio = new Portfolio<>(id, "Portefeuille de " + nom);
        this.historique = new ArrayList<>();
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
        this.historique.add(t);
    }

    public List<Transaction> getHistorique() {
        return historique;
    }
}