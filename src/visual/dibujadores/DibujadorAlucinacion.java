package visual.dibujadores;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;
import modelo.unidades.Unidad;
import modelo.unidades.Unidades;
import modelo.unidades.protos.UnidadesProtos;
import visual.vistas.VistaAlucinacion;

public class DibujadorAlucinacion extends Dibujador {
	
	Map<Unidades, String> imagenes = new HashMap<Unidades, String>();
	
	public DibujadorAlucinacion(){
		imagenes.put(UnidadesProtos.ZEALOT, pathTexturas + "zealot.png");
		imagenes.put(UnidadesProtos.ALTO_TEMPLARIO, pathTexturas + "alto_templario.png");
		imagenes.put(UnidadesProtos.DRAGON, pathTexturas + "dragon.png");
		imagenes.put(UnidadesProtos.NAVE_DE_TRANSPORTE, pathTexturas + "nave_transporte_protoss.png");
		imagenes.put(UnidadesProtos.SCOUT, pathTexturas + "scout.png");
		
	}
	
	private void setearImagen(Unidad aDibujar){
		String urlImagen = imagenes.get(aDibujar.getNombre());
		if(imagenes.isEmpty()){
			(new Exception()).printStackTrace();
		}
		
		this.imagen = createImageIcon(urlImagen, "");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion){
		Unidad unidad = (Unidad) aDibujar;
		setearImagen(unidad);
		return new  VistaAlucinacion(unidad, posicion, imagen) ;
	}
}
