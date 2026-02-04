import java.util.Date;
import  java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        TradingPlatform maPlatfrom=new TradingPlatform();
         maPlatfrom.initialiserMarche();


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
            System.out.println("8. Analyse des transactions : ");
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
                        maPlatfrom.ajouterActif(new Stock(code,nom,prix,"Stock",101,0));
                    }
                    else {
                        maPlatfrom.ajouterActif(new CryptoCurrency(code, nom, prix, "Crypto",1,0));
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
                case 6:
                    System.out.println("");
                    System.out.print("Entrez votre ID: ");
                    int idt=s.nextInt();

                    Trader ach = maPlatfrom.chercherTrader(idt);
                    if (ach !=null){
                        maPlatfrom.controlePrix();
                        maPlatfrom.afficherAsset();
                        System.out.println("Entre votre code ex:(btc): ");
                        String codeAsset=s.next();
                        Asset assetAch=maPlatfrom.chercherAsset(codeAsset);
                        if (assetAch !=null){
                            System.out.println("Enter Qte: ");
                            int qte=s.nextInt();
                            maPlatfrom.achatAsset(ach,assetAch,qte);
                        }
                        else {
                            System.out.println("Accune Asset !");
                        }
                    }
                    else {
                        System.out.println("Trader n'est pas existe !");
                    }
                    break;
                case 7:
                    System.out.println("");
                    System.out.print("Entrez votre ID: ");
                    int idt1=s.nextInt();

                    Trader vend = maPlatfrom.chercherTrader(idt1);
                    if (vend !=null){
                        maPlatfrom.controlePrix();
                        maPlatfrom.afficherAsset();
                        System.out.println("Entre votre code ex:(btc): ");
                        String codeAsset=s.next();
                        Asset assetAch=maPlatfrom.chercherAsset(codeAsset);
                        if (assetAch !=null){
                            System.out.println("Enter Qte: ");
                            int qte=s.nextInt();
                            maPlatfrom.venderAsset(vend,assetAch,qte);
                        }
                        else {
                            System.out.println("Accune Asset !");
                        }
                    }
                    else {
                        System.out.println("Trader n'est pas existe !");
                    }
                    break;

              case 8:
                 while (true){
                     System.out.println("1- Voir historique de transactions: (general | Trader) ");
                     System.out.println("2- Filtrer les transactions par: Type | actif | dates ");
                     System.out.println("3- Trier les transactions par (date |montant):");
                     System.out.println("4- Calculer de volume total: ");
                     System.out.println("0- Quitter Historique: ");
                     System.out.print("Saisie : ");
                     int choixHis=s.nextInt();
                     if (choixHis ==0) break;
                     switch (choixHis){
                         //Voir historique de transactions
                         case 1:
                             System.out.println("1- Voir historique de : 1. general | 2. Trader");
                             int historique=s.nextInt();
                             if (historique == 1){
                                    maPlatfrom.afficherToutesTransactions();

                             } else {
                                 System.out.println("Enter votre id pour consulter le historique: ");
                                 int idChercher=s.nextInt();
                                 maPlatfrom.afficherTrader(idChercher);
                             }
                             break;
                      //Filtrer les transactions par Type
                         case 2:
                             System.out.println("Filtrer les transactions par: 1. type | 2. actif | 3. dates");
                             int typ = s.nextInt();

                             if (typ == 1) {
                                 System.out.println("Choisir le type: 1- BUY | 2- SELL");
                                 int bs = s.nextInt();

                                 if (bs == 1) {
                                     System.out.println("----------  BUY ------------");
                                     maPlatfrom.filtrerTrnasactionType("ACHAT");
                                     System.out.println("----------------------------");
                                 } else if (bs == 2) {
                                     System.out.println("----------  SELL ------------");
                                     maPlatfrom.filtrerTrnasactionType("Vendre");
                                     System.out.println("-----------------------------");
                                 } else {
                                     System.out.println("Choix invalide.");
                                 }
                             }
                             else if (typ==2){
                                 System.out.println("Enter votre code : ");
                                 String codeActif=s.next();
                                 maPlatfrom.filtrerTransactionsParActif(codeActif);

                             }
                             else {

                             }
                             break;
                       // Trier les transactions par 1 date | 2 montant
                         case 3:
                             System.out.println("Trier par : 1 date | 2 montant");
                             int typedm=s.nextInt();
                             if (typedm==1){
                              maPlatfrom.TrierTransactionsDate();
                             }
                             else if (typedm==2){
                               maPlatfrom.TrierTransactionsMontant();
                             }
                             break;
                         case 4:
                             System.out.println("Calculer: 1. volume total actif| 2. le montant total : achats | ventes");
                             int choixv=s.nextInt();
                             if (choixv == 1){
                                 System.out.println("--------- volume total actif ------------");
                                 System.out.println("Entrez le code de l'actif (ex: BTC):  :");
                                 String codev =s.next();
                                 maPlatfrom.calculerMontantParActif(codev);
                                 System.out.println("------------------------------------------");
                             } else if (choixv==2) {
                                 System.out.println("1. achats | 2.ventes : ");
                                 int choit=s.nextInt();
                                 if (choit==1){
                                     System.out.println("------------- achats ------------------");
                                     maPlatfrom.totalachats("ACHAT");
                                     System.out.println("---------------------------------------");
                                 }
                                 else if (choixv==2){
                                     System.out.println("--------------vents --------------------");
                                     maPlatfrom.totalVende("Vendre");
                                     System.out.println("-----------------------------------------");
                                 }

                             }
                     }
                 }
            }
        }
    }
}

