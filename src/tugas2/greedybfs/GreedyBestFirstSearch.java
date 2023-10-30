package tugas2.greedybfs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tugas2.ucs.NodeUCS;
import tugas2.bfs.Solusi;

public class GreedyBestFirstSearch {
    public void search(NodeUCS awal, NodeUCS tujuan) {
        // Membuat antrian untuk menyimpan solusi yang akan dievaluasi
        Queue<Solusi> queue = new LinkedBlockingQueue<>();

        // Inisialisasi solusi awal dengan node awal dan tambahkan ke antrian
        Solusi awalSolusi = new Solusi();
        awalSolusi.setNode(awal);
        queue.add(awalSolusi);

        // Pesan untuk memulai pencarian
        System.out.println("Mencari solusi dari " + awal.getNilai() + " ke " + tujuan.getNilai());

        while(!queue.isEmpty()) {
            // Mengambil solusi dari depan antrian untuk dievaluasi
            Solusi eval = queue.poll();

            // Pesan untuk menunjukkan node yang dievaluasi
            System.out.println("Evaluasi: " + eval.getNode().getNilai());

            if(eval.getNode().equals(tujuan)) {
                // Pesan bahwa solusi telah ditemukan
                System.out.println("Solusi ditemukan: ");

                // Mencetak jalur solusi dari node awal ke node tujuan
                for(NodeUCS node : eval.getNodes()) {
                    System.out.print(node.getNilai() + " -> ");
                }

                System.out.println(eval.getNode().getNilai());
                break;
            }
            else {
                // Pesan yang menunjukkan bahwa sedang dievaluasi suksesor dari node saat ini
                System.out.println("Suksesor " + eval.getNode().getNilai());

                // Membuat solusi untuk suksesor terbaik
                Solusi solusiSuksesor = new Solusi();

                NodeUCS terbaik = null;
                int min = Integer.MAX_VALUE;
                int kedalaman = 0;

                for (NodeUCS node : eval.getNode().getTetangga()) {
                    if (kedalaman < 5) {
                        // Mencetak suksesor yang dievaluasi beserta biayanya
                        System.out.print(node.getNilai() + " (" + node.getBiaya() + "), ");

                        // Menentukan suksesor terbaik berdasarkan biaya terendah
                        if (min > node.getBiaya()) {
                            min = node.getBiaya();
                            terbaik = node;
                        }
                    }
                    else {
                        // Jika sudah mencapai kedalaman 5, hentikan pencarian dan kembali
                        return;
                    }
                    kedalaman++;
                }

                // Memilih suksesor terbaik dan menyiapkan solusi untuk suksesor tersebut
                NodeUCS suksesor = terbaik;
                solusiSuksesor.setNode(suksesor);
                solusiSuksesor.setNodes(eval.getNodes());
                solusiSuksesor.getNodes().add(eval.getNode());

                // Pesan yang menunjukkan node terpilih dan biayanya
                System.out.println();
                System.out.println("Node terpilih: " + terbaik.getNilai() + " (" + min + ")");
                // Menambahkan solusi suksesor ke dalam antrian untuk evaluasi berikutnya
                queue.offer(solusiSuksesor);
                // Memberikan jeda sebelum iterasi berikutnya
                System.out.println();
            }
        }
    }
}