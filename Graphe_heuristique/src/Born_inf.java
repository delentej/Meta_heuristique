import java.lang.*;


public class Born_inf {

	
	private Sommet[] Tab_Sommet_evac;
	private Arc[] Tab_Arc;
	private int nbr_sommet_evac;
	
	
	public Born_inf(int nbr, Sommet[] Sommet, Arc[] Arc) {
		nbr_sommet_evac=nbr;
		Tab_Sommet_evac=new Sommet[nbr];
		int i=0;
		while(i<nbr_sommet_evac) {
			
			Tab_Sommet_evac[i]=Sommet[i];
			i++;
			
		}
		Tab_Arc=new Arc[Arc.length];
		int k=0;
		while(k<Arc.length) {
			
			Tab_Arc[k]=Arc[k];
			k++;
			
		}
		
		
		
	}
	
	
	public int calcul_born_inf() {

		
		
		int born_inf=0;
		int j=0;
		while(j<nbr_sommet_evac) {
		
			Sommet id=Tab_Sommet_evac[j];
			// calcul temps
			int[] Tab_route;
			Tab_route=id.get_tab_escape_route();
			int k=id.get_k();
			int min_cap=Integer.MAX_VALUE;
			int temps_chemin=0;
			int pop=0;
			
			int u=0;
			while(u<k) {
				if(u==0) {
					pop=id.get_population();
				}
				//on cherche l'arc id1 id2
				int v=0;
				while(!(Tab_Arc[v].test_arc(Tab_route[u],Tab_route[u+1]))){
					
					v++;
				}
				min_cap=Math.min(min_cap,Tab_Arc[v].get_capacity());
				temps_chemin=temps_chemin+Tab_Arc[v].get_length();
				u++;
				
			}
			born_inf=Math.max(born_inf,temps_chemin+(pop/min_cap));
			j++;
			
		}
		
		System.out.println(" La valeur de la born inf est de " + born_inf );
		
		return born_inf;
	}
	
	
	
	
	
}
