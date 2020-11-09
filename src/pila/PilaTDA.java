package pila;

public interface PilaTDA {
	
	void inicializar(int size);
	void apilar(int x);				// pila inicializada
	void desapilar();				// pila inicializada y no vacía
	boolean pilaVacia();			// pila inicializada
	int tope();						// pila inicializada y no vacía
	
}
