package merkle;

import java.util.ArrayList;
import java.util.List;

import pila.Pila;
import pila.PilaTDA;

public class NodoFull {
	public Nodo raiz;
	public Trx[] trxs;

	public NodoFull(String[] trxs) {
		this.trxs = new Trx[trxs.length];

		for (int i = 0; i < trxs.length; i++) {
			this.trxs[i] = new Trx(trxs[i]);
		}

		this.setNodosTrxs();
	}

	private void setNodosTrxs() {
		Nodo[] nodos = new Nodo[this.trxs.length];

		for (int i = 0; i < this.trxs.length; i++) {
			nodos[i] = new Nodo(this.trxs[i]);
		}

		this.setNodosHijos(nodos);
	}

	private void setNodosHijos(Nodo[] nodos) {
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

		this.setNodosHijos(nodosPadres);
	}

	public PilaTDA solicitudNodoLigero(Trx trx) {
		PilaTDA path = new Pila();
		path.inicializar((this.height()) + 1);

		this.getTrxPath(raiz, path, trx);
		return path;
	}

	public boolean getTrxPath(Nodo nodo, PilaTDA path, Trx trx) {
		if (nodo == null)
			return false;

		path.apilar(nodo.hashCode());

		if (nodo.trx != null && nodo.trx.equals(trx))
			return true;

		if (getTrxPath(nodo.nodoIzq, path, trx) || getTrxPath(nodo.nodoDer, path, trx))
			return true;

		path.desapilar();
		return false;
	}

	private int height() {
		return (int) (Math.log(this.trxs.length) / Math.log(2));
	}

	public void print() {
		List<String> niveles = new ArrayList<String>();
		for (int i = 0; i <= height(); i++) {
			niveles.add(printNivel(raiz, i));
		}

		for (int i = 0; i < niveles.size(); i++) {
			String nivel = niveles.get(i);

			int cantEspacios = i == niveles.size() - 1 ? 0
					: (niveles.get(niveles.size() - 1).length() - nivel.length()) / 2;
			String espacios = cantEspacios < 1 ? "" : String.format("%0" + cantEspacios + "d", 0).replace("0", " ");
			System.out.println(espacios + nivel);
		}
	}

	private String printNivel(Nodo nodo, int nivel) {
		String str = "";
		if (nodo == null)
			str = "";
		if (nivel == 0)
			str = nodo + " ";
		else if (nivel > 0) {
			str = printNivel(nodo.nodoIzq, nivel - 1);
			str += printNivel(nodo.nodoDer, nivel - 1);
		}

		return str;
	}

}
