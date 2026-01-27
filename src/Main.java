import java.util.Scanner;

public class Main {
public static void main(String[] args){
    Scanner s=new Scanner(System.in);

    while (true){
        System.out.println("--- Système de Trading Simplifié ---");
        System.out.println("1.Ajouter un actifs: ");
        System.out.println("2.Ajouter un trader: ");
        System.out.println("3.Afficher les actifs disponibles: ");
        System.out.println("4.Créer un portefeuille: ");
        System.out.println("5.Consulter le portefeuille: ");
        System.out.println("6.Acheter un actif: ");
        System.out.println("7.Vendre un actif:  ");
        System.out.println("8.Historique des transactions: ");
        System.out.println("Enter un choix: ");

        int choix=s.nextInt();
        if (choix ==0){
            System.out.println("Au revoir !");
            break;
        }
    }
}
}
