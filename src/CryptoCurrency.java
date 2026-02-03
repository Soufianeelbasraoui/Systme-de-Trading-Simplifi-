public class CryptoCurrency extends Asset{
    private int idcurrence;


    public CryptoCurrency(String code, String nom, double prixUnitaire, String type, int quantite, int idcurrence) {
        super(code, nom, prixUnitaire, type, quantite);
        this.idcurrence = idcurrence;
    }

    public int getIdcurrence() {
        return idcurrence;
    }

    @Override
    public String afficherDescription() {
        return String.format("[CRYPTO]: Code: "+code+ " | Nom:" +nom +"| Prix: "+prixUnitaire + " | type: " +type) ;
    }

    public void setIdcurrence(int idcurrence) {
        this.idcurrence = idcurrence;
    }

}
