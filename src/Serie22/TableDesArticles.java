package Serie22;

import java.util.*;

public class TableDesArticles {
	
	private TreeMap<Integer,Article<Integer>> tabArt;
	
	public TableDesArticles()
	{
		Article<Integer> a1= new Article<Integer>(2, " CARTE SON NVIDIA ", 23.8F);
		Article<Integer> a2= new Article<Integer>(5, " CARTE RESEAU ", 12F); 
		
		tabArt= new TreeMap<Integer,Article<Integer>>();
		
		//comme ça on ajoute un element dans le treemap, le code, cle et puis l'objet
		tabArt.put(a2.getCode(),a2);
		tabArt.put(a1.getCode(),a1);
	}
	
	public String toString()
	{
		String st=" \n ***** TABLE DES ARTICLES *****\n ";
		
		for(Article<Integer> art: tabArt.values())
			
			st = st + art.toString() + " *** ";
		
//		for(int i=0;i<tabArt.size();i++)
//		{
//			st= st + tabArt.get(i).toString();
//		}
		
		return st;
	}
	
	public String cle()
	{
		String st = "\n ** LISTE DES CLES DE LA TABLE DES ARTICLES **\n";
		
		for(Integer code : tabArt.keySet())
			st= st + code + " ** ";
		return st;
	}
	
	public Article<Integer> retourner(Integer code)
	{
		return tabArt.get(code);
	}
	
	public int taille(){return tabArt.size();}
	
	//il faut vérifier si l'article existe ou pas avant de l'ajouter. Pour tester dans le treemap on a contentkey, contenttable...
	//Quand nous sommes à l'intérieur de Table des articles on peut appeler toutes les methodes de treemap, si on est a l'exterieur il faut appeler retourner
	
	public void ajouter(Article<Integer> art)
	{
		if (retourner(art.getCode())==null) tabArt.put(art.getCode(), art);
//		if(!tabArt.containsValue(art)) tabArt.put(art.getCode(), art);
	}
		
	public void supprimer(Article<Integer> art)
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
