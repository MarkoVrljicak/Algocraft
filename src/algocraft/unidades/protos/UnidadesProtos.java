package algocraft.unidades.protos;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;

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
	};
	
	abstract public Unidad crear();
	
}
