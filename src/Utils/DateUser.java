package Utils;

import java.util.*;
import java.io.Serializable;

public class DateUser implements Serializable {
	
	private int jour;
	private int mois;
	private int annee;
	
	public DateUser(){
		Calendar cal= Calendar.getInstance();
		jour= cal.get(Calendar.DAY_OF_MONTH);
		mois= cal.get(Calendar.MONTH)+1; //parce que le tableau commence par 0
		annee= cal.get(Calendar.YEAR);
	}
	
	public DateUser (int jour, int mois, int annee){
		this.jour=jour; this.mois=mois; this.annee=annee;
	}
	
	public int getJour() {return jour;}
	public int getMois() {return mois;}
	public int getAnnee() {return annee;}
	
	public void setJour(int jj) {jour = jj;}
	public void setMois(int mm) {mois = mm;}
	public void setAnnee(int aa) {annee = aa;}
	
	public String toString() {
		return ("**" + jour + "/" + mois + "/" + annee + "\n");
	}
	public static boolean  validDate(int jour, int mois, int annee) {
		//switch (mois){
		//case 4: case 6 : case 9 : case 11 return (jour < 31);
		//case 2 : if ((annee % 400 == 0 ||(anne % 100!=0 && (anne %4==0)) return jour < 30;
		//else return (jour <29);
		//default: return true;
		
		return (jour <= nbJourMax(mois,annee));
	}
	public static int nbJourMax(int mois, int annee) {
		switch (mois) {
		case 4: case 6: case 9: case 11: return 30;
		case 2: if ((annee % 400 ==0) || (annee % 100 != 0) && (annee % 4 == 0)) return 29;
		else return 28;
		default: return 31;
		}
	}
	public void lendemain() 
	{
		jour++;
		
		if (jour > nbJourMax(mois,annee))
		{	
			jour=1; mois++; if (mois > 12){mois=1; annee++;}
		}	
	}
	
	public DateUser lendemain2()
	{
		DateUser dat1= new DateUser(jour,mois,annee);
		dat1.lendemain();
		return dat1;
	}
	
	public void hier()
	{
		jour--;
		
		if (jour < 1)
		{	
			mois--; if (mois < 1){mois=12; annee--;}
			jour = nbJourMax(mois,annee);
		}	
		
	}
	
	public DateUser hier2()
	{
		DateUser dat1= new DateUser(jour,mois,annee);
		dat1.hier();
		return dat1;
	}
	
	public int zeller()
	{
		int mz,az,sz;
		
		if (mois > 2) mz= mois-2; else { mz=mois+10; annee=annee-1;}
		
		az=annee%100; //le reste de la division entière
		sz= (int)(annee/100);
		
		return (((int)(2.6*mz-0.2) + jour + az + (int)(az/4) + (int)(sz/4) - 2*sz) %7);
	}
	
	public String jourDeSemaine()
	{
		int z=this.zeller();
		switch(z)
		{
		case 0: return "Dimanche" ;
		case 1: return "Lundi";
		case 2: return "Mardi";
		case 3: return "Mercredi" ;
		case 4: return "Jeudi";
		case 5: return "Vendredi";
		case 6: return "Samedi";
		default: return "A FAIRE";
		}
	}
	
	public boolean avant (DateUser dat)
	{
		//this.jour<dat.getJour();
		boolean avant;
		if (this.jour < dat.getJour() && this.mois <= dat.getMois() && this.annee <= dat.getAnnee()) {return avant =true;}
		else{return avant = false;}
	}
	
	public int age()
	{
		DateUser dat2 = new DateUser();
		int age= dat2.annee - this.annee;
		
		if(dat2.mois<this.mois){return age-1;
		
		}else if(dat2.mois==this.mois){
			if(dat2.jour<this.jour) {return age-1;}
		}
		
		return age;
	}
	
	public void nbJours(int nb)
	{
		jour= jour + nb;
		
		while (jour > nbJourMax(mois, annee))
		{
			jour = jour - nbJourMax(mois, annee);
			mois++;
			if (mois > 12) { mois=1; annee++;}
		}
	}
}
