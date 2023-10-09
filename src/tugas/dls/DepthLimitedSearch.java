package tugas.dls;

// Mengimpor kelas Node dari package "tugas"
import tugas.Node;
public class DepthLimitedSearch {
    // Variabel untuk menyimpan batasan kedalaman pencarian
    private int limit;

    // Setter untuk mengatur kedalaman limit pencarian
    public void setLimit(int limit) {
        this.limit = limit;
    }

    // Getter untuk mendapatkan kedalaman limit pencarian
    public int getLimit() {
        return limit;
    }

    // Metode untuk menjalankan pencarian DLS dari simpul "start" ke simpul "goal"
    public void search(Node start, Node goal) {
        System.out.println("Mencari solusi dari " + start.getNilai() + " ke " + goal.getNilai());
        // Inisialisasi simpul evaluasi dengan simpul awal
        Node eval = start;
        // Iterasi sejumlah kali sesuai dengan kedalaman limit
        for(int i = 0; i < limit; i++) {
            System.out.println("Level " + i + " evaluasi: " + eval.getNilai());
            // Jika simpul yang dievaluasi adalah tujuan yang dicari
            if(eval.equals(goal)) {
                System.out.println("Solusi ditemukan ");
                // Keluar dari loop jika solusi ditemukan
                break;
            }
            // Jika simpul memiliki tetangga
            if(!eval.getTetangga().isEmpty()) {
                // Pilih tetangga pertama untuk evaluasi
                eval = eval.getTetangga().get(0);
            }
            else {
                // Jika simpul tidak memiliki tetangga, keluar dari loop
                break;
            }
        }
    }
}