package sk.host.arabasso.search;

import java.util.ArrayList;

public class No {

	public ArrayList<Integer> childs;
	public ArrayList<Integer> costs;
	public int heuristic;
	public int id;

	public No(int id, int heuristic) {
		this.id = id;
		this.heuristic = heuristic;
		this.childs = new ArrayList<Integer>();
		this.costs = new ArrayList<Integer>();
	}

}
