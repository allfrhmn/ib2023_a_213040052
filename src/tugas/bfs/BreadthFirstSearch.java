package tugas.bfs;

// Mengimpor kelas Node dari package "tugas"
import tugas.Node;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {
    public void search(Node start, Node goal) {
        // Membuat antrian (queue) BFS menggunakan LinkedBlockingQueue
        Queue<Solusi> queue = new LinkedBlockingQueue<>();
        // Membuat objek Solusi untuk simpul awal
        Solusi solusiStart = new Solusi();
        // Mengatur simpul awal sebagai simpul pada objek Solusi
        solusiStart.setNode(start);
        // Menambahkan objek Solusi awal ke dalam antrian
        queue.add(solusiStart);
        System.out.println("Mencari solusi dari " + start.getNilai() + " ke " + goal.getNilai());

        while (!queue.isEmpty()) {
            // Mengambil dan menghapus objek Solusi dari depan antrian untuk evaluasi
            Solusi eval = queue.poll();
            System.out.println("Evaluasi: " + eval.getNode().getNilai());

            // Jika simpul yang dievaluasi adalah tujuan yang dicari
            if (eval.getNode().equals(goal)) {
                System.out.println("Solusi ditemukan: ");
                for(Node node: eval.getNodes()) {
                    System.out.print(node.getNilai() + " -> ");
                }
                System.out.println(eval.getNode().getNilai());
                // Keluar dari loop jika solusi ditemukan
                break;
            }
            else {
                System.out.println("Suksesor " + eval.getNode().getNilai());
                for(Node successor : eval.getNode().getTetangga()) {
                    System.out.print(successor.getNilai() + " ");
                    // Membuat objek Solusi untuk suksesor simpul
                    Solusi solusiSuksesor = new Solusi();
                    // Mengatur suksesor sebagai simpul pada objek Solusi
                    solusiSuksesor.setNode(successor);
                    // Menyalin daftar simpul dari evaluasi sebelumnya
                    solusiSuksesor.setNodes(eval.getNodes());
                    // Menambahkan simpul evaluasi ke daftar simpul
                    solusiSuksesor.getNodes().add(eval.getNode());

                    // Menambahkan objek Solusi suksesor ke dalam antrian
                    queue.offer(solusiSuksesor);
                }
                System.out.println();
                System.out.println();
            }
        }

    }
}