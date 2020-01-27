package Serie61;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import IPane.ES;
import Serie51.*;

public class FrameGestionCommandes extends JFrame implements ActionListener {

private JButton creation,suppression,facturation,affichage,fin;
	
	private TableDesCommandes tabCde = new TableDesCommandes();
	
	public FrameGestionCommandes()
	{
		this.tabCde=tabCde;
		
		setLayout(new GridLayout(5,1,10,10));
		setSize(350,250);
		setTitle(" GESTION DES COMMANDES");
		
		creation= new JButton(" CREATION ");
		suppression= new JButton( " SUPPRESSION ");
		facturation= new JButton( " FACTURATION ");
		affichage= new JButton( " AFFICHAGE ");
		fin= new JButton(" FIN ");
		
		
		add(creation); creation.addActionListener(this);
		add(suppression); suppression.addActionListener(this);
		add(facturation); facturation.addActionListener(this);
		add(affichage); affichage.addActionListener(this);
		add(fin); fin.addActionListener(this);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
	try{
		if(event.getSource()==affichage) {afficher(tabCde);}
		if(event.getSource()==creation) {ES.affiche("Vous avez choisi CREATION. En cours de construction");}
		if(event.getSource()==suppression) {supprimer(tabCde);}
		if(event.getSource()==facturation) {ES.affiche("Vous avez choisi FACTURATION. En cours de construction");}
		if(event.getSource()==fin) {ES.affiche(" AU REVOIR "); setVisible(false);}
		}catch (Exception e){}
	}
		
		public void afficher(TableDesCommandes tabCde)
		{
			ES.affiche(" TABLE DES COMMANDES " + tabCde.toString());
		}
		
		public void supprimer(TableDesCommandes tabCde) throws Exception
		{
			String code= ES.saisie(" QUEL COMMANDE VOULEZ SUPPRIMER?" + tabCde.cle());
			
			if(tabCde.retourner(code) != null) tabCde.supprimer(code);
		}
}
