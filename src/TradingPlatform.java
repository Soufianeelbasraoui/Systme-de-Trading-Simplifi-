import java.util.ArrayList;
import java.util.List;

public class TradingPlatform {
    private List<Asset> assets=new ArrayList<>();
    private List<Trader> traders =new ArrayList<>();

    // Méthode ajouter Actif
    public void ajouterActif(Asset nouvelActif) {

        if (chercherAsset(nouvelActif.getCode()) != null) {
            System.out.println("Erreur : Un actif avec le code " + nouvelActif.getCode() + " existe déjà.");
            return;
        }
        assets.add(nouvelActif);
        System.out.println("L'actif " + nouvelActif.getNom() + " a été ajouté avec succès.");
    }

    //ajouter un trader
    public void ajouterTrader(Trader t){
        if (chercherTrader(t.getId()) !=null){
            System.out.println("Erreur : Un trader avec le code " + t.getId() + " existe déjà.");
            return;
        }
        traders.add(t);
        System.out.println("L'trader " + t.getNom() + " a été ajouté avec succès.");
    }
    //creat creer Portefeuille
    public void creerPortefeuille(Trader t, String nomPortefeuille) {
        Portfolio nouveauP = new Portfolio(t.getId(), nomPortefeuille);

        t.setPortfolio(nouveauP);

        System.out.println(" Portefeuille '" + nomPortefeuille + "' associé avec succès à " + t.getNom());
    }

    //methode chercher trader
    public Trader chercherTrader(int idt){
        for (Trader t: traders){
            if (t.getId() ==idt){
                return t;
            }
        }
        return  null;
    }
    //methode chercher actif
    public Asset chercherAsset(String code) {
        for (Asset a : assets) {
            if (a.getCode().equalsIgnoreCase(code)) {
                return a;
            }
        }
        return null;
    }

    //affficher actif
    public void afficherAsset(){
        System.out.println("\n--------------- CATALOGUE DU MARCHÉ XTRADE -------------------");
        if (assets.isEmpty()){
            System.out.println("Le marché est actuellement fermé (aucun actif).");
        }
        else {
            for (Asset a: assets){
                System.out.println(a.afficherDescription());
            }
        }
        System.out.println("---------------------------------------------------------------");
    }


}
