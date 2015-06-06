package algocraft.mapa;



import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import algocraft.mapa.terrenos.Terreno;

public class GeneradorMapaTest {

	@Test
	public void testAireNoSeCreaSolo(){
		GeneradorDeMapa generador = new GeneradorDeMapa(100,100);
		Mapa mapa = generador.generar();
		boolean anterioresNoSolos= true;
		
		Iterator<Terreno> itMapa1 = (Iterator<Terreno>) mapa.iterator();
		//para todos los aires
		while(itMapa1.hasNext() && anterioresNoSolos){
			Terreno unTerreno = itMapa1.next();
			if(unTerreno.sePuedeVolar()){
				//busco vecinos
				Iterator<Terreno> itMapa2 = (Iterator<Terreno>) mapa.iterator();
				boolean encontradoVecinoAire = false;
				while(itMapa2.hasNext() && !encontradoVecinoAire){
					Terreno otroTerreno = itMapa2.next();
					if(otroTerreno.sePuedeVolar() && 
							unTerreno.getCoordenada().distanciaA(otroTerreno.getCoordenada()) == 1)
						encontradoVecinoAire = true;
				}
				if(!encontradoVecinoAire) anterioresNoSolos=false;
			}
		}
		
		assertTrue(anterioresNoSolos);
	}
	
	@Test
	public void testBasesTienenMineralesEquidistantes(){
		GeneradorDeMapa generador = new GeneradorDeMapa(100,100);
		Mapa mapa = generador.generar();
		Coordenada base1 = generador.posicionBase1;
		Coordenada base2 = generador.posicionBase2;
		boolean mineralesEquidistantes = true;
		//los valores de n son las dist min y maxima determinadas en la construccion
		for(int n=3 ; n<=15 && mineralesEquidistantes ; n++){
			int mineralesADistanciaNDeBase1= 0;	
			int mineralesADistanciaNDeBase2= 0;	

			Iterator<Terreno> itMapa = (Iterator<Terreno>) mapa.iterator();
			while(itMapa.hasNext()){
				Terreno unTerreno = itMapa.next();
				if(unTerreno.sePuedeMinar() && unTerreno.getCoordenada().distanciaA(base1) == n) 
					mineralesADistanciaNDeBase1++;			
			}
			
			itMapa = (Iterator<Terreno>) mapa.iterator();
			while(itMapa.hasNext()){
				Terreno unTerreno = itMapa.next();
				if(unTerreno.sePuedeMinar() && unTerreno.getCoordenada().distanciaA(base2) == n)
					mineralesADistanciaNDeBase2++;					
			}
			
			if(mineralesADistanciaNDeBase1 != mineralesADistanciaNDeBase2)
				mineralesEquidistantes = false;
		}
		
		assertTrue(mineralesEquidistantes);
	}
	
	@Test
	public void testBasesTienenGasEquidistantes(){
		GeneradorDeMapa generador = new GeneradorDeMapa(100,100);
		Mapa mapa = generador.generar();
		Coordenada base1 = generador.posicionBase1;
		Coordenada base2 = generador.posicionBase2;
		boolean gasEquidistantes = true;
		
		for(int n=3 ; n<=15 && gasEquidistantes ; n++){
			int gasADistanciaNDeBase1= 0;	
			int gasADistanciaNDeBase2= 0;	

			Iterator<Terreno> itMapa = (Iterator<Terreno>) mapa.iterator();
			while(itMapa.hasNext()){
				Terreno unTerreno = itMapa.next();
				if(unTerreno.tieneGas() && unTerreno.getCoordenada().distanciaA(base1) == n) gasADistanciaNDeBase1++;			
			}
			itMapa = (Iterator<Terreno>) mapa.iterator();
			while(itMapa.hasNext()){
				Terreno unTerreno = itMapa.next();
				if(unTerreno.tieneGas() && unTerreno.getCoordenada().distanciaA(base2) == n) gasADistanciaNDeBase2++;					
			}
			if(gasADistanciaNDeBase1 != gasADistanciaNDeBase2)
				gasEquidistantes = false;
		}
		
		assertTrue(gasEquidistantes);
	}
}
