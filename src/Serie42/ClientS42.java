package Serie42;

import IPane.*;
import MesExceptions.*;

public class ClientS42 {
	
	
	public static void main(String[] s) throws Abandon
	{
		TableDesArticles42 tabArt= new TableDesArticles42();
		TableDesCommandes tabCde = new TableDesCommandes();
		
		GestionTableDesArticles42 gta= new GestionTableDesArticles42();
		GestionDesCommandes42 gtc = new GestionDesCommandes42();
		
		
		int choix;
				
	do{
		try {
			choix= menuChoixGeneral();
			switch (choix)
			{
			case 1: gta.menuGeneral(tabArt, tabCde); break;
			case 2: gtc.menuGeneral(tabCde, tabArt); break;
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