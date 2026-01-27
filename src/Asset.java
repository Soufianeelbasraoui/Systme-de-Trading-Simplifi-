public abstract class Asset {
    private  int code ;
    private  String nom;
    private double prixUnitar;
    private  String type;

    public Asset(int code, String nom, double prixUnitar, String type) {
        this.code = code;
        this.nom = nom;
        this.prixUnitar = prixUnitar;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitar() {
        return prixUnitar;
    }

    public void setPrixUnitar(double prixUnitaire) {
        if (prixUnitaire <= 0) {
            throw new IllegalArgumentException("Le prix doit être positif.");
        }
        this.prixUnitar = prixUnitaire;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    // methode abstract AfficherDescription
    public abstract String AfficherDescription();

}
