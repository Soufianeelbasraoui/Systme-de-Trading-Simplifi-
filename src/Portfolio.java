import java.util.ArrayList;
import java.util.List;

public class Portfolio <T extends Asset>{
    private int idPortfolio;
    private String nom;
    private List<T> asset;

    public Portfolio(int idPortfolio, String nom) {
        this.idPortfolio = idPortfolio;
        this.nom = nom;
        this.asset =new ArrayList<>();
    }
    // afficher portfio
    public void afficherPortfio(){
        System.out.println("Portefeuille: " + nom + " (ID: " + idPortfolio + ")");
        if (asset ==null || asset.isEmpty()){
            System.out.println("Aucun actif détenu.");
        }
        else {
            for (Asset a: asset ){
                double qnt=a.getQuantite();
                double valeu=a.prixUnitaire*qnt;
                System.out.println("Code: " +a.code + "| Le Nom: "+a.getNom()+ "| Qté: " +a.quantite   +"| Valeur Totale: "+valeu +" €%n");
            }
        }
    }


// Ajouter quantité
public void ajouterQuantite(T a, int qte){
        if (!asset.contains(a)){
            a.setQuantite(qte);
            asset.add(a);
        }
        else {
           a.setQuantite(a.getQuantite() + qte);
        }
}



    public void retirerQuantite(T a, int qte) {
        for (T item : asset) {
            if (item.getCode().equalsIgnoreCase(a.getCode())) {
                if (item.getQuantite() >= qte) {
                    item.setQuantite(item.getQuantite() - qte);
                    if (item.getQuantite() == 0)
                        asset.remove(item);
                    return;
                } else {
                    System.out.println(" Erreur : Quantité insuffisante en portefeuille.");
                    return;
                }
            }
        }
        System.out.println(" Erreur : Actif non possédé.");
    }

    public void setIdPortfolio(int idPortfolio) {
        this.idPortfolio = idPortfolio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<T> getAsset() {
        return asset;
    }

    public void setAsset(List<T> asset) {
        this.asset = asset;
    }
}
