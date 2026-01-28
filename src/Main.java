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
            // --- MENU ADMIN ---
            System.out.println("\n----------- Menu Administrateur ----------");
            System.out.println("1. Ajouter un actif (Action/Crypto)");
            System.out.println("2. Ajouter un nouveau trader");
            System.out.println("3. Afficher tous les actifs du marché");
            System.out.println("0. Retour");
            System.out.println("--------------------------------------------");
            System.out.print("Saisie : ");

            int choixAdmin = s.nextInt();
            switch (choixAdmin) {
                case 1:
                    System.out.println("Type d'actif : 1. Action | 2. Crypto");
                    int type = s.nextInt();
                    s.nextLine(); // Nettoyer le buffer

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
                    int id=s.nextInt();

                    System.out.println("Enter Le Nom: ");
                    String nom=s.next();

                    System.out.println("Enter le Solde initial: ");
                    double solde=s.nextDouble();
                     maPlatform.ajouterTrader(new Trader(id,nom,solde));
                    System.out.println("---------------------------------------");
                     break;


            }

        } else if (profil == 2) {
            // --- MENU UTILISATEUR ---
            System.out.println("\n-------------- Menu Trader ---------------");
            System.out.println("1. Créer un portefeuille : ");
            System.out.println("2. Consulter mon portefeuille: ");
            System.out.println("3. Acheter un actif: ");
            System.out.println("4. Vendre un actif: ");
            System.out.println("5. Voir mon historique de transactions: ");
            System.out.println("0. Retour");
            System.out.print("Saisie : ");

            int choixUser = s.nextInt();


        }
    }
}
}
