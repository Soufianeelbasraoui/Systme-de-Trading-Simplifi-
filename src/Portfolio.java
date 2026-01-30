import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio<T extends Asset> {

    private int idPortfolio;
    private String nom;

    private Map<T, Double> asset;
    private List<Asset> assets=new ArrayList<>();

    // Constructeur
    public Portfolio(int idPortfolio, String nom) {
        this.idPortfolio = idPortfolio;
        this.nom = nom;
        this.asset = new HashMap<>();
    }

    public double calculerValeurTotale() {
        double total = 0;
        for (Map.Entry<T, Double> entry : asset.entrySet()) {
            total += entry.getKey().getPrixUnitaire() * entry.getValue();
        }
        return total;
    }

    public void afficherPortfolio() {
        System.out.println("Portefeuille: " + this.nom + " (ID: " + this.idPortfolio + ")");

        // On utilise le nom de la Map défini dans ta classe Portfolio
        if (asset == null || asset.isEmpty()) {
            System.out.println("Aucun actif détenu.");
        } else {
            asset.forEach((actif, qte) -> {
                double valeur = actif.getPrixUnitaire() * qte;
                System.out.printf("- %s (%s) | Qté: %.2f | Valeur Totale: %.2f €%n",
                        actif.getNom(), actif.getCode(), qte, valeur);
            });
        }
    }


    public void ajouterQuantite(T actif, double qte) {
        double qteActuelle = asset.getOrDefault(actif, 0.0);
        asset.put(actif, qteActuelle + qte);
    }

    public void retirerQuantite(T actif, double qte) {
        if (asset.containsKey(actif)) {
            double qteActuelle =asset.get(actif);
            if (qteActuelle >= qte) {
                asset.put(actif, qteActuelle - qte);
            }
        }
    }

    // Getters
    public Map<T, Double> getActifsPossedes() {
        return asset;
    }


}