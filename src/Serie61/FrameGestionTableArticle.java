package Serie61;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import IPane.ES;
import Serie51.*;

public class FrameGestionTableArticle extends JFrame implements ActionListener {
	
	private JButton creation,suppression,affichage,fin;
	
	//private TableDesArticles51 tabArt;
	//public FrameGestionTableArticle(TableDesArticles51 tabArt)
	
	private TableDesArticles51 tabArt = new TableDesArticles51();
	
	public FrameGestionTableArticle()
	{
		//je recupere la tabledesarticles que je passe en parametre dans tabArt
		this.tabArt=tabArt;
		
		setLayout(new GridLayout(4,1,10,10));
		setSize(350,250);
		setTitle(" GESTION DES ARTICLES");
		
		creation= new JButton(" CREATION ");
		suppression= new JButton( " SUPPRESSION ");
		affichage= new JButton( " AFFICHAGE ");
		fin= new JButton(" FIN ");
		
		//les boutons sont crees et maintenant je vais les ajouter dans la frame avec l'action à ecouter
		
		add(creation); creation.addActionListener(this);
		add(suppression); suppression.addActionListener(this);
		add(affichage); affichage.addActionListener(this);
		add(fin); fin.addActionListener(this);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
	try{
		if(event.getSource()==affichage) afficher(tabArt);
		if(event.getSource()==creation) //new FrameArticle(tabArt);
		if(event.getSource()==suppression) supprimer(tabArt);
		if(event.getSource()==fin) {ES.affiche(" AU REVOIR "); setVisible(false);}
	}catch (Exception e){}
	}
		
		public void afficher(TableDesArticles51 tabArt)
		{
			ES.affiche(" TABLE DES ARTICLES " + tabArt.toString());
		}
		
		public void supprimer(TableDesArticles51 tabArt) throws Exception
		{
			int code= ES.saisie(" QUEL CODE VOULEZ SUPPRIMER?" + tabArt.cle(),1,9999);
			
			if(tabArt.retourner(code) != null) tabArt.supprimer(code);
		}

}
