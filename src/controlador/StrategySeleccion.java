package controlador;

import modelo.Juego;
import modelo.construcciones.Construccion;
import modelo.exception.FueraDeLimitesException;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import modelo.propiedad.Propiedad;
import modelo.unidades.Unidad;

public class StrategySeleccion implements StrategyAccion {

	@Override
	public void accionSuelo(Coordenada posicion, Juego juego,Controlador controlador) {
		Terreno terrenoElegido;
		try {
			terrenoElegido = juego.obtenerTerreno(posicion);
			Propiedad objetoEnSuelo = terrenoElegido.getContenidoSuelo();
			controlador.escribirEnLog("Seleccionado posicion(x/y):"+posicion.getX()+"/"+posicion.getY());
			if(objetoEnSuelo == null){
				controlador.ofrecerConstruccionesDisponibles(terrenoElegido);
			}else if(objetoEnSuelo instanceof Unidad){
				controlador.ofrecerAccionesParaUnidad((Unidad)objetoEnSuelo);
			}else if(objetoEnSuelo instanceof Construccion){
				controlador.ofrecerAccionesParaEdificio((Construccion)objetoEnSuelo);
			}
		} catch (FueraDeLimitesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
