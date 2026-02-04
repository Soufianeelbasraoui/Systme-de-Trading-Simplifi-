import java.util.*;

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
//        traders.stream()
//                .flatMap(t -> t.getTransactions().stream())
//                .forEach(Transaction::afficherDiscription);
        for (Trader t : traders) {
            for (Transaction tr : t.getTransactions()) {
                tr.afficherDiscription();
            }
        }


    }

//Afficher toutes les transactions d’un trader donné
    public void afficherTrader(int idChercher){
        traders.stream().filter(t->t.getId() == idChercher)
                .flatMap(t1 ->t1.getTransactions().stream())
                .forEach(Transaction::afficherDiscription);

    }
    public void filtrerTransactionsParActif(String codeActif) {
        traders.stream()
                .flatMap(t -> t.getTransactions().stream())
                .filter(tr -> tr.getAsset().getCode().equalsIgnoreCase(codeActif))
                .forEach(Transaction::afficherDiscription);
    }
    //Filtrer les transactions par : type (BUY / SELL), actif financier (ex : AAPL, BTC, EUR/USD),
    public void filtrerTrnasactionType(String type){
        traders.stream()
                .flatMap(t->t.getTransactions().stream())
                .filter(tr->tr.getTypeDoperation().equalsIgnoreCase(type))
                .forEach(Transaction::afficherDiscription);
    }


    public void TrierTransactionsDate(){
        traders.stream()
                .flatMap(t->t.getTransactions().stream())
                .sorted(Comparator.comparing(Transaction::getDate))
                .forEach(Transaction::afficherDiscription);
    }

    public void TrierTransactionsMontant(){
        traders.stream().flatMap(t->t.getTransactions().stream())
                .sorted(Comparator.comparing(Transaction::getPrix))
                .forEach(Transaction::afficherDiscription);
    }
    public void calculerMontantParActif(String code) {
      double totalValue= traders.stream()
                .flatMap(t -> t.getTransactions().stream())
                .filter(tr -> tr.getAsset().getCode().equalsIgnoreCase(code))
                .mapToDouble(tr -> tr.getQuantite() * tr.getPrix())
                .sum();
        System.out.println("montant total : "+totalValue);

        long totalQte=traders.stream()
                .flatMap(t->t.getTransactions().stream())
                .filter(tr -> tr.getAsset().getCode().equalsIgnoreCase(code))
                .mapToLong(tq->tq.getQuantite())
                .sum();
        System.out.println("Total Qtn: "+ totalQte);
    }
public  void totalachats(String type){
        double totatalAchat=traders.stream()
                .flatMap(t->t.getTransactions().stream())
                .filter(ta->ta.getTypeDoperation().equalsIgnoreCase(type))
                .mapToDouble(taq->taq.getPrix() * taq.getQuantite())
                .sum();
    System.out.println("number Totale de achate: "+ totatalAchat);
}

public void totalVende(String type){
        double totalVende=traders.stream()
                .flatMap(t->t.getTransactions().stream())
                .filter(tv->tv.getTypeDoperation().equalsIgnoreCase(type))
                .mapToDouble(tav->tav.getPrix() * tav.getQuantite())
                .sum();
    System.out.println("number Total de vents: "+totalVende);
}
}
