package tugas.ucs;

import java.util.ArrayList;
import java.util.List;

public class UniformCostSearch {

    // Metode untuk menjalankan pencarian UCS dari simpul "start" ke simpul "goal"
    public void search(NodeUCS start, NodeUCS goal) {
        System.out.println("Mencari solusi dari " + start.getNilai() + " ke " + goal.getNilai());

        // Inisialisasi simpul evaluasi dengan simpul awal
        NodeUCS eval = start;
        // Variabel untuk menandai apakah pencarian selesai
        boolean done = false;
        // List untuk menyimpan solusi pencarian
        List<NodeUCS> solusi = new ArrayList<>();

        while (!done) {
            System.out.println("Evaluasi: " + eval.getNilai() + " dengan cost " + eval.getCost());
            // Menambahkan simpul evaluasi ke dalam list solusi
            solusi.add(eval);

            // Jika simpul yang dievaluasi adalah tujuan yang dicari
            if (eval.equals(goal)) {
                System.out.println("Solusi ditemukan ");
                // Menandai bahwa pencarian selesai
                done = true;
            }
            // Jika simpul memiliki tetangga
            if (!eval.getTetangga().isEmpty()) {
                // Variabel untuk menyimpan tetangga terbaik
                NodeUCS best = null;
                // Variabel untuk menyimpan minimum angka
                int min = Integer.MAX_VALUE;

                System.out.println();
                for (NodeUCS node: eval.getTetangga()) {
                    System.out.print(node.getNilai() + " (" + node.getCost() + "), ");
                    // Memeriksa apakah biaya simpul saat ini lebih kecil dari biaya minimum yang tercatat
                    if (min > node.getCost()) {
                        // Memperbarui biaya minimum
                        min = node.getCost();
                        // Memperbarui simpul terbaik
                        best = node;
                    }
                }
                System.out.println();
                System.out.println("Node terpilih: " + best.getNilai() + " (" + min + ")");
                // Mengatur simpul evaluasi sebagai tetangga terbaik
                eval = best;
            }
            else {
                // Jika simpul tidak memiliki tetangga, pencarian selesai
                done = true;
            }
        }
        System.out.println();
        System.out.println("Solusi ditemukan: ");
        for (NodeUCS node : solusi) {
            System.out.println(node.getNilai() + " (" + node.getCost() + ")");
        }
    }
}