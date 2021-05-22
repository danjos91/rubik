import java.util.ArrayList;
import java.util.List;

public final class Cubies {

    private static Cubies instance;
    public boolean print = true;
    public static Cubies getInstance() {
        if (instance == null) {
            instance = new Cubies();
        }
        return instance;
    }

    public Faces up = new Faces("up",1, 1 ,1 ,1);
    public Faces front = new Faces("front",1, 4 ,3 ,2);
    public Faces right = new Faces("right",2, 4 ,2 ,2);
    public Faces back = new Faces("back",3, 4 ,1 ,2);
    public Faces left = new Faces("left",4, 4 ,4 ,2);
    public Faces down = new Faces("down",3, 3 ,3 ,3);
    public CubeData cubeData = new CubeData(up, front, right, back, left, down);

    public void initCube() {
        up.setVectorFace(new Vector(0,1,2,3,4,5,6,7));
        front.setVectorFace(new Vector(8,9,10,11,12,13,14,15));
        right.setVectorFace(new Vector(16,17,18,19,20,21,22,23));
        back.setVectorFace(new Vector(24,25,26,27,28,29,30,31));
        left.setVectorFace(new Vector(32,33,34,35,36,37,38,39));
        down.setVectorFace(new Vector(40,41,42,43,44,45,46,47));

    }


