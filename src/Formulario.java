import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Formulario extends JFrame implements ActionListener, ChangeListener, ItemListener{
	private JLabel lmarca;
	private JComboBox cbmarca;
	private JLabel ltipo;
	private JRadioButton rgamab, rgamam, rgamaa;
	private ButtonGroup marcabg;
	private JLabel lmem;
	private JRadioButton r8gb, r16gb, r32gb;
	private ButtonGroup membg;
	private JCheckBox checkvid,checkfun;
	private JButton bimporte, bdialogo, bsalir;
	private JLabel ltotal;
	private String marcanom;
	float cel, gama, mem, vidrio, funda, total;
	
	
	public Formulario(){
		setLayout(null);
		marcanom="0";
		cel=0.00F;
		gama=0.00F;
		vidrio=0.00F;
		funda=0.00F;
		total=0.00F;
		lmarca=new JLabel("Selecciones marca: ");
		lmarca.setBounds(100, 10, 130, 30);
		add(lmarca);
		cbmarca=new JComboBox();
		cbmarca.setBounds(230, 10, 130,30);
		add(cbmarca);
		cbmarca.addItem("Opciones");
		cbmarca.addItem("IPHONE");
		cbmarca.addItem("SAMSUNG");
		cbmarca.addItem("MOTOROLA");
		cbmarca.addItemListener(this);
		ltipo=new JLabel("Seleccione el tipo:");
		ltipo.setBounds(10,50, 125, 30);
		add(ltipo);
		marcabg=new ButtonGroup();
		rgamab=new JRadioButton("  Gama Baja");
		rgamab.setBounds(120, 50, 100, 30);
		rgamab.addChangeListener(this);
		add(rgamab);
		marcabg.add(rgamab);
		rgamam=new JRadioButton("  Gama Media");
		rgamam.setBounds(220, 50, 110, 30);
		rgamam.addChangeListener(this);
		add(rgamam);
		marcabg.add(rgamam);
		rgamaa=new JRadioButton("  Gama Alta");
		rgamaa.setBounds(330, 50, 100, 30);
		rgamaa.addChangeListener(this);
		add(rgamaa);
		marcabg.add(rgamaa);
		lmem=new JLabel("Memoria:");
		lmem.setBounds(20,90,70,30);
		add(lmem);
		membg=new ButtonGroup();
		r8gb=new JRadioButton("     8 Gb");
		r8gb.setBounds(15, 110, 80, 30);
		r8gb.addChangeListener(this);
		add(r8gb);
		membg.add(r8gb);
		r16gb=new JRadioButton("     16 Gb");
		r16gb.setBounds(15, 140, 90, 30);
		r16gb.addChangeListener(this);
		add(r16gb);
		membg.add(r16gb);
		r32gb=new JRadioButton("     32Gb");
		r32gb.setBounds(15, 170, 90, 30);
		r32gb.addChangeListener(this);
		add(r32gb);
		membg.add(r32gb);
		checkvid=new JCheckBox("Vidrio Templado");
		checkvid.setBounds(200, 110, 120, 30);
		checkvid.addChangeListener(this);
		add(checkvid);
		checkfun=new JCheckBox("Funda Protectora");
		checkfun.setBounds(200, 140, 140, 30);
		checkfun.addChangeListener(this);
		add(checkfun);
		bimporte=new JButton("Calcular Importe");
		bimporte.setBounds(130, 180, 150, 35);
		bimporte.addActionListener(this);
		add(bimporte);
		bdialogo=new JButton("Ver Diálogo");
		bdialogo.setBounds(130, 220, 150, 35);
		bdialogo.addActionListener(this);
		add(bdialogo);
		ltotal=new JLabel("0.00");
		ltotal.setBounds(350, 180, 60, 35);
		ltotal.setFont(new Font("Arial", Font.BOLD, 15));
		ltotal.setBackground(Color.white);
		add(ltotal);
		bsalir=new JButton("Salir");
		bsalir.setBounds(290, 220, 150, 35);
		bsalir.addActionListener(this);
		add(bsalir);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cbmarca) {
			if(cbmarca.getSelectedItem()=="IPHONE") {
				cel=250.00F;
				marcanom="IPHONE";
			}
			if(cbmarca.getSelectedItem()=="SAMSUNG") {
				cel=200.00F;
				marcanom="SAMSUNG";
			}
			if(cbmarca.getSelectedItem()=="MOTOROLA") {
				cel=180.00F;
				marcanom="SAMSUNG";
			}
		}
	}
	
	public void stateChanged(ChangeEvent e) {
		if(rgamab.isSelected()) {
			gama=0.00F;
		}
		if(rgamam.isSelected()) {
			gama=10.00F;
		}
		if(rgamaa.isSelected()) {
			gama=30.00F;
		}
		if(r8gb.isSelected()) {
			mem=30.00F;
		}
		if(r16gb.isSelected()) {
			mem=60.00F;
		}
		if(r32gb.isSelected()) {
			mem=90.00F;
		}
		if(checkvid.isSelected()==true) {
			vidrio=3.00F;
		}else {
			if(checkvid.isSelected()==false) {
				vidrio=0.00F;
			}
		}
		if(checkfun.isSelected()==true) {
			funda=5.00F;
		}else {
			if(checkfun.isSelected()==false) {
				funda=0.00F;
			}
			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bimporte) {
			if(cel==0.00F) {
				setTitle("Seleccione una Marca");
			}else {
				total= cel + ((cel/100)*gama) + vidrio + funda+mem;
				ltotal.setText(String.valueOf(total));
			}
		}
		
		if(e.getSource()==bdialogo) {
			if(total==0.00F) {
				setTitle("Calcule el importe");
			}else {
			     DialogoImporte di=new DialogoImporte(marcanom, total);
			     di.setBounds(10,10,200,120);
			     di.setVisible(true);
			}
		}
			
		if(e.getSource()==bsalir) {
			System.exit(0);
		}
	}
	
	

	public static void main (String[]ar) {
		Formulario f1=new Formulario();
		f1.setBounds(10,10,500,335);
		f1.setVisible(true);
	}
}