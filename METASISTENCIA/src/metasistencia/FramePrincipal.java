package metasistencia;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FramePrincipal extends JFrame{
	
	static Login panelInicio;
	
	
	public FramePrincipal(){

	
	setTitle("MetAsistencia");
	this.setLayout(null);
	panelInicio = new Login(this);
	panelInicio.setLayout(null);
	this.setContentPane(panelInicio);
	panelInicio.setVisible(true);
	
	
	
	}
	
	//Cambios de panel
	public void cambiarPanel(JPanel panel){
		this.getContentPane().setVisible(false);
		panel.setBounds(this.getBounds());
		this.setContentPane(panel);
		panel.setVisible(true);
	}

}