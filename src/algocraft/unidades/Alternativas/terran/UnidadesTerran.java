package algocraft.unidades.Alternativas.terran;

import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public enum UnidadesTerran implements Unidades{

	MARINE{
		public Unidad crear(){
			return new Marine();
		}
	},
	GOLLIAT{
		public Unidad crear(){
			return new Golliat();
		}
	},
	ESPECTRO{
		public Unidad crear(){
			return new Espectro();
		}
	},
	NAVE_CIENCIA{
		public Unidad crear(){
			return new NaveCiencia();
		}
	},
	NAVE_TRANSPORTE{
		public Unidad crear(){
			return new NaveTransporte();
		}
	},
}