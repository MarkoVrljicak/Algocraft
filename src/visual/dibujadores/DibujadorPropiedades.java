package visual.dibujadores;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import modelo.construcciones.Construccion;
import modelo.construcciones.EnumEdificios;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.propiedad.Propiedad;
import modelo.unidades.Unidad;
import modelo.unidades.Unidades;
import modelo.unidades.protos.UnidadesProtos;
import modelo.unidades.terran.UnidadesTerran;

@SuppressWarnings("rawtypes")
public class DibujadorPropiedades {
	
private static DibujadorPropiedades instance = null;
	
	public static DibujadorPropiedades getInstance(){
		if(instance == null)
			instance = new DibujadorPropiedades();
		
		return instance;
	}
	
	private HashMap<Enum,Dibujador> dibujadores;
	
	protected DibujadorPropiedades(){
		dibujadores = new HashMap<Enum, Dibujador>();
		
		dibujadores.put(EnumEdificiosTerran.BARRACA, new DibujadorBarraca());
		dibujadores.put(EnumEdificiosTerran.BASE_TERRAN, new DibujadorBaseTerran());
		dibujadores.put(EnumEdificiosTerran.CENTRO_DE_MINERALES, new DibujadorCentroDeMineral());
		dibujadores.put(EnumEdificiosTerran.REFINERIA, new DibujadorRefineria());
		dibujadores.put(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, new DibujadorDepositoSuministros());
		dibujadores.put(EnumEdificiosTerran.FABRICA, new DibujadorFabrica());
		dibujadores.put(EnumEdificiosTerran.PUERTO_ESTELAR, new DibujadorPuertoEstelarTerran());
		dibujadores.put(UnidadesTerran.ESPECTRO, new DibujadorEspectro());
		dibujadores.put(UnidadesTerran.GOLLIAT, new DibujadorGolliat());
		dibujadores.put(UnidadesTerran.MARINE, new DibujadorMarine());
		dibujadores.put(UnidadesTerran.NAVE_CIENCIA, new DibujadorNaveCiencia());
		dibujadores.put(UnidadesTerran.NAVE_TRANSPORTE, new DibujadorNaveTransporteTerran());
		dibujadores.put(EnumEdificiosProtos.ACCESO, new DibujadorAcceso());
		dibujadores.put(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS, new DibujadorArchivosTemplarios());
		dibujadores.put(EnumEdificiosProtos.ASIMILADOR, new DibujadorAsimilador());
		dibujadores.put(EnumEdificiosProtos.BASE_PROTOSS, new DibujadorBaseProtoss());
		dibujadores.put(EnumEdificiosProtos.NEXO_MINERAL, new DibujadorNexoMineral());
		dibujadores.put(EnumEdificiosProtos.PILON, new DibujadorPilon());
		dibujadores.put(EnumEdificiosProtos.PUERTO_ESTELAR, new DibujadorPuertoEstelarProtoss());
		dibujadores.put(UnidadesProtos.ALTO_TEMPLARIO, new DibujadorAltoTemplario());
		dibujadores.put(UnidadesProtos.DRAGON, new DibujadorDragon());
		dibujadores.put(UnidadesProtos.NAVE_DE_TRANSPORTE, new DibujadorNaveTransporteProtoss());
		dibujadores.put(UnidadesProtos.SCOUT, new DibujadorScout());
		dibujadores.put(UnidadesProtos.ZEALOT, new DibujadorZealot());
	}

	public JLabel dibujar(Propiedad aDibujar) {
		JLabel imagenObtenida;
		Border border = null;
		if(aDibujar == null){
			imagenObtenida = new DibujadorVacio().dibujar();
		}else if (aDibujar.getColor()==Colores.AZUL)
			border = BorderFactory.createLineBorder(Color.BLUE, 1);
		else
			border = BorderFactory.createLineBorder(Color.RED, 1);
		
		if(aDibujar instanceof Construccion){
			Construccion edificio = (Construccion) aDibujar;
			EnumEdificios nombre = edificio.getNombre();
			imagenObtenida = dibujadores.get(nombre).dibujar();
			imagenObtenida.setBorder(border);
		}else if(aDibujar instanceof Unidad){
			Unidad unidad = (Unidad) aDibujar;
			Unidades nombe = unidad.getNombre();
			imagenObtenida = dibujadores.get(nombe).dibujar();
			imagenObtenida.setBorder(border);
		}else
			imagenObtenida = new DibujadorVacio().dibujar();
		
		return imagenObtenida;
	}

}
