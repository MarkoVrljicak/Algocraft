package stats;

public class Stat {
	
	private int MaximoValor;
	private int ActualValor;
	
	public Stat(){
		this.MaximoValor = 0;
		this.ActualValor = 0;
	}
	
	public int max(){
		return this.MaximoValor;
	}

	public void set(int MaximoValor) {
		this.MaximoValor = MaximoValor;
		this.ActualValor = this.MaximoValor;
	}
	
	public int actual(){
		return ActualValor;
	}
	
	public void disminuir(int cantidad){
		this.ActualValor = this.ActualValor - cantidad;
		
		if (this.ActualValor < 0){
			this.ActualValor = 0;
		}
	}
	

}
