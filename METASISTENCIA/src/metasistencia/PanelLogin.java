package metasistencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.AsignaturaDAO;
import DAO.ProfesorDAO;
import metodos.Contrasenya;
import model.Asignatura;
import model.Profesor;

import java.awt.Font;


public class PanelLogin extends JPanel implements ActionListener{

	//Declaracion de componentes
		FramePrincipal framePrincipal;
		
		private JLabel lProfesor, lContrasenya,imagen;
		private JButton bAcceder;
		private JPasswordField tfPass;
		
		private JComboBox cProfesor;

		Font fuente = new Font("Century Gothic", Font.BOLD, 20);
		
		/*Constructor*/
		public PanelLogin(JFrame framePrincipal){
			
			ProfesorDAO profesorDAO = new ProfesorDAO();
			this.framePrincipal.profesores = profesorDAO.findAll();
			Profesor[] arrayProfesores = new Profesor[this.framePrincipal.profesores.size()];
			for(int i=0;i<this.framePrincipal.profesores.size();i++){
				arrayProfesores[i] = this.framePrincipal.profesores.get(i);
			}
			
			//Inicializar
			
			this.setLayout(null);
			this.framePrincipal = (FramePrincipal) framePrincipal;
			
			
			//Creacion de componentes
			cProfesor = new JComboBox(arrayProfesores);
			cProfesor.setFont(fuente);
			tfPass = new JPasswordField();
			bAcceder = new JButton("Acceder");
			bAcceder.setFont(fuente);
			lProfesor = new JLabel("Profesor");
			lProfesor.setFont(fuente);
			lContrasenya = new JLabel("Contrase�a");
			lContrasenya.setFont(fuente);
			
			
			//Posicionamiento de los componentes
			cProfesor.setBounds(306, 102, 237, 43);		
			tfPass.setBounds(306, 165, 237, 28);
			bAcceder.setBounds(266, 240, 143, 52);
			lProfesor.setBounds(116, 109, 130, 28); 
			lContrasenya.setBounds(116, 165, 130, 28);
			
			//A�adir al panel los componentes
			this.add(cProfesor);
			this.add(tfPass);
			this.add(bAcceder);
			this.add(lProfesor);
			this.add(lContrasenya);
			
			
			//metodos listener
			cProfesor.addActionListener(this);
			bAcceder.addActionListener(this);
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bAcceder)){
				
				ProfesorDAO profesorDAO = new ProfesorDAO();
				AsignaturaDAO asignaturaDAO = new AsignaturaDAO();


				String user, pass = null;
				user = cProfesor.getToolTipText();
				try {
					pass = Contrasenya.encriptarContrasenya(String.valueOf(tfPass.getPassword()));
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
				framePrincipal.profesorConectado = profesorDAO.check_login(user, pass);

				if (framePrincipal.profesorConectado == null) {
					Object[] textoError = { "Ok" };

					JOptionPane.showMessageDialog(null,
							"Usuario y Contrase�a no corresponden.", "Inane error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					framePrincipal.asignaturas = asignaturaDAO.findByProfesor(framePrincipal.profesorConectado.getId());
				}			
			}
			framePrincipal.cambiarPanel(new PanelAsignatura(framePrincipal));
		}

}
