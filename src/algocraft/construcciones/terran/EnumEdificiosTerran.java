package algocraft.construcciones.terran;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;

public enum EnumEdificiosTerran implements EnumEdificios{
	
	CENTRO_DE_MINERALES{
		public Construccion crear(){
			return new CentroDeMineral();
		}
	},
	REFINERIA{
		public Construccion crear(){
			return new Refineria();
		}
	},
	DEPOSITO_DE_SUMINISTROS{
		public Construccion crear(){
			return new DepositoDeSuministros();
		}
	},
	BARRACA{
		public Construccion crear(){
			return new Barraca();
		}
	},
	FABRICA{
		public Construccion crear(){
			return new Fabrica();
		}
	},
	PUERTO_ESTELAR{
		public Construccion crear(){
			return new PuertoEstelar();
		}
	},
	BASE_TERRAN{
		public Construccion crear(){
			return new BaseTerran();
		}
	}
}
