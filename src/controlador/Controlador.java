package controlador;

import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.construcciones.Construccion;
import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EnumEdificios;
import modelo.exception.CoordenadaInexistenteException;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.exception.RecursosNegativosException;
import modelo.exception.UnidadIncompletaException;
import modelo.jugador.Colores;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import modelo.propiedad.Propiedad;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadAtacante;
import modelo.unidades.Unidades;
import visual.Algocraft;
import visual.VentanaErrorFatal;
import visual.VentanaIngresoDeDatosJugador;
import visual.Ventanas;

public class Controlador {
	
	private Algocraft aplicacion;
	private Juego juego;
	private StrategyAccion estrategia;

	public Controlador(Algocraft aplicacion, Juego juego){
		AccionesAlgocraft.setearControlador(this);
		MiControladorMouse.setearControlador(this);
		this.aplicacion = aplicacion;
		this.juego = juego;
		estrategia = new StrategySeleccion();
	}
	
	public void setStrategyAccion(StrategyAccion strategy) {
	
		estrategia = strategy;
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
	
	public void pasarTurno() {
		try {
			juego.pasarTurno();
		} catch (DestinoInvalidoException e) {
			(new VentanaErrorFatal("Destino invalido")).setVisible(true);
		} catch (FueraDeLimitesException e) {
			(new VentanaErrorFatal("Fuera de limites")).setVisible(true);
		} catch (PropiedadNoEstaEnJuegoException e) {
			(new VentanaErrorFatal("Unidad o construccion fuera de juego")).setVisible(true);
		} catch (UnidadIncompletaException e) {
			(new VentanaErrorFatal("Unidad mal inicializada")).setVisible(true);
		}		
	}

	public void accionCielo(Coordenada posicion) throws FueraDeLimitesException {
		Terreno terrenoElegido = juego.obtenerTerreno(posicion);
		Propiedad objetoEnCielo = terrenoElegido.getContenidoCielo();
		if(objetoEnCielo instanceof Unidad){
			ofrecerAccionesParaUnidad((Unidad)objetoEnCielo);
		}
	}

	public void accionSuelo(Coordenada posicion) throws FueraDeLimitesException {
		estrategia.accionSuelo(posicion, juego, this);
	}
	
	protected JToolBar obtenerToolbarAccionesLimpo() {
		JToolBar acciones = aplicacion.ventanaJuego.getAcciones();
		acciones.removeAll();
		acciones.repaint();
		return acciones;
	}

	protected void ofrecerAccionesParaEdificio(Construccion construccion) {
		if(construccion instanceof CreadorDeUnidades){
			CreadorDeUnidades creador = (CreadorDeUnidades)construccion;
			Set<Unidades> unidadesCreables = creador.getUnidadesCreables();
			JToolBar acciones = obtenerToolbarAccionesLimpo();
			for(Iterator<Unidades> it = unidadesCreables.iterator(); it.hasNext(); ){
				Unidades nombreUnidad = it.next();
				JButton btnNewButton = new JButton(nombreUnidad.toString());
				btnNewButton.addActionListener(new AccionCrearUnidad(nombreUnidad, creador));
				acciones.add(btnNewButton);
			}
		}
		
	}
	
	protected void ofrecerAccionesParaUnidad(Unidad unidad) {
		JToolBar acciones = obtenerToolbarAccionesLimpo();
		
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new AccionMoverUnidad(unidad));
		acciones.add(btnMover);
		
		JButton btnAtacar = new JButton("Atacar");
		btnMover.addActionListener(new AccionAtacar((UnidadAtacante) unidad));
		acciones.add(btnAtacar);
		
	}

	protected void ofrecerConstruccionesDisponibles(Terreno terreno) {
		Set<EnumEdificios> edificiosProbables = juego.getJugadorActual().getConstruccionesDisponibles();
		JToolBar acciones = obtenerToolbarAccionesLimpo();
		for(Iterator<EnumEdificios> it = edificiosProbables.iterator(); it.hasNext();){
			EnumEdificios nombreEdificio = it.next();
			JButton btnNewButton = new JButton(nombreEdificio.toString());
			btnNewButton.addActionListener(new AccionCrearEdificio(nombreEdificio, terreno.getCoordenada()));
			acciones.add(btnNewButton);
		}
	}

	public void construirEn(EnumEdificios nombreEdificio, Coordenada posicion) {
		try {
			juego.construirEn(nombreEdificio, posicion);
		} catch (DestinoInvalidoException e) {
			(new VentanaErrorFatal("Destino invalido")).setVisible(true);
		} catch (FueraDeLimitesException e) {
			(new VentanaErrorFatal("Fuera de limites")).setVisible(true);
		} catch (MineralInsuficienteException e) {
			//TODO este error no es fatal
			e.printStackTrace();
			(new VentanaErrorFatal("Fuera de limites")).setVisible(true);
		} catch (GasInsuficienteException e) {
			//TODO este error no es fatal
			e.printStackTrace();
			(new VentanaErrorFatal("Fuera de limites")).setVisible(true);
		} catch (DependenciasNoCumplidasException e) {
			//// mostrar mensajes 
			e.printStackTrace();
		} catch (RecursosNegativosException e) {
			(new VentanaErrorFatal("Recursos negativos")).setVisible(true);
		}		
	}

	public void crearUnidad(Unidades nombreUnidad, CreadorDeUnidades creador) {
		try {
			juego.crearUnidad(creador, nombreUnidad);
		} catch (MineralInsuficienteException e) {
			//  mostrar mensajes
			e.printStackTrace();
		} catch (GasInsuficienteException e) {
			//  mostrar mensajes
			e.printStackTrace();
		} catch (PoblacionInsuficienteException e) {
			//  mostrar mensajes
			e.printStackTrace();
		} catch (RecursosNegativosException e) {
			// mostrar mensajes
			e.printStackTrace();
		}		
	}

	public void moverUnidad(Unidad unidad, Coordenada coordenada2) {
		try {
			juego.moverUnidad(unidad, coordenada2);
		} catch (PropiedadNoEstaEnJuegoException e) {
			// mostrar mensajes
			e.printStackTrace();
		} catch (CoordenadaInexistenteException e) {
			// mostrar mensajes
			e.printStackTrace();
		} catch (PropiedadNoExisteEnEstaUbicacion e) {
			// mostrar mensajes
			e.printStackTrace();
		} catch (DestinoInvalidoException e) {
			// mostrar mensajes
			e.printStackTrace();
		}		
	}

	public void realizarAtaque(UnidadAtacante unidad, Coordenada posicionAtacado) {
		try {
			juego.realizarAtaque(unidad,posicionAtacado);
		} catch (FueraDeLimitesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
