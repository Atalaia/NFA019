package Serie52;

import java.io.Serializable;

import Connexions.ConnexionFichier;
import IPane.ES;
import MesExceptions.Abandon;
import Utils.DateUser;

public class GestionDesFactures implements MesInterfaces.InterfaceGestion<TableDesCommandes, TableDesFactures>
{
	ConnexionFichier<TableDesFactures> fichFac;
	
	//constructeur vide
	public GestionDesFactures() {}
	
	public GestionDesFactures(String nomPhysique)
	{ fichFac = new ConnexionFichier<TableDesFactures>(nomPhysique);}
	
	public TableDesFactures recupererTab()
	{
		TableDesFactures tabFac;
		tabFac= fichFac.lire();
		if(tabFac == null)
		{tabFac = new TableDesFactures();}
		return tabFac;
	}
	
	public void sauvegarder(TableDesFactures tabFac)
	{
		fichFac.ecrire(tabFac);
	}
	
	public void menuGeneral(TableDesCommandes tabCde, TableDesFactures tabFac) {}
	public void ajouter(TableDesCommandes tabCde, TableDesFactures tabFac) {}
	public void supprimer(TableDesCommandes tabCde, TableDesFactures tabFac) {}
	public void afficher(TableDesCommandes tabCde) {}
	
	public void menuGeneral(TableDesFactures tabFac, TableDesCommandes tabCde, TableDesArticles52 tabArt) throws Abandon
	{
		int choix;
		
		do
		{
			try {
				choix = menuChoix();
				switch(choix)
				{
				case 1: creer1facture(tabCde,tabArt,tabFac);break;
				case 2: editer1facture(tabFac); break;
				case 3: supprimer(tabFac); break;
				case 4: editerToutesLesFactures(tabFac); break; 
				case 0: break;
				}
			}catch (Abandon ab){choix = 0;}
		} while (choix != 0);
	}
		
	//affiche les cles de commande, numero des commande a partir de la table des commandes que retourne que les cles
		// l'utilisateur choisi une cle, string, 
		//tabCommande.retourner avec la cle et si la commande n'est pas vide, message "cle n'existe pas"
		//Si cle existe, la cle est à faux, on facture la facture. 
	//string.facture. commande.getNumero + DateUser dat new FActure de ces 3 elements la
		// et puis on les ajoute dans table facture
		
		//pour creer 1 facture il faut creer puis ajouter dans la table de facture
		
		//ajouter on reutilise la methode facturer de commande 

	public void creer1facture(TableDesCommandes tabCde, TableDesArticles52 tabArt, TableDesFactures tabFac)
	{
		if(tabCde.taille() !=0) ES.affiche(tabCde.cle());	
		String numCde = ES.saisie("Quelle commande voulez-vous facturer ?");
		TableDesLignesDeCommande cde = tabCde.retourner(numCde);
				
		if(cde != null){
			String Facture = cde.facturer(tabArt);
			Facture fac = new Facture(new DateUser(), numCde, Facture);
			tabFac.ajouter(fac);
		}else{
			ES.affiche(" La commande n'existe pas !!");
		}
		
	}
	
	
	//afficher les cles de la commande
	//demander laquelle veut afficher
	//toString
	public void editer1facture(TableDesFactures tabFac) throws Abandon
	{
		if (tabFac.taille() != 0){
			ES.affiche(tabFac.cle());
			String numCde = ES.saisie("Quelle facture voulez-vous afficher ?");
			if(numCde == null){ClientS52.menuChoixGeneral();}
			if(tabFac.retourner(numCde) != null){
				ES.affiche(tabFac.retourner(numCde).toString());
			}else{
				ES.affiche("La facture n'existe pas.");
			}
		}else{
			ES.affiche("\n**** Facture vide. ****\n");	
		}
	}

	public void supprimer(TableDesFactures tabFac)
	{
		if (tabFac.taille() != 0){
			ES.affiche(tabFac.cle());
			String numCde = ES.saisie("Quelle facture voulez-vous supprimer ?");
			if(numCde == null){ES.affiche("*** Cette facture n'existe pas ***");}
			if(tabFac.retourner(numCde) != null){
				tabFac.supprimer(numCde);
			}else{
				ES.affiche("La facture n'existe pas.");
			}
		}else{
			ES.affiche("\n**** Facture vide. ****\n");	
		}
	}

	public void editerToutesLesFactures(TableDesFactures tabFac)
	{
		if (tabFac.taille() != 0){
			ES.affiche(tabFac.toString());
		}else{
			ES.affiche("\n**** Facture vide ****\n");	
	}
	}
	
	public int menuChoix() throws Abandon
	{
		String mes= "\n *** MENU GESTION DES FACTURES ***\n"
				+ "CREER UNE FACTURE________________1\n"
				+ "EDITER UNE FACTURE_______________2\n" +
				" SUPPRIMER UNE FACTURE_____________3\n" +
				" EDITER TOUTES LES FACTURES________4\n" +
				//facturer
				" FIN_______________________________0\n" +
				"VOTRE CHOIX_________________________";
		
		return ES.saisie(mes, 0, 4);
	}

}
