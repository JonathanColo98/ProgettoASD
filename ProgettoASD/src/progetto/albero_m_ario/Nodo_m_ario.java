
/*
 * 	Jonathan Colombo	7011579
 * 	Jacopo Manetti		7003888
 * 	Tommaso Santi		7013977
 * 
 */


package progetto.albero_m_ario;

import java.util.Arrays;

public class Nodo_m_ario {
	private String informazione; // informazione del nodo
	private Nodo_m_ario padre; // riferimento al nodo padre
	private Nodo_m_ario[] figli; // riferimento ai figli
	
	// costruttore
	public Nodo_m_ario(String informazione) {
		this.informazione = informazione;
		figli = new Nodo_m_ario[Albero_m_ario.m()];
	}

	public String getInformazione() {
		return informazione;
	}

	public void setInformazione(String informazione) {
		this.informazione = informazione;
	}

	public Nodo_m_ario getPadre() {
		return padre;
	}

	public void setPadre(Nodo_m_ario padre) {
		this.padre = padre;
	}

	public Nodo_m_ario[] getFigli() {
		return figli;
	}

	public void setFigli(Nodo_m_ario[] figli) {
		this.figli = figli;
	}
	
	
	// metodo toString per stampare i parametri del nodo
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [" + (informazione != null ? "informazione=" + informazione + ", " : "")
				+ (padre != null ? "padre=" + padre.getInformazione() + ", " : "")
				+ (figli != null ? "figli=" + Arrays.toString(figli) : "") + "]";
	}
	 
	// metodo toString per stampare solo i figli
	public String toStringFigli() {
		return this.getClass().getSimpleName() + "[figli " + Arrays.toString(figli) + "]";
	}
	
	// metodo calcolo del livello di ogni nodo (helper per altri metodi)
	public int livello(){
		int livello = 0;
		Nodo_m_ario temp = this.getPadre();
		while(temp!=null){
			livello++;
			temp = temp.getPadre();
		}
		return livello;
	}
	
}
