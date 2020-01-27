package IPane;

import javax.swing.*;

import MesExceptions.*;

//maintenant implements MesInterfaces.EntreeSortie et il faut enlever les static, mais on va pas le faire
public class ES{
	
	public static void affiche(String mes)
	{
		JOptionPane.showMessageDialog(null, mes);
	}
	
	public static char saisieChar(String mes)
	{
		
	do{
		String saisi= JOptionPane.showInputDialog(mes);
		try { char rep=saisi.charAt(0); return rep;}
			catch (NullPointerException ne){ affiche(" CHAINE VIDE !! RESSAISISSEZ");}
	} while (true);
	
		//return saisi.charAt(0);
	}
	
	public static boolean saisieOuiNon(String mes)
	{
		int saisi= JOptionPane.showConfirmDialog(null, mes, "", JOptionPane.YES_NO_OPTION);
		return (saisi==0); //si c'est 0 c vrai, retourne vrai, l'option JOptionPane.showConfirmDialog
	}
	
	//prend 3 paramètres un string messages et deux entiers
	
	public static int saisie(String mes, int inf, int sup) throws Abandon
	{
		String saisi;
		
		do {
			try{
				saisi= JOptionPane.showInputDialog(mes);
			//dans le cas où on a rien saisi, saisi = null, on va tester si null, on leve une exception, il faut deplacer le try plus haute, car maintenant ça c'est une zone de capture aussi
		
			//il faut le parser pour le convertir en entier, je parse la chaine de caracteres et j'obtiens une valeur
			//JOptionPane nous laisse seulement entrer des chaines de caracteres, pour lui 14 c'est 2 caracteres par exemple, donc il faut le parser et le convertir en int
		
				if (saisi == null) throw new Abandon();
				
				//Si clique sur ok, sans rien, maintenant il faut tester si le contenu de la chaine est vide, si la chaine est vide, on va déclarer une autre exception
				
				if(saisi.equals("")) throw new Exception();
				
				int valeur;
			
				valeur= Integer.parseInt(saisi);
		
				if (valeur >= inf && valeur <= sup) return valeur;
		
				affiche( "SAISIE HORS INTERVALLE... RESSAISISSEZ SVP");
			} catch (NumberFormatException e)
			{
				affiche ("SAISIE NON NUMERIQUE... RESSAISISSEZ SVP");
			}
			catch (Abandon ab) {
				
			//	char rep = saisieChar("SOUHAITEZ-VOUS VRAIMENT ABANDONNER ? 0/N ?");
			//	if(rep == 'o' || rep =='O') throw ab;
				
					if (saisieOuiNon(" ABANDON ?")) {throw ab;}
			}
			catch (Exception ex) {affiche(" Il faut saisir quelque chose SVP");}
		} while(true);
	}
	
	public static String saisie(String mes)
	{
		return JOptionPane.showInputDialog(mes);
	}
	
	public static int saisie(String mes, int inf) throws Abandon
	{
		String saisi;
		
		do {
			try{
				saisi= JOptionPane.showInputDialog(mes);
			
				if (saisi == null) throw new Abandon();
								
				if(saisi.equals("")) throw new Exception();
				
				int valeur;
			
				valeur= Integer.parseInt(saisi);
		
				if (valeur >= inf) return valeur;
		
				affiche( "SAISIE INFERIEUR  A " + inf + "... RESSAISISSEZ \n");
			} catch (NumberFormatException e)
			{
				affiche ("SAISIE NON NUMERIQUE... RESSAISISSEZ SVP");
			}
			catch (Abandon ab) {
						
					if (saisieOuiNon(" ABANDON ?")) {throw ab;}
			}
			catch (Exception ex) {affiche(" Il faut saisir quelque chose SVP");}
		} while(true);
	}
	
	public static float saisie(String mes, float inf, float sup) throws Abandon
	{
		String saisi;
		
		do {
			try{
				saisi= JOptionPane.showInputDialog(mes);
			
				if (saisi == null) throw new Abandon();
								
				if(saisi.equals("")) throw new Exception();
				
				float valeur;
			
				valeur= Float.parseFloat(saisi);
		
				if (valeur >= inf && valeur <= sup) return valeur;
		
				affiche( "SAISIE INFERIEUR  A " + inf + "... RESSAISISSEZ SVP");
			} catch (NumberFormatException e)
			{
				affiche ("SAISIE NON NUMERIQUE... RESSAISISSEZ SVP");
			}
			catch (Abandon ab) {
				
			
					if (saisieOuiNon(" ABANDON ?")) {throw ab;}
			}
			catch (Exception ex) {affiche(" Il faut saisir quelque chose SVP");}
		} while(true);
	}

	public static float saisie(String mes, float inf) throws Abandon
	{
		String saisi;
		
		do {
			try{
				saisi= JOptionPane.showInputDialog(mes);
			
				if (saisi == null) throw new Abandon();
								
				if(saisi.equals("")) throw new Exception();
				
				float valeur;
			
				valeur= Float.parseFloat(saisi);
		
				if (valeur >= inf) return valeur;
		
				affiche( "SAISIE INFERIEUR  A " + inf + "... RESSAISISSEZ \n");
			} catch (NumberFormatException e)
			{
				affiche ("SAISIE NON NUMERIQUE... RESSAISISSEZ SVP");
			}
			catch (Abandon ab) {
						
					if (saisieOuiNon(" ABANDON ?")) {throw ab;}
			}
			catch (Exception ex) {affiche(" Il faut saisir quelque chose SVP");}
		} while(true);
	}
}
