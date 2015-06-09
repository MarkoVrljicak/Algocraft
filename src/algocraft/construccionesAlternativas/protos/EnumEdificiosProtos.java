package algocraft.construccionesAlternativas.protos;
import Interfaces.Construccion;
import algocraft.construccionesAlternativas.EnumEdificios;

public enum EnumEdificiosProtos implements EnumEdificios{

		ACCESO{
			public Construccion crear(){
				return new Acceso();
			}
		},
		ARCHIVOS_TEMPLARIOS{
			public Construccion crear(){
				return new ArchivosTemplarios();
			}
		},
		ASIMILADOR{
			public Construccion crear(){
				return new Asimilador();
			}
		},
		NEXO_MINERAL{
			public Construccion crear(){
				return new NexoMineral();
			}
		},
		PILON{
			public Construccion crear(){
				return new Pilon();
			}
		},
		PUERTO_ESTELAR{
			public Construccion crear(){
				return new PuertoEstelar();
			}
		},
		BASE_PROTOSS{
			public Construccion crear(){
				return new BaseProtoss();
			}
		}
}
