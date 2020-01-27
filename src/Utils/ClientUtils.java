package Utils;

import java.util.Scanner;

public class ClientUtils {
	
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] s)
	{
		
		System.out.print("SAISIR JOUR, MOIS ET ANNEE SVP \n");	
		int jour = lireEnt("Jour",1,31);
		int mois = lireEnt("Mois",1,12);
		int annee = lireEnt("Annee",0, Integer.MAX_VALUE);
		
		if (DateUser.validDate(jour, mois, annee)){
			//DateUser dat1 = new DateUser(jour,mois,annee);
			DateUser dat1= new DateUser(jour,mois,annee);
			System.out.print("LA DATE EST " + dat1.toString());
		
	//		dat1.lendemain();
	//		System.out.print("LA DATE du lendemain est: " + dat1.toString());
			
	//		dat1.hier();
	//		System.out.print("LA DATE d'hier est: " + dat1.toString());
			
			DateUser dat2= new DateUser();
			
		//	System.out.print(" Nous sommes le " + dat1.jourDeSemaine());
			
//			System.out.print(" Avant ? " + dat2.avant(dat1));

//			dat2= dat1.lendemain2();
//			System.out.print(" Le lendemain de " + dat1.toString() + " est " + dat2.toString());
			} 
		else System.out.print("DATE INVALIDE !!\n");
	}
		
	public static int lireEnt(String mes, int inf, int sup)
	{
		System.out.print(mes);
			
		int saisie;
			
		boolean ok;
			
		do {
			saisie = sc.nextInt();
			
			ok = (saisie >= inf) && (saisie <= sup);
				if (!ok) System.out.print("HORS INTERVALLE\n");
			} while(!ok);	
		
		return saisie;
	}

}
