package Connexions;
import java.io.*;

import IPane.ES;

//cette classe doit être générique sur le type de la structure. 
//Recuperer la table dans le fichier et puis fermer le fichier en écrivant les données du fichier

public class ConnexionFichier <TypeStructure> {

	private String nomPhysique;
	
	public ConnexionFichier(String nomP) { nomPhysique = nomP;}
	
	public ConnexionFichier(){}
	
	//maintenant on va lire, on recuperer la table qui etait deja sauvegarder dans le fichier
	//doit retourner une table de type structure
	//ça c pour lire
	public TypeStructure lire()
	{
		TypeStructure tab= null;
		
		try {
		//il faut associer ce nom physique au nom logique
		FileInputStream fis = new FileInputStream (nomPhysique);
		
		//maintenant on lit, on ouvre le fichier, l'objet ois est le fichier, c'est le nom logique du fichier
		ObjectInputStream ois= new ObjectInputStream(fis);
		
		//maintenant on recupere la table avec l'objet readObjet
		//comme on recupere un objet on le caste vers le type de la strucutre
		
		tab=(TypeStructure)ois.readObject();
		
		}
		//cette exception veut dire que le nom physique n'existe pas
		catch (FileNotFoundException fne){ES.affiche(" LECTURE D'UN FICHIER INEXISTANT ***\n");}
		//problème de type
		catch(ClassNotFoundException cne){ES.affiche(" *** TYPE LECTURE INCOHERENT ***\n");}
		//problème lecture
		catch (IOException ioe){ES.affiche(" ** PROBLEME DISK LECTURE OU ECRITURE ***\n");}
		
		return tab;
	}
	
	//maintenant on fait la même chose pour l'écriture
	//retourne rien donc void et prendre comme parametre la table qu'on veut ecrire dans le fichier
	
	public void ecrire(TypeStructure tab)
	{
		try{
			//associe un nom physique fichier à un nom logique en memoire
			FileOutputStream fos = new FileOutputStream(nomPhysique);
			//apres on l'ouvre en mode ecriture
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(tab);
		}
		//le fichier n'existe pas
		catch(FileNotFoundException fne){ES.affiche(" ** FICHIER NOUVEAU **	\n");}
		catch(IOException ioe){ES.affiche(" ** PROBLEME D'ÉCRITURE SUR FICHIER **\n");}
	}
}
