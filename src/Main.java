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
               System.out.println("2. Ajouter un nouveau trader");
               System.out.println("3. Afficher tous les actifs du marché");
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
                           System.out.print("Entreprise : ");
                           String entreprise = s.nextLine();
                           maPlatform.ajouterActif(new Stock(code, n, prix, "Action", 101, entreprise));
                       } else {
                           System.out.print("Algorithme : ");
                           String algo = s.nextLine();
                           maPlatform.ajouterActif(new CryptoCurrency(code, n, prix, "Crypto", algo));
                       }
                       break;

                   case 2:
                       System.out.println("--------- Ajouter un trader ---------");
                       System.out.println("ID: ");
                       int id = s.nextInt();

                       System.out.println("Enter Le Nom: ");
                       String nom = s.next();

                       System.out.println("Enter le Solde initial: ");
                       double solde = s.nextDouble();
                       maPlatform.ajouterTrader(new Trader(id, nom, solde));
                       System.out.println("---------------------------------------");
                       break;
                   case 3:
                       maPlatform.afficherActifsDisponibles();
                       break;


               }
           }
        } else if (profil == 2) {
          while (true){

              System.out.println("Enter votre id pour connecter: ");
              int id= s.nextInt();
              Trader traderid=maPlatform.chercherTrader(id);
              if (traderid == null){
                  System.out.println("Sir tsajale: ");
                  break;
              }
              else {
                  // --- MENU UTILISATEUR ---
                  System.out.println("\n-------------- Menu Trader ---------------");
                  System.out.println("1. Consulter mon portefeuille: ");
                  System.out.println("2. Acheter un actif: ");
                  System.out.println("3. Vendre un actif: ");
                  System.out.println("4. Voir mon historique de transactions: ");
                  System.out.println("0. Retour");
                  System.out.print("Saisie : ");

                  int choixUser = s.nextInt();
                  if (choixUser == 0) break;
                  switch (choixUser){
                      case 1:
                        traderid.getPortfolio().consulterPortefeuille();
                        break;



                  }

              }


          }
        }
    }
}
}
