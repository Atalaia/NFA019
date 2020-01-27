package Serie31;

import java.util.*;

import Serie22.*;
import Serie23.*;
import Utils.ClientUtils;
import IConsole.*;
import MesExceptions.*;

public class ClientS31 {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public static void main(String[] s) throws Abandon
	{
		TableDesArticles tabArt= new TableDesArticles();
		TableDesCommandes tabCde = new TableDesCommandes();
		
		GestionTableDesArticles gta= new GestionTableDesArticles();
		GestionDesCommandes gtc = new GestionDesCommandes();
		
		
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
	
	public static int menuChoixGeneral() throws Abandon //exception levée mais pas traitée, il faut attraper au plus haut niveau, car si on traite avant l'exception ne releve pas jusqu'au dernier niveau, le dernier methode qui l'appelle
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

//Sustituer le system.out, toutes les E S par ES.affiche et ES.saisie et puis mettre l'exception Abandon où il y a ES.saisie