import javax.swing.*;
import java.awt.event.*;
public class DialogoImporte extends JDialog implements ActionListener{
	private JLabel label1, label2;
	private JButton boton1;
	
	public DialogoImporte(String marca, float total) {
		setLayout(null);
		setResizable(false);
		setModal(true);
		label1=new JLabel("Celular: "+marca);
		label1.setBounds(10,10, 150, 30);
		add(label1);
		label2=new JLabel("Total: $"+total);
		label2.setBounds(10, 40, 90, 30);
		add(label2);
		boton1=new JButton("Ok");
		boton1.setBounds(10, 80, 50, 30);
		boton1.addActionListener(this);
		add(boton1);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			dispose();
		}
	}
}
