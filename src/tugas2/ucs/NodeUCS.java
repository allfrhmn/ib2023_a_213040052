package tugas2.ucs;

import tugas2.Node;

import java.util.ArrayList;
import java.util.List;
public class NodeUCS {
    // Nilai atau label dari node
    private String nilai;
    // Biaya dari node
    private int biaya;
    // Menandakan apakah node sudah dikunjungi
    public boolean dikunjungi;

    // Daftar node tetangga yang terhubung
    private List<NodeUCS> tetangga;
    // Biaya menuju tetangga yang sesuai
    private List<Integer> biayaTetangga;

    public NodeUCS(Node node, int biaya) {
        this.nilai = node.getNilai();
        this.biaya = biaya;

        // Inisialisasi daftar tetangga sebagai ArrayList
        tetangga = new ArrayList<>();
        // Inisialisasi daftar biaya tetangga sebagai ArrayList
        biayaTetangga = new ArrayList<>();
    }

    public String getNilai() {
        // Mengembalikan nilai/node dari objek NodeUCS
        return nilai;
    }

    public void setNilai(String nilai) {
        // Mengatur nilai/node dari objek NodeUCS
        this.nilai = nilai;
    }

    public int getBiaya() {
        // Mengembalikan biaya dari objek NodeUCS
        return biaya;
    }

    public void setBiaya(int biaya) {
        // Mengatur biaya dari objek NodeUCS
        this.biaya = biaya;
    }

    public List<NodeUCS> getTetangga() {
        // Mengembalikan daftar node tetangga
        return tetangga;
    }

    public void setTetangga(List<NodeUCS> tetangga) {
        // Mengatur daftar node tetangga
        this.tetangga = tetangga;
    }

    public void addTetangga(NodeUCS node, int biaya) {
        // Menambahkan node tetangga ke daftar tetangga
        tetangga.add(node);
        // Menambahkan biaya menuju tetangga ke daftar biaya tetangga
        biayaTetangga.add(biaya);
    }

    public List<Integer> getBiayaTetangga() {
        // Mengembalikan daftar biaya menuju tetangga
        return biayaTetangga;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NodeUCS) {
            // Memeriksa apakah objek NodeUCS sama dengan objek ini berdasarkan nilai/node
            return((NodeUCS) obj).nilai.equals(this.nilai);
        }
        return false;
    }
}
