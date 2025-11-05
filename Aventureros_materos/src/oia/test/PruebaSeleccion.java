package oia.test;

import org.junit.Test;

import java.util.Random;

import org.junit.Assert;

import oia.aventureros.*;

public class PruebaSeleccion {
	 	@Test
	    public void pruebaNormal() {
			int n = 5;
			long[] pasajes = {1, 2, 3, 4};
	        DatosEntrada datos = new DatosEntrada(n, pasajes);

	        Resultado resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(datos);

	        int[] esperadosEliminados = {2, 5, 1, 3};
	        int esperadoCebador = 4;

	        Assert.assertArrayEquals(resultado.getEliminados(), esperadosEliminados);
	        Assert.assertEquals(resultado.getCebador(), esperadoCebador);
	    }
	 	
	 	@Test
	    public void pruebaCantidadAventurerosFueraDeRango() {
			int n = 450000;
			long[] pasajes = new long[n - 1];
			
			Random random = new Random();
			int max = 100000000;
			for (int i = 0; i < pasajes.length; i++) {
				pasajes[i] = random.nextLong(max + 1);
			}

	        Assert.assertThrows(IllegalArgumentException.class, () -> {
	        		new DatosEntrada(n, pasajes);
	        	}
	        );
	    }
	 	
	 	@Test
	    public void pruebaPasajesInsuficientes() {
			int n = 5;
			long[] pasajes = {1, 2};

	        Assert.assertThrows(IllegalArgumentException.class, () -> {
	        		new DatosEntrada(n, pasajes);
	        	}
	        );
	    }
	 	
	 	@Test
	    public void pruebaPasajeFueraDeRango() {
			int n = 2;
			long[] pasajes = {200000000};

	        Assert.assertThrows(IllegalArgumentException.class, () -> {
	        		new DatosEntrada(n, pasajes);
	        	}
	        );
	    }
	 	
	 	@Test
	    public void pruebaCantidadDeAventurerosLimite() {
			int nMax = 400000;
			long[] pasajes = new long[nMax - 1];
			DatosEntrada datos = new DatosEntrada(nMax, pasajes);
			
	        int[] esperadosEliminados = new int[nMax - 1];
	        int esperadoCebador = 400000;
	        for (int i = 0; i < esperadosEliminados.length; i++) {
	        	esperadosEliminados[i] = i+1;
	        }
	        
	        Resultado resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(datos);

	        Assert.assertArrayEquals(resultado.getEliminados(), esperadosEliminados);
	        Assert.assertEquals(resultado.getCebador(), esperadoCebador);
	    }
	 	
	 	@Test
	    public void pruebaCantidadDePasajeLimite() {
			int nMax = 3;
			long[] pasajes = {100000000, 100000000};
			DatosEntrada datos = new DatosEntrada(nMax, pasajes);

	        int[] esperadosEliminados = {2, 3};
	        int esperadoCebador = 1;
	        
	        Resultado resultado = SeleccionarCebador.seleccionarCebadorSegmentTree(datos);

	        Assert.assertArrayEquals(resultado.getEliminados(), esperadosEliminados);
	        Assert.assertEquals(resultado.getCebador(), esperadoCebador);
	    }
}
