public class SubVector {
    private int corner1;
    private int edge;
    private int corner2;

    public SubVector(int corner1, int edge, int corner2){
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.edge = edge;
    }

    public int getCorner1() {
        return corner1;
    }

    public int getCorner2() {
        return corner2;
    }

    public int getEdge() {
        return edge;
    }

    @Override
    public String toString() {
        return "SubVector{" +
                "corner=" + corner1 +
                ", edge=" + edge +
                ", corner=" + corner2 +
                '}';
    }
}
