package controlador;

import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import controlador.acciones.AccionesAlgocraft;
import modelo.Juego;
import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EnumEdificios;
import modelo.exception.ColorRepetidoExepcion;
import modelo.exception.CoordenadaInexistenteException;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.EdificioTodaviaEnConstruccionException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.MinimoCuatroCaracteresException;
import modelo.exception.NombreRepetidoExepcion;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.exception.RecursosNegativosException;
import modelo.exception.UnidadIncompletaException;
import modelo.jugador.Colores;
import modelo.mapa.Coordenada;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadAtacante;
import modelo.unidades.Unidades;
import visual.Algocraft;
import visual.Seleccionable;
import visual.VentanaErrorFatal;
import visual.VentanaIngresoDeDatosJugador;
import visual.Ventanas;

public class Controlador {
	
	private Algocraft aplicacion;
	private Juego juego;
	private StrategyAccion estrategiaClick;

	public Controlador(Algocraft aplicacion, Juego juego){
		AccionesAlgocraft.setearControlador(this);
		MiControladorMouse.setearControlador(this);
		this.aplicacion = aplicacion;
		this.juego = juego;
		estrategiaClick = new StrategySeleccion();
	}
	
	public void setStrategyAccion(StrategyAccion strategyClick) {
	
		estrategiaClick = strategyClick;
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
	
	public void escribirEnLog(String texto){
		aplicacion.ventanaJuego.escribirEnLog(texto);
	}

	public EnumRazas seleccionRaza(){
		VentanaIngresoDeDatosJugador ventanaDatos = aplicacion.ventanaDatosJugador;
		EnumRazas razaElegida = null;
		
		if(ventanaDatos.opcionTerran.isSelected()){
			razaElegida = EnumRazas.TERRAN;
		}else if(ventanaDatos.opcionProtoss.isSelected()){
			razaElegida = EnumRazas.PROTOSS;
		}		
		return razaElegida;
	}
	
	public Colores seleccionColor(){
		VentanaIngresoDeDatosJugador ventanaDatos = aplicacion.ventanaDatosJugador;
		Colores colorElegido = null;
		
		if(ventanaDatos.opcionRojo.isSelected()){
			colorElegido = Colores.ROJO;
			ventanaDatos.opcionRojo.setEnabled(false);
		}else if(ventanaDatos.opcionAzul.isSelected()){
			colorElegido = Colores.AZUL;
			ventanaDatos.opcionAzul.setEnabled(false);
		}
		return colorElegido;
	}
	
	public String nombreIngresado(){
		VentanaIngresoDeDatosJugador ventanaDatos = aplicacion.ventanaDatosJugador;
		return ventanaDatos.nombreJugador.getText();
	}
	
	public void ingresarDatosJugador1(String nombre, EnumRazas raza, Colores color) throws MinimoCuatroCaracteresException {
			juego.setJugador1(nombre, raza, color);
	}
	
	public void renovarIngresoDeDatos(){
		VentanaIngresoDeDatosJugador ventanaDatos = aplicacion.ventanaDatosJugador;
		
		ventanaDatos.lblSetUpJugador.setText("Set Up Jugador 2");
		ventanaDatos.nombreJugador.setText("");
		ventanaDatos.ColorBtnGroup.clearSelection();
		ventanaDatos.RazaBtnGroup.clearSelection();
		ventanaDatos.btnContinuar.removeAll();
		ventanaDatos.btnContinuar.addActionListener(new SubmitDatosJugador2());
	}
	
	public void ingresarDatosJugador2(String nombre, EnumRazas raza, Colores color) throws MinimoCuatroCaracteresException, NombreRepetidoExepcion, ColorRepetidoExepcion {
		juego.setJugador2(nombre, raza, color);	
	}
	
	public void iniciarJuego(){
		try {
			juego.iniciarJuego();
		} catch (DestinoInvalidoException | FueraDeLimitesException
				| MineralInsuficienteException | GasInsuficienteException
				| DependenciasNoCumplidasException | RecursosNegativosException e) {
			// Ninguno deberia suceder.
			nuevoMensajeFatal("Error de inicializacion");
		}
		this.cambiarVentanaA(Ventanas.JUEGO);	
	}
	
	public void pasarTurno() {
		try {
			juego.pasarTurno();
			if(juego.hayGanador()){
				JOptionPane.showMessageDialog(aplicacion.getFrame(),"El Jugador:"+juego.getNombreGanador()+" ha ganado.");
			}
			
		} catch (DestinoInvalidoException e) {
			nuevoMensajeFatal("Destino invalido");
		} catch (FueraDeLimitesException e) {
			nuevoMensajeFatal("Fuera de limites");
		} catch (PropiedadNoEstaEnJuegoException e) {
			nuevoMensajeFatal("Unidad o construccion fuera de juego");
		} catch (UnidadIncompletaException e) {
			nuevoMensajeFatal("Unidad mal inicializada");
		}		
	}
	
	public void accionPara(Seleccionable accionado) {
		estrategiaClick.accionPara(accionado, juego, this);
	}


	protected JToolBar obtenerToolbarAccionesLimpio() {
		JToolBar acciones = aplicacion.ventanaJuego.getAcciones();
		acciones.removeAll();
		acciones.repaint();
		return acciones;
	}


	public void construirEn(EnumEdificios nombreEdificio, Coordenada posicion) {
		try {
			juego.construirEn(nombreEdificio, posicion);
		} catch (DestinoInvalidoException e) {
			nuevoMensaje("No Podes construir ahi");
		} catch (FueraDeLimitesException e) {
			nuevoMensajeFatal("Fuera de limites");
		} catch (MineralInsuficienteException e) {
			nuevoMensaje("Te falta mineral");
		} catch (GasInsuficienteException e) {
			nuevoMensaje("Te falta gas");
		} catch (DependenciasNoCumplidasException e) {
			nuevoMensaje("Te faltan los edificios anteriores");
		} catch (RecursosNegativosException e) {
			nuevoMensajeFatal("Recursos negativos");
		}		
	}

	public void crearUnidad(Unidades nombreUnidad, CreadorDeUnidades creador) {
		try {
			juego.crearUnidad(creador, nombreUnidad);
		} catch (MineralInsuficienteException e) {
			nuevoMensaje("Te falta mineral");
		} catch (GasInsuficienteException e) {
			nuevoMensaje("Te falta gas");
		} catch (PoblacionInsuficienteException e) {
			nuevoMensaje("Poblacion Insuficiente");
		} catch (RecursosNegativosException e) {
			nuevoMensajeFatal("Recursos negativos");
			e.printStackTrace();
		} catch (EdificioTodaviaEnConstruccionException e) {
			nuevoMensaje("Edificio en construccion");
		}		
	}

	public void moverUnidad(Unidad unidad, Coordenada coordenada2) {
		try {
			juego.moverUnidad(unidad, coordenada2);
			this.setStrategyAccion(new StrategySeleccion());
		} catch (PropiedadNoEstaEnJuegoException e) {
			nuevoMensajeFatal("No Existe Unidad ?");
			e.printStackTrace();
		} catch (CoordenadaInexistenteException e) {
			nuevoMensajeFatal("No Existe Destino, no se como lo cliqueaste..");
			e.printStackTrace();
		} catch (PropiedadNoExisteEnEstaUbicacion e) {
			nuevoMensajeFatal("La unidad no esta donde esta");
			e.printStackTrace();
		} catch (DestinoInvalidoException e) {
			nuevoMensaje("La unidad no puede moversa al destino");
			e.printStackTrace();
		}		
	}

	public void realizarAtaque(UnidadAtacante unidad, Coordenada posicionAtacado) {
		
		try {
			juego.realizarAtaque(unidad,posicionAtacado);
			this.setStrategyAccion(new StrategySeleccion());
			escribirEnLog(
					"Atacando con: "+unidad.getNombre().toString()
					+" a posicion:" +posicionAtacado.getX() +"/" +posicionAtacado.getY());
		} catch (FueraDeLimitesException e) {
			nuevoMensajeFatal("Fuera de limites");
		}
	}
	
	public void nuevoMensaje(String mensaje){
		JOptionPane.showMessageDialog(aplicacion.getFrame(),mensaje);
	}
	
	public void nuevoMensajeFatal(String mensaje){
		(new VentanaErrorFatal(mensaje)).setVisible(true);
	}

	
}