    public int[] cubies  = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7,
            8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23,
            24, 25, 26, 27, 28, 29, 30, 31,
            32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47
    };

    public void updateCubies() {
        int i;
        List<Integer> vectorUp = up.getVectorFace().getVector();
        i = 0;
        for(Integer value: vectorUp) {
            cubies[i++] = value;
        }
        List<Integer> vectorFront = front.getVectorFace().getVector();
        for(Integer value: vectorFront) {
            cubies[i++] = value;
        }
        List<Integer> vectorRight = right.getVectorFace().getVector();
        for(Integer value: vectorRight) {
            cubies[i++] = value;
        }
        List<Integer> vectorBack = back.getVectorFace().getVector();
        for(Integer value: vectorBack) {
            cubies[i++] = value;
        }
        List<Integer> vectorLeft = left.getVectorFace().getVector();
        for(Integer value: vectorLeft) {
            cubies[i++] = value;
        }
        List<Integer> vectorDown = down.getVectorFace().getVector();
        for(Integer value: vectorDown) {
            cubies[i++] = value;
        }
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

    public List<Movements> parseSequence(String sequence) {
        String[] values = sequence.trim().split(" ");
        List<Movements> movs = new ArrayList<Movements>();
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
            } else if (!value.equals("")){
                throw  new MovementNotFoundException("Wrong sequence, please check. Movement = " + value);
            }
        }
        return (movs);
    }

    public void runSequence(List<Movements> movements){
        for(Movements move : movements){
            switch (move){
                case U_CW:
                    up.rotateCW();
                    break;
                case U_CCW :
                    up.rotateCCW();
                    break;
                case F_CW :
                    front.rotateCW();
                    break;
                case F_CCW :
                    front.rotateCCW();
                    break;
                case R_CW :
                    right.rotateCW();
                    break;
                case R_CCW :
                    right.rotateCCW();
                    break;
                case B_CW :
                    back.rotateCW();
                    break;
                case B_CCW :
                    back.rotateCCW();
                    break;
                case D_CW :
                    down.rotateCW();
                    break;
                case D_CCW :
                    down.rotateCCW();
                    break;
                case L_CW :
                    left.rotateCW();
                    break;
                case L_CCW :
                    left.rotateCCW();
                    break;
            }
            updateCubies();
        }

    }

    public String makeCross() {
        int[] cross = {1, 3, 5, 7};
        List<Movements>  sequence = null;
        String result = "";
        String solution = "";
        int index;
        for (int edge : cross) {
            index = getIndex(cubies, edge);
            solution = makeCross(index);
            System.out.println("For EDGE " + edge + " in index " + index + "the solution is " + solution + " U'");
            sequence = parseSequence(solution);
            runSequence(sequence);
            up.rotateCCW();
            result += solution + " U'";
        }
        return result;
    }

    public String makeCross(int index) {
        String solution = "";
        switch (index) {
            case 3:
                solution = " R R D B B";
                break;
            case 5:
                solution = " F F D D B B";
                break;
            case 7:
                solution = " L L D' B B";;
                break;
            case 9:
                solution =" F U R U'";
                break;
            case 11:
                solution = " U R U'";
                break;
            case 13:
                solution = " U F' R F U'";
                break;
            case 15:
                solution = " U' L' U";
                break;
            case 17:
                solution = " R B";
                break;
            case 19:
                solution = " B";
                break;
            case 21:
                solution = " U R' U' B";
                break;
            case 23:
                solution = " U R' R' U' B";
                break;
            case 25:
                solution = " B" + makeCross(27);
                break;
            case 27:
                solution = " U' L U";
                break;
            case 29:
                solution = " B' U' L U";
                break;
            case 31:
                solution = " U R' U'";
                break;
            case 33:
                solution = " L' B'";
                break;
            case 35:
                solution = " U U F U U";
                break;
            case 37:
                solution = " L B' L'";
                break;
            case 39:
                solution = " B'";
                break;
            case 41:
                solution = " D D" + makeCross(45);;
                break;
            case 43:
                solution = " D" + makeCross(45);
                break;
            case 45:
                solution = " B B";
                break;
            case 47:
                solution = " D'" + makeCross(45);
                break;
        }
        return solution;
    }

    public String solveCorners() {
        List<Movements>  sequence = null;
        int[] corners = {0, 2, 4, 6};
        String result = "";
        String solution = "";
        int index;
        for (int corner : corners) {
            index = getIndex(cubies, corner);
            solution = solveCorners(index);
            System.out.println("For CORNER " + corner + " in index " + index + " the solution is " + solution + " U'");
            sequence = parseSequence(solution);
            runSequence(sequence);
            up.rotateCCW();
            result += solution + " U'";
        }
        return result;
    }

    private String solveCorners(int index){
        String solution = "";
        switch (index) {
            case 2:
                solution = " R D R'" + solveCorners(38);
                break;
            case 4:
                solution = " R' D D R" + solveCorners(28);
                break;
            case 6:
                solution = " F' D' F" + solveCorners(28);
                break;
            case 8:
                solution = " F' B D' F B'";
                break;
            case 10:
                solution = " F D D" + solveCorners(28);
                break;
            case 12:
                solution = " D D" + solveCorners(28);
                break;
            case 14:
                solution = " D'" + solveCorners(38);
                break;
            case 16:
                solution = " R' D D R" + solveCorners(38);
                break;
            case 18:
                solution = " R L' D L R'";//    R D R' + 28
                break;
            case 20:
                solution = " D" + solveCorners(28);
                break;
            case 22:
                solution = " D D" + solveCorners(38);
                solveCorners(46);
                break;
            case 24:
                solution = " B' D' B D D" + solveCorners(46);
                break;
            case 26:
                solution = " B D B' D'" + solveCorners(28);
                break;
            case 28:
                solution = " B D B'";
                break;
            case 30:
                solution = " D" + solveCorners(38);
                break;
            case 32:
                solution = " L' D' L D" + solveCorners(38);;
                break;
            case 34:
                solution = " L D L'" + solveCorners(12);
                break;
            case 36:
                solution = " D'" + solveCorners(28);
                break;
            case 38:
                solution = " L' D' L";
                break;
            case 40:
                solution = " D'" + solveCorners(46);
                break;
            case 42:
                solution = " D D" + solveCorners(46);
                break;
            case 44:
                solution = " D" + solveCorners(46);
                break;
            case 46:
                solution = " B D D B' D'" + solveCorners(28);
                break;
        }
        return solution;
    }


    String[] orderFaces = {" U", " F", " R", " B", " D", " L"};


    public String solveEdges() {
        String result = "";
        String solution;
        int[] edges = {11, 19, 27, 43};
        List<String[]> orderY = new ArrayList<String[]>();
        String[] orderFaces1 = {" U", " R", " B", " L", " D", " F"};
        String[] orderFaces2 = {" U", " B", " L", " F", " D", " R"};
        String[] orderFaces3 = {" U", " L", " F", " R", " D", " B"};
        orderY.add(orderFaces);
        orderY.add(orderFaces1);
        orderY.add(orderFaces2);
        orderY.add(orderFaces3);
        int index;
        int i = 0;
        for (int edge : edges) {
            index = getIndex(cubies, edge);
            //System.out.println("Edge: " + edge);
            solution = solveEdges(index);
            orderFaces = orderY.get(i++);
            result += solution;
        }
        return result;
    }

    public String sequenceEdgeBetweenFaces(String faceOnLeft, String faceOnRight) {
        String F = faceOnLeft;
        String R = faceOnRight;
        return (R + "' D" + R +" D"+ F +" D'"+ F +"'");
    }
    public String sequenceEdgeBetweenFaces2(String faceOnLeft, String faceOnRight) {
        String F = faceOnLeft;
        String R = faceOnRight;
        return(F + " D'"+ F + "' D'" + R + "' D" + R);
    }

    private String solveEdges(int index){
        String solution = "";
        String up = orderFaces[0];
        String front = orderFaces[1];
        String right = orderFaces[2];
        String back = orderFaces[3];
        String down = orderFaces[4];
        String left = orderFaces[5];
        String minus = "'";
        List<Movements> sequence;
        switch (index) {
            case 13:
                solution = up + "'";
                solveEdges(45);
                break;
            case 15:
                solution = sequenceEdgeBetweenFaces(left, front) + down + down;
                solveEdges(45);
                break;
            case 19:
                solution = sequenceEdgeBetweenFaces(right, back) + down + minus;
                solveEdges(37);
                break;
            case 21:
                solution = down + down;
                solveEdges(45);
                break;
            case 23:
                solveEdges(45);
                solveEdges(29);
                break;
            case 27:
                solution = sequenceEdgeBetweenFaces(back, left);
                solveEdges(33);
                break;
            case 29:
                solution = down;
                solveEdges(45);
                break;
            case 31:
                solution = sequenceEdgeBetweenFaces(right, back);
                solveEdges(45);
                break;
            case 33:
                solution = down + down;
                solveEdges(37);
                break;
            case 35:
                solution = down;
                solveEdges(37);
                break;
            case 37://main sequence mirror
                solution = front + down + minus + front + minus + down +
                        minus + right + minus + down + right;
                break;
            case 39:
                solution = down + minus;
                solveCorners(37);
                break;
            case 43:
                solution = sequenceEdgeBetweenFaces(left, front) + down;
                solveEdges(37);
                break;
            case 45://main sequence
                solution = right + minus + down + right + down + front +
                        down + minus + front + minus;
                break;
            case 47:
                solution = sequenceEdgeBetweenFaces(back, left);
                solveEdges(13);
                break;
        }
        sequence = parseSequence(solution);
        runSequence(sequence);
        return solution;
    }

    public void printCube(){
        System.out.println("-----------------------------------------\n   \t\t\tUP\n" +
                "   \t\t\t" + cubies[0] + " "+ cubies[1] + " "         + cubies[2] + "   \n" +
                "   \t\t\t" + cubies[7] + " "+"\033[43mU \033[0m"+ " " + cubies[3] + "   \n" +
                "   \t\t\t" + cubies[6] + " "+ cubies[5] + " "         + cubies[4] + "   \n" +
                "LEFT\t\t_________\t RIGHT\t\t BACK\n" +
                cubies[32] + " "+ cubies[33] + " "          + cubies [34] + "   \t" + cubies[8] + " " + cubies[9] + " "          + cubies[10] + "   \t" + cubies[16] + " "+ cubies[17] + " "                +       cubies[18] + "   \t" + cubies[24] + " " + cubies[25] + " " + cubies[26] + "\n" +
                cubies[39] + " "+ "\033[41mL \033[0m" + " " + cubies [35] + "   \t" + cubies[15] + " " +"\033[42mF \033[0m"+ " " + cubies[11] + "   \t" + cubies[23] + " "+ "\033[48:2:255:165:0mR \033[0m" + " " + cubies[19]  + "   \t" + cubies[31] + " " +   "\033[44mB \033[0m"     + " " + cubies[27] + "\n" +
                cubies[38] + " "+ cubies[37] + " "          + cubies [36] + "   \t" + cubies[14] + " " + cubies[13] + " "        + cubies[12] + "   \t" + cubies[22] + " "+ cubies[21] + " "                 +      cubies[20] + "   \t" + cubies[30] + " " + cubies[29] + " " + cubies[28] + "\n" +
                "   \t\t\t_________\n" +
                "   \t\t\t" + cubies[40] + " " + cubies[41] + " " + cubies[42] + "\n" +
                "   \t\t\t" + cubies[47] + " " +   "\033[47mD \033[0m"    + " " + cubies[43] + "\n" +
                "   \t\t\t" + cubies[46] + " " + cubies[45] + " " + cubies[44] + "\n" +
                "   \t\t\t DOWN");
    }

}
