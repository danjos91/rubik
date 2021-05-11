import java.util.ArrayList;
import java.util.List;

public final class Cubies {

    private static Cubies instance;

    public static Cubies getInstance() {
        if (instance == null) {
            instance = new Cubies();
        }
        return instance;
    }

    public int[] cubies  = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7,
            8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23,
            24, 25, 26, 27, 28, 29, 30, 31,
            32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47
    };

    public int turnCW(Faces face) {
        switch (face) {
            case UP:
                System.out.print("U ");
                cubies = new int[]{
                        cubies[6], cubies[7], cubies[0], cubies[1], cubies[2], cubies[3], cubies[4], cubies[5],
                        cubies[16], cubies[17], cubies[18], cubies[11], cubies[12], cubies[13], cubies[14], cubies[15],
                        cubies[24], cubies[25], cubies[26], cubies[19], cubies[20], cubies[21], cubies[22], cubies[23],
                        cubies[42], cubies[43], cubies[44], cubies[27], cubies[28], cubies[29], cubies[30], cubies[31],
                        cubies[32], cubies[33], cubies[34], cubies[35], cubies[36], cubies[37], cubies[38], cubies[39],
                        cubies[40], cubies[41], cubies[8], cubies[9], cubies[10], cubies[45], cubies[46], cubies[47]
                };
                return Movements.U_CW;
            case FRONT:
                System.out.print("F ");
                cubies = new int[]{
                        cubies[0], cubies[1], cubies[2], cubies[3], cubies[44], cubies[45], cubies[46], cubies[7],
                        cubies[14], cubies[15], cubies[8], cubies[9], cubies[10], cubies[11], cubies[12], cubies[13],
                        cubies[6], cubies[17], cubies[18], cubies[19], cubies[20], cubies[21], cubies[4], cubies[5],
                        cubies[24], cubies[25], cubies[26], cubies[27], cubies[28], cubies[29], cubies[30], cubies[31],
                        cubies[32], cubies[33], cubies[34], cubies[35], cubies[22], cubies[23], cubies[16], cubies[39],
                        cubies[40], cubies[41], cubies[42], cubies[43], cubies[36], cubies[37], cubies[38], cubies[47]
                };
                return Movements.F_CW;
            case RIGHT:
                System.out.print("R ");
                cubies = new int[]{
                        cubies[0], cubies[1], cubies[10], cubies[11], cubies[12], cubies[5], cubies[6], cubies[7],
                        cubies[8], cubies[9],  cubies[38], cubies[39], cubies[32], cubies[13], cubies[14], cubies[15],
                        cubies[22], cubies[23], cubies[16], cubies[17], cubies[18], cubies[19], cubies[20], cubies[21],
                        cubies[4], cubies[25], cubies[26], cubies[27], cubies[28], cubies[29],  cubies[2], cubies[3],
                        cubies[24], cubies[33], cubies[34], cubies[35], cubies[36], cubies[37], cubies[30], cubies[31],
                        cubies[40], cubies[41], cubies[42], cubies[43], cubies[44], cubies[45], cubies[46], cubies[47]
                };
                return Movements.R_CW;
            case BACK:
                System.out.print("B ");
                cubies = new int[]{
                        cubies[18], cubies[19], cubies[20], cubies[3], cubies[4], cubies[5], cubies[6], cubies[7],
                        cubies[8], cubies[9], cubies[10], cubies[11], cubies[12], cubies[13], cubies[14], cubies[15],
                        cubies[16], cubies[17], cubies[32], cubies[33], cubies[34], cubies[21], cubies[22], cubies[23],
                        cubies[30], cubies[31], cubies[24], cubies[25], cubies[26], cubies[27], cubies[28], cubies[29],
                        cubies[40], cubies[41], cubies[42], cubies[35], cubies[36], cubies[37], cubies[38], cubies[39],
                        cubies[0], cubies[1], cubies[2], cubies[43], cubies[44], cubies[45], cubies[46], cubies[47]
                };
                return Movements.B_CW;
            case DOWN:
                System.out.print("D ");
                cubies = new int[]{
                        cubies[0], cubies[1], cubies[2], cubies[3], cubies[4], cubies[5], cubies[6], cubies[7],
                        cubies[8], cubies[9], cubies[10], cubies[11], cubies[46], cubies[47], cubies[40], cubies[15],
                        cubies[16], cubies[17], cubies[18], cubies[19], cubies[12], cubies[13], cubies[14], cubies[23],
                        cubies[24], cubies[25], cubies[26], cubies[27], cubies[20], cubies[21], cubies[22], cubies[31],
                        cubies[38], cubies[39], cubies[32], cubies[33], cubies[34], cubies[35], cubies[36], cubies[37],
                        cubies[30], cubies[41], cubies[42], cubies[43], cubies[44], cubies[45], cubies[28], cubies[29]
                };
                return Movements.D_CW;
            case LEFT:
                System.out.println("L ");
                cubies =  new int[]{
                        cubies[28], cubies[1], cubies[2], cubies[3], cubies[4], cubies[5], cubies[26], cubies[27],
                        cubies[0], cubies[9], cubies[10], cubies[11], cubies[12], cubies[13], cubies[6], cubies[7],
                        cubies[16], cubies[17], cubies[18], cubies[19], cubies[20], cubies[21], cubies[22], cubies[23],
                        cubies[24], cubies[25],   cubies[40], cubies[41], cubies[42], cubies[29], cubies[30], cubies[31],
                        cubies[38], cubies[39], cubies[32], cubies[33], cubies[34], cubies[35], cubies[36], cubies[37],
                        cubies[14], cubies[15],   cubies[8], cubies[43], cubies[44], cubies[45], cubies[46], cubies[47],
                };
                return Movements.L_CW;
        }
        return -1;
    }

    public int turnCCW(Faces face) {
        switch (face) {
            case UP:
                System.out.print("U' ");
                cubies = new int[] {
                        cubies[2], cubies[3], cubies[4], cubies[5], cubies[6], cubies[7], cubies[0], cubies[1],
                        cubies[42], cubies[43], cubies[44], cubies[11], cubies[12], cubies[13], cubies[14], cubies[15],
                        cubies[8], cubies[9], cubies[10], cubies[19], cubies[20], cubies[21], cubies[22], cubies[23],
                        cubies[16], cubies[17], cubies[18], cubies[27], cubies[28], cubies[29], cubies[30], cubies[31],
                        cubies[32], cubies[33], cubies[34], cubies[35], cubies[36], cubies[37], cubies[38], cubies[39],
                        cubies[40], cubies[41], cubies[24], cubies[25], cubies[26], cubies[45], cubies[46], cubies[47]
                };
                return Movements.U_CCW;
            case FRONT:
                System.out.print("F' ");
                cubies = new int[]{
                        cubies[0], cubies[1], cubies[2], cubies[3], cubies[22], cubies[23], cubies[16], cubies[7],
                        cubies[10], cubies[11], cubies[12], cubies[13], cubies[14], cubies[15], cubies[8], cubies[9],
                        cubies[38], cubies[17], cubies[18], cubies[19], cubies[20], cubies[21], cubies[36], cubies[37],
                        cubies[24], cubies[25], cubies[26], cubies[27], cubies[28], cubies[29], cubies[30], cubies[31],
                        cubies[32], cubies[33], cubies[34], cubies[35], cubies[44], cubies[45], cubies[46], cubies[39],
                        cubies[40], cubies[41], cubies[42], cubies[43], cubies[4], cubies[5], cubies[6], cubies[47]
                };
                return Movements.F_CCW;
            case RIGHT:
                System.out.print("R' ");
                cubies = new int[]{
                        cubies[0], cubies[1], cubies[30], cubies[31], cubies[24], cubies[5], cubies[6], cubies[7],
                        cubies[8], cubies[9],  cubies[2], cubies[3], cubies[4], cubies[13], cubies[14], cubies[15],
                        cubies[18], cubies[19], cubies[20], cubies[21], cubies[22], cubies[23], cubies[16], cubies[17],
                        cubies[32], cubies[25], cubies[26], cubies[27], cubies[28], cubies[29], cubies[38], cubies[39],
                        cubies[12], cubies[33], cubies[34], cubies[35], cubies[36], cubies[37], cubies[10], cubies[11],
                        cubies[40], cubies[41], cubies[42], cubies[43], cubies[44], cubies[45], cubies[46], cubies[47]
                };
                return Movements.R_CCW;
            case BACK:
                System.out.print("B' ");
                cubies = new int[]{
                        cubies[40], cubies[41], cubies[42], cubies[3], cubies[4], cubies[5], cubies[6], cubies[7],
                        cubies[8], cubies[9], cubies[10], cubies[11], cubies[12], cubies[13], cubies[14], cubies[15],
                        cubies[16], cubies[17], cubies[0], cubies[1], cubies[2], cubies[21], cubies[22], cubies[23],
                        cubies[26], cubies[27], cubies[28], cubies[29], cubies[30], cubies[31], cubies[24], cubies[25],
                        cubies[18], cubies[19], cubies[20], cubies[35], cubies[36], cubies[37], cubies[38], cubies[39],
                        cubies[32], cubies[33], cubies[34], cubies[43], cubies[44], cubies[45], cubies[46], cubies[47]
                };
                return Movements.B_CCW;
            case DOWN:
                System.out.print("D' ");
                cubies = new int[]{
                        cubies[0], cubies[1], cubies[2], cubies[3], cubies[4], cubies[5], cubies[6], cubies[9],
                        cubies[8], cubies[9], cubies[10], cubies[11], cubies[20], cubies[21], cubies[22], cubies[15],
                        cubies[16], cubies[17], cubies[18], cubies[19], cubies[28], cubies[29], cubies[30], cubies[23],
                        cubies[24], cubies[25], cubies[26], cubies[27], cubies[46], cubies[47], cubies[40], cubies[31],
                        cubies[34], cubies[35], cubies[36], cubies[37], cubies[38], cubies[39], cubies[32], cubies[33],
                        cubies[14], cubies[41], cubies[42], cubies[43], cubies[44], cubies[45], cubies[12], cubies[13]
                };
                return Movements.D_CCW;
            case LEFT:
                System.out.println("L' ");
                cubies =  new int[]{
                        cubies[8], cubies[1], cubies[2], cubies[3], cubies[4], cubies[5], cubies[14], cubies[15],
                        cubies[36], cubies[9], cubies[10], cubies[11], cubies[12], cubies[13], cubies[34], cubies[35],
                        cubies[16], cubies[17], cubies[18], cubies[19], cubies[20], cubies[21], cubies[22], cubies[23],
                        cubies[24], cubies[25], cubies[6], cubies[7], cubies[0], cubies[29], cubies[30], cubies[31],
                        cubies[32], cubies[33], cubies[26], cubies[27], cubies[28], cubies[37], cubies[38], cubies[39],
                        cubies[42], cubies[43], cubies[44], cubies[45], cubies[46], cubies[47], cubies[40], cubies[41]
                };
                return Movements.L_CCW;
        }
        return -1;
    }

    private int getIndex(int[] cubie, int element) {
        int i;
        for(i=0; i < 48; i++) {
            if(element == cubie[i]) {
                return i;
            }
        }
        return -1;
    }

    List<Integer>  crossSequence = new ArrayList<Integer>();

    public List<Integer> parseSequence(String sequence) {
        String[] values = sequence.trim().split(" ");
        List<Integer> movs = new ArrayList<Integer>();
        for (String value : values) {
            if (value.equals("U")){
                movs.add(Movements.U_CW);
            } else if (value.equals("U'")){
                movs.add(Movements.U_CCW);
            } else if (value.equals("F")){
                movs.add(Movements.F_CW);
            } else if (value.equals("F'")){
                movs.add(Movements.F_CCW);
            } else if (value.equals("R")){
                movs.add(Movements.R_CW);
            } else if (value.equals("R'")){
                movs.add(Movements.R_CCW);
            } else if (value.equals("B")){
                movs.add(Movements.B_CW);
            } else if (value.equals("B'")){
                movs.add(Movements.B_CCW);
            } else if (value.equals("D")){
                movs.add(Movements.D_CW);
            } else if (value.equals("D'")){
                movs.add(Movements.D_CCW);
            } else if (value.equals("L")){
                movs.add(Movements.L_CW);
            } else if (value.equals("L'")){
                movs.add(Movements.L_CCW);
            } else {
                throw  new MovementNotFoundException("Wrong sequence, please check.");
            }
        }
        return (movs);
    }

    public void runSequence(List<Integer> movements){
        for(int move : movements){
            switch (move){
                case Movements.U_CW :
                    turnCW(Faces.UP);
                    break;
                case Movements.U_CCW :
                    turnCCW(Faces.UP);
                    break;
                case Movements.F_CW :
                    turnCW(Faces.FRONT);
                    break;
                case Movements.F_CCW :
                    turnCCW(Faces.FRONT);
                    break;
                case Movements.R_CW :
                    turnCW(Faces.RIGHT);
                    break;
                case Movements.R_CCW :
                    turnCCW(Faces.RIGHT);
                    break;
                case Movements.B_CW :
                    turnCW(Faces.BACK);
                    break;
                case Movements.B_CCW :
                    turnCCW(Faces.BACK);
                    break;
                case Movements.D_CW :
                    turnCW(Faces.DOWN);
                    break;
                case Movements.D_CCW :
                    turnCCW(Faces.DOWN);
                    break;
                case Movements.L_CW :
                    turnCW(Faces.LEFT);
                    break;
                case Movements.L_CCW :
                    turnCCW(Faces.LEFT);
                    break;
            }
        }
    }

    public void makeCross() {
        List<Integer>  sequence = null;
        int[] cross = {1, 3, 5, 7};
        int index;
        for (int edge : cross) {
            index = getIndex(cubies, edge);
            switch (index) {
                case 1:
                    break;
                case 3:
                    sequence = parseSequence("R R' D B' B");
                    break;
                case 5:
                    sequence = parseSequence("F' F' D D B' B'");
                    break;
                case 7:
                    sequence = parseSequence("L' R' D' B' B'");
                    break;
                case 9:
                    sequence = parseSequence("F U R U'");
                    break;
                case 11:
                    sequence = parseSequence("U R U'");
                    break;
                case 13:
                    sequence = parseSequence("U F' R F U'");
                    break;
                case 15:
                    sequence = parseSequence("U' L' U");
                    break;
                case 17:
                    sequence = parseSequence("R B");
                    break;
                case 19:
                    sequence = parseSequence("B");
                    break;
                case 21:
                    sequence = parseSequence("U R' U' B");
                    break;
                case 23:
                    sequence = parseSequence("U R' R' U' B");
                    break;
                case 25:
                    sequence = parseSequence("B U' L U");
                    break;
                case 27:
                    sequence = parseSequence("U' L U");
                    break;
                case 29:
                    sequence = parseSequence("B' U' L U");
                    break;
                case 31:
                    sequence = parseSequence("U R' U'");
                    break;
                case 33:
                    sequence = parseSequence("B B");
                    break;
                case 35:
                    sequence = parseSequence("D' B B");
                    break;
                case 37:
                    sequence = parseSequence("D' D' B B");
                    break;
                case 39:
                    sequence = parseSequence("D B B");
                    break;
                case 41:
                    sequence = parseSequence("B'");
                    break;
                case 43:
                    sequence = parseSequence("L' B'");
                    break;
                case 45:
                    sequence = parseSequence("L' L' B'");
                    break;
                case 47:
                    sequence = parseSequence("U' L U B'");
                    break;
            }
            runSequence(sequence);
            turnCCW(Faces.UP);
        }
    }

    public void solveCorners(int index){
        List<Integer>  sequence = null;
        switch (index) {
            case 0:
                break;
            case 2:
                sequence = parseSequence("R D R'");
                solveCorners(46);
                break;
            case 4:
                sequence = parseSequence("R' D D R");
                solveCorners(28);
                break;
            case 6:
                sequence = parseSequence("F' D' F");
                solveCorners(28);
                break;
            case 8:
                sequence = parseSequence("F' B D' F B'");
                break;
            case 10:
                sequence = parseSequence("R' D D R L' D D L D");
                solveCorners(46);
                break;
            case 12:
                sequence = parseSequence("D D");
                solveCorners(28);
                break;
            case 14:
                sequence = parseSequence("D'");
                solveCorners(46);
                break;
            case 16:
                sequence = parseSequence("R' D D R");
                solveCorners(46);
                break;
            case 18:
                sequence = parseSequence("R L' D L R'");
                break;
            case 20:
                sequence = parseSequence("D");
                solveCorners(28);
                break;
            case 22:
                sequence = parseSequence("D D");
                solveCorners(46);
                break;
            case 24:
                sequence = parseSequence("B' D' B D D");
                solveCorners(46);
                break;
            case 26:
                solveCorners(28);
                sequence = parseSequence("D' B D B");
                break;
            case 28:
                sequence = parseSequence("B D B'");
                break;
            case 30:
                sequence = parseSequence("D");
                solveCorners(46);
                break;
            case 32:
                sequence = parseSequence("R'" );
                solveCorners(34);
                break;
            case 34:
                sequence = parseSequence("L D L'");
                solveCorners(22);
                break;
            case 36:
                sequence = parseSequence("D'");
                solveCorners(34);
                break;
            case 38:
                sequence = parseSequence("D D");
                solveCorners(34);
                break;
            case 40:
                solveCorners(46);
                solveCorners(30);
                break;
            case 42:
                sequence = parseSequence("L D L'");
                solveCorners(12);
                break;
            case 44:
                sequence = parseSequence("D'");
                solveCorners(28);
                break;
            case 46:
                sequence = parseSequence("L' D' L");
                break;
        }
        if (sequence != null) {
            runSequence(sequence);
        } else {
            throw new MovementNotFoundException("Error with solving INDEX: " + index);
        }

    }

    public void solveCorners() {
        List<Integer>  sequence = null;
        int[] cross = {0, 2, 4, 6};
        int index;
        for (int edge : cross) {
            index = getIndex(cubies, edge);
            solveCorners(index);

            turnCCW(Faces.UP);
        }
    }

    public void solveEdges() {
        List<Integer>  sequence = null;
        int[] cross = {11, 15};
        int index;
        for (int edge : cross) {
            index = getIndex(cubies, edge);
            solveEdges(index);
            //turnCCW(Faces.UP);
        }
    }

    public String sequenceEdgeBetweenFaces(String faceOnLeft, String faceOnRight) {
        String F = faceOnLeft;
        String R = faceOnRight;
        return (R + "' D " + R +" D "+ F +" D' "+ F +"'");
    }
    public String sequenceEdgeBetweenFaces2(String faceOnLeft, String faceOnRight) {
        String F = faceOnLeft;
        String R = faceOnRight;
        return(F + " D' "+ F + "' D' " + R + "' D " + R);
    }

    public void solveEdges(int index){
        List<Integer>  sequence = null;
        switch (index) {
            case 11:
                break;
            case 13:
                sequence = parseSequence("D'");
                solveEdges(45);
                break;
            case 15:
                sequence = parseSequence(sequenceEdgeBetweenFaces("L", "F") + " D D " +
                           sequenceEdgeBetweenFaces("L", "F"));
                break;
            case 19:
                sequence = parseSequence(sequenceEdgeBetweenFaces("R", "B") +" D' " +
                        sequenceEdgeBetweenFaces2("R", "B"));
                break;
            case 21:
                sequence = parseSequence("D D");
                solveEdges(45);
                break;
            case 23:
                solveEdges(45);
                solveEdges(29);
                break;
            case 27:
                sequence = parseSequence(sequenceEdgeBetweenFaces("B", "L") + " D D " +
                        sequenceEdgeBetweenFaces("B", "L"));
                break;
            case 29:
                sequence = parseSequence("D");
                solveEdges(45);
                break;
            case 31:
                sequence = parseSequence(sequenceEdgeBetweenFaces("R", "B") +" D' " +
                        sequenceEdgeBetweenFaces("R", "B"));
                break;
            case 33:
                sequence = parseSequence("D D");
                solveEdges(37);
                break;
            case 35:
                sequence = parseSequence("D");
                solveEdges(37);
                break;
            case 37:
                sequence = parseSequence("F D' F' D' R' D R");
                break;
            case 39:
                sequence = parseSequence("D'");
                solveCorners(37);
                break;
            case 43:
                sequence = parseSequence("B' D' B D D");
                solveCorners(46);
                break;
            case 45:
                sequence = parseSequence("R' D R D F D' F'");
                break;
            case 47:
                sequence = parseSequence("B D B'");
                break;
        }
        if (sequence != null) {
            runSequence(sequence);
        } else {
            throw new MovementNotFoundException("Error with solving INDEX: " + index);
        }

    }

}
