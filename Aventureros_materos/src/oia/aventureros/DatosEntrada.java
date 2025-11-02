package oia.aventureros;

public class DatosEntrada {
	final private int n;
	final private long[] pasajes;
	
	public DatosEntrada(int n, long[] pasajes) {
		this.n = n;
		this.pasajes = pasajes;
	}
	
	public int getN() {
        return this.n;
    }

    public long[] getPasajes() {
        return this.pasajes;
    }
}
