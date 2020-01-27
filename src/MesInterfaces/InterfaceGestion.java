package MesInterfaces;

//pour gérer une structure, il faut utiliser deux ou trois autres structures, typestructure à gerer et le type de structure dont on a besoin pour gerer

public interface InterfaceGestion <TypeStructure1, TypeStructure2>
{
	public abstract void menuGeneral(TypeStructure1 tab1, TypeStructure2 tab2) throws Exception;

	public abstract int menuChoix() throws Exception;
	
	public abstract void ajouter(TypeStructure1 tab1, TypeStructure2 tab2) throws Exception;
	public abstract void supprimer(TypeStructure1 tab1, TypeStructure2 tab2) throws Exception;
	
	public abstract void afficher(TypeStructure1 tab1) throws Exception;
	
}
