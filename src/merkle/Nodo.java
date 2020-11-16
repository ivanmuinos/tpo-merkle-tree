package merkle;

public class Nodo {
	public Nodo nodoIzq;
	public Nodo nodoDer;
	public Trx trx;
	public String hash;

	public Nodo() {
	}
	
	public Nodo(Nodo nodoIzq, Nodo nodoDer) {
		this.nodoIzq = nodoIzq;
		this.nodoDer = nodoDer;
		this.hash = Integer.toString(this.hashCode());
	}
	
	public Nodo(Trx trx) {
		this.trx = trx;
		this.hash = Integer.toString(this.hashCode());
	}

	@Override
	public String toString() {
		return "[Nodo = " + hash + (trx != null ? ", trx = " + trx : "") + "]";
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
