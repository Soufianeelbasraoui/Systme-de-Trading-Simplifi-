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

    // afficher Actifs
    public void afficherActifsDisponibles() {
        System.out.println("\n--------------- CATALOGUE DU MARCHÉ XTRADE -------------------");

        // CORRECTION : On vérifie si la LISTE 'assets' est vide, pas la méthode elle-même
        if (assets.isEmpty()) {
            System.out.println("Le marché est actuellement fermé (aucun actif).");
        } else {

            for (Asset actif : assets) {
                System.out.println(actif.AfficherDescription());
            }
        }
        System.out.println("------------------------------------------------");
    }
    //chercher trader
    public Trader chercherTrader(int id){
       for (Trader t:traders){
           if (t.getId()==id){
               return t;
           }

       }
       return  null;
    }
}
