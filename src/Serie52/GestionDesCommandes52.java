package Serie52;

import java.io.Serializable;

import IPane.*;
import MesExceptions.*;
import Connexions.ConnexionFichier;


public class GestionDesCommandes52 implements MesInterfaces.InterfaceGestion<TableDesCommandes, TableDesArticles52>
{
	ConnexionFichier<TableDesCommandes> fichCde;
	
	public GestionDesCommandes52(String nomPhysique)
	{ fichCde = new ConnexionFichier<TableDesCommandes>(nomPhysique);}
	
	public TableDesCommandes recupererTab()
	{
		TableDesCommandes tabCde;
		tabCde= fichCde.lire();
		if(tabCde == null){tabCde = new TableDesCommandes();}
		return tabCde;
	}
	
	public void sauvegarder(TableDesCommandes tabCde)
	{
		fichCde.ecrire(tabCde);
	}
	
	
	public void menuGeneral(TableDesCommandes tabCde, TableDesArticles52 tabArt) throws Abandon
	{
		int choix;
		
		do
		{
			try {
				choix = menuChoix();
				switch(choix)
				{
				case 1: ajouter(tabCde, tabArt); break;
				case 2: supprimer(tabCde, tabArt); break;
				case 3: afficherUneCommande(tabCde); break;
				case 4: afficherToutesLesCommandes(tabCde); break;
				case 5: facturer1Commande(tabArt,tabCde); break;
				case 0: break;
				}
			}catch (Abandon ab){choix = 0;}
		} while (choix != 0);
	}
	
	// manque la date de creation, la date de commande, int numero est maintenant un string
	public void ajouter(TableDesCommandes tabCde, TableDesArticles52 tabArt) throws Abandon
	{
		TableDesLignesDeCommande cde = new TableDesLignesDeCommande();
		
		GestionUneCommande52 guc= new GestionUneCommande52();
		guc.menuGeneral(cde, tabArt); 
		if(cde.taille() != 0) 
			{ String numero = premierNumeroDispo(tabCde);
			cde.setDateCommande(new Utils.DateUser());
			cde.setNumCde(numero);
		
			tabCde.ajouter(cde);
		}
	}
	
	public void supprimer(TableDesCommandes tabCde, TableDesArticles52 obj) throws Abandon
	{
		if(tabCde.taille() !=0) {			
			ES.affiche(tabCde.cle());
			String numCde = ES.saisie("Quelle commande voulez-vous supprimer ?");
			if(tabCde.retourner(numCde) != null)
				tabCde.supprimer(numCde);
			else {
				ES.affiche("La commande n'existe pas.");
			}
		}else
			ES.affiche("\n**** La table des commandes est vide. ****\n");	
	}
	 
	public void afficherUneCommande(TableDesCommandes tabCde) throws Abandon
	{
		if (tabCde.taille() != 0){
			ES.affiche(tabCde.cle());
			String numCde = ES.saisie("Quelle commande voulez-vous afficher ?");
			if(numCde == null){ClientS52.menuChoixGeneral();}
			if(tabCde.retourner(numCde) != null){
				ES.affiche(tabCde.retourner(numCde).toString());
			}else{
				ES.affiche("La commande n'existe pas.");
			}
		}else{
			ES.affiche("\n**** Commande vide. ****\n");	
		}
	}
	
	public void afficherToutesLesCommandes(TableDesCommandes tabCde){
		if (tabCde.taille() != 0){
			ES.affiche(tabCde.toString());
		}else{
			ES.affiche("\n**** Commande vide ****\n");	
		}
	}
	
	public void afficher(TableDesCommandes tabCde){}
	
	public void facturer1Commande(TableDesArticles52 tabArt, TableDesCommandes tabCde) throws Abandon
	{
		ES.affiche(" \n** LISTE DES NUMEROS DE COMMANDES : \n" + tabCde.toString());
		String numero= ES.saisie(" QUELLE COMMANDE VOULEZ-VOUS FACTURER ?");
		
		if(tabCde.retourner(numero) != null) 
			ES.affiche(" \n " + tabCde.retourner(numero).facturer(tabArt));
	}
	
	public String premierNumeroDispo(TableDesCommandes tabCde)
	{
	Utils.DateUser dateDuJour = new Utils.DateUser();
	
	String part1= "" + dateDuJour.getAnnee() + dateDuJour.getMois() + dateDuJour.getJour();
	
	String part2= "";
	int numero=1;
	 
	part2 = part1 + numero;
	if (tabCde.taille() == 0){return part2;}
	while(tabCde.retourner(part2) != null) 
		 {numero ++;
		 part2 = part1+numero;
		 }
	 return part2;
	}
	
	public int menuChoix() throws Abandon
	{
		String mes= "\n *** MENU GESTION DES COMMANDES ***\n" +
				" CREER UNE COMMANDE________________1\n" +
				" SUPPRIMER UNE COMMANDE____________2\n" +
				" AFFICHER UNE COMMANDE_____________3\n" +
				" AFFICHER TOUTES LES COMMANDES_____4\n" +
				" FACTURER UNE COMMANDE_____________5\n" +
				" FIN_______________________________0\n" +
				"VOTRE CHOIX_________________________";
		
		return ES.saisie(mes, 0, 5);
	}
	
}
