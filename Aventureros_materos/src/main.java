import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		int N = 5;
		int[] a = { 1, 2, 3, 4 };

		int resultado = seleccionarCebador(N, a);
		System.out.println(resultado);

	}

	public static int seleccionarCebador(int N, int[] a) {

		List<Integer> ronda = new LinkedList<>();
		List<Integer> eliminados = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			ronda.add(i);

		int pos = 0;

		for (int i = 0; i < N - 1; i++) {
			int pasos = a[i] % ronda.size();
			pos = (pos + pasos) % ronda.size();
			eliminados.add(ronda.get(pos));
			ronda.remove(pos);
			if (pos == ronda.size())
				pos = 0;
		}
		for (Integer eliminado : eliminados) {
			System.out.print(eliminado + " ");

		}
		System.out.println();
		return ronda.get(0);
	}

}
