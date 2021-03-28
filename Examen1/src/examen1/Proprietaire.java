package examen1;

public class Proprietaire {
	private String Nom;
	private String Prenom;
	private String Addresse;
	static final int LIMITE = 50;
	private Propriete[] listeP;
	private int nb;

	Proprietaire(String n, String p, String a) {
		this.Nom = n;
		this.Prenom = p;
		this.Addresse = a;
		listeP = new Propriete[LIMITE];
		this.nb = 0;
	}
	
	public String getNomComplet() {
		return Nom + " " + Prenom;
	}
	
	public Propriete [] getPropriete() {
		return listeP;
	}
	
	public int getTailleEffective() {
		return nb;
	}

	public boolean acquerir(Propriete p) {

		if (nb < LIMITE) {
			listeP[nb] = p;
			nb = nb + 1;
			return true;
		} else
			return false;
	}

	public void vendre(String c, Proprietaire proprio) {
		
		Propriete P = null;
		int indexPropriete =-1;
		
		for (int i = 0; i < nb; i++)
			if (listeP[i].getCode() == c) {
				P = listeP[i];
				indexPropriete = i;
				break;
			}

		if (P != null) {
			if (proprio.acquerir(P)) {
				listeP[indexPropriete]=null;
				
				var nouvelleListP = new Propriete[LIMITE];  // Creer une nouvelle liste temporaire
															// pour s'assurer qu'il n'y a pas de trous (null entre deux non-null) dans la liste
				var indexTemp=0; // Index temporaire
				
				for (int i=0;i<nb ;i++) {
					if(listeP[i]!=null) {
						nouvelleListP[indexTemp] = listeP[i];
						indexTemp = indexTemp + 1;
					}
				}
				
				listeP = nouvelleListP; // Reassigne la liste temporaire non troue a la liste potentiellement troue
				nb = nb - 1;
			}
			else
				System.out.println("Cette propriété n'est pas dans le registre.");
		}
	}

	public Propriete rechercher(String c) {
		Propriete P1 = null;

		for (int i = 0; i < nb; i++)
			if (listeP[i].getCode() == c)
				P1 = listeP[i];

		return P1;
	}

	public void Afficher() {
		System.out.println(String.format("------------------------------------\nNom: %s \nPrenom: %s \nAddresse: %s\n", Nom, Prenom, Addresse));

		for (int i = 0; i < nb; i++)
			System.out.println(listeP[i].toString());
	}
}
