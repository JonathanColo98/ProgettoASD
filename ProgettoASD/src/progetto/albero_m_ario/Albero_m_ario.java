
/*
 * 	Jonathan Colombo	7011579
 * 	Jacopo Manetti   	7003888
 * 	Tommaso Santi	 	7013977
 * 
 */

package progetto.albero_m_ario;

import java.util.LinkedList;
import java.util.Stack;


public class Albero_m_ario {
	private Nodo_m_ario radice; // nodo radice 
	private static int m; // numero max di figli di ogni nodo (arietà dell'albero)
	private int numNodi; // numero dei nodi interni inseriti nell'albero 
	private int altezza; // altezza dell'albero
	private int numFoglie;// alternativa alla gestione ricorsiva per calcolo del numero di foglie 
	
	//costruttore che contiene solo l'arietà
	public Albero_m_ario(int m) {
		Albero_m_ario.m = m;
	}
	
	// restituisce l'arietà dell'albero
	public static int m() {
		return m;
	}
	
	// metodo toString per stampare gli elementi dell'albero
	@Override
	public String toString() {
		return "Albero_m_ario [" + (radice != null ? "radice=" + radice + ", " : "") + "numNodi=" + numNodi
				+ ", altezza=" + altezza + ", numFoglie=" + numFoglie + "]";
	}

	//	restituisce i figli del Nodo padre
	public Nodo_m_ario[] figli(Nodo_m_ario nodo){
		return nodo.getFigli();
	}
	
		//	1) inserisce la radice in un albero vuoto e la restituisce
		public Nodo_m_ario aggiungiRadice(String info){
			if(radice!=null)
	            return null;
			
	        numNodi++;
	        radice = new Nodo_m_ario(info);
	        numFoglie += Albero_m_ario.m;
	        return radice;
		}

		// 2) inserimento figlio tramite il nodo padre
		public Nodo_m_ario aggiungiFiglio(Nodo_m_ario U, String informazione, int i) {
			Nodo_m_ario V = new Nodo_m_ario(informazione);
			if(U != null) {
				U.getFigli()[i] = V;
				V.setPadre(U);
				numNodi++;
				numFoglie += Albero_m_ario.m - 1;
				if(V.livello() > altezza)
					altezza = V.livello();
			}
			return V;
		}
		
		// 3) Inserimento della radice di cui ne è presente già una
		public Nodo_m_ario aggiungiNuovaRadice(Nodo_m_ario radiceNuova,int i) {
			if(radice != null) {
				radiceNuova.getFigli()[i]= radice;
				radice = radiceNuova;
				numNodi++;
				numFoglie += Albero_m_ario.m - 1;
				if(radiceNuova.livello() > altezza)
					altezza = radiceNuova.livello();
			}
			else return null;
			return radice;
		}
		
		// 4)	Visita in profondità (visita anticipata) 
		public LinkedList<String> visitaAnticipata(){
			Stack<Nodo_m_ario> pila = new Stack<>(); 	//Struttura di servizio.
			LinkedList<String> nodiAlbero = new LinkedList<>();	//Conterra' i nodi visitati.
			
			pila.push(radice); 
			
			while (!pila.isEmpty()){
				
				Nodo_m_ario nodoDaEstrarre = pila.pop();
				
				if(nodoDaEstrarre != null){
					nodiAlbero.add(nodoDaEstrarre.getInformazione());	//	Il nodo viene chiuso
					for(Nodo_m_ario figlio : nodoDaEstrarre.getFigli()) {
						pila.push(figlio);	//Si inseriscono nella pila i nodi da visitare.
					}
				}
			}
			return nodiAlbero;
		}
		
		// 5) Visita in ampiezza (visita per livelli)
		public LinkedList<String> visitaInAmpiezza(){
			LinkedList<Nodo_m_ario> coda = new LinkedList<>(); //coda di servizio: la simulo con una LinkedList
			LinkedList<String> listaNodi = new LinkedList<>(); //lista nodi in uscita
		
			coda.add(radice); //aggiungo in fondo
			
			while (!coda.isEmpty()){
				
				Nodo_m_ario nodoDaEstrarre = coda.remove();
				
				if(nodoDaEstrarre != null ){
					listaNodi.add(nodoDaEstrarre.getInformazione());	// Il nodo viene chiuso.
					for(Nodo_m_ario figlio : nodoDaEstrarre.getFigli()) {
						coda.add(figlio);//Si inseriscono nella coda i nodi da visitare.	
					}
				}
			}
			return listaNodi;
		}
		
		//6) restituisce il numero di nodi interni
		public int numNodi(){
			return numNodi;
			}
		
		//7) dato un nodo interno restituisce il numero dei suoi figli che siano nodi interni
		public void stampaNumeroNodiInterni(Nodo_m_ario nodoInterno) {
			if(nodoInterno != null && nodoInterno.getFigli() != null) {
				int count = 0;
				for(int i=0;i<nodoInterno.getFigli().length; i++) {
					if(nodoInterno.getFigli()[i] != null)
						count++;
				}
				System.out.println("Numero figli nodo interno: " + count);
			}
		}
		
		//8) dato un nodo interno restituisce l'informazione dei suoi figli
		public void stampaInfoNodiInterni(Nodo_m_ario nodoInterno){
			if(nodoInterno != null && nodoInterno.getFigli() != null) {
				for(int i=0;i < nodoInterno.getFigli().length ; i++) {
					if(nodoInterno.getFigli()[i] != null)
						System.out.println("Informazione nodo interno: " + nodoInterno.getFigli()[i].getInformazione());
				}
			}
			else System.out.println("Nodo non esistente!");
		}
		
		//9) restituisce il contenuto di un nodo interno
		public String informazione(Nodo_m_ario nodo){
			return nodo.getInformazione();
		}	
		
		//10) cambiare il contenuto di un nodo interno
		public void cambiaInfo(Nodo_m_ario nodo, String informazione){
			nodo.setInformazione(informazione);
		}
		
		//11)restituire la radice dell'albero
		public Nodo_m_ario radice(){
			return radice;
		}
		
		//12) restituire il padre di un nodo interno
		public Nodo_m_ario padre(Nodo_m_ario nodo){
			return nodo.getPadre();
		}
		
		//13) restituire il numero di foglie dell'albero
		public int numFoglie() {
			return numFoglie;
		}
		
		//14) restituire l'altezza dell'albero
		public int altezza(){
			return altezza;
		}
		
		//15) restituire il livello di un nodo
		public int livello(Nodo_m_ario nodo){
			return nodo.livello();
		}
		
}
