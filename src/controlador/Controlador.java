package controlador;

import modelo.Juego;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.UnidadIncompletaException;
import modelo.jugador.Colores;
import modelo.mapa.Coordenada;
import modelo.razas.EnumRazas;
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
		EnumRazas razaElegida = null;
		Colores colorElegido = null;
		//validar nombre
		
		
		if(ventanaDatos.opcionTerran.isSelected()){
			razaElegida = EnumRazas.TERRAN;
		}else if(ventanaDatos.opcionProtoss.isSelected()){
			razaElegida = EnumRazas.PROTOSS;
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
		
		ventanaDatos.lblSetUpJugador.setText("Set Up Jugador 2");
		ventanaDatos.nombreJugador.setText("");
		ventanaDatos.ColorBtnGroup.clearSelection();
		ventanaDatos.RazaBtnGroup.clearSelection();
		ventanaDatos.btnContinuar.removeAll();
		ventanaDatos.btnContinuar.addActionListener(new SubmitDatosJugador2());
	}
	
	public void validarDatosJugador2() {
		VentanaIngresoDeDatosJugador ventanaDatos = aplicacion.ventanaDatosJugador;
		String nombreIngresado = ventanaDatos.nombreJugador.getText();
		EnumRazas razaElegida = null;
		Colores colorElegido = null;
		//validar nombre
		
		
		if(ventanaDatos.opcionTerran.isSelected()){
			razaElegida = EnumRazas.TERRAN;
		}else if(ventanaDatos.opcionProtoss.isSelected()){
			razaElegida = EnumRazas.PROTOSS;
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

	public void realizarAccionPara(Coordenada posicion) {
		//toma la posicion y acorde al strategy hace algo con juego	
	}

	public void pasarTurno() {
		try {
			juego.pasarTurno();
		} catch (DestinoInvalidoException e) {
			// TODO Avisar en ventana de error
		} catch (FueraDeLimitesException e) {
			// TODO Avisar en ventana de error
		} catch (PropiedadNoEstaEnJuegoException e) {
			// TODO Avisar en ventana de error
		} catch (UnidadIncompletaException e) {
			// TODO Avisar en ventana de error
		}		
	}
}
