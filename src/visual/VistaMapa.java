package visual;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.ClickEnLugar;



@SuppressWarnings("serial")
public class VistaMapa extends JPanel {

	public VistaMapa(){
		super();
		setLayout(null);
		inicializarComponentes();
		this.setBounds(0, 0, 900, 900);
	}

	private void inicializarComponentes() {

		final int anchoCelda = 30;
		final int altoCelda = 30;
		for(int x = 1 ; x <= 30 ; x++){
			for(int y = 1 ; y <= 30 ; y++){
				JButton botonGenerico = new JButton("ClickEnLugar");
				botonGenerico.addActionListener(new ClickEnLugar(x,y));
				botonGenerico.setBounds((x-1)*anchoCelda,(y-1)*altoCelda,anchoCelda,altoCelda);
				botonGenerico.setVisible(false);
				this.add(botonGenerico);
			}
		}
		
	}
	
	
}
