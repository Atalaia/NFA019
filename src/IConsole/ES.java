package IConsole;

import java.util.Scanner;
import java.util.*;
import MesExceptions.*;

public class ES {

	static Scanner sc= new Scanner(System.in);
	
	public static void affiche(String mes)
	{
		System.out.print(mes);
	}
	
	public static char saisieCarac(String mes)
	{
		affiche(mes);
		return sc.next().charAt(0);
	}
	
	public static int saisie(String mes, int inf, int sup) throws Abandon // dans cette methode on ne traite pas l'exception
	{
		int saisi;
		affiche(mes);
		
	do {	
		try {
			saisi= sc.nextInt();sc.nextLine(); //ajouter le nextLine après chaque nextInt ou nextFlot pour eviter les boucles infinies et vider le retour chariot
		
			if (saisi >= inf && saisi <= sup) return saisi;
			throw new Abandon();
			
		}catch (InputMismatchException e)
		{
			affiche( " SAISIE NON NUMERIQUE... RESSAISSISSEZ");
			sc.nextLine(); // pour vider le buffer, sinon boucle infinie sur le message précédente, saisie non numerique... 
		}//Exception pour quand la saisie est non numérique
		
		catch (Abandon ab){
			char rep = saisieCarac(" VOULEZ VOUS ABANDONNER ? (O/N)");
			if (rep == 'o' || rep == 'O') throw ab;//je releve l'exception une fois traité, ici c'est relevé sans la traiter
			else affiche( " SAISIE HORS INTERVALLE ... RESSAISISSEZ \n");
		}
		
	} while (true);
	}
	
	/*retourne la chaine de caractères saisie. Aucun contrôle n’est nécessaire*/
	
	public static String saisie(String mes)
	{
		affiche(mes);
		return sc.nextLine();
		
	} 
	
	/*retourne un entier plus grand ou égal à la valeur de inf*/
	
	public static int saisie(String mes, int inf) throws Abandon
	{
		int saisi;
		affiche(mes);
		
	do {	
		try {
			saisi= sc.nextInt();
		
			if (saisi >= inf) return saisi;
			throw new Abandon();
			
			}catch (InputMismatchException e)
			{
				affiche( " SAISIE NON NUMERIQUE... RESSAISSISSEZ");
				sc.nextLine(); 
			}
		
			catch (Abandon ab){
				char rep = saisieCarac(" VOULEZ VOUS ABANDONNER ? (O/N)");
				if (rep == 'o' || rep == 'O') throw ab;
				else affiche( " SAISIE INFERIEUR  A " + inf + "... RESSAISISSEZ \n");
		}		
	} while (true);
	}
	
	/* retourne un réel saisi avec les mêmes contrôles que la fonction précédente.*/
	
	public static float saisie(String mes, float inf, float sup) throws Abandon 
	{
		float saisi;
		affiche(mes);
		
	do {	
		try {
			saisi= sc.nextFloat();
		
			if (saisi >= inf && saisi <= sup) return saisi;
			throw new Abandon();
			
		}catch (InputMismatchException e)
		{
			affiche( " SAISIE NON NUMERIQUE... RESSAISSISSEZ");
			sc.nextLine(); 
		}
		
		catch (Abandon ab){
			char rep = saisieCarac(" VOULEZ VOUS ABANDONNER ? (O/N)");
			if (rep == 'o' || rep == 'O') throw ab;
			else affiche( " SAISIE HORS INTERVALLE ... RESSAISISSEZ \n");
		}
		
	} while (true);
	} 
	
	/* retourne un réel plus grand ou égal à la valeur de inf */
	
	public static float saisie(String mes, float inf) throws Abandon
	{
		float saisi;
		affiche(mes);
		
	do {	
		try {
			saisi= sc.nextFloat();
		
			if (saisi >= inf) return saisi;
			throw new Abandon();
			
			}catch (InputMismatchException e)
			{
				affiche( " SAISIE NON NUMERIQUE... RESSAISSISSEZ");
				sc.nextLine(); 
			}
		
			catch (Abandon ab){
				char rep = saisieCarac(" VOULEZ VOUS ABANDONNER ? (O/N)");
				if (rep == 'o' || rep == 'O') throw ab;
				else affiche( " SAISIE INFERIEUR  A " + inf + "... RESSAISISSEZ \n");
			}		
		} while (true);
	}
	
}