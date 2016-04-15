package graph;

/**
 * Created by lukas on 4/15/16.
 */
public class AdjazenzNode {
    private String nodeName;
    private int nodeWeight;

    public AdjazenzNode(String nodeName, int nodeWeight) {
        this.nodeName = nodeName;
        this.nodeWeight = nodeWeight;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public int getNodeWeight() {
        return this.nodeWeight;
    }

    public String toString() {
        return this.nodeName + " : " + this.nodeWeight;
    }

}
