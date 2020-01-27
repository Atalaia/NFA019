package Serie61;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import IPane.ES;

public class FrameMenuGeneral extends JFrame implements ActionListener {

	private JButton articles,commandes,fin;
	
	public FrameMenuGeneral()
	{
		setLayout(new GridLayout(3,1,10,10));
		setSize(350,250);
		setTitle(" MENU GENERAL ");
	
		articles= new JButton(" GESTION DES ARTICLES ");
		commandes= new JButton( " GESTION DES COMMANES ");
		fin= new JButton(" FIN ");
		
		add(articles); articles.addActionListener(this);
		add(commandes); commandes.addActionListener(this);
		add(fin); fin.addActionListener(this);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		try{
			if(event.getSource()==articles) new FrameGestionTableArticle();
			if(event.getSource()==commandes) new FrameGestionCommandes();
			if(event.getSource()==fin) {ES.affiche(" AU REVOIR "); setVisible(false);}
		}catch (Exception e){}
		}
	
}
