import java.util.Scanner;

public class Main {
public static void main(String[] args){
    Scanner s=new Scanner(System.in);

    while (true) {
        // Exemple de style pour le menu principal
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
            System.out.println("\n----- Menu Administrateur -----");
            System.out.println("1. Ajouter un actif (Action/Crypto)");
            System.out.println("2. Ajouter un nouveau trader");
            System.out.println("3. Afficher tous les actifs du marché");
            System.out.println("0. Retour");

            int choixAdmin = s.nextInt();
            switch (choixAdmin) {

            }

        } else if (profil == 2) {
            // --- MENU UTILISATEUR ---
            System.out.println("\n----- Menu Trader -----");
            System.out.println("1. Créer/Associer un portefeuille");
            System.out.println("2. Consulter mon portefeuille (Valeur totale)");
            System.out.println("3. Acheter un actif");
            System.out.println("4. Vendre un actif");
            System.out.println("5. Voir mon historique de transactions");
            System.out.println("0. Retour");

            int choixUser = s.nextInt();


        }
    }
}
}
