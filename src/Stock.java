public class Stock extends Asset {
    private int stockId;
    private String company;

    public Stock(String code, String nom, double prixUnitaire, String type, int stockId, String company) {
        super(code, nom, prixUnitaire, type);
        this.stockId = stockId;
        this.company = company;
    }

    @Override
    public String AfficherDescription() {

        return String.format("[ACTION] Code: %s | Nom: %s | Entreprise: %s | Prix: %.2f€",
                code, nom, company, prixUnitaire);
    }

    // Getters et Setters
    public int getStockId() {
        return stockId;
    }
    public void setStockId(int stockId) {
        this.stockId = stockId;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
}