public class Stock extends Asset{
    private int stockId;
    private String company;

    public Stock(int code, String nom, double prixUnitar, String type, int stockId, String company) {
        super(code, nom, prixUnitar, type);
        this.stockId = stockId;
        this.company = company;
    }

    @Override
    public String AfficherDescription() {
        return "";
    }

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
