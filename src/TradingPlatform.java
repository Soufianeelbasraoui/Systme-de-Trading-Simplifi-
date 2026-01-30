import java.util.ArrayList;
import java.util.Date;
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
    //methode  Acheter Actif
    public void acheterActif(Trader trader, Asset actif, double quantite) {
        double prixTotal = actif.getPrixUnitaire() * quantite;

        // 1. Vérifier si le trader a assez d'argent
        if (trader.getSolde() >= prixTotal) {

            // 2. Déduire l'argent du solde
            trader.setSolde(trader.getSolde() - prixTotal);

            // 3. Ajouter l'actif au portefeuille
            if (trader.getPortfolio() != null) {
                trader.getPortfolio().ajouterQuantite(actif, quantite);

                // 4. Enregistrer la transaction dans l'historique
                Transaction t = new Transaction("ACHAT", actif, (int)quantite, actif.getPrixUnitaire());
                trader.ajouterTransaction(t);

                System.out.println(" Achat réussi : " + quantite + " " + actif.getCode());
            } else {
                System.out.println(" Erreur : Le trader n'a pas de portefeuille.");
            }
        } else {
            System.out.println(" Solde insuffisant ! (Requis: " + prixTotal + "€)");
        }
    }
    // methode vender actif
    public  void  venderActif(Trader trader,Asset asset, double quantite){
        double prix = asset.getPrixUnitaire() * quantite;

        // 1. Vérifier si le trader a assez d'argent
        if (trader.getSolde() >= prix) {

            // 2. Déduire l'argent du solde
            trader.setSolde(trader.getSolde() - prix);

            // 3. Ajouter l'actif au portefeuille
            if (trader.getPortfolio() != null) {
                trader.getPortfolio().retirerQuantite(asset, quantite);

                // 4. Enregistrer la transaction dans l'historique
                Transaction t = new Transaction("ACHAT", asset, (int)quantite, asset.getPrixUnitaire());
                trader.ajouterTransaction(t);

                System.out.println(" Achat réussi : " + quantite + " " + asset.getCode());
            } else {
                System.out.println(" Erreur : Le trader n'a pas de portefeuille.");
            }
        } else {
            System.out.println(" Solde insuffisant ! (Requis: " + prix + "€)");
        }
    }
    // afficher Actifs
    public void afficherActifsDisponibles() {
        System.out.println("\n--------------- CATALOGUE DU MARCHÉ XTRADE -------------------");
        if (assets.isEmpty()) {
            System.out.println("Le marché est actuellement fermé (aucun actif).");
        } else {

            for (Asset actif : assets) {
                System.out.println(actif.AfficherDescription());
            }
        }
        System.out.println("------------------------------------------------");
    }
    //creat creer Portefeuille
    public void creerPortefeuille(Trader t, String nomPortefeuille) {
        Portfolio nouveauP = new Portfolio(t.getId(), nomPortefeuille);

        t.setPortfolio(nouveauP);

        System.out.println(" Portefeuille '" + nomPortefeuille + "' associé avec succès à " + t.getNom());
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
    //chercher Actif
    public Asset chercherActif(String code){
        for (Asset a:assets){
            if (a.getCode().equals(code)){
                return  a;
            }
        }
        return null;
    }


}
