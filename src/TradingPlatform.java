import java.util.ArrayList;
import java.util.List;

public class TradingPlatform {

    private List<Trader> traders=new ArrayList<>();
    private  List<Asset> assets=new ArrayList<>();

   //methode ajouter trader
    public void ajouterTrader(Trader t){
        traders.add(t);
        System.out.println("le Trader ajouter avec success! ");
    }
    //methode ajouter Actifs
    public void ajouterActif(Asset nouvelActif) {
        // Validation : Vérifier l'unicité du code
        for (Asset a : assets) {
            if (a.getCode().equalsIgnoreCase(nouvelActif.getCode())) {
                System.out.println("Erreur : Un actif avec le code " + nouvelActif.getCode() + " existe déjà.");
                return;
            }
        }


        assets.add(nouvelActif);
        System.out.println("L'actif " + nouvelActif.getNom() + " a été ajouté avec succès.");
    }
}
