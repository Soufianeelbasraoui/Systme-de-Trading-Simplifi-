import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
    private String typeDoperation;
    private int quantite;
    private double prix;
    private Date date;
    private Asset asset;
    private Trader trader;

    public Transaction(String typeDoperation, int quantite, double prix, Date date, Asset asset,Trader trader) {
        this.typeDoperation = typeDoperation;
        this.quantite = quantite;
        this.prix = prix;
        this.date = date;
        this.asset = asset;
        this.trader=trader;

    }



    public String getTypeDoperation() {
        return typeDoperation;
    }

    public void setTypeDoperation(String typeDoperation) {
        this.typeDoperation = typeDoperation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }
    // afiicher  transaction
    public void  afficherDiscription(){
        System.out.printf("date: " +date.toString()+" | "+ typeDoperation+ "|"+ asset.getNom() +" | Qte: "+ quantite +" | " +"Prix Unit: "+prix +" | Totale:  " +(quantite * prix) +"\n");
    }

}
