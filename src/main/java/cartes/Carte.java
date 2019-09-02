package cartes;

public class Carte {
	private Valeur valeur;
	private Signe signe;
	private Couleur couleur;
	
	public Carte(Valeur valeur, Signe signe) {
		super();
		this.valeur = valeur;
		this.signe = signe;
	}
	
	public Valeur getValeur() {
		return valeur;
	}
	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}
	public Signe getSigne() {
		return signe;
	}
	public void setSigne(Signe signe) {
		this.signe = signe;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return valeur + " " + signe;
	}

	
}
