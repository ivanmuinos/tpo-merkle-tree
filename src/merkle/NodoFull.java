package merkle;

public class NodoFull {
	public Nodo raiz;
	public Nodo[] hojas;

	public NodoFull(String[] trxs) {
		this.hojas = new Nodo[trxs.length];

		for (int i = 0; i < trxs.length; i++) {
			this.hojas[i] = new Nodo(trxs[i]);
		}

		setNodosPadre(this.hojas);
	}

	private void setNodosPadre(Nodo[] nodos) {
		if (nodos.length == 1) {
			this.raiz = nodos[0];
			return;
		}

		Nodo[] nodosPadres = new Nodo[nodos.length / 2];
		int countPadre = 0;

		for (int i = 0; i < nodos.length; i = i + 2) {
			Nodo nodoIzq = nodos[i];
			Nodo nodoDer = nodos[i + 1];
			nodosPadres[countPadre++] = new Nodo(nodoIzq, nodoDer);
		}

		this.setNodosPadre(nodosPadres);
	}

	void print() {
		int i;
		for (i = 1; i <= hojas.length / 2; i++) {
			printNivel(raiz, i);
			System.out.println();
		}
	}

	void printNivel(Nodo nodo, int nivel) {
		if (nodo == null)
			return;
		if (nivel == 1)
			System.out.print(nodo + " ");
		else if (nivel > 1) {
			printNivel(nodo.nodoIzq, nivel - 1);
			printNivel(nodo.nodoDer, nivel - 1);
		}
	}

}
