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

    public void makeCross() {
        int[] cross = {1, 3, 5, 7};
        int index;
        for (int edge : cross) {
            index = getIndex(cubies, edge);
            switch (index) {
                case 1:
                    break;
                case 3:
                    crossSequence.add(turnCCW(Faces.RIGHT));
                    crossSequence.add(turnCCW(Faces.RIGHT));
                    crossSequence.add(turnCW(Faces.DOWN));
                    crossSequence.add(turnCCW(Faces.BACK));
                    crossSequence.add(turnCCW(Faces.BACK));
                    break;
                case 5:
                    crossSequence.add(turnCCW(Faces.FRONT));
                    crossSequence.add(turnCCW(Faces.FRONT));
                    crossSequence.add(turnCW(Faces.DOWN));
                    crossSequence.add(turnCW(Faces.DOWN));
                    crossSequence.add(turnCCW(Faces.BACK));
                    crossSequence.add(turnCCW(Faces.BACK));
                    break;
                case 7:
                    crossSequence.add(turnCCW(Faces.LEFT));
                    crossSequence.add(turnCCW(Faces.RIGHT));
                    crossSequence.add(turnCCW(Faces.DOWN));
                    crossSequence.add(turnCCW(Faces.BACK));
                    crossSequence.add(turnCCW(Faces.BACK));
                    break;
                case 9:
                    crossSequence.add(turnCW(Faces.FRONT));
                    crossSequence.add(turnCW(Faces.UP));
                    crossSequence.add(turnCW(Faces.RIGHT));
                    crossSequence.add(turnCCW(Faces.UP));
                    break;
                case 11:
                    crossSequence.add(turnCW(Faces.UP));
                    crossSequence.add(turnCW(Faces.RIGHT));
                    crossSequence.add(turnCCW(Faces.UP));
                    break;
                case 13:
                    turnCW(Faces.UP);
                    turnCCW(Faces.FRONT);
                    turnCW(Faces.RIGHT);
                    turnCW(Faces.FRONT);
                    turnCCW(Faces.UP);
                    break;
                case 15:
                    turnCCW(Faces.UP);
                    turnCCW(Faces.LEFT);
                    turnCW(Faces.UP);
                    break;
                case 17:
                    turnCW(Faces.RIGHT);
                    turnCW(Faces.BACK);
                    break;
                case 19:
                    turnCW(Faces.BACK);
                    break;
                case 21:
                    turnCW(Faces.UP);
                    turnCCW(Faces.RIGHT);
                    turnCCW(Faces.UP);
                    turnCW(Faces.BACK);
                    break;
                case 23:
                    turnCW(Faces.UP);
                    turnCCW(Faces.RIGHT);
                    turnCCW(Faces.RIGHT);
                    turnCCW(Faces.UP);
                    turnCW(Faces.BACK);
                    break;
                case 25:
                    turnCW(Faces.BACK);
                    turnCCW(Faces.UP);
                    turnCW(Faces.LEFT);
                    turnCW(Faces.UP);
                    break;
                case 27:
                    turnCCW(Faces.UP);
                    turnCW(Faces.LEFT);
                    turnCW(Faces.UP);
                    break;
                case 29:
                    turnCCW(Faces.BACK);
                    turnCCW(Faces.UP);
                    turnCW(Faces.LEFT);
                    turnCW(Faces.UP);
                    break;
                case 31:
                    turnCW(Faces.UP);
                    turnCCW(Faces.RIGHT);
                    turnCCW(Faces.UP);
                    break;
                case 33:
                    turnCW(Faces.BACK);
                    turnCW(Faces.BACK);
                    break;
                case 35:
                    turnCCW(Faces.DOWN);
                    turnCW(Faces.BACK);
                    turnCW(Faces.BACK);
                    break;
                case 37:
                    turnCCW(Faces.DOWN);
                    turnCCW(Faces.DOWN);
                    turnCW(Faces.BACK);
                    turnCW(Faces.BACK);
                    break;
                case 39:
                    turnCW(Faces.DOWN);
                    turnCW(Faces.BACK);
                    turnCW(Faces.BACK);
                    break;
                case 41:
                    turnCCW(Faces.BACK);
                    break;
                case 43:
                    turnCCW(Faces.LEFT);
                    turnCCW(Faces.BACK);
                    break;
                case 45:
                    turnCCW(Faces.LEFT);
                    turnCCW(Faces.LEFT);
                    turnCCW(Faces.BACK);
                    break;
                case 47:
                    turnCCW(Faces.UP);
                    turnCW(Faces.LEFT);
                    turnCW(Faces.UP);
                    turnCCW(Faces.BACK);
                    break;
            }
            turnCCW(Faces.UP);
        }
    }


}

