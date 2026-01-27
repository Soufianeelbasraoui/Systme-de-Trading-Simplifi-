public class Trader extends Person{
    private double solde;

    public Trader(int id, String nom, double solde) {
        super(id, nom);
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
