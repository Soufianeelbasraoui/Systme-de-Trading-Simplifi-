import java.util.Scanner;

public class Main {
public static void main(String[] args){
    Scanner s=new Scanner(System.in);
    TradingPlatform  maPlatform=new TradingPlatform();

    while (true) {

        System.out.println("-------------------------------------------");
        System.out.println("          XTRADE : SIMULATEUR PRO          ");
        System.out.println("-------------------------------------------");
        System.out.println(" [1] ESPACE ADMINISTRATEUR (Marché/Actifs) ");
        System.out.println(" [2] ESPACE TRADER (Investissements)       ");
        System.out.println(" [0] QUITTER LE SYSTÈME                    ");
        System.out.println("-------------------------------------------");
        System.out.print("Saisie : ");

        int profil = s.nextInt();

        if (profil == 0) break;

        if (profil == 1) {
           while (true) {
               // --- MENU ADMIN ---
               System.out.println("\n----------- Menu Administrateur ----------");
               System.out.println("1. Ajouter un actif (Action/Crypto)");
               System.out.println("2. Afficher tous les actifs du marché");
               System.out.println("0. Retour");
               System.out.println("--------------------------------------------");
               System.out.print("Saisie : ");


               int choixAdmin = s.nextInt();
               if (choixAdmin ==0) break;
               switch (choixAdmin) {
                   case 1:
                       System.out.println("Type d'actif : 1. Action | 2. Crypto");
                       int type = s.nextInt();
                       s.nextLine();

                       System.out.print("Code (ex: BTC) : ");
                       String code = s.nextLine();
                       System.out.print("Nom : ");
                       String n = s.nextLine();
                       System.out.print("Prix unitaire : ");
                       double prix = s.nextDouble();
                       s.nextLine();

                       if (type == 1) {

                           maPlatform.ajouterActif(new Stock(code, n, prix, "Action", 101));
                       } else {

                           maPlatform.ajouterActif(new CryptoCurrency(code, n, prix, "Crypto"));
                       }
                       break;

                   case 2:
                       maPlatform.afficherActifsDisponibles();
                       break;


               }
           }
        } else if (profil == 2) {
            while (true) {
                System.out.println("\n----------- MENU TRADER -----------");
                System.out.println("1. Ajouter un nouveau trader");
                System.out.println("2. Créer un portefeuille :");
                System.out.println("3. Consulter mon portefeuille");
                System.out.println("4. Acheter un actif");
                System.out.println("5. Vendre un actif");
                System.out.println("6. Voir mon historique de transactions");
                System.out.println("0. Retour");
                System.out.print("Saisie : ");

                int choixUser = s.nextInt();
                s.nextLine(); // Nettoyage buffer

                if (choixUser == 0) break;

                switch (choixUser) {
                    case 1:
                        System.out.println("--------- Ajouter un trader ---------");
                        System.out.print("ID : ");
                        int idNouveau = s.nextInt();
                        s.nextLine();
                        System.out.print("Nom : ");
                        String nomNouveau = s.nextLine();
                        System.out.print("Solde initial : ");
                        double soldeNouveau = s.nextDouble();

                        maPlatform.ajouterTrader(new Trader(idNouveau, nomNouveau, soldeNouveau));
                        break;
                    case 2:
                        System.out.print("Entrez votre ID Trader : ");
                        int idC = s.nextInt();
                        s.nextLine();
                        Trader traderC = maPlatform.chercherTrader(idC);

                        if (traderC != null) {
                            System.out.print("Donnez un nom à votre nouveau portefeuille : ");
                            String nomPorte = s.nextLine();

                            maPlatform.creerPortefeuille(traderC, nomPorte);
                        } else {
                            System.out.println(" Trader introuvable.");
                        }
                        break;

                    case 3:
                        System.out.print("Entrez votre ID pour consulter : ");
                        int idConsult = s.nextInt();
                        Trader t2 = maPlatform.chercherTrader(idConsult);

                        if (t2 != null) {
                            System.out.println("\n--- BIENVENUE " + t2.getNom().toUpperCase() + " ---");
                            System.out.println("Solde actuel : " + t2.getSolde() + " €");

                            if (t2.getPortfolio() != null) {
                                t2.getPortfolio().afficherPortfolio();
                            } else {
                                System.out.println(" Vous n'avez pas encore de portefeuille. Créez-en un (Option 2).");
                            }
                        } else {
                            System.out.println(" ID introuvable.");
                        }
                        break;

                    case 4:

                        System.out.print("Entrez votre ID Trader : ");
                        int idA = s.nextInt();
                        Trader buycod = maPlatform.chercherTrader(idA);

                        if (buycod != null) {
                            // Afficher les actifs pour que l'utilisateur choisisse
                            maPlatform.afficherActifsDisponibles();

                            System.out.print("Entrez le CODE de l'actif (ex: BTC) : ");
                            s.nextLine(); // Nettoyage
                            String codeActif = s.nextLine();

                            // Trouver l'actif dans la plateforme
                            Asset a = maPlatform.chercherActif(codeActif);

                            if (a != null) {
                                System.out.print("Quantité à acheter : ");
                                double qte = s.nextDouble();

                                // Appeler la méthode de la plateforme
                                maPlatform.acheterActif(buycod, a, qte);
                            } else {
                                System.out.println(" Actif introuvable sur le marché.");
                            }
                        } else {
                            System.out.println(" Trader introuvable.");
                        }
                        break;

                    case 5:

                        System.out.print("Entrez votre ID Trader : ");
                        int id = s.nextInt();
                        Trader td = maPlatform.chercherTrader(id);

                        if (td != null) {
                            // Afficher les actifs pour que l'utilisateur choisisse
                            maPlatform.afficherActifsDisponibles();

                            System.out.print("Entrez le CODE de l'actif (ex: BTC) : ");
                            s.nextLine(); // Nettoyage
                            String codeActif = s.nextLine();

                            // Trouver l'actif dans la plateforme
                            Asset a = maPlatform.chercherActif(codeActif);

                            if (a != null) {
                                System.out.print("Quantité à vent : ");
                                double qte = s.nextDouble();

                                // Appeler la méthode de la plateforme
                                maPlatform.acheterActif(td, a, qte);
                            } else {
                                System.out.println(" Actif introuvable sur le marché.");
                            }
                        } else {
                            System.out.println(" Trader introuvable.");
                        }
                        System.out.println("Fonctionnalité de vente en cours de développement...");
                        break;

                    case 6:
                        System.out.print("Entrez votre ID pour l'historique : ");
                        int idHist = s.nextInt();
                        Trader t5 = maPlatform.chercherTrader(idHist);

                        if (t5 != null) {
                            System.out.println("\n--- HISTORIQUE DE " + t5.getNom().toUpperCase() + " ---");
                            // Respect de la relation Trader 1 -> 0..* Transaction
                            if (t5.getHistorique().isEmpty()) {
                                System.out.println("Aucune transaction effectuée.");
                            } else {
                                for (Transaction trans : t5.getHistorique()) {
                                    trans.afficherTransaction();
                                }
                            }
                        } else {
                            System.out.println(" ID introuvable.");
                        }
                        break;

                    default:
                        System.out.println("Option invalide.");
                }
            }
        }
    }
}
}
