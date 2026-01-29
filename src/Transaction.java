import java.util.Date;

public class Transaction {
    // Attributs du diagramme
    private String typeDoperation;
    private int quantite;
    private double prix;
    private Date date;
    private Asset asset;

    public Transaction(String type, Asset actif, int qte, double prix) {
        this.typeDoperation = type;
        this.asset = actif;
        this.quantite = qte;
        this.prix = prix;
        this.date = new Date();
    }

    public void afficherTransaction() {
        System.out.printf("[%s] %s | %s | Qté: %d | Prix Unit: %.2f€ | Total: %.2f€%n",
                date.toString(), typeDoperation, asset.getNom(), quantite, prix, (quantite * prix));
    }
}