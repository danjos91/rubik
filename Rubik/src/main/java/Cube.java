import peasy.*;
import processing.core.*;


import java.awt.*;
import java.util.List;

public class Cube extends PApplet {

    int dim = 3;
    int speed = 10;
    int index = 0;
    private PeasyCam cam;
    Box[] cube = new Box[dim*dim*dim];
    int counter = 0;
    List<Movements> moves;
    List<Movements> movesCube;
    List<Movements> movesFirstLayer;
    List<Movements> movesSecondLayer;
    List<Movements> movesThirdLayerCorners;
    List<Movements> movesThirdLayerCross;
    boolean disorder = false;
    boolean solve = false;
    boolean solveFirstLayer = false;
    boolean solveSecondLayer = false;
    boolean solveThirdLayerCorners = false;
    boolean solveThirdLayerCross = false;

    Move moveU_CW;
    Move moveU_CCW;
    Move moveF_CW;
    Move moveF_CCW;
    Move moveR_CW;
    Move moveR_CCW;
    Move moveB_CW;
    Move moveB_CCW;
    Move moveD_CW;
    Move moveD_CCW;
    Move moveL_CW;
    Move moveL_CCW;
    Move move;

    String solveSequence = "";
    String solveCross = "";
    String solveCorners = "";
    String solveLastCorners = "";
    String orderLastCorners = "";
    String solveEdges = "";
    String solveLastCross= "";
    String orderLastCross = "";

    public static void main(String[] args) {
        if (args.length >= 1 && args.length < 3){
            try {
                if (args.length == 1){
                    Cubies.getInstance().parseSequence(Cubies.getInstance().parseSequenceInitial(args[0]));
                    Cubies.getInstance().setInitialSequence(Cubies.getInstance().parseSequenceInitial(args[0]));
                } else {
                    if (args[0].equals("-m")){
                        Cubies.getInstance().parseSequence(Cubies.getInstance().parseSequenceInitial(args[1]));
                        Cubies.getInstance().activatePrintMoves();
                        Cubies.getInstance().setInitialSequence(Cubies.getInstance().parseSequenceInitial(args[1]));
                    }
                    else if (args[1].equals("-m")){
                        Cubies.getInstance().parseSequence(Cubies.getInstance().parseSequenceInitial(args[0]));
                        Cubies.getInstance().activatePrintMoves();
                        Cubies.getInstance().setInitialSequence(Cubies.getInstance().parseSequenceInitial(args[0]));
                    }
                    else {
                        System.out.println("Error. Please check the arguments.\n" +
                                "Usage example: Arguments example: -m 'F F D D L L'");
                        return;
                    }
                }
                PApplet.main("Cube");
            } catch (Exception e) {
                System.out.println("Error. Please check the arguments.\n" +
                        "Usage example: Arguments example: -m 'F F D D L L'\n" + e.getMessage());
                e.printStackTrace();
            }


        } else {
            System.out.println("Write a sequence as argument.\nAdd flag -m to print vector cube moves." +
                    "\nArguments example: -m 'F F D D L L'");
        }
    }

    public void setup(){
        cam = new PeasyCam(this, 600);
    }

