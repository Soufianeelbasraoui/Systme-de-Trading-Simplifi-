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
                double qnt=0;
                double valeu=a.getPrixUnitaire() * qnt;
                System.out.println(a.getNom()+ "| Qté: " + qnt +"| Valeur Totale: "+valeu+" €%n");
            }
        }
    }

    public int getIdPortfolio() {
        return idPortfolio;
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
