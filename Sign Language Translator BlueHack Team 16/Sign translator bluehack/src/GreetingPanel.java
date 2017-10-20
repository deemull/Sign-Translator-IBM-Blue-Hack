import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GreetingPanel extends JFrame {
	
	private JPanel greetingPanel1;
	private JLabel team;
	
	private JPanel buttonPanel;
	private JButton ok;
	
	private JPanel greetingPanel2;
	private JLabel ibm;
	
	private JPanel emptyPanel = new JPanel();
	
	

	public GreetingPanel()
	{
		setTitle("Sign and Language Translator");
		setLayout(new GridLayout(3,1));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGreetingPanel1();
		buildGreetingPanel2();
		buildButtonPanel();
		add(greetingPanel1);
		add(greetingPanel2);
		//add(emptyPanel);
		add(buttonPanel);
		pack();
		setVisible(true);
	}
	
	private void buildGreetingPanel1()
	{
		greetingPanel1 = new JPanel();
		ImageIcon teamImg = new ImageIcon("images\\teamImg.jpg");
		team = new JLabel(teamImg);	          
		greetingPanel1.add(team);
		
	}
	
	private void buildGreetingPanel2()
	{
		greetingPanel2 = new JPanel();
		ImageIcon ibmImg = new ImageIcon("images\\ibmImg.jpg");
		ibm = new JLabel(ibmImg);
		greetingPanel2.add(ibm);
			
	}
	
	private void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		ok = new JButton("Please Click me to PROCEED");
		ok.addActionListener( new OK());
		
		buttonPanel.add(ok);
	}
	
	private class OK implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			new Options();
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args)
	{
		new GreetingPanel();
	}

}
