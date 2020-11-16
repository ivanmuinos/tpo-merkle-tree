package pila;

public interface PilaTDA {
	
	void inicializar(int size);
	void apilar(String x);			// pila inicializada
	void desapilar();				// pila inicializada y no vac�a
	boolean pilaVacia();			// pila inicializada
	String tope();					// pila inicializada y no vac�a
	
}
