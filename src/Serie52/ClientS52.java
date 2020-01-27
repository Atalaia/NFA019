package Serie52;

import IPane.*;
import MesExceptions.*;

public class ClientS52 {
	
	
	public static void main(String[] s) throws Abandon
	{
		TableDesArticles52 tabArt;
		GestionTableDesArticles52 gta= new GestionTableDesArticles52("ARTICLES2.DAT");

		tabArt = gta.recupererTab();
		
		TableDesCommandes tabCde;		
		GestionDesCommandes52 gtc = new GestionDesCommandes52("COMMANDES2.DAT");
		
		tabCde = gtc.recupererTab();
		
		//ajout TableDesFactures
		TableDesFactures tabFac;		
		GestionDesFactures gdf = new GestionDesFactures("FACTURES.DAT");
		
		tabFac = gdf.recupererTab();
		
		int choix;
				
	do{
		try {
			choix= menuChoixGeneral();
			switch (choix)
			{
			case 1: gta.menuGeneral(tabArt, tabCde); break;
			case 2: gtc.menuGeneral(tabCde, tabArt); break;
			//ajout du case 3
			case 3: gdf.menuGeneral(tabFac,tabCde, tabArt);break;
			case 0: ES.affiche(" SAUVEGARDE DU CATALOGUE, LA TABLE DES COMMANDES ET LES FACTURES **\n");
			gta.sauvegarder(tabArt); gtc.sauvegarder(tabCde); gdf.sauvegarder(tabFac);
				break;
			}
		}catch (Abandon ab){choix = 0;}
	} while(choix !=0);	
	
	ES.affiche("\n ** AU REVOIR A BIENTOT SUR SUPERETTE ** \n");		
	}	
	
	//ajouter un 3ème choix Gestion des factures
	public static int menuChoixGeneral() throws Abandon 
	{
		String mes= "\n ***** BIENVENUE A LA SUPERETTE **\n"+
					"\n____________________________________\n"+
					"\n GESTION DES ARTICLES---------------1\n"+
					"\n GESTION DES COMMANDES -------------2\n"+
					"\n GESTION DES FACTURES  -------------3\n"+
					"\n FIN--------------------------------0\n"+
					"\n VOTRE CHOIX..............";
		
		return ES.saisie(mes, 0, 3);
	}
}