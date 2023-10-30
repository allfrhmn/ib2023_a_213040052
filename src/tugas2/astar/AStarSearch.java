package tugas2.astar;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tugas2.ucs.NodeUCS;
import tugas2.bfs.Solusi;

public class AStarSearch {
    public void search(NodeUCS awal, NodeUCS tujuan) {
        // Membuat antrian untuk menyimpan solusi yang akan dievaluasi
        Queue<Solusi> queue = new LinkedBlockingQueue<>();

        // Inisialisasi solusi awal dengan node awal dan tambahkan ke antrian
        Solusi awalSolusi = new Solusi();
        awalSolusi.setNode(awal);
        queue.add(awalSolusi);

        // Menginisialisasi variabel untuk melacak total biaya
        int semuaBiaya = 0;

        // Pesan untuk memulai pencarian
        System.out.println("Mencari solusi dari " + awal.getNilai() + " ke " + tujuan.getNilai());

        while(!queue.isEmpty()) {
            // Mengambil solusi dari depan antrian untuk dievaluasi
            Solusi eval = queue.poll();

            // Pesan untuk menunjukkan node yang dievaluasi
            System.out.println("Evaluasi " + eval.getNode().getNilai());

            if(eval.getNode().equals(tujuan)) {
                // Pesan bahwa solusi telah ditemukan
                System.out.println("Solusi ditemukan: ");

                // Mencetak jalur solusi dari node awal ke node tujuan
                for(NodeUCS node : eval.getNodes()) {
                    System.out.print(node.getNilai() + " -> ");
                }

                System.out.print(eval.getNode().getNilai());

                break;
            }
            else {
                // Pesan yang menunjukkan bahwa sedang dievaluasi suksesor dari node saat ini
                System.out.println("Suksesor " + eval.getNode().getNilai() + ": ");

                // Membuat solusi untuk suksesor terbaik
                Solusi solusiSuksesor = new Solusi();

                // Menandai node saat ini sebagai sudah dikunjungi
                eval.getNode().dikunjungi = true;

                NodeUCS terbaik = null;
                int min = Integer.MAX_VALUE;
                int biaya = 0;
                int i = 0;

                for(NodeUCS node : eval.getNode().getTetangga()) {
                    int biayaTetangga = eval.getNode().getBiayaTetangga().get(i);

                    if(eval.getNode().getBiayaTetangga().size() > i) {
                        // Menghitung total biaya dan mencetaknya
                        int apakahMin = node.getBiaya() + biayaTetangga + semuaBiaya;
                        System.out.print(node.getNilai() + " (" + node.getBiaya() + " + " + biayaTetangga + " + " + semuaBiaya + "), = " + apakahMin + "\n");

                        if(node.dikunjungi == true) {
                            System.out.println(node.getNilai() + " sudah dikunjungi.\n");
                        }

                        if(min > apakahMin && node.dikunjungi == false) {
                            // Menentukan suksesor terbaik berdasarkan biaya terendah
                            min = apakahMin;
                            terbaik = node;
                            biaya = i;
                            node.dikunjungi = true;
                        }
                    }
                    else {
                        // Jika sudah mencapai kedalaman, hentikan pencarian dan kembali
                        return;
                    }
                    i++;
                }

                // Memilih suksesor terbaik dan menyiapkan solusi untuk suksesor tersebut
                NodeUCS suksesor = terbaik;
                solusiSuksesor.setNode(suksesor);
                solusiSuksesor.setNodes(eval.getNodes());
                solusiSuksesor.getNodes().add(eval.getNode());

                // Pesan yang menunjukkan node terpilih dan biayanya
                System.out.println();
                System.out.println("Node terpilih: " + terbaik.getNilai() + " (" + min + ")");

                // Menghitung total biaya
                semuaBiaya += eval.getNode().getBiayaTetangga().get(biaya);

                // Menambahkan solusi suksesor ke dalam antrian untuk evaluasi berikutnya
                queue.offer(solusiSuksesor);
                System.out.println();
            }
        }
    }
}