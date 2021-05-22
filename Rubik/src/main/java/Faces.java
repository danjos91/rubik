import java.util.Arrays;
import java.util.List;

public class Faces {//"FRBL"
    /*UP(1, 1 ,1 ,1),
    FRONT(1, 4 ,3 ,2),
    RIGHT(2, 4 ,2 ,2),
    BACK(3, 4 ,1 ,2),
    DOWN(4, 4 ,4 ,2),
    LEFT(3, 3 ,3 ,3);*/

    Faces neighborDown;
    Faces neighborRight;
    Faces neighborUp;
    Faces neighborLeft;
    String name = "";
    public final int neighborSideDown;
    public final int neighborSideRight;
    public final int neighborSideUp;
    public final int neighborSideLeft;
    public Vector vectorFace;
    private SubVector subNeighborVectorDown;
    private SubVector subNeighborVectorRight;
    private SubVector subNeighborVectorUp;
    private SubVector subNeighborVectorLeft;

    public void updateSubVectorsNeighbors(Faces neighborDown, Faces neighborRight, Faces neighborUp, Faces neighborLeft) {
        subNeighborVectorDown = neighborDown.getVectorFace().getSubVector(neighborSideDown);
        subNeighborVectorRight = neighborRight.getVectorFace().getSubVector(neighborSideRight);
        subNeighborVectorUp = neighborUp.getVectorFace().getSubVector(neighborSideUp);
        subNeighborVectorLeft = neighborLeft.getVectorFace().getSubVector(neighborSideLeft);
    }

    public Faces(String name, int neighborSideDown, int neighborSideRight, int neighborSideUp, int neighborSideLeft) {
        this.name = name;
        this.neighborSideDown = neighborSideDown;
        this.neighborSideRight = neighborSideRight;
        this.neighborSideLeft = neighborSideLeft;
        this.neighborSideUp = neighborSideUp;
    }


