package merkle;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int height = 3;
		String[] trxs = setTrxs(height);
		NodoFull nodoFull = new NodoFull(trxs);
		nodoFull.print();
		
		String trx = "7";
		String[] path = nodoFull.solicitudNodoLigero(trx);
		System.out.println("");
		System.out.println("La ruta de la trx " + trx + " es:");
		Arrays.stream(path).forEach(System.out::println);
	}

	private static String[] setTrxs(int height) {
		int cant = (int) Math.pow(2, height);
		String[] trxs = new String[cant];
		for (int i = 0; i < cant; i++) {
			trxs[i] = Integer.toString(i + 1);
		}
		return trxs;
	}

}
