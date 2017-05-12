package sk.host.arabasso.search;

import java.util.ArrayList;

public class HillClimbing implements Busca {
	
	private ArrayList<Fringe_element> fringe;
	private ArrayList<No> nos;
	private Utilities util;
	
	public HillClimbing(ArrayList<No> nos) {
		this.nos = nos;
		this.fringe = new ArrayList<>();
		this.util = new Utilities();
	}
	
	public void solve(int source, int destiny, int show) {
		
		Fringe_element f = new Fringe_element(nos.get(source), 0);
		this.fringe.add(f);
		f.visited.add(source);
		
		Fringe_element aux;
		
		while(fringe.size() > 0) {
			
			if (show == 1)
				this.util.show_fringe(this.fringe);
			aux = this.fringe.remove(0);
			
			if (aux.n.id == destiny) {
				this.util.end(aux, "Hill Climbing");
				return;
			}
			
			int min = getMin(aux.n);
			No n = this.nos.get(aux.n.childs.get(min));
			f = new Fringe_element(n, aux.f_function + aux.n.costs.get(min), this.util.copy(aux.visited));
			f.visited.add(n.id);
			this.fringe.add(f);
		}
		
		System.out.println("ERROR! SOLUTION NOT FOUND!");
	}
	
	private int getMin(No n) {
		int min = 0;

		for (int i = 1; i < n.childs.size(); i++) {
			if (this.nos.get(n.childs.get(i)).heuristic < this.nos.get(n.childs.get(min)).heuristic) {
				min = i;
			}
		}
		return min;
	}
}