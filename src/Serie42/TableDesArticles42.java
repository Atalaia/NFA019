package Serie42;

import java.util.*;
//je remplace tous les Article41 par des ArticleAbstrait
//interface InterfaceStructure avec TypeMetier et TypeCode

public class TableDesArticles42 implements MesInterfaces.InterfaceStructure<ArticleAbstrait<Integer>, Integer>
{
	
	private TreeMap<Integer,ArticleAbstrait<Integer>> tabArt;
	
	public TableDesArticles42()
	{
		ArticleAbstrait<Integer> a1= new Article42(2, " CARTE SON NVIDIA ", 23.8F);
		ArticleAbstrait<Integer> a2= new Article42(5, " CARTE RESEAU ", 12F); 
		ArticleAbstrait<Integer> a3= new ArticlePromo(4, " CLES USB", 2F, 5, 20F);
		
		tabArt= new TreeMap<Integer,ArticleAbstrait<Integer>>();
		
		//comme ça on ajoute un element dans le treemap, le code, cle et puis l'objet
		tabArt.put(a2.getCode(),a2);
		tabArt.put(a1.getCode(),a1);
		tabArt.put(a3.getCode(),a3);
	}
	
	public String toString()
	{
		String st=" \n ***** TABLE DES ARTICLES *****\n ";
		
		for(ArticleAbstrait<Integer> art: tabArt.values())
			
			st = st + art.toString() + " *** ";
		
		return st;
	}
	
	//tester avant si la table vide, donc affiche rien
	public String toStringPromo()
	{
		String st = " \n ***** ARTICLES EN PROMOTION *****\n ";
		
		for(ArticleAbstrait<Integer> art : tabArt.values())
		{
			if (art instanceof ArticlePromo) st= st + art.toString();
		}
		return st;
	}
	
	public String cle()
	{
		String st = "\n ** LISTE DES CLES DE LA TABLE DES ARTICLES **\n";
		
		for(Integer code : tabArt.keySet())
			st= st + code + " ** ";
		return st;
	}
	
	public ArticleAbstrait<Integer> retourner(Integer code)
	{
		return tabArt.get(code);
	}
	
		
	public int taille(){return tabArt.size();}
	

	public void ajouter(ArticleAbstrait<Integer> art)
	{
		if (retourner(art.getCode())==null) tabArt.put(art.getCode(), art);
	}
		
	public void supprimer(ArticleAbstrait<Integer> art)
	{
		if(retourner(art.getCode())!=null) tabArt.remove(art);
	}
	
	public void supprimer(int code,TableDesCommandes tabCde)
	{
		if (tabArt.containsKey(code)) //Je vérifie si le code existe
			{tabArt.remove(code);
			tabCde.purge(code);
			}
	}
	
	public void supprimer(Integer code){}
	
}
