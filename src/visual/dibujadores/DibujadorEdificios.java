package visual.dibujadores;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import modelo.construcciones.EnumEdificios;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.mapa.Coordenada;

public class DibujadorEdificios extends Dibujador {

	private static DibujadorEdificios instance = null;

	public static DibujadorEdificios getInstance(){
		if(instance == null)
			instance = new DibujadorEdificios();

		return instance;
	}

	Map<EnumEdificios, Dibujador> dibujadoresParticulares = new HashMap<EnumEdificios, Dibujador>();
	
	private DibujadorEdificios(){
		dibujadoresParticulares.put(EnumEdificiosTerran.BASE_TERRAN, new DibujadorBaseTerran());
		dibujadoresParticulares.put(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, new DibujadorDepositoSuministros());
		dibujadoresParticulares.put(EnumEdificiosProtos.BASE_PROTOSS, new DibujadorBaseProtoss());
		dibujadoresParticulares.put(EnumEdificiosProtos.PILON, new DibujadorPilon());
		dibujadoresParticulares.put(EnumEdificiosTerran.CENTRO_DE_MINERALES, new DibujadorCentroDeMineral());
		dibujadoresParticulares.put(EnumEdificiosProtos.NEXO_MINERAL, new DibujadorNexoMineral());
		dibujadoresParticulares.put(EnumEdificiosTerran.REFINERIA, new DibujadorRefineria());
		dibujadoresParticulares.put(EnumEdificiosProtos.ASIMILADOR, new DibujadorAsimilador());
		dibujadoresParticulares.put(EnumEdificiosTerran.BARRACA, new DibujadorBarraca());
		dibujadoresParticulares.put(EnumEdificiosTerran.FABRICA, new DibujadorFabrica());
		dibujadoresParticulares.put(EnumEdificiosTerran.PUERTO_ESTELAR, new DibujadorPuertoEstelarTerran());
		dibujadoresParticulares.put(EnumEdificiosProtos.ACCESO, new DibujadorAcceso());
		dibujadoresParticulares.put(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS, new DibujadorArchivosTemplarios());
		dibujadoresParticulares.put(EnumEdificiosProtos.PUERTO_ESTELAR, new DibujadorPuertoEstelarProtoss());
	}

	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		Construccion construccion = (Construccion)aDibujar;
		Dibujador dibujadorParticular =  dibujadoresParticulares.get(construccion.getNombre());
		return dibujadorParticular.dibujar(aDibujar, posicion);
	}

}
