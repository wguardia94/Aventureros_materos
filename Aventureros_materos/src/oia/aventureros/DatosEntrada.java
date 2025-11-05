package oia.aventureros;

import java.util.Arrays;

public class DatosEntrada {
	final private int n;
	final private long[] pasajes;
	
	public DatosEntrada(int n, long[] pasajes) throws IllegalArgumentException {
		int aventurerosMin = 1, aventurerosMax = 400000;
		if (n < aventurerosMin || n > aventurerosMax) {
			throw new IllegalArgumentException("Cantidad de aventureros invalida, no se encuentra entre [1, 400.000]");
		}
		int cantidadPasajesObligatorios = n - 1;
		if (pasajes.length != cantidadPasajesObligatorios) {
			throw new IllegalArgumentException("Cantidad de pasajes invalida, no es la cantidad de aventureros - 1");
		}
		
		long pasajeMin = 0, pasajeMax = 100000000;
		for (long pasaje: pasajes) {
			if (pasaje < pasajeMin || pasaje > pasajeMax) {
				throw new IllegalArgumentException("Valor de pasaje fuera del rango [0, 100.000.000]");
			}
		}
		this.n = n;
		this.pasajes = Arrays.copyOf(pasajes, pasajes.length);;
	}
	
	public int getN() {
        return this.n;
    }

    public long getPasaje(int pos) {
        return this.pasajes[pos];
    }
}
