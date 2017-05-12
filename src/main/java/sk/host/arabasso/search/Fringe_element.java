package sk.host.arabasso.search;

import java.util.ArrayList;


public class Fringe_element {
	No n;
	int f_function;
	int g_function;
	ArrayList<Integer> visited;
	
	public Fringe_element(No n, int f_function) {
		this.n = n;
		this.f_function = f_function;
		this.visited = new ArrayList<>();
		this.g_function = this.f_function + this.n.heuristic;
	}

	public Fringe_element(No n, int f_function, ArrayList<Integer> visited) {
		this.n = n;
		this.f_function = f_function;
		this.visited = visited;
		this.g_function = this.f_function+this.n.heuristic;
	}
	
	public int get_g_function() {
		return this.g_function;
	}
	
	public int get_f_function() {
		return this.f_function;
	}

}
