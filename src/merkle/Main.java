package merkle;

public class Main 
{
	public static void main(String[] noargs) 
	{
		String[] trxs = {"a", "b", "c", "d", "1", "2", "3", "4"};
		NodoFull nodoFull = new NodoFull(trxs);
		nodoFull.printLevelOrder();
	}

}