    public void rotateCCW(){
        vectorFace.rotateCCW();
        Cubies.getInstance().updateCubies();
        if (name.equals("up")) {
            updateSubVectorsNeighbors(Cubies.getInstance().front, Cubies.getInstance().right, Cubies.getInstance().back, Cubies.getInstance().left);
            Cubies.getInstance().front.setVectorFace(neighborSideDown, subNeighborVectorLeft);
            Cubies.getInstance().right.setVectorFace(neighborSideRight, subNeighborVectorDown);
            Cubies.getInstance().back.setVectorFace(neighborSideUp, subNeighborVectorRight);
            Cubies.getInstance().left.setVectorFace(neighborSideLeft, subNeighborVectorUp);
        } else if (name.equals("front")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().right, Cubies.getInstance().up, Cubies.getInstance().left);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorLeft);
            Cubies.getInstance().right.setVectorFace(neighborSideRight, subNeighborVectorDown);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorRight);
            Cubies.getInstance().left.setVectorFace(neighborSideLeft, subNeighborVectorUp);
        } else if (name.equals("right")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().back, Cubies.getInstance().up, Cubies.getInstance().front);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorLeft);
            Cubies.getInstance().back.setVectorFace(neighborSideRight, subNeighborVectorDown);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorRight);
            Cubies.getInstance().front.setVectorFace(neighborSideLeft, subNeighborVectorUp);
        } else if (name.equals("back")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().left, Cubies.getInstance().up, Cubies.getInstance().right);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorLeft);
            Cubies.getInstance().left.setVectorFace(neighborSideRight, subNeighborVectorDown);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorRight);
            Cubies.getInstance().right.setVectorFace(neighborSideLeft, subNeighborVectorUp);
        } else if (name.equals("left")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().front, Cubies.getInstance().up, Cubies.getInstance().back);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorLeft);
            Cubies.getInstance().front.setVectorFace(neighborSideRight, subNeighborVectorDown);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorRight);
            Cubies.getInstance().back.setVectorFace(neighborSideLeft, subNeighborVectorUp);
        } else if (name.equals("down")) {
            updateSubVectorsNeighbors(Cubies.getInstance().back, Cubies.getInstance().right, Cubies.getInstance().front, Cubies.getInstance().left);
            Cubies.getInstance().back.setVectorFace(neighborSideDown, subNeighborVectorLeft);
            Cubies.getInstance().right.setVectorFace(neighborSideRight, subNeighborVectorDown);
            Cubies.getInstance().front.setVectorFace(neighborSideUp, subNeighborVectorRight);
            Cubies.getInstance().left.setVectorFace(neighborSideLeft, subNeighborVectorUp);
        }
        Cubies.getInstance().updateCubies();
        if (Cubies.getInstance().print) {
            System.out.println("Movement :" + name.toUpperCase() + "'");
            Cubies.getInstance().printCube();
        }
    }

    public void rotateCW(){
        vectorFace.rotateCW();
        Cubies.getInstance().updateCubies();
        if (name.equals("up")) {
            updateSubVectorsNeighbors(Cubies.getInstance().front, Cubies.getInstance().right, Cubies.getInstance().back, Cubies.getInstance().left);
            Cubies.getInstance().front.setVectorFace(neighborSideDown, subNeighborVectorRight);
            Cubies.getInstance().right.setVectorFace(neighborSideRight, subNeighborVectorUp);
            Cubies.getInstance().back.setVectorFace(neighborSideUp, subNeighborVectorLeft);
            Cubies.getInstance().left.setVectorFace(neighborSideLeft, subNeighborVectorDown);
        } else if (name.equals("front")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().right, Cubies.getInstance().up, Cubies.getInstance().left);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorRight);
            Cubies.getInstance().right.setVectorFace(neighborSideRight, subNeighborVectorUp);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorLeft);
            Cubies.getInstance().left.setVectorFace(neighborSideLeft, subNeighborVectorDown);
        } else if (name.equals("right")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().back, Cubies.getInstance().up, Cubies.getInstance().front);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorRight);
            Cubies.getInstance().back.setVectorFace(neighborSideRight, subNeighborVectorUp);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorLeft);
            Cubies.getInstance().front.setVectorFace(neighborSideLeft, subNeighborVectorDown);
        } else if (name.equals("back")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().left, Cubies.getInstance().up, Cubies.getInstance().right);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorRight);
            Cubies.getInstance().left.setVectorFace(neighborSideRight, subNeighborVectorUp);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorLeft);
            Cubies.getInstance().right.setVectorFace(neighborSideLeft, subNeighborVectorDown);
        } else if (name.equals("left")) {
            updateSubVectorsNeighbors(Cubies.getInstance().down, Cubies.getInstance().front, Cubies.getInstance().up, Cubies.getInstance().back);
            Cubies.getInstance().down.setVectorFace(neighborSideDown, subNeighborVectorRight);
            Cubies.getInstance().front.setVectorFace(neighborSideRight, subNeighborVectorUp);
            Cubies.getInstance().up.setVectorFace(neighborSideUp, subNeighborVectorLeft);
            Cubies.getInstance().back.setVectorFace(neighborSideLeft, subNeighborVectorDown);
        } else if (name.equals("down")) {
            updateSubVectorsNeighbors(Cubies.getInstance().back, Cubies.getInstance().right, Cubies.getInstance().front, Cubies.getInstance().left);
            Cubies.getInstance().back.setVectorFace(neighborSideDown, subNeighborVectorRight);
            Cubies.getInstance().right.setVectorFace(neighborSideRight, subNeighborVectorUp);
            Cubies.getInstance().front.setVectorFace(neighborSideUp, subNeighborVectorLeft);
            Cubies.getInstance().left.setVectorFace(neighborSideLeft, subNeighborVectorDown);
        }
        Cubies.getInstance().updateCubies();
        if (Cubies.getInstance().print) {
            System.out.println("Movement :" + name.toUpperCase());
            Cubies.getInstance().printCube();
        }
    }

    public SubVector getSubVector(int side) {
        switch (side) {
            case 1:
                return subNeighborVectorUp;
            case 2:
                return subNeighborVectorRight;
            case 3:
                return subNeighborVectorDown;
            case 4:
                return subNeighborVectorLeft;
        }
        return subNeighborVectorDown;
    }

    public void setVectorFace(Vector vectorFace) {
        this.vectorFace = vectorFace;
    }

    public void setVectorFace(int neighborSide, SubVector subNeighborVector) {
        vectorFace.setSide(neighborSide, subNeighborVector);
        vectorFace = getVectorFace();
    }

    public Vector getVectorFace() {
        return vectorFace;
    }

}

