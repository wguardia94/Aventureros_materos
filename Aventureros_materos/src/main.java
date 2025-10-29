import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		int N = 5;
		int[] a = { 1, 2, 3, 4 };

		int resultado = seleccionarCebador(N, a);
		System.out.println(resultado);

	}

	public static int seleccionarCebador(int N, int[] a) {

		int[] izq = new int[N + 1];
		int[] der = new int[N + 1];
		List<Integer> eliminados = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			izq[i] = (i == 1) ? N : i - 1;
			der[i] = (i == N) ? 1 : i + 1;
		}

		int actual = 1;

		int siguenEnRonda = N;

		for (int i = 0; i < N - 1; i++) {
			int pasos = a[i] % siguenEnRonda;
			for (int j = 0; j < pasos; j++) {
				actual = der[actual];
			}

			eliminados.add(actual);

			der[izq[actual]] = der[actual];
			izq[der[actual]] = izq[actual];

			actual = der[actual];
			siguenEnRonda--;
		}

		System.out.println("Eliminados: " + eliminados);

		return actual;

	}

}
