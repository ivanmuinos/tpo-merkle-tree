package merkle;

public class Nodo {
	public Nodo nodoPadre;
	public Nodo nodoIzq;
	public Nodo nodoDer;
	public String datos;

	public Nodo() {
	}
	
	public Nodo(Nodo nodoIzq, Nodo nodoDer) {
		nodoIzq.nodoPadre = this;
		nodoDer.nodoPadre = this;
		this.nodoIzq = nodoIzq;
		this.nodoDer = nodoDer;
	}
	
	public Nodo(String datos) {
		this.datos = datos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datos == null) ? 0 : datos.hashCode());
		result = prime * result + ((nodoIzq == null) ? 0 : nodoIzq.hashCode());
		result = prime * result + ((nodoDer == null) ? 0 : nodoDer.hashCode());
		return result;
	}
	
	public String hashCodeStr() {
		return Integer.toString(this.hashCode());
	}

	@Override
	public String toString() {
		return "[Nodo = " + hashCodeStr() + (datos != null ? ", trx = " + datos : "") + "]";
	}

}
