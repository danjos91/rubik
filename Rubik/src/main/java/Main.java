import processing.core.PApplet;
import processing.core.PApplet.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Desordering:");
        Cubies.getInstance().turnCW(Faces.BACK);
        Cubies.getInstance().turnCW(Faces.BACK);
        Cubies.getInstance().turnCW(Faces.RIGHT);
        System.out.println("\nSolution:");
        Cubies.getInstance().makeCross();
        int[] moves = new int[]{Movements.U_CW, Movements.U_CCW};
        Cube cube = new Cube();
        cube.main("Cube");
    }

}

