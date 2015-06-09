package stats;

abstract public class Stat {
	
	abstract public int max();
	abstract public int actual();
	abstract public void disminuir(int cantidad);	
	abstract public boolean estoyVacio();
	abstract public void regenerar();

}
