package Serie51;

import IPane.ES;
import MesExceptions.*;
import Connexions.ConnexionFichier;

public class GestionTableDesArticles51 implements MesInterfaces.InterfaceGestion<TableDesArticles51, TableDesCommandes>{
		
	ConnexionFichier<TableDesArticles51> fichArt;
	
	//ajouter dans la gestion un constructuer, recuperer le nom physique du fichier et fait le lien
	//on a passe le nom physique dans le constructeur
	
	public GestionTableDesArticles51(String nomPhysique)
	{ fichArt = new ConnexionFichier<TableDesArticles51>(nomPhysique);}
	
	//recuperer la table
	public TableDesArticles51 recupererTab()
	{
		TableDesArticles51 tabArt;
		tabArt= fichArt.lire();
		if (tabArt == null)
		{
			ES.affiche(" FICHIER DES ARTICLES NOUVEAU... TABART PAR DEFAUT CREER ** \n");
			tabArt = new TableDesArticles51();
		}
		return tabArt;
	}
	
	//methode pour sauvegarder la table des articles 51
	
	public void sauvegarder(TableDesArticles51 tabArt)
	{
		fichArt.ecrire(tabArt);
	}
	
	public void menuGeneral(TableDesArticles51 tabArt, TableDesCommandes tabCde) throws Abandon
	{
		
		int choix;
		
		do{
			try{
				choix = menuChoix();
				switch(choix)
				{
				case 1: ajouter(tabArt,tabCde); break;
				case 2: supprimer(tabArt, tabCde); break; 
				case 3: afficher(tabArt); break;
				case 4: afficherPromotion(tabArt); break;
				case 0: break;
				}
			}catch (Abandon ab){choix = 0;}
		}while (choix != 0);
	}
	
	public void afficherPromotion(TableDesArticles51 tabArt)
	{
		if(tabArt.taille() != 0) ES.affiche(tabArt.toStringPromo());
		else ES.affiche("\n*** STOCK VIDE ***\n");
	}
	
	public int menuChoix() throws Abandon
	{
		String mes = "\n ***** GESTION DES ARTICLES **\n"+
				"\n____________________________________\n"+
				"\n AJOUTER UN ARTICLE-------------------1\n"+
				"\n SUPPRIMER UN ARTICLE-----------------2\n"+
				"\n AFFICHER LA TABLE DES ARTICLES-------3\n"+
				"\n AFFICHER ARTICLES EN PROMOTION-------4\n"+
				"\n FIN----------------------------------0\n"+
				"\n VOTRE CHOIX..........................";
		
		return ES.saisie(mes, 0, 4);
	}
	
	public void ajouter(TableDesArticles51 tabArt,TableDesCommandes obj) throws Abandon
	{
		ArticleAbstrait<Integer> art = saisie(tabArt);
		if(art != null) tabArt.ajouter(art);
		else ES.affiche("\n ** ARTICLE DE CODE EXISTANT ** \n");
	}
	
	public void supprimer(TableDesArticles51 tabArt, TableDesCommandes tabCde) throws Abandon
	{
		if (tabArt.taille() == 0) ES.affiche("\n *** STOCK VIDE !!! PAS DE SUPPRESSION POSSIBLE ***\n");
		else {
			int code= ES.saisie(" Quel code voulez-vous supprimer ? ", 1, Integer.MAX_VALUE);
			tabArt.supprimer(code,tabCde);
		}
	}
	
	public void afficher(TableDesArticles51 tabArt)
	{
		if (tabArt.taille() == 0) ES.affiche("\n *** STOCK VIDE ! ***\n");
		else ES.affiche(tabArt.toString());
	}
	
	public ArticleAbstrait<Integer> saisie(TableDesArticles51 tabArt) throws Abandon
	{
		int code;
		
		code= ES.saisie(" QUEL CODE ?", 1, Integer.MAX_VALUE);
				
		if (tabArt.retourner(code)==null)
		{
			String designation= ES.saisie(" Quelle designation ? ");
			float pu= ES.saisie(" Quel prix unitaire ? ", 0, Float.MAX_VALUE);
			
			if (ES.saisieOuiNon(" Cet article est-il en Promotion ? "))
			{
				int quantiteMini= ES.saisie(" Quantite minimum ?", 1, Integer.MAX_VALUE);
				float reduc= ES.saisie("Quelle reduction ?", 0, 100);
				return new ArticlePromo(code, designation,pu,quantiteMini,reduc);
			}
			
			return new Article51(code, designation, pu);
		}
		else {
				ES.affiche(" *** Cet article existe déjà ! ");
				return null;
		}
	}
}
