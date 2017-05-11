package sk.host.arabasso;

import sk.host.arabasso.search.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by arabasso on 01/10/2016.
 *
 */
public class Application {
    public static void main(String [] args){
        InputStream input = ClassLoader.class.getResourceAsStream("/input2");
        Scanner a = new Scanner(input);

        ArrayList<No> nos = new ArrayList<>();

        int n_nodes = a.nextInt();

        for (int i = 0; i < n_nodes; i++) {
            No x = new No(i, a.nextInt());
            int childs = a.nextInt();
            for (int j = 0; j < childs; j++) {
                x.childs.add(a.nextInt());
                x.costs.add(a.nextInt());
            }
            nos.add(x);
        }

        int source = a.nextInt();
        int destiny = a.nextInt();

        int choice = a.nextInt();
        int fringe = 2;

        Busca busca;

        switch (choice) {
            case 1:
                busca = new BFS(nos);
                break;

            case 4:
                busca = new AStar(nos);
                break;

            default:
                busca = new HillClimbing(nos);
                break;
        }

        busca.solve(source, destiny, fringe);
    }
}
