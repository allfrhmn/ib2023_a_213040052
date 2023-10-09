package tugas;

import java.util.ArrayList;
import java.util.List;

public class Node {
    // Variabel untuk menyimpan nilai dari node
    private String nilai;
    // List untuk menyimpan daftar tetangga (node-node terhubung) dari node ini
    private List<Node> tetangga;

    // Konstruktor untuk membuat objek Node dengan nilai awal
    public Node(String nilai) {
        // Inisialisasi list tetangga sebagai ArrayList baru
        tetangga = new ArrayList<>();
        // Mengatur nilai node saat dibuat
        this.nilai = nilai;
    }

    // Setter untuk mengatur nilai node
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    // Getter untuk mendapatkan nilai node
    public String getNilai() {
        return nilai;
    }

    // Setter untuk mengatur daftar tetangga (node-node terhubung) dari node ini
    public void setTetangga(List<Node> tetangga) {
        this.tetangga = tetangga;
    }

    // Getter untuk mendapatkan daftar tetangga (node-node terhubung) dari node ini
    public List<Node> getTetangga() {
        return tetangga;
    }

    // Menambahkan simpul tetangga ke dalam daftar simpul ini
    public void addTetangga(Node node) {
        tetangga.add(node);
    }

    // Override metode equals untuk membandingkan dua objek Node berdasarkan nilai
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            // Membandingkan nilai node
            return ((Node) obj).nilai.equals(this.nilai);
        }
        // Jika objek yang dibandingkan bukan instance dari Node
        return false;
    }
}