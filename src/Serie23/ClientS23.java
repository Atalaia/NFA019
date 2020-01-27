package Serie23;

import java.util.*;

import Serie22.*;
import Utils.ClientUtils;
import IConsole.*;

public class ClientS23 {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public static void main(String[] s)
	{
		TableDesArticles tabArt= new TableDesArticles();
		TableDesCommandes tabCde = new TableDesCommandes();
		
		GestionTableDesArticles gta= new GestionTableDesArticles();
		GestionDesCommandes gtc = new GestionDesCommandes();
		
		
		int choix;
				
	do{
		choix= menuChoixGeneral();
		switch (choix)
		{
			case 1: gta.menuGeneral(tabArt, tabCde); break;
			case 2: gtc.menuGeneral(tabArt,tabCde); break;
			case 0: break;
		}
	} while(choix !=0);	
	
	System.out.print("\n ** AU REVOIR A BIENTOT SUR SUPERETTE ** \n");		
	}	
	
	public static int menuChoixGeneral()
	{
		String mes= "\n ***** BIENVENUE A LA SUPERETTE **\n"+
					"\n____________________________________\n"+
					"\n GESTION DES ARTICLES---------------1\n"+
					"\n GESTION DES COMMANDES -------------2\n"+
					"\n FIN--------------------------------0\n"+
					"\n VOTRE CHOIX..............";
		
		return ClientUtils.lireEnt(mes, 0, 2);
	}
}