package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import modelo.mapa.Coordenada;
import modelo.unidades.UnidadMagica;
import modelo.unidades.terran.NaveCiencia;
import controlador.acciones.AccionEMP;
import controlador.acciones.AccionRadiacion;

@SuppressWarnings("serial")
public class VistaNaveCiencia extends VistaUnidadesMagicas{

	public VistaNaveCiencia(UnidadMagica unidad, Coordenada posicion,
			ImageIcon imagen) {
		super(unidad, posicion, imagen);
	}
	
	@Override
	protected void ofrecerMagias(JToolBar barraAcciones) {
		JButton botonEMP = new JButton("Lanzar EMP");
		botonEMP.addActionListener(new AccionEMP((NaveCiencia) unidadMagica));
		botonEMP.setToolTipText("<html> Quita escudo o magia <br> a todas las unidades <br> en un radio. </html>");
		barraAcciones.add(botonEMP);
		
		JButton botonRadiacion = new JButton("Lanzar Radiacion");
		botonRadiacion.addActionListener(new AccionRadiacion((NaveCiencia) unidadMagica));
		botonRadiacion.setToolTipText("<html> Consume a una unidad en particular <br> hasta matarla y afecta a todas <br> las demas unidades que esta toque. </html>");
		barraAcciones.add(botonRadiacion);
		
	}

}
