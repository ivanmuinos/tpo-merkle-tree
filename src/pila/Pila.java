package pila;

/**
 * Pila con tope al final
  */
public class Pila implements PilaTDA {
	private String[] valores;
	private int indice;

	/**
	 * Costo constante
	 */
	public void inicializar(int size) {
		this.valores = new String[size];
		this.indice = 0;
	}

	/**
	 * Costo constante
	 */
	public void apilar(String x) {
		this.valores[indice] = x;
		this.indice++;
	}

	/**
	 * Costo constante
	 */
	public void desapilar() {
		this.indice--;
	}

	/**
	 * Costo constante
	 */
	public boolean pilaVacia() {
		return this.indice == 0;
	}

	/**
	 * Costo constante
	 */
	public String tope() {
		return this.valores[indice - 1];
	}

	@Override
	public String toString() {
		String text = "[";
		for (int i = 0; i < indice; i++) {
			text += valores[i];
			
			if (i + 1 < indice)
				text += ", ";
		}
		text += "]";
		return text;
	}

}
