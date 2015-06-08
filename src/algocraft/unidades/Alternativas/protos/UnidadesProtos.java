package algocraft.unidades.Alternativas.protos;

import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public enum UnidadesProtos implements Unidades{
	
	ALTO_TEMPLARIO{
		public Unidad crear(){
			return new AltoTemplario();
		}
	},
	DRAGON{
		public Unidad crear(){
			return new Dragon();
		}
	},
	NAVE_DE_TRANSPORTE{
		public Unidad crear(){
			return new NaveDeTransporte();
		}
	},
	SCOUT{
		public Unidad crear(){
			return new Scout();
		}
	},
	ZEALOT{
		public Unidad crear(){
			return new Zealot();
		}
	},
	
}
