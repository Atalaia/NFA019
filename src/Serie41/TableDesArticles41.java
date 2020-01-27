package Serie41;

import java.util.*;

public class TableDesArticles41 {
	
	private TreeMap<Integer,Article41<Integer>> tabArt;
	
	public TableDesArticles41()
	{
		Article41<Integer> a1= new Article41<Integer>(2, " CARTE SON NVIDIA ", 23.8F);
		Article41<Integer> a2= new Article41<Integer>(5, " CARTE RESEAU ", 12F); 
		ArticlePromo a3= new ArticlePromo(4, " CLES USB", 2F, 5, 20F);
		
		tabArt= new TreeMap<Integer,Article41<Integer>>();
		
		//comme ça on ajoute un element dans le treemap, le code, cle et puis l'objet
		tabArt.put(a2.getCode(),a2);
		tabArt.put(a1.getCode(),a1);
		tabArt.put(a3.getCode(),a3);
	}
	
	public String toString()
	{
		String st=" \n ***** TABLE DES ARTICLES *****\n ";
		
		for(Article41<Integer> art: tabArt.values())
			
			st = st + art.toString() + " *** ";
		
		return st;
	}
	
	//tester avant si la table vide, donc affiche rien
	public String toStringPromo()
	{
		String st = " \n ***** ARTICLES EN PROMOTION *****\n ";
		
		for(Article41<Integer> art : tabArt.values())
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
	
	public Article41<Integer> retourner(Integer code)
	{
		return tabArt.get(code);
	}
	
		
	public int taille(){return tabArt.size();}
	
	
	public void ajouter(Article41<Integer> art)
	{
		if (retourner(art.getCode())==null) tabArt.put(art.getCode(), art);
//		if(!tabArt.containsValue(art)) tabArt.put(art.getCode(), art);
	}
		
	public void supprimer(Article41<Integer> art)
	{
		if(retourner(art.getCode())!=null) tabArt.remove(art);
	}
	
	public void supprimer(int code,TableDesCommandes tabCde) //On rajoute la TableDesCommandes pour supprimer en cascade le code
	{
		if (tabArt.containsKey(code)) //Je vérifie si le code existe
			{tabArt.remove(code);
			tabCde.purge(code);
			}
	}
	
}
