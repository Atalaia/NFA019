package Serie21;

import java.util.*;

public class TableDesArticles {
	
	private Vector<Article> tabArt;
	
	public TableDesArticles()
	{
		Article a1= new Article(2, " CARTE SON NVIDIA ", 23.8F);
		Article a2= new Article(1,"DISK DUR", 50.5F);
		Article a3= new Article(4, "Carte mère", 1000F);
		Article a4= new Article(5, "Carte réseau", 24.7F); 
		Article a5= new Article(12, "Boite 100CD", 75.5F);
		Article a6= new Article(18, "MEMOIRE FLASH", 17F);
				
		tabArt= new Vector<Article>();
		
		tabArt.addElement(a1);
		tabArt.addElement(a2);
		tabArt.addElement(a3);
		tabArt.addElement(a4);
		tabArt.addElement(a5);
		tabArt.addElement(a6);
	}
	
	public String toString()
	{
		String st=" \n ***** TABLE DES ARTICLES *****\n ";
		for(int i=0;i<tabArt.size();i++)
		{
			st= st + tabArt.get(i).toString();
		}
		return st;
	}
	
	public Article retourner(int code)
	{
		for(int i=0; i< taille(); i++)
		{
			Article a = tabArt.get(i);
			if (a.getCode()== code) return a;
		}
		return null;
	}
	
	public int taille(){return tabArt.size();}
	
	
	//méthodes supprimer et ajouter un article de la table des articles
	public void ajouter(Article art)
	{
		tabArt.addElement(art);
	}
	
	public void supprimer(int i)
	{
			if (i>=0 && i < taille()){
			tabArt.remove(i);
			}
	}
	
	//manque constructeur avec paramètres, getter, setter, seulement 1 parce qu'il y a qu'une variable d'isntance qui est à part
	
	public TableDesArticles(Article a)
	{
		Article b = new Article(a.getCode(),a.getDesignation(),a.getPu());
		
		tabArt= new Vector<Article>();
		
		tabArt.addElement(b);
	}
	
}
