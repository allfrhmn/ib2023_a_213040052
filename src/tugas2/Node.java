package tugas2;

import java.util.ArrayList;
import java.util.List;

public class Node {
    // Nilai atau label dari node
    private String nilai;
    // Daftar node tetangga yang terhubung
    private List<Node> tetangga;

    public Node(String nilai) {
        // Inisialisasi daftar tetangga sebagai ArrayList
        tetangga = new ArrayList<>();
        // Mengatur nilai/node saat objek Node dibuat
        this.nilai = nilai;
    }

    public String getNilai() {
        // Mengembalikan nilai/node dari objek Node
        return nilai;
    }

    public void setNilai(String nilai) {
        // Mengatur nilai/node dari objek Node
        this.nilai = nilai;
    }

    public List<Node> getTetangga() {
        // Mengembalikan daftar node tetangga
        return tetangga;
    }

    public void setTetangga(List<Node> tetangga) {
        // Mengatur daftar node tetangga
        this.tetangga = tetangga;
    }

    public void addTetangga(Node node) {
        // Menambahkan node tetangga ke daftar tetangga
        tetangga.add(node);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node) {
            // Memeriksa apakah objek Node sama dengan objek ini berdasarkan nilai/node
            return((Node) obj).nilai.equals(this.nilai);
        }
        return false;
    }
}
