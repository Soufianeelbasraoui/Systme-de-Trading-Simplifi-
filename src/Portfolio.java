import java.util.HashMap;
import java.util.Map;

public class Portfolio<T extends Asset> {

    private int idPortfolio;
    private String nom;

    private Map<T, Double> actifsPossedes;

    // Constructeur
    public Portfolio(int idPortfolio, String nom) {
        this.idPortfolio = idPortfolio;
        this.nom = nom;
        this.actifsPossedes = new HashMap<>();
    }

    public double calculerValeurTotale() {
        double total = 0;
        for (Map.Entry<T, Double> entry : actifsPossedes.entrySet()) {
            total += entry.getKey().getPrixUnitaire() * entry.getValue();
        }
        return total;
    }

    public void afficherPortfolio() {
        System.out.println("Portefeuille: " + nom + " (ID: " + idPortfolio + ")");
        if (actifsPossedes.isEmpty()) {
            System.out.println("Aucun actif détenu.");
        } else {
            actifsPossedes.forEach((actif, qte) -> {
                System.out.println("- " + actif.getNom() + " (" + actif.getCode() +
                        ") | Qté: " + qte + " | Valeur: " + (actif.getPrixUnitaire() * qte));
            });
        }
    }

    public void consulterPortefeuille() {
        afficherPortfolio();
        System.out.println("Valeur Totale du Portefeuille : " + calculerValeurTotale());
    }

    public void ajouterQuantite(T actif, double qte) {
        double qteActuelle = actifsPossedes.getOrDefault(actif, 0.0);
        actifsPossedes.put(actif, qteActuelle + qte);
    }

    public void retirerQuantite(T actif, double qte) {
        if (actifsPossedes.containsKey(actif)) {
            double qteActuelle = actifsPossedes.get(actif);
            if (qteActuelle >= qte) {
                actifsPossedes.put(actif, qteActuelle - qte);
            }
        }
    }

    // Getters
    public Map<T, Double> getActifsPossedes() {
        return actifsPossedes;
    }
}