    public void settings(){
        size(600, 600, P3D);
        for (int x=-1; x <= 1; x++) {
            for (int y=-1; y <= 1; y++) {
                for (int z=-1; z <= 1; z++) {
                    PMatrix3D matrix = new PMatrix3D();
                    matrix.translate(x, y, z);
                    cube[index] = new Box(matrix, x, y, z);
                    index++;
                }
            }
        }
        moveU_CW  = new Move(0, -1, 0, 1);
        moveU_CCW = new Move(0, -1, 0, -1);
        moveF_CW = new Move(0, 0, 1, 1);
        moveF_CCW = new Move(0, 0, 1, -1);
        moveR_CW = new Move(1, 0, 0, 1);
        moveR_CCW = new Move(1, 0, 0, -1);
        moveB_CW = new Move(0, 0, -1, -1);
        moveB_CCW = new Move(0, 0, -1, 1);
        moveD_CW = new Move(0, 1, 0, -1);
        moveD_CCW = new Move(0, 1, 0, 1);
        moveL_CW = new Move(-1, 0, 0, -1);
        moveL_CCW = new Move(-1, 0, 0, 1);


        Cubies.getInstance().initCube();
        String sequence = Cubies.getInstance().getInitialSequence();
        System.out.println("Initial Cube State");
        moves = Cubies.getInstance().parseSequence(sequence);
        Cubies.getInstance().printCube();
        Cubies.getInstance().runSequence(moves);
        solveCross = Cubies.getInstance().makeCross();
        solveCorners = Cubies.getInstance().solveCorners();
        solveEdges = Cubies.getInstance().solveEdges();
        orderLastCorners = Cubies.getInstance().orderLastCorners();
        solveLastCorners = Cubies.getInstance().solveLastCorners();
        orderLastCross = Cubies.getInstance().orderLastCross();
        solveLastCross = Cubies.getInstance().solveLastCross();
        solveSequence = Cubies.getInstance().optimizeSequence(solveCross + solveCorners + solveEdges +
                orderLastCorners + solveLastCorners + orderLastCross + solveLastCross);
        Cubies.getInstance().counterMoves = 0;
        if(Cubies.getInstance().getPrintMoves()) {
            Cubies.getInstance().printOn();
        }
        Cubies.getInstance().runSequence(Cubies.getInstance().parseSequence(solveSequence));
        System.out.println("Cube solved in " + Cubies.getInstance().counterMoves + " moves!");
        System.out.println("Initial sequence: " + sequence);
        System.out.println("Solution:\n" + solveSequence + "\n");
        movesCube = Cubies.getInstance().parseSequence(solveSequence);
        movesFirstLayer = Cubies.getInstance().parseSequence(Cubies.getInstance().optimizeSequence(solveCross + solveCorners));
        movesSecondLayer = Cubies.getInstance().parseSequence(Cubies.getInstance().optimizeSequence(solveEdges));
        movesThirdLayerCorners = Cubies.getInstance().parseSequence(Cubies.getInstance().optimizeSequence(orderLastCorners + solveCorners));
        movesThirdLayerCross = Cubies.getInstance().parseSequence(Cubies.getInstance().optimizeSequence(orderLastCross + solveLastCross));
        System.out.println("Run initial sequence -> press 1\n" +
                            "run solver -> press 2\nExit -> press 7\n" +
                            "Find more controls on readme file");
    }

    void turnY(int index, int dir) {
        for (int i = 0; i < cube.length; i++) {
            Box qb = cube[i];
            if (qb.y == index) {
                PMatrix2D matrix = new PMatrix2D();
                matrix.rotate(dir*HALF_PI);
                matrix.translate(qb.x, qb.z);
                qb.update(round(matrix.m02), qb.y, round(matrix.m12));
                qb.turnFacesY(dir);
            }
        }
    }

    void turnZ(int index, int dir) {
        for (int i = 0; i < cube.length; i++) {
            Box qb = cube[i];
            if (qb.z == index) {
                PMatrix2D matrix = new PMatrix2D();
                matrix.rotate(dir*HALF_PI);
                matrix.translate(qb.x, qb.y);
                qb.update(round(matrix.m02), round(matrix.m12), round(qb.z));
                qb.turnFacesZ(dir);
            }
        }
    }

    void turnX(int index, int dir) {
        for (int i = 0; i < cube.length; i++) {
            Box qb = cube[i];
            if (qb.x == index) {
                PMatrix2D matrix = new PMatrix2D();
                matrix.rotate(dir*HALF_PI);
                matrix.translate(qb.y, qb.z);
                qb.update(qb.x,round(matrix.m02), round(matrix.m12));
                qb.turnFacesX(dir);
            }
        }
    }

