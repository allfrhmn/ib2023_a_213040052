package tugas.ucs;

// Mengimpor kelas Node dari package "tugas"
import tugas.Node;

import java.util.ArrayList;
import  java.util.List;

public class NodeUCS {
    // Variabel untuk menyimpan nilai dari node
    private String nilai;
    // Variabel untuk menyimpan biaya (cost) yang terkait dengan node ini
    private int cost;

    // List untuk menyimpan daftar tetangga (node-node terhubung) dari node ini
    private List<NodeUCS> tetangga;

    // Konstruktor untuk membuat objek NodeUCS dengan node asal dan biaya terkait
    public NodeUCS(Node node, int cost) {
        // Mengambil nilai dari node asal
        this.nilai = node.getNilai();
        // Mengatur biaya terkait dengan node ini
        this.cost = cost;
        // Inisialisasi list tetangga sebagai ArrayList baru
        tetangga = new ArrayList<>();
    }

    // Setter untuk mengatur nilai node
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    // Getter untuk mendapatkan nilai node
    public String getNilai() {
        return nilai;
    }

    // Setter untuk mengatur biaya terkait dengan node
    public void setCost(int cost) {
        this.cost = cost;
    }

    // Getter untuk mendapatkan biaya terkait dengan node
    public int getCost() {
        return cost;
    }

    // Setter untuk mengatur daftar tetangga (node-node terhubung) dari node ini
    public void setTetangga(List<NodeUCS> tetangga) {
        this.tetangga = tetangga;
    }

    // Getter untuk mendapatkan daftar tetangga (node-node terhubung) dari node ini
    public List<NodeUCS> getTetangga() {
        return tetangga;
    }

    // Menambahkan simpul tetangga ke dalam daftar simpul UCS
    public void addTetangga(NodeUCS node) {
        tetangga.add(node);
    }

    // Override metode equals untuk membandingkan dua objek NodeUCS berdasarkan nilai
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodeUCS) {
            // Membandingkan nilai node
            return ((NodeUCS) obj).nilai.equals(this.nilai);
        }
        // Jika objek yang dibandingkan bukan instance dari NodeUCS
        return false;
    }
}