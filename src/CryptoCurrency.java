public class CryptoCurrency extends Asset {
    private String algorithme;

    public CryptoCurrency(String code, String nom, double prixUnitaire, String type, String algorithme) {
        super(code, nom, prixUnitaire, type);
        this.algorithme = algorithme;
    }

    @Override
    public String AfficherDescription() {
        return String.format("[CRYPTO] Code: %s | Nom: %s | Algo: %s | Prix: %.2f€",
                code, nom, algorithme, prixUnitaire);
    }

    public String getAlgorithme() {
        return algorithme;
    }

    public void setAlgorithme(String algorithme) {
        this.algorithme = algorithme;
    }
}