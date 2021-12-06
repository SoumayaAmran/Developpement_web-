package Model;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

public class Produit {
	private String nom;
	private String prix;
	private String fournisseur;
	
	public Produit(String nom, String prix, String fournisseur) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public static Connection getStoredConnection(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
