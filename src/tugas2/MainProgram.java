package tugas2;

import tugas2.astar.AStarSearch;
import tugas2.greedybfs.GreedyBestFirstSearch;
import tugas2.ucs.NodeUCS;

public class MainProgram {
    public static void main(String[] args) {
        // Membuat node-node yang akan digunakan dalam graf
        NodeUCS nodeA = new NodeUCS(new Node("A"), 0);
        NodeUCS nodeB = new NodeUCS(new Node("B"), 4);
        NodeUCS nodeC = new NodeUCS(new Node("C"), 8);
        NodeUCS nodeD = new NodeUCS(new Node("D"), 16);

        // Menghubungkan node-node dengan tetangga dan biaya
        nodeA.addTetangga(nodeB, 4);
        nodeA.addTetangga(nodeC, 8);
        nodeB.addTetangga(nodeD, 16);
        nodeD.addTetangga(nodeA, 0);

        // Membuat objek AStarSearch
        System.out.println("A* Search :");
        AStarSearch astar = new AStarSearch();

        // Memulai pencarian dari node A ke node D
        astar.search(nodeA, nodeD);

        System.out.println("\n");

        // Membuat objek GreedyBestFirstSearch
        System.out.println("Greedy Best-First Search :");
        GreedyBestFirstSearch greedyBFS = new GreedyBestFirstSearch();

        // Memulai pencarian dari node A ke node D
        greedyBFS.search(nodeA, nodeD);
    }
}