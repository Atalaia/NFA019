package Serie61;

import javax.swing.*;

import IPane.ES;

import java.awt.event.*;
import java.awt.*;

//comme cette classe est une frame il faut qu'il hérite de la classe jframe, comme c'est une frame hérite de la classe jframe
//il y aura des actions, on va agir sur la frame donc il faut que cette frame implémente actionlistener pour écouter les actions et
//puis pour pouvoir les traiter, sinon on pourra pas agir sur les actions

public class FrameIdentification extends JFrame implements ActionListener {
	
	//je met tout ce qui est editable en variable d'instance
	private JTextField login;
	private JPasswordField pwd;
	private JButton valid;

	//pour declarer la frame il faut dire quelle est la bordure de la frame
	public FrameIdentification() 
	{
		//on definir la bordure de la grille
		//3 panel, 2 composants, 10, 10 largeur, hauteur de chaque composant
		setLayout(new GridLayout(3,2,10,10));
		
		// dimensions de la grille
		setSize(300,200);
		
		//definir le titre du jpanel
		setTitle( " FRAME IDENTIFICATION ");
		JPanel panel1, panel2, panel3;
		panel1 = new JPanel(); //premier panel contient un label et un textfield
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		JLabel ident = new JLabel (" login : ");
		login = new JTextField(10); //longueur 10
		
		//je preparais le 1er panel et maintenant je vais ajouter ces composants dans le 1er panel
		//addActionListener pour écouter ce que j'ai écris dans le login, pour traiter ce que j'ai écouté je le traite dans actionPerformed
		//et puis je vais ajouter ce panel dans la frame, après avoir écouté
		
		panel1.add(ident); panel1.add(login); login.addActionListener(this);
		this.add(panel1);
		
		JLabel lab2 = new JLabel(" password : ");
		pwd = new JPasswordField(10);
		panel2.add(lab2); panel2.add(pwd); pwd.addActionListener(this);
		add(panel2);
		
		valid = new JButton( " VALIDER ");
		panel3.add(valid); valid.addActionListener(this);
		add(panel3);
		
		//pour ramener la frame au milieu
		setLocationRelativeTo(null);
		
		//tous les frames sont preprares, donc il faut juste rendre visible cette frame
		setVisible(true);
		
		//comme ça quand on ferme la frame l'opération s'arrête
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//ici on va traiter l'action
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == valid)
		{
			//je vais recuperer ce que j'ai saisi dans le login dans l'ident
			
			String ident =login.getText();
			
			//maintenant ce que j'ai saisi dans le password
			char[] mdpT = pwd.getPassword();
			
			//getPassword renvoie un tableau de char et maintenant je convertie le tableau de caracteres en chaine de carateres
			String mdp = conv(mdpT);
			if(valid(ident,mdp)){ //ES.affiche(" IDENTIFICATION OK");
				new FrameMenuGeneral();
				this.setVisible(false);
		}
			else ES.affiche(" PB IDENTIFICATION !!!");
			raz();
		}
	}
	
	public String conv(char[] tab)
	{
		String res = "";
		for(int i=0; i<tab.length;i++) res=res+tab[i];
		return res;
	}
	
	public boolean valid(String ident, String mdp)
	{
		return (ident.equals("PSI") && mdp.equals("PSI"));
	}
	
	//la fonction raz sert à reinitialiser, remise à 0 des champs
	public void raz()
	{
		login.setText(""); pwd.setText("");
	}
	
}

//ajouter des controles, ex. si le login est vide, peut pas cliquer sur valider
