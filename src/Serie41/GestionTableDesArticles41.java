package Serie41;

import IPane.ES;
import MesExceptions.*;

public class GestionTableDesArticles41 {
		
	public void menuGeneral(TableDesArticles41 tabArt, TableDesCommandes tabCde) throws Abandon
	{
		
		int choix;
		
		do{
			try{
				choix = menuChoix();
				switch(choix)
				{
				case 1: ajouter(tabArt); break;
				case 2: supprimer(tabArt, tabCde); break; 
				case 3: afficher(tabArt); break;
				case 4: afficherPromotion(tabArt); break;
				case 0: break;
				}
			}catch (Abandon ab){choix = 0;}
		}while (choix != 0);
	}
	
	public void afficherPromotion(TableDesArticles41 tabArt)
	{
		if(tabArt.taille() != 0) ES.affiche(tabArt.toStringPromo());
		else ES.affiche("\n*** STOCK VIDE ***\n");
	}
	
	//ajouter l'option 4 dans le menuCHoix
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
	
	public void ajouter(TableDesArticles41 tabArt) throws Abandon
	{
		Article41<Integer> art = saisie(tabArt);
		if(art != null) tabArt.ajouter(art);
	}
	
	public void supprimer(TableDesArticles41 tabArt, TableDesCommandes tabCde) throws Abandon
	{
		if (tabArt.taille() == 0) ES.affiche("\n *** STOCK VIDE !!! PAS DE SUPPRESSION POSSIBLE ***\n");
		else {
			int code= ES.saisie(" Quel code voulez-vous supprimer ? ", 1, Integer.MAX_VALUE);
			tabArt.supprimer(code,tabCde);
		}
		//il faut aller dans la structure et supprimer, j'ajoute tabCde pour supprimer en cascade
	}
	
	public void afficher(TableDesArticles41 tabArt)
	{
		if (tabArt.taille() == 0) ES.affiche("\n *** STOCK VIDE ! ***\n");
		else ES.affiche(tabArt.toString());
	}
	
	//cette methode nous retourne un article, soit un article en promotion soit un article normal
	public Article41<Integer> saisie(TableDesArticles41 tabArt) throws Abandon
	{
		int code;
		
		code= ES.saisie(" QUEL CODE ?", 1, Integer.MAX_VALUE);
				
		if (tabArt.retourner(code)==null)
		{
			String designation= ES.saisie(" Quelle designation ? ");
			float pu= ES.saisie(" Quel prix unitaire ? ", 0, Float.MAX_VALUE);
			
			if (ES.saisieOuiNon(" Cet article est-il en Promotion ? "))
			{
				//article en promo
				int quantiteMini= ES.saisie(" Quantite minimum ?", 1, Integer.MAX_VALUE);
				float reduc= ES.saisie("Quelle reduction ?", 0, 100);
				return new ArticlePromo(code, designation,pu,quantiteMini,reduc);
			}
			
			return new Article41<Integer>(code, designation, pu);
		}
		else {
				ES.affiche(" *** Cet article existe déjà ! ");
				return null;
		}
	}
}
