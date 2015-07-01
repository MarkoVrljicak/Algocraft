package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import modelo.mapa.Coordenada;
import modelo.unidades.UnidadMagica;
import modelo.unidades.protos.AltoTemplario;
import controlador.acciones.AccionAlucinacion;
import controlador.acciones.AccionTormentaPsionica;

@SuppressWarnings("serial")
public class VistaAltoTemplario extends VistaUnidadesMagicas{

	public VistaAltoTemplario(UnidadMagica unidad, Coordenada posicion,
			ImageIcon imagen) {
		super(unidad, posicion, imagen);
	}

	@Override
	protected void ofrecerMagias(JToolBar barraAcciones) {
		JButton botonTormenta = new JButton("Tormenta Psionica");
		botonTormenta.addActionListener(new AccionTormentaPsionica((AltoTemplario) unidadMagica));
		botonTormenta.setToolTipText("<html> Inflige 100 unidades de daño <br> a todas las unidades que <br> se encuentren debajo de la <br> tormenta durante 2 turnos. </html>");
		barraAcciones.add(botonTormenta);
		
		JButton botonAlucinacion = new JButton("Crear alucinacion");
		botonAlucinacion.addActionListener(new AccionAlucinacion((AltoTemplario) unidadMagica));
		botonAlucinacion.setToolTipText("<html> Crea 2 copias falsas <br> de una unidad propia <br> en juego. </html>");
		barraAcciones.add(botonAlucinacion);
		
	}

}
