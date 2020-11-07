package merkle;

public class Trx {
	public Nodo nodoPadre;
	public String dato;

	public Trx(String dato) {
		this.dato = dato;
	}

	@Override
	public String toString() {
		return dato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dato == null) ? 0 : dato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trx other = (Trx) obj;
		if (dato == null) {
			if (other.dato != null)
				return false;
		} else if (!dato.equals(other.dato))
			return false;
		return true;
	}

}
