package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InventarioButtons extends JButton implements ActionListener {
	ImageIcon X,O;
	byte value=0;
	/*
	0:nothing
	1:X
	2:O
	*/
	
	public InventarioButtons(){
//		X=new ImageIcon(this.getClass().getResource("X.png"));
//		O=new ImageIcon(this.getClass().getResource("O.png"));
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
