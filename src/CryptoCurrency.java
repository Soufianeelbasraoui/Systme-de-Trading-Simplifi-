public class CryptoCurrency extends Asset {
    private int CurrencyId;
    private String CurrencyName;

    public CryptoCurrency(int code, String nom, double prixUnitar, String type, int currencyId, String currencyName) {
        super(code, nom, prixUnitar, type);
        CurrencyId = currencyId;
        CurrencyName = currencyName;
    }

    @Override
    public String AfficherDescription() {
        return "";
    }

    public int getCurrencyId() {
        return CurrencyId;
    }

    public void setCurrencyId(int currencyId) {
        CurrencyId = currencyId;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }
}
