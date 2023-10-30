package tugas2.bfs;

import tugas2.ucs.NodeUCS;

import java.util.ArrayList;
import java.util.List;

public class Solusi {
    private List<NodeUCS> nodes;
    private NodeUCS node;

    public Solusi() {
        nodes = new ArrayList<>();
    }

    public NodeUCS getNode() {
        return node;
    }

    public void setNode(NodeUCS node) {
        this.node = node;
    }

    public List<NodeUCS> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeUCS> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }
}
