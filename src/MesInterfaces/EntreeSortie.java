package MesInterfaces;

public interface EntreeSortie {

	public abstract int saisie(String mes, int inf, int sup) throws Exception; // il peut avoir des exceptions levees qu'on n'est pas obligés de traiter
	public abstract float saisie(String mes, float inf, float sup) throws Exception;
	
	public abstract void affiche(String mes);
	
	public abstract String saisie(String mes);
	
	public abstract char saisieChar(String mes);
	
	public abstract boolean saisieOuiNon(String mes);
}
