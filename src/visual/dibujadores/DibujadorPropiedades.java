package visual.dibujadores;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EdificioBasico;
import modelo.construcciones.EdificioConEscudo;
import modelo.construcciones.RecolectorGas;
import modelo.construcciones.RecolectorMineral;
import modelo.jugador.Colores;
import modelo.mapa.Coordenada;
import modelo.propiedad.Propiedad;
import modelo.unidades.protos.AltoTemplario;
import modelo.unidades.protos.Alucinacion;
import modelo.unidades.protos.Dragon;
import modelo.unidades.protos.NaveDeTransporte;
import modelo.unidades.protos.Scout;
import modelo.unidades.protos.Zealot;
import modelo.unidades.terran.Espectro;
import modelo.unidades.terran.Golliat;
import modelo.unidades.terran.Marine;
import modelo.unidades.terran.NaveCiencia;
import modelo.unidades.terran.NaveTransporte;
import visual.Seleccionable;
import controlador.MiControladorMouse;



@SuppressWarnings("rawtypes")
public class DibujadorPropiedades {

	private static DibujadorPropiedades instance = null;

	public static DibujadorPropiedades getInstance(){
		if(instance == null)
			instance = new DibujadorPropiedades();

		return instance;
	}

	private HashMap<Class,Dibujador> dibujadores;

	protected DibujadorPropiedades(){
		dibujadores = new HashMap<Class, Dibujador>();

		dibujadores.put(EdificioBasico.class,DibujadorEdificios.getInstance());
		dibujadores.put(EdificioConEscudo.class, DibujadorEdificios.getInstance());
		dibujadores.put(RecolectorMineral.class, DibujadorEdificios.getInstance());
		dibujadores.put(RecolectorGas.class, DibujadorEdificios.getInstance());
		dibujadores.put(CreadorDeUnidades.class, DibujadorEdificios.getInstance());
		dibujadores.put(Espectro.class, new DibujadorEspectro());
		dibujadores.put(Golliat.class, new DibujadorGolliat());
		dibujadores.put(Marine.class, new DibujadorMarine());
		dibujadores.put(NaveCiencia.class, new DibujadorNaveCiencia());
		dibujadores.put(NaveTransporte.class, new DibujadorNaveTransporteTerran());
		dibujadores.put(AltoTemplario.class, new DibujadorAltoTemplario());
		dibujadores.put(Dragon.class, new DibujadorDragon());
		dibujadores.put(NaveDeTransporte.class, new DibujadorNaveTransporteProtoss());
		dibujadores.put(Scout.class, new DibujadorScout());
		dibujadores.put(Zealot.class, new DibujadorZealot());
		dibujadores.put(Alucinacion.class, new DibujadorAlucinacion());
	}

	public JLabel dibujar(Propiedad aDibujar,Coordenada posicion) {
		JLabel vistaObtenida=null;
		
		if(aDibujar == null){
			return new JLabel("");
		}else{
			Border border;
			if (aDibujar.getColor()==Colores.AZUL)
				border = BorderFactory.createLineBorder(Color.BLUE, 1);
			else
				border = BorderFactory.createLineBorder(Color.RED, 1);
			
			vistaObtenida = dibujadores.get(aDibujar.getClass()).dibujar(aDibujar,posicion);
			vistaObtenida.setBorder(border);
			vistaObtenida.addMouseListener(new MiControladorMouse((Seleccionable) vistaObtenida));
			return vistaObtenida;
		}
	}
}
