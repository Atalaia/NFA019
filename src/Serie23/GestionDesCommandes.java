package Serie23;

import Utils.ClientUtils;
import Serie22.*;

public class GestionDesCommandes {
	
	public void menuGeneral(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		int choix;
		
		do
		{
			choix = menuChoix();
			switch(choix)
			{
			case 1: ajouter(tabCde,tabArt); break;
			case 2: supprimer(tabCde); break;
			case 3: afficherUneCommande(tabCde); break;
			case 4: afficherToutesLesCommandes(tabCde); break;
			case 5: facturer1Commande(tabArt,tabCde); break;
			case 0: break;
			}
		} while (choix != 0);
	}
	
	public void ajouter(TableDesCommandes tabCde, TableDesArticles tabArt)
	{
		TableDesLignesDeCommande cde = new TableDesLignesDeCommande();
		GestionUneCommande guc= new GestionUneCommande();
		guc.menuGeneral(tabArt,cde); 
		if(cde.taille() != 0) 
			{ int numero = premierNumeroDispo(tabCde);
			cde.setDateCommande(new Utils.DateUser());
			cde.setNumCde(numero);
		
			tabCde.ajouter(cde);
		}
	}
	
	public void supprimer(TableDesCommandes tabCde)
	{
		if(tabCde.taille() !=0) {			
			System.out.print(tabCde.cle());
			int numCde = Utils.ClientUtils.lireEnt("Quelle commande voulez-vous supprimer ?", 1, 999);
			if(tabCde.retourner(numCde) != null)
				tabCde.supprimer(numCde);
			else {
				System.out.print("La commande n'existe pas.");
			}
		}else
			System.out.println("\n**** La table des commandes est vide. ****\n");	
	}
	 
	public void afficherUneCommande(TableDesCommandes tabCde)
	{
		if (tabCde.taille() != 0){
			System.out.print(tabCde.cle());
			int numCde = Utils.ClientUtils.lireEnt("Quelle commande voulez-vous afficher ?", 1, 999);
			if(tabCde.retourner(numCde) != null){
				System.out.print(tabCde.retourner(numCde).toString());
			}else{
				System.out.print("La commande n'existe pas.");
			}
		}else{
			System.out.println("\n**** Commande vide. ****\n");	
		}
	}
	
	public void afficherToutesLesCommandes(TableDesCommandes tabCde){
		if (tabCde.taille() != 0)
			System.out.print(tabCde.toString());
	}
	
	public void facturer1Commande(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		System.out.print(" \n** LISTE DES NUMEROS DE COMMANDES : \n" + tabCde.toString());
		int numero= Utils.ClientUtils.lireEnt("", 0, 999);
		
		if(tabCde.retourner(numero) != null) 
			System.out.print(" \n " + tabCde.retourner(numero).facturer(tabArt));
	}
	
	public int premierNumeroDispo(TableDesCommandes tabCde)
	{
	 int numero=1;
	 while(tabCde.retourner(numero) != null) numero++;
	 return numero;
	}
	
	public int menuChoix()
	{
		String mes= "\n *** MENU GESTION DES COMMANDES ***\n" +
				" CREER UNE COMMANDE________________1\n" +
				" SUPPRIMER UNE COMMANDE____________2\n" +
				" AFFICHER UNE COMMANDE_____________3\n" +
				" AFFICHER TOUTES LES COMMANDES_____4\n" +
				" FACTURER UNE COMMANDE_____________5\n" +
				" FIN_______________________________0\n" +
				"VOTRE CHOIX_________________________";
		
		return ClientUtils.lireEnt(mes, 0, 5);
	}
	
}
