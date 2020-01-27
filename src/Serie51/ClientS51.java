package Serie51;

import IPane.*;
import MesExceptions.*;

public class ClientS51 {
	
	
	public static void main(String[] s) throws Abandon
	{
		TableDesArticles51 tabArt;
		GestionTableDesArticles51 gta= new GestionTableDesArticles51("ARTICLES.DAT");

		tabArt = gta.recupererTab();
		
		TableDesCommandes tabCde;		
		GestionDesCommandes51 gtc = new GestionDesCommandes51("COMMANDES.DAT");
		
		tabCde = gtc.recupererTab();
		
		int choix;
				
	do{
		try {
			choix= menuChoixGeneral();
			switch (choix)
			{
			case 1: gta.menuGeneral(tabArt, tabCde); break;
			case 2: gtc.menuGeneral(tabCde, tabArt); break;
			case 0: ES.affiche(" SAUVEGARDE DU CATALOGUE ET DE LA TABLE DES COMMANDES **\n");gta.sauvegarder(tabArt); gtc.sauvegarder(tabCde);
				break;
			}
		}catch (Abandon ab){choix = 0;}
	} while(choix !=0);	
	
	ES.affiche("\n ** AU REVOIR A BIENTOT SUR SUPERETTE ** \n");		
	}	
	
	public static int menuChoixGeneral() throws Abandon 
	{
		String mes= "\n ***** BIENVENUE A LA SUPERETTE **\n"+
					"\n____________________________________\n"+
					"\n GESTION DES ARTICLES---------------1\n"+
					"\n GESTION DES COMMANDES -------------2\n"+
					"\n FIN--------------------------------0\n"+
					"\n VOTRE CHOIX..............";
		
		return ES.saisie(mes, 0, 2);
	}
}