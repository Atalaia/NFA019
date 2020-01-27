package MesInterfaces;

//on fait TypeStructure et TypeMetier pour pouvoir les utiliser avec tous les types différents de metiers et structure

public interface InterfaceStructure <TypeMetier,TypeCode> 
{
	//on passe le TypeMetier en paramètre
	public abstract TypeMetier retourner(TypeCode code);
	
	//je j'ajoute en metier
	public abstract void ajouter(TypeMetier metier);
	
	//je supprime avec le code
	public abstract void supprimer(TypeCode code);
	
	//public abstract void supprimer(TypeMetier metier);
	
	public abstract int taille();

}
//je vais dans la première structure : tabledesarticles42