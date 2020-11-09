package merkle;

public class Nodo {
	public Nodo nodoIzq;
	public Nodo nodoDer;
	public Trx trx;

	public Nodo() {
	}
	
	public Nodo(Nodo nodoIzq, Nodo nodoDer) {
		this.nodoIzq = nodoIzq;
		this.nodoDer = nodoDer;
	}
	
	public Nodo(Trx trx) {
		this.trx = trx;
	}
	
	public String hashCodeStr() {
		return Integer.toString(this.hashCode());
	}

	@Override
	public String toString() {
		return "[Nodo = " + hashCodeStr() + (trx != null ? ", trx = " + trx : "") + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodoDer == null) ? 0 : nodoDer.hashCode());
		result = prime * result + ((nodoIzq == null) ? 0 : nodoIzq.hashCode());
		result = prime * result + ((trx == null) ? 0 : trx.hashCode());
		return result;
	}

}
