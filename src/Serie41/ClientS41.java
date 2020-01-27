package Serie41;

import IPane.*;
import MesExceptions.*;

public class ClientS41 {
	
	
	public static void main(String[] s) throws Abandon
	{
		TableDesArticles41 tabArt= new TableDesArticles41();
		TableDesCommandes tabCde = new TableDesCommandes();
		
		GestionTableDesArticles41 gta= new GestionTableDesArticles41();
		GestionDesCommandes41 gtc = new GestionDesCommandes41();
		
		
		int choix;
				
	do{
		try {
			choix= menuChoixGeneral();
			switch (choix)
			{
			case 1: gta.menuGeneral(tabArt, tabCde); break;
			case 2: gtc.menuGeneral(tabArt,tabCde); break;
			case 0: break;
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