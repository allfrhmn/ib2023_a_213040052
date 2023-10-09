package tugas;

// Mengimpor beberapa kelas dari package "tugas"
import tugas.bfs.BreadthFirstSearch;
import tugas.dls.DepthLimitedSearch;
import tugas.ucs.NodeUCS;
import tugas.ucs.UniformCostSearch;

public class MainProgram {
    public static void main(String[] args) {
        // Buat simpul-simpul tentang stasiun kereta di provinsi Jawa Barat
        Node stasiunBdg = new Node("Stasiun Bandung");
        Node stasiunBjr = new Node("Stasiun Banjar");
        Node stasiunBks = new Node("Stasiun Bekasi");
        Node stasiunCkp = new Node("Stasiun Cikampek");
        Node stasiunJkt = new Node("Stasiun Jakarta");
        Node stasiunPwk = new Node("Stasiun Purwakarta");
        Node stasiunTsm = new Node("Stasiun Tasikmalaya");

        // Tentukan rute tetangga stasiun dari Bandung
        stasiunBdg.addTetangga(stasiunPwk);
        stasiunBdg.addTetangga(stasiunTsm);

        // Tentukan rute tetangga stasiun dari Banjar
        stasiunBjr.addTetangga(stasiunTsm);

        // Tentukan rute tetangga stasiun dari Bekasi
        stasiunBks.addTetangga(stasiunCkp);
        stasiunBks.addTetangga(stasiunJkt);

        // Tentukan rute tetangga stasiun dari Cikampek
        stasiunCkp.addTetangga(stasiunJkt);
        stasiunCkp.addTetangga(stasiunPwk);

        // Tentukan rute tetangga stasiun dari Jakarta
        stasiunJkt.addTetangga(stasiunBks);

        // Tentukan rute tetangga stasiun dari Purwakarta
        stasiunPwk.addTetangga(stasiunBdg);
        stasiunPwk.addTetangga(stasiunCkp);

        // Tentukan rute tetangga stasiun dari Tasikmalaya
        stasiunTsm.addTetangga(stasiunBdg);
        stasiunTsm.addTetangga(stasiunBjr);

        // Menggunakan metode BFS (Breadth First Search) untuk mencari rute terdekat
        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(stasiunJkt, stasiunBdg);
        System.out.println();

        // Menggunakan metode DLS (Depth Limited Search) untuk batas kedalaman pencarian rute terdekat
        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(3);
        dls.search(stasiunJkt, stasiunBdg);
        System.out.println();

        // Tentukan rute serta biaya antar stasiun di provinsi Jawa Barat
        NodeUCS bdgUCS = new NodeUCS(stasiunBdg, 63);
        NodeUCS bjrUCS = new NodeUCS(stasiunBjr, 230);
        NodeUCS bksUCS = new NodeUCS(stasiunBks,49);
        NodeUCS ckpUCS = new NodeUCS(stasiunCkp, 105);
        NodeUCS jktUCS = new NodeUCS(stasiunJkt, 160);
        NodeUCS pwkUCS = new NodeUCS(stasiunPwk,110);
        NodeUCS tsmUCS = new NodeUCS(stasiunTsm, 135);

        // Tentukan rute tetangga stasiun dari Bandung dengan menggunakan UCS
        bdgUCS.addTetangga(pwkUCS);
        bdgUCS.addTetangga(tsmUCS);

        // Tentukan rute tetangga stasiun dari Banjar dengan menggunakan UCS
        bjrUCS.addTetangga(tsmUCS);

        // Tentukan rute tetangga stasiun dari Bekasi dengan menggunakan UCS
        bksUCS.addTetangga(ckpUCS);
        bksUCS.addTetangga(jktUCS);

        // Tentukan rute tetangga stasiun dari Cikampek dengan menggunakan UCS
        ckpUCS.addTetangga(jktUCS);
        ckpUCS.addTetangga(pwkUCS);

        // Tentukan rute tetangga stasiun dari Jakarta dengan menggunakan UCS
        jktUCS.addTetangga(bksUCS);

        // Tentukan rute tetangga stasiun dari Purwakarta dengan menggunakan UCS
        pwkUCS.addTetangga(bdgUCS);
        pwkUCS.addTetangga(ckpUCS);

        // Tentukan rute tetangga stasiun dari Tasikmalaya dengan menggunakan UCS
        tsmUCS.addTetangga(bdgUCS);
        tsmUCS.addTetangga(bjrUCS);

        // Menggunakan metode UCS (Uniform Cost Search) untuk mencari rute terdekat dengan biaya
        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(jktUCS, bdgUCS);
        System.out.println();
    }
}