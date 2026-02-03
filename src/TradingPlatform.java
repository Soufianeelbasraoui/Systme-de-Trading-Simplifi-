import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TradingPlatform {
    private List<Asset> assets=new ArrayList<>();
    private List<Trader> traders =new ArrayList<>();
    public void initialiserMarche() {

        this.ajouterActif(new Stock("AAPL", "Apple Inc", 180.50, "Stock", 1001,1));
        this.ajouterActif(new Stock("TSLA", "Tesla", 240.20, "Stock", 1002,3));
        this.ajouterActif(new Stock("MC.PA", "LVMH", 750.00, "Stock", 1003,2));

        this.ajouterActif(new CryptoCurrency("BTC", "Bitcoin", 420.0, "Crypto", 33,3));
        this.ajouterActif(new CryptoCurrency("ETH", "Ethereum", 220.0, "Crypto", 1,2));

    }
    public void controlePrix() {
        Random random = new Random();

        for (int i = 0; i < assets.size(); i++) {
            Asset a = assets.get(i);
            double nouveauPrix = random.nextDouble(100,1000);

            nouveauPrix = Math.round(nouveauPrix * 100.0) / 100.0;

            a.setPrixUnitaire(nouveauPrix);
        }
        System.out.println(" Les prix du marché ont été mis à jour (Fourchette 100€ - 1000€).");
    }
    // Méthode ajouter Actif
    public void ajouterActif(Asset nouvelActif) {

        if (chercherAsset(nouvelActif.getCode()) != null) {
            System.out.println("Erreur : Un actif avec le code " + nouvelActif.getCode() + " existe déjà.");
            return;
        }
        assets.add(nouvelActif);

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
    // achat aaset
    public void achatAsset(Trader t,Asset a,int  qte){
        double total= a.getPrixUnitaire()* qte;

        if (t.getSolde() <total){
            System.out.println("Solde insuffisant !");
            return;
        }
        t.setSolde(t.getSolde()-total);
        t.getPortfolio().ajouterQuantite(a,qte);


        Transaction t1 = new Transaction("ACHAT", qte, a.getPrixUnitaire(), new Date(),a,t);
        t.ajouterTransatction(t1);
        System.out.println("Achat effectuée avec succès !");

    }
    //vender asset
    public void venderAsset(Trader t,Asset a,int  qte){
        double total= a.getPrixUnitaire()* qte;
//
//        if (t.getSolde() < total){
//            System.out.println("Solde insuffisant !");
//            return;
//        }
        t.setSolde(t.getSolde()+total);
        t.getPortfolio().retirerQuantite(a,qte);


        Transaction t1 = new Transaction("Vendre", qte, a.getPrixUnitaire(), new Date(),a,t);
        t.ajouterTransatction(t1);
        System.out.println("Vente effectuée avec succès !");

    }
    //afficherToutesTransactions
    public void afficherToutesTransactions() {
        traders.stream()
                .flatMap(t -> t.getTransactions().stream())
                .forEach(Transaction::afficherDiscription);
    }


}
