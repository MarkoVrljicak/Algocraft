package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DatosDelGrupo implements ActionListener {

	String informacionAplicacion="";
	
	public DatosDelGrupo(){
		informacionAplicacion="Esta es una aplicacion creada para Algoritmos 3 \n\n";
		informacionAplicacion+="Integrantes: \n";
		informacionAplicacion+="Dominguez,Lucas Nicolas - nicolas7885@hotmail.com \n";
		informacionAplicacion+="Duhalde, Agustin - agustinduhalde@hotmail.com \n";
		informacionAplicacion+="Vrljicak, Marko - marcos.vrljicak@gmail.com \n";
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, informacionAplicacion,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
	}

}
