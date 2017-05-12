package sk.host.arabasso.search;

import java.util.ArrayList;

public class AStar implements Busca {

	private ArrayList<Fringe_element> fringe;
	private ArrayList<No> nos;
	private Utilities util;

	public AStar(ArrayList<No> nos) {
		this.nos = nos;
		this.fringe = new ArrayList<>();
		this.util = new Utilities();
	}

	public void solve(int source, int destiny, int show) {
		
		Fringe_element f = new Fringe_element(this.nos.get(source), 0);
		this.fringe.add(f);
		f.visited.add(source);
		
		Fringe_element aux;
		
		while(this.fringe.size() > 0) {
			
			this.util.sort_astar(this.fringe);
			if (show == 1)
				this.util.show_fringe_astar(this.fringe);
			aux = this.fringe.remove(0);
			
			if (aux.n.id == destiny) {
				this.util.end(aux, "A*");
				return;
			}
			
			for (int i = 0; i < aux.n.childs.size(); i++) {
				f = new Fringe_element(nos.get(aux.n.childs.get(i)), aux.f_function+aux.n.costs.get(i), this.util.copy(aux.visited));
				f.visited.add(aux.n.childs.get(i));
				this.fringe.add(f);
			}	
		}
		
		System.out.println("ERROR! SOLUTION NOT FOUND!");
	}
}
