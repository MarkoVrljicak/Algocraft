package controlador;

import algocraft.Juego;
import algocraft.jugador.Colores;
import algocraft.razas.Protoss;
import algocraft.razas.Raza;
import algocraft.razas.Terran;
import visual.Algocraft;
import visual.VentanaIngresoDeDatosJugador;
import visual.Ventanas;

public class Controlador {
	
	private Algocraft aplicacion;
	private Juego juego;

	public Controlador(Algocraft aplicacion, Juego juego){
		AccionesAlgocraft.setearControlador(this);	
		this.aplicacion = aplicacion;
		this.juego = juego;
	}

	public void cambiarVentanaA(Ventanas enumVentana) {
		
		switch(enumVentana){
		case INGRESO_DATOS_JUGADOR:
			aplicacion.ventanaInicial.setVisible(false);
			aplicacion.ventanaJuego.setVisible(false);
			aplicacion.ventanaDatosJugador.setVisible(true);
			break;
		case JUEGO:
			aplicacion.ventanaInicial.setVisible(false);
			aplicacion.ventanaDatosJugador.setVisible(false);
			aplicacion.ventanaJuego.setVisible(true);
			break;
		case VENTANA_INICIAL:
			aplicacion.ventanaDatosJugador.setVisible(false);
			aplicacion.ventanaJuego.setVisible(false);
			aplicacion.ventanaInicial.setVisible(true);
			break;
		}
		
	}

	public void validarDatosJugador1() {
		VentanaIngresoDeDatosJugador ventanaDatos = aplicacion.ventanaDatosJugador;
		String nombreIngresado = ventanaDatos.nombreJugador.getText();
		Raza razaElegida = null;
		Colores colorElegido = null;
		//validar nombre
		
		
		if(ventanaDatos.opcionTerran.isSelected()){
			razaElegida = new Terran();
		}else if(ventanaDatos.opcionProtoss.isSelected()){
			razaElegida = new Protoss();
		}//aniadir control al menos uno elegido
		
		if(ventanaDatos.opcionRojo.isSelected()){
			colorElegido = Colores.ROJO;
			ventanaDatos.opcionRojo.setEnabled(false);
		}else if(ventanaDatos.opcionAzul.isSelected()){
			colorElegido = Colores.AZUL;
			ventanaDatos.opcionAzul.setEnabled(false);
		}//aniadir control al menos uno elegido
		
		//si llego aca es que los datos son validos
		juego.setJugador1(nombreIngresado, razaElegida, colorElegido);
		
		ventanaDatos.lblSetUpJugador.setText("Set Up Jsugador 2");
		ventanaDatos.nombreJugador.setText("");
		ventanaDatos.ColorBtnGroup.clearSelection();
		ventanaDatos.RazaBtnGroup.clearSelection();
		ventanaDatos.btnContinuar.removeAll();
		ventanaDatos.btnContinuar.addActionListener(new SubmitDatosJugador2());
	}
	
	public void validarDatosJugador2() {
		VentanaIngresoDeDatosJugador ventanaDatos = aplicacion.ventanaDatosJugador;
		String nombreIngresado = ventanaDatos.nombreJugador.getText();
		Raza razaElegida = null;
		Colores colorElegido = null;
		//validar nombre
		
		
		if(ventanaDatos.opcionTerran.isSelected()){
			razaElegida = new Terran();
		}else if(ventanaDatos.opcionProtoss.isSelected()){
			razaElegida = new Protoss();
		}//aniadir control al menos uno elegido
		
		if(ventanaDatos.opcionRojo.isSelected()){
			colorElegido = Colores.ROJO;
			ventanaDatos.opcionRojo.setEnabled(false);
		}else if(ventanaDatos.opcionAzul.isSelected()){
			colorElegido = Colores.AZUL;
			ventanaDatos.opcionAzul.setEnabled(false);
		}//aniadir control al menos uno elegido
		
		//si llego aca es que los datos son validos
		juego.setJugador2(nombreIngresado, razaElegida, colorElegido);
		juego.iniciarJuego();
		this.cambiarVentanaA(Ventanas.JUEGO);
		
	}
}
