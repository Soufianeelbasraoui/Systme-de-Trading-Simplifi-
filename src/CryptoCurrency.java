public class CryptoCurrency extends Asset {

    public CryptoCurrency(String code, String nom, double prixUnitaire, String type) {
        super(code, nom, prixUnitaire, type);

    }

    @Override
    public String AfficherDescription() {
        return String.format("[CRYPTO]: Code: %s | Nom: %s | Prix: %.2f€",
                code, nom, prixUnitaire);
    }



}