import  java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        TradingPlatform maPlatfrom=new TradingPlatform();


        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("          XTRADE : SIMULATEUR PRO          ");
            System.out.println("-------------------------------------------");
            System.out.println("1. Ajouter un actif (Action/Crypto): ");
            System.out.println("2. Ajouter un nouveau trader: ");
            System.out.println("3. Afficher tous les actifs du marché: ");
            System.out.println("4. Créer un portefeuille: ");
            System.out.println("5. Consulter mon portefeuille: ");
            System.out.println("6. Acheter un actif: ");
            System.out.println("7. Vendre un actif: ");
            System.out.println("8. Voir mon historique de transactions: ");
            System.out.println("0. QUITTER LE SYSTÈME ");
            System.out.print("Saisie : ");
            int choix = s.nextInt();

            if (choix == 0) break;
            switch (choix){
                case 1:
                    System.out.println("Type d'actif : 1. Action | 2. Crypto");
                    int type = s.nextInt();
                    s.nextLine();

                    System.out.print("Code : ");
                    String code = s.nextLine();

                    System.out.print("Nom : ");
                    String nom = s.nextLine();

                    System.out.print("Prix : ");
                    double prix = s.nextDouble();
                    s.nextLine();

                    if (type == 1){
                        maPlatfrom.ajouterActif(new Stock(code,nom,prix,"Stock",101));
                    }
                    else {
                        maPlatfrom.ajouterActif(new CryptoCurrency(code, nom, prix, "Crypto",1));
                    }
                    break;
                case 2:
                    System.out.println("--------- Ajouter un trader ---------");
                    System.out.print("ID : ");
                    int idNouveau = s.nextInt();
                    s.nextLine();
                    System.out.print("Nom : ");
                    String nomNouveau = s.nextLine();
                    System.out.print("Solde initial : ");
                    double soldeNouveau = s.nextDouble();
                    maPlatfrom.ajouterTrader(new Trader(idNouveau,nomNouveau,soldeNouveau));
                    break;
                case 3:
                    maPlatfrom.afficherAsset();
                    break;
                case 4:
                    System.out.print("Entrez votre ID Trader : ");
                    int idC = s.nextInt();
                    s.nextLine();
                    Trader traderC = maPlatfrom.chercherTrader(idC);

                    if (traderC != null) {
                        System.out.print("Donnez un nom à votre nouveau portefeuille : ");
                        String nomPorte = s.nextLine();

                        maPlatfrom.creerPortefeuille(traderC, nomPorte);
                    } else {
                        System.out.println(" Trader introuvable.");
                    }
                    break;

                case 5:
                    System.out.print("Entrez votre ID pour consulter : ");
                    int idConsult = s.nextInt();
                    Trader t=maPlatfrom.chercherTrader(idConsult);
                    if (t !=null){
                        System.out.println("\n--- BIENVENUE " + t.getNom().toUpperCase() + " ---");
                        System.out.println("Solde actuel : " + t.getSolde() + " €");
                        if (t.getPortfolio() !=null){
                            t.getPortfolio().afficherPortfio();
                        }
                        else {
                            System.out.println(" Vous n'avez pas encore de portefeuille. Créez-en un (Option 4).");
                        }

                    }else {
                        System.out.println(" ID introuvable.");
                    }
                    break;
                case 8:
                    System.out.print("Entrez votre ID pour l'historique : ");
                    int idHist = s.nextInt();
                    Trader t5 = maPlatfrom.chercherTrader(idHist);
                    if (t5 !=null){
                        System.out.println("\n--- HISTORIQUE DE " + t5.getNom().toUpperCase() + " ---");
                        if (t5.getTransactions().isEmpty()){
                            System.out.println("Aucune transaction effectuée.");
                        }
                        else {
                            for (Transaction tran: t5.getTransactions()){
                                tran.afficherTransaction();

                            }
                        }
                    } else {
                        System.out.println(" ID introuvable.");
                    }
                    break;


            }
        }
    }
}
