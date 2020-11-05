
package progetto.albero_m_ario;


public class Run {

	public static void main(String[] args){
		// TODO Auto-generated method stub	
		
		// Debug di prova
		int m = 3;
		Albero_m_ario albero = new Albero_m_ario(m);
		System.out.println(albero.toString());
		
		albero.aggiungiRadice("A");
		System.out.println();
		
		System.out.println(albero.toString());
		
		albero.aggiungiRadice("Radice Nulla");
		
		System.out.println();
		System.out.println(albero.toString());
		
		albero.aggiungiFiglio(albero.radice(), "B", 0);
	
		System.out.println();
		System.out.println(albero.toString());
		
		albero.aggiungiFiglio(albero.radice(), "C", 1);
		System.out.println();
		System.out.println(albero.toString());
		
		
		albero.aggiungiFiglio(albero.radice().getFigli()[0], "D",0);
		System.out.println();
		System.out.println(albero.toString());
		
		albero.aggiungiFiglio(albero.radice().getFigli()[0].getFigli()[0], "E", 0);
		System.out.println();
		System.out.println(albero.toString());

		albero.aggiungiFiglio(albero.radice().getFigli()[0].getFigli()[0], "F", 1);
				
		
		System.out.println();
		System.out.println("Visita anticipata");
		System.out.println(albero.visitaAnticipata());
		
		System.out.println();
		System.out.println("Visita in ampiezza");
		System.out.println(albero.visitaInAmpiezza());
	
		System.out.println();
		albero.stampaNumeroNodiInterni(albero.radice());
		
		System.out.println();
		
		albero.stampaInfoNodiInterni(albero.radice());
		
	}

}
