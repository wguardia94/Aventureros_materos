package oia.aventureros;

public class Resultado {
	final private int cebador;
	final private int[] eliminados;
	
	public Resultado(int cebador, int[] eliminados) {
		this.cebador = cebador;
		this.eliminados = eliminados;
	}
	
	public int getCebador() {
        return this.cebador;
    }

    public int[] getEliminados() {
        return this.eliminados;
    }
    
    public int getEliminado(int pos) {
    	return this.eliminados[pos];
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

        // Eliminados separados por espacio
        for (int i = 0; i < eliminados.length; i++) {
            sb.append(eliminados[i]);
            if (i < eliminados.length - 1) {
            	sb.append(" ");
            }
        }
        sb.append("\n");

        // Cebador final
        sb.append(cebador).append("\n");

        return sb.toString();
    }
}
