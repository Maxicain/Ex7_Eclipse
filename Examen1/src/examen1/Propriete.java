package examen1;

public class Propriete {
	private String code;
	private String type;
	private float superficie;
	private double prixEva; //Prix d'évalutation
	private String addresse;
	
	Propriete(String c, String t, float s, double p, String a){
		this.code = c;
		this.type = t;
		this.superficie = s;
		this.prixEva = p;
		this.addresse = a;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public double getPrixEva() {
		return this.prixEva;
	}
	
	public void augmenter(double taux) {
		this.prixEva = this.prixEva * (taux + 1);
	}
	
	static public double prixTotal(Propriete[] tab, int t) {
		double somme = 0;
		
		for (int i = 0; i < t; i++) {
			somme = somme + tab[i].prixEva;
		}
		
		return somme;
	}
	
	public String toString() {
		return " Code: " + code + 
				"\n Type: " + type + 
				"\n Superficie: " + superficie + 
				"\n Prix d'évaluation: " + prixEva + 
				"\n Addresse: " + addresse+"\n";
	}
}
