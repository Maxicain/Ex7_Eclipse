package examen1;

public class Main {

	public static void main(String[] args) {
		
		Proprietaire P1 = new Proprietaire("Dupuis", "Marc", "123 Avenue de l'ile");
		Proprietaire P2 = new Proprietaire("Lalonde", "Jean", "647 Blvd Seigneur");
		
		Propriete Pr1 = new Propriete("P004", "Maison", 8500F, 500D, "475 Blvd Tashero.");
		

		
		P2.acquerir(new Propriete("P001", "Duplex", 15000F, 300000D, "123 Blvd Principal"));
		P2.acquerir(new Propriete("P002", "Condo", 400F, 250000D, "500 Rue Proulx"));
		P2.acquerir(new Propriete("P005", "Bloc Appartement", 25000F, 350000D, "4500 3e Avenue"));

		
		P1.acquerir(new Propriete("P040", "Duplex", 15000F, 300000D, "123 Blvd Principal"));
		P1.acquerir(new Propriete("P025", "Bungalo", 10000F, 500000D, "457 Rue Leclerc"));
		P1.acquerir(new Propriete("P003", "Semi-Detache", 7500F, 275000D, "784 Rue Tranquille"));
		
		P2.vendre("P005", P1);
		
		if (P1.rechercher("P003")!=null)
			P1.vendre("P003", P2);
		
		if (P1.rechercher("P006")!=null)
			P1.vendre("P006", P2);
		
		P2.vendre("P001", P1);	
		
		P1.Afficher();
		P2.Afficher();
		
		System.out.print("\n----------------------------\n");
		System.out.print("\nLe propriétaire avec le le plus grand total des prix: ");
		if (Propriete.prixTotal(P1.getPropriete(), P1.getTailleEffective()) > Propriete.prixTotal(P2.getPropriete(), P2.getTailleEffective())) {
			System.out.print(P1.getNomComplet());
		}
		else {
			System.out.print(P2.getNomComplet());
		}
	}

}
