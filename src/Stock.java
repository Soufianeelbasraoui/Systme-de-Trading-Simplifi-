public class Stock extends Asset {
    private int stockId;


    public Stock(String code, String nom, double prixUnitaire, String type, int stockId) {
        super(code, nom, prixUnitaire, type);
        this.stockId = stockId;

    }

    @Override
    public String AfficherDescription() {

        return String.format("[ACTION]: Code: %s | Nom: %s | Prix: %.2f€",
                code, nom, prixUnitaire);
    }


    // Getters et Setters
    public int getStockId() {
        return stockId;
    }
    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

}