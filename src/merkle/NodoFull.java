package merkle;

import java.util.ArrayList;
import java.util.List;

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
			this.trxs[i].nodoPadre = nodos[i];
		}

		this.setNodosPadre(nodos);
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

	public String[] solicitudNodoLigero(Trx searchTrx) {
		for (int i = 0; i < trxs.length; i++) {
			Trx trx = trxs[i];
			if (trx.equals(searchTrx))
				return getTrxPath(trx);
		}
		return new String[0];
	}

	private String[] getTrxPath(Trx trx) {
		int i = 0;
		String[] path = new String[(this.height()) + 1];
		Nodo nodo = trx.nodoPadre;
		while(nodo != null) {
			path[i++] = nodo.hash;
			nodo = nodo.nodoPadre;
		}
		
		return path;
	}
	
	private int height() {
		return (int)(Math.log(this.trxs.length) / Math.log(2));
	}

	public void print() {
		List<String> niveles = new ArrayList<String>();
		for (int i = 0; i <= height(); i++) {
			niveles.add(printNivel(raiz, i));
		}
		
		for (int i = 0; i < niveles.size(); i++) {
			String nivel = niveles.get(i);

			int cantEspacios = i == niveles.size() - 1 ? 0 : (niveles.get(niveles.size() - 1).length() - nivel.length()) / 2;
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