    public void draw(){
        background(115,215,255);

        rotateX(-0.5f);
        rotateY(0.4f);
        rotateX(0.1f);
        scale(60);

        if(disorder){
            move.update();
            if(frameCount % speed == 0) {
                if(move.finished()) {
                    if (counter < moves.size()) {
                        move(moves.get(counter));
                        counter++;
                    } else {
                        counter = 0;
                        disorder = false;
                    }
                }
            }
        }
        if(solve){
            move.update();
            if(frameCount % speed == 0) {
                if(move.finished()) {
                    if (counter < movesCube.size()) {
                        move(movesCube.get(counter));
                        counter++;
                    } else {
                        counter = 0;
                        solve = false;
                    }
                }
            }
        }
        if(solveFirstLayer && !solveSecondLayer && !solveThirdLayerCorners && !solveThirdLayerCross){
            move.update();
            if(frameCount % speed == 0) {
                if(move.finished()) {
                    if (counter < movesFirstLayer.size()) {
                        move(movesFirstLayer.get(counter));
                        counter++;
                    } else {
                        counter = 0;
                        solveFirstLayer = false;
                    }
                }
            }
        }
        if(!solveFirstLayer && solveSecondLayer && !solveThirdLayerCorners && !solveThirdLayerCross){
            move.update();
            if(frameCount % speed == 0) {
                if(move.finished()) {
                    if (counter < movesSecondLayer.size()) {
                        move(movesSecondLayer.get(counter));
                        counter++;
                    } else {
                        counter = 0;
                        solveSecondLayer = false;
                    }
                }
            }
        }
        if(!solveFirstLayer && !solveSecondLayer && solveThirdLayerCorners && !solveThirdLayerCross){
            move.update();
            if(frameCount % speed == 0) {
                if(move.finished()) {
                    if (counter < movesThirdLayerCorners.size()) {
                        move(movesThirdLayerCorners.get(counter));
                        counter++;
                    } else {
                        counter = 0;
                        solveThirdLayerCorners = false;
                    }
                }
            }
        }
        if(!solveFirstLayer && !solveSecondLayer && !solveThirdLayerCorners && solveThirdLayerCross){
            move.update();
            if(frameCount % speed == 0) {
                if(move.finished()) {
                    if (counter < movesThirdLayerCross.size()) {
                        move(movesThirdLayerCross.get(counter));
                        counter++;
                    } else {
                        counter = 0;
                        solveThirdLayerCross = false;
                    }
                }
            }
        }
        if(move != null) {
            move.update();
            for (Box box : cube) {
                push();
                if (box.z == move.z && (move == moveF_CCW || move == moveF_CW || move == moveB_CCW || move == moveB_CW)) {
                    rotateZ(move.angle);
                } else if (box.y == move.y && (move == moveU_CCW || move == moveU_CW || move == moveD_CCW || move == moveD_CW)) {
                    rotateY(-move.angle);
                } else if (box.x == move.x && (move == moveR_CCW || move == moveR_CW || move == moveL_CCW || move == moveL_CW)) {
                    rotateX(move.angle);
                }
                box.show();
                pop();
            }
        } else {
            for (Box box : cube) {
                box.show();
            }
        }
    }


    public void move(Movements movements){
        switch (movements){
            case U_CW:
                System.out.print("U ");
                move = moveU_CW;
                break;
            case U_CCW:
                System.out.print("U' ");
                move = moveU_CCW;
                break;
            case F_CW:
                System.out.print("F ");
                move = moveF_CW;
                break;
            case F_CCW:
                System.out.print("F' ");
                move = moveF_CCW;
                break;
            case R_CW:
                System.out.print("R ");
                move = moveR_CW;
                break;
            case R_CCW:
                System.out.print("R' ");
                move = moveR_CCW;
                break;
            case B_CW:
                System.out.print("B ");
                move = moveB_CW;
                break;
            case B_CCW:
                System.out.print("B' ");
                move = moveB_CCW;
                break;
            case D_CW:
                System.out.print("D ");
                move = moveD_CW;
                break;
            case D_CCW:
                System.out.print("D' ");
                move = moveD_CCW;
                break;
            case L_CW:
                System.out.print("L ");
                move = moveL_CW;
                break;
            case L_CCW:
                System.out.print("L' ");
                move = moveL_CCW;
                break;
        }
        move.start();
        move.update();
    }

    public void keyPressed() {
        switch (key){
            case '7':
                exit();
            case '1':
                disorder = true;
                move = new Move(0,0,0,0 );
                break;
            case '2':
                solve = true;
                move = new Move(0,0,0,0 );
                break;
            case '3':
                solveFirstLayer = true;
                move = new Move(0,0,0,0 );
                break;
            case '4':
                solveSecondLayer = true;
                move = new Move(0,0,0,0 );
                break;
            case '5':
                solveThirdLayerCorners = true;
                move = new Move(0,0,0,0 );
                break;
            case '6':
                solveThirdLayerCross = true;
                move = new Move(0,0,0,0 );
                break;
            case 'q':
                move(Movements.U_CW);
                break;
            case 'w':
                move(Movements.U_CCW);
                break;
            case 'a':
                move(Movements.F_CW);
                break;
            case 's':
                move(Movements.F_CCW);
                break;
            case 'z':
                move(Movements.R_CW);
                break;
            case 'x':
                move(Movements.R_CCW);
                break;
            case 'e':
                move(Movements.B_CW);
                break;
            case 'r':
                move(Movements.B_CCW);
                break;
            case 'd':
                move(Movements.D_CW);
                break;
            case 'f':
                move(Movements.D_CCW);
                break;
            case 'c':
                move(Movements.L_CW);
                break;
            case 'v':
                move(Movements.L_CCW);
                break;
            default:
                break;
        }
        if(move != null) {
            move.start();
        }
    }

