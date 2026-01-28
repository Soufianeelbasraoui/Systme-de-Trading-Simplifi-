public abstract class Asset {
    protected String code;
    protected String nom;
    protected double prixUnitaire;
    protected String type;

    public Asset(String code, String nom, double prixUnitaire, String type) {
        if (prixUnitaire <= 0) {
            throw new IllegalArgumentException("Le prix doit être strictement positif.");
        }
        this.code = code;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.type = type;
    }

    // Getters et Setters
    public String getCode() {
        return code;
    }
    public String getNom() {
        return nom;
    }
    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        if (prixUnitaire <= 0) {
            throw new IllegalArgumentException("Le prix doit être positif.");
        }
        this.prixUnitaire = prixUnitaire;
    }

    public abstract String AfficherDescription();
}