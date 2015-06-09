//package algocraft.unidades.Alternativas.protos;
//
//import stats.Escudo;
//import stats.Movimientos;
//import stats.Stat;
//import stats.Vida;
//import algocraft.ataques.Danio;
//import algocraft.unidades.Alternativas.Unidad;
//
//public class Alucinacion extends Unidad {
//	
//	public Alucinacion(Unidad otraUnidad){
//		super.inicializar();
//		setearEscudo();
//	}
//
//	@Override
//	protected void setearNombre() {
//	}
//
//	@Override
//	protected void setearVida() {
//	}
//	
//	protected void setearEscudo(){
//		Stat vida = new Vida(0);
//		this.stat = new Escudo(otraUnidad.getEscudo(), vida);
//	}
//
//	@Override
//	protected void setearPesoTransporte() {
//		this.pesoTransporte = 2;
//		
//	}
//	
//	@Override
//	protected void setearSuministros() {
//		this.suministros = 0;
//	}
//
//
//	@Override
//	protected void setearDanio() {
//		this.danio = new Danio(0,0,0,0);
//		
//	}
//
//	@Override
//	protected void setearMovimientos() {
//		this.movimientos = new Movimientos(3);
//	}
//	
//	@Override
//	public int getVida() {
//		return ((Escudo)this.stat).actualProtegida();
//	}	
//	
//}

