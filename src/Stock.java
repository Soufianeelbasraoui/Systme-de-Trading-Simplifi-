public class Stock extends Asset{
    private int idStok;

    public Stock(String code, String nom, double prixUnitaire, String type,int quantite, int idStok) {
        super(code, nom, prixUnitaire, type,quantite);
        this.idStok = idStok;
    }

    @Override
    public String afficherDescription() {
        return String.format("[CRYPTO]: Code: "+code+ "| Nom:" +nom +"| Prix: "+prixUnitaire + " | type: " +type) ;
    }
}
