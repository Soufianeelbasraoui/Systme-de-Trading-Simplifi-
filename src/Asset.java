public abstract class Asset {

    protected String code;
    protected String nom;
    protected double prixUnitaire;
    protected String type;
    protected int quantite;
    private Transaction transaction;
    private Portfolio portfolio;
    public Asset(String code, String nom, double prixUnitaire, String type,int quantite) {
        this.code = code;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.type = type;
        this.quantite=quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
//afficherdescrption
    public abstract String  afficherDescription();



}
