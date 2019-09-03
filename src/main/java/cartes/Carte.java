package cartes;

import java.util.Objects;

public class Carte {
	private Valeur valeur;
	private Signe signe;

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
		return signe.getCouleur();
	}

	@Override
	public String toString() {
		return valeur + " " + signe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(signe, valeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (this.signe != other.signe)
			return false;
		if (this.valeur != other.valeur)
			return false;
		return true;
	}

	
}