/*
 String[] cubiesOrder  = new String[] {
            "1", "2", "3", "4", "6", "7", "8", "9",
            "11", "12", "13", "14", "16", "17", "18", "19",
            "21", "22", "23", "24", "26", "27", "28", "29",
            "31", "32", "33", "34", "36", "37", "38", "39",
            "41", "42", "43", "44", "46", "47", "48", "49",
            "51", "52", "53", "54", "56", "57", "58", "59"
    };



    static int[] cubiesOrderInt2  = new int[] {
            7, 8, 1, 2, 3, 4, 5, 6,
            21, 22, 23, 14, 15, 16, 17, 18,
            31, 32, 33, 24, 25, 26, 27, 28,
            53, 54, 55, 34, 35, 36, 37, 38,
            41, 42, 43, 44, 45, 46, 47, 48,
            51, 52, 11, 12, 13, 56, 57, 58,
    };

    static int[] cubiesOrderInt3  = new int[] {
            3, 4, 5, 6, 7, 8, 1, 2,
            21, 22, 23, 14, 15, 16, 17, 18,
            31, 32, 33, 24, 25, 26, 27, 28,
            53, 54, 55, 34, 35, 36, 37, 38,
            41, 42, 43, 44, 45, 46, 47, 48,
            51, 52, 11, 12, 13, 56, 57, 58,
    };

        static int[] changeToFrontd(int[] pos) {//UFRBDL
        return new int[] {
                pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7],
                pos[8], pos[9], pos[10], pos[11], pos[12], pos[13], pos[14], pos[15],
                pos[16], pos[17], pos[18], pos[19], pos[20], pos[21], pos[22], pos[23],
                pos[24], pos[25], pos[26], pos[27], pos[28], pos[29], pos[30], pos[31],
                pos[32], pos[33], pos[34], pos[35], pos[36], pos[37], pos[38], pos[39],
                pos[40], pos[41], pos[42], pos[43], pos[44], pos[45], pos[46], pos[47]

        };
    }

    static int[] changeToFront(int[] pos) {//UFRBDL
        return new int[] {
                pos[8], pos[9], pos[10], pos[11], pos[12], pos[13], pos[14], pos[15],
                pos[16], pos[17], pos[18], pos[19], pos[20], pos[21], pos[22], pos[23],
                pos[24], pos[25], pos[26], pos[27], pos[28], pos[29], pos[30], pos[31],
                pos[32], pos[33], pos[34], pos[35], pos[36], pos[37], pos[38], pos[39],
                pos[40], pos[41], pos[42], pos[43], pos[44], pos[45], pos[46], pos[47],
                pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7]
        };
    }

    static int[] changeToRight(int[] pos) {//FRBDLU
        return new int[] {
                pos[16], pos[17], pos[18], pos[19], pos[20], pos[21], pos[22], pos[23],
                pos[24], pos[25], pos[26], pos[27], pos[28], pos[29], pos[30], pos[31],
                pos[32], pos[33], pos[34], pos[35], pos[36], pos[37], pos[38], pos[39],
                pos[40], pos[41], pos[42], pos[43], pos[44], pos[45], pos[46], pos[47],
                pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7],
                pos[8], pos[9], pos[10], pos[11], pos[12], pos[13], pos[14], pos[15]
        };
    }

    static int[] changeToBack(int[] pos) {//RBDLUF
        return new int[] {
                pos[24], pos[25], pos[26], pos[27], pos[28], pos[29], pos[30], pos[31],
                pos[32], pos[33], pos[34], pos[35], pos[36], pos[37], pos[38], pos[39],
                pos[40], pos[41], pos[42], pos[43], pos[44], pos[45], pos[46], pos[47],
                pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7],
                pos[8], pos[9], pos[10], pos[11], pos[12], pos[13], pos[14], pos[15],
                pos[16], pos[17], pos[18], pos[19], pos[20], pos[21], pos[22], pos[23]
        };
    }

    static int[] changeToDown(int[] pos) {//BDLUFR
        return new int[] {
                pos[32], pos[33], pos[34], pos[35], pos[36], pos[37], pos[38], pos[39],
                pos[40], pos[41], pos[42], pos[43], pos[44], pos[45], pos[46], pos[47],
                pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7],
                pos[8], pos[9], pos[10], pos[11], pos[12], pos[13], pos[14], pos[15],
                pos[16], pos[17], pos[18], pos[19], pos[20], pos[21], pos[22], pos[23],
                pos[24], pos[25], pos[26], pos[27], pos[28], pos[29], pos[30], pos[31]
        };
    }

    static int[] changeToLeft(int[] pos) {//DLUFRB
        return new int[] {
                pos[40], pos[41], pos[42], pos[43], pos[44], pos[45], pos[46], pos[47],
                pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7],
                pos[8], pos[9], pos[10], pos[11], pos[12], pos[13], pos[14], pos[15],
                pos[16], pos[17], pos[18], pos[19], pos[20], pos[21], pos[22], pos[23],
                pos[24], pos[25], pos[26], pos[27], pos[28], pos[29], pos[30], pos[31],
                pos[32], pos[33], pos[34], pos[35], pos[36], pos[37], pos[38], pos[39]
        };
    }
* */
