package tugas.bfs;

// Mengimpor kelas Node dari package "tugas"
import tugas.Node;

import java.util.ArrayList;
import java.util.List;

public class Solusi {
    // List untuk menyimpan daftar node yang terlibat dalam solusi BFS
    private List<Node> nodes;
    // Node yang merupakan hasil dari solusi BFS
    private Node node;

    // Konstruktor untuk membuat objek Solusi dengan daftar node awal kosong
    public Solusi() {
        nodes = new ArrayList<>();
    }

    // Inisialisasi list nodes sebagai ArrayList baru
    public void setNode(Node node) {
        this.node = node;
    }

    // Setter untuk mengatur node hasil dari solusi BFS
    public Node getNode() {
        return node;
    }

    // Getter untuk mendapatkan node hasil dari solusi BFS
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    // Setter untuk mengatur node hasil dari solusi BFS
    public List<Node> getNodes() {
        return nodes;
    }
}