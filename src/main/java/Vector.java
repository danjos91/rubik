import java.util.ArrayList;
import java.util.List;

public class Vector {

    private int corner1;
    private int corner2;
    private int corner3;
    private int corner4;
    private int edge1;
    private int edge2;
    private int edge3;
    private int edge4;
    public SubVector  upSide;
    public SubVector  rightSide;
    public SubVector  leftSide;
    public SubVector  downSide;


    public Vector(int corner1, int edge1, int corner2 , int edge2, int corner3, int edge3, int corner4, int edge4) {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;
        this.corner4 = corner4;
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
        this.edge4 = edge4;
        updateSubVectors();
    }

    public void  updateSubVectors() {
        upSide = new SubVector(corner1, edge1, corner2);
        rightSide = new SubVector(corner2, edge2, corner3);
        downSide = new SubVector(corner3, edge3, corner4);
        leftSide = new SubVector(corner4, edge4, corner1);
    }

    public List<Integer> getVector() {
        List<Integer> vector = new ArrayList<Integer>();
        vector.add(corner1);
        vector.add(edge1);
        vector.add(corner2);
        vector.add(edge2);
        vector.add(corner3);
        vector.add(edge3);
        vector.add(corner4);
        vector.add(edge4);

        return vector;
    }

    public SubVector getSubVector(int side) {
        switch (side) {
            case 1:
                return upSide;
            case 2:
                return rightSide;
            case 3:
                return downSide;
            case 4:
                return leftSide;
        }
        return upSide;
    }

    public void rotateCW()
    {
        List<Integer> vector = getVector();
        this.corner1 = vector.get(6);
        this.edge1 = vector.get(7);
        this.corner2 = vector.get(0);
        this.edge2 = vector.get(1);
        this.corner3 = vector.get(2);
        this.edge3 = vector.get(3);
        this.corner4 = vector.get(4);
        this.edge4 = vector.get(5);
        updateSubVectors();
    }

    public void rotateCCW()
    {
        List<Integer> vector = getVector();
        this.corner1 = vector.get(2);
        this.edge1 = vector.get(3);
        this.corner2 = vector.get(4);
        this.edge2 = vector.get(5);
        this.corner3 = vector.get(6);
        this.edge3 = vector.get(7);
        this.corner4 = vector.get(0);
        this.edge4 = vector.get(1);
        updateSubVectors();
    }

    public SubVector getUpSide() {
        return upSide;
    }

    public SubVector getDownSide() {
        return downSide;
    }

    public SubVector getLeftSide() {
        return leftSide;
    }

    public SubVector getRightSide() {
        return rightSide;
    }

    public void setSide(int side, SubVector vector) {
        switch (side) {
            case 1:
                this.upSide = vector;
                corner1 = vector.getCorner1();
                edge1 = vector.getEdge();
                corner2 = vector.getCorner2();
                break;
            case 2:
                this.rightSide = vector;
                corner2 = vector.getCorner1();
                edge2 = vector.getEdge();
                corner3 = vector.getCorner2();
                break;
            case 3:
                this.downSide = vector;
                corner3 = vector.getCorner1();
                edge3 = vector.getEdge();
                corner4 = vector.getCorner2();
                break;
            case 4:
                this.leftSide = vector;
                corner4 = vector.getCorner1();
                edge4 = vector.getEdge();
                corner1 = vector.getCorner2();
                break;
        }
        updateSubVectors();
    }

    public void setUpSide(SubVector upSide) {
        this.upSide = upSide;
    }

    public void setRightSide(SubVector rightSide) {
        this.rightSide = rightSide;
    }

    public void setDownSide(SubVector downSide) {
        this.downSide = downSide;
    }

    public void setLeftSide(SubVector leftSide) {
        this.leftSide = leftSide;
    }

    public String toString() {
        String vec = "";
        List<Integer> vector = getVector();
        for (int element : vector){
            vec += element + " ";
        }
        return vec;
    }

}