    public class Box {
        PMatrix3D matrix;
        int x;
        int y;
        int z;
        Color color;
        Face[] faces = new Face[6];

        Box(PMatrix3D m, int x, int y, int z) {
            matrix = m;
            this.x = x;
            this.y = y;
            this.z = z;
            color = Color.WHITE;

            faces[0] = new Face(new PVector(0, 0, -1), Color.BLUE);
            faces[1] = new Face(new PVector(0, 0, 1), Color.GREEN);
            faces[2] = new Face(new PVector(0, 1, 0), Color.WHITE);
            faces[3] = new Face(new PVector(0, -1, 0), Color.YELLOW);
            faces[4] = new Face(new PVector(1, 0, 0), new Color(255, 150, 0));
            faces[5] = new Face(new PVector(-1, 0, 0), Color.RED);
        }

        void turnFacesZ(int dir) {
            for (Face f : faces) {
                f.turnZ(dir*HALF_PI);
            }
        }

        void turnFacesY(int dir) {
            for (Face f : faces) {
                f.turnY(dir*HALF_PI);
            }
        }

        void turnFacesX(int dir) {
            for (Face f : faces) {
                f.turnX(dir*HALF_PI);
            }
        }

        void update(int x, int y, int z) {
            matrix.reset();
            matrix.translate(x, y, z);
            this.x = x;
            this.y = y;
            this.z = z;
        }

        void show() {
            noFill();
            stroke(0);
            strokeWeight(0.1f);
            pushMatrix();
            applyMatrix(matrix);
            box(1);
            for (Face f : faces) {
                f.show();
            }
            popMatrix();
        }
    }

    public class Face {

        PVector normal;
        Color color;

        Face(PVector normal, Color color) {
            this.normal = normal;
            this.color = color;
        }


        void turnZ(float angle) {
            PVector v2 = new PVector();
            v2.x = round(normal.x * cos(angle) - normal.y * sin(angle));
            v2.y = round(normal.x * sin(angle) + normal.y * cos(angle));
            v2.z = round(normal.z);
            normal = v2;
        }

        void turnY(float angle) {
            PVector v2 = new PVector();
            v2.x = round(normal.x * cos(angle) - normal.z * sin(angle));
            v2.z = round(normal.x * sin(angle) + normal.z * cos(angle));
            v2.y = round(normal.y);
            normal = v2;
        }

        void turnX(float angle) {
            PVector v2 = new PVector();
            v2.y = round(normal.y * cos(angle) - normal.z * sin(angle));
            v2.z = round(normal.y * sin(angle) + normal.z * cos(angle));
            v2.x = round(normal.x);
            normal = v2;
        }

        public void square(float x, float y, float extent) {
            rect(x, y, extent, extent);
        }

        void show() {
            pushMatrix();
            fill(color.getRGB());
            noStroke();
            rectMode(CENTER);
            translate(0.5f*normal.x, 0.5f*normal.y, 0.5f*normal.z);
            if (abs(normal.x) > 0) {
                rotateY(HALF_PI);
            } else if (abs(normal.y) > 0) {
                rotateX(HALF_PI);
            }
            square(0, 0, 1);
            popMatrix();
        }
    }

    public class Move {
        float angle = 0;
        int x;
        int y;
        int z;
        int dir;
        boolean animating = false;
        boolean finished = false;

        public Move(int x, int y, int z, int dir) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dir = dir;
        }

        void start() {
            animating = true;
            finished = false;
            angle = 0;
        }

        void makeMovement() {
            if (abs(z) > 0) {
                turnZ(z, dir);
            } else if (abs(x) > 0) {
                turnX(x, dir);
            } else if (abs(y) > 0) {
                turnY(y, dir);
            }
        }

        boolean finished() {
            return finished;
        }

        void update() {
            if(animating) {
                angle += dir * speed * 0.01;
                if (abs(angle) > HALF_PI) {
                    angle = 0;
                    animating = false;
                    makeMovement();
                }
                finished = true;
            }
        }
    }

}