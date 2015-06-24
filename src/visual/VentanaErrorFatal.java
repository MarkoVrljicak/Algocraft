package visual;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import controlador.CerrarAplicacionListener;

@SuppressWarnings("serial")
public class VentanaErrorFatal extends JDialog {
	
	private final JButton botonSalida = new JButton("Salir");
	String mensaje;
	public VentanaErrorFatal(String mensaje) {
		this.mensaje = mensaje;
		
		botonSalida.addActionListener(new CerrarAplicacionListener());
		
		JLabel str1 = new JLabel("Error", SwingConstants.CENTER);
		
		JLabel str2 = new JLabel(mensaje, SwingConstants.CENTER);
		
		JLabel str3 = new JLabel("El programa debera cerrarse.", SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(botonSalida, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(144)
					.addComponent(str1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(str3)
					.addContainerGap(82, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(str2, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(str1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(str2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(str3)
					.addGap(40)
					.addComponent(botonSalida))
		);
		getContentPane().setLayout(groupLayout);
		
		this.pack();
		this.setModal(true);
	}
}
