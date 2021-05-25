import processing.core.PApplet;

public class Main {

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
                                "Usage example: Arguments example: -m \"F F D D L L\"");
                        return;
                    }
                }
                PApplet.main("Cube");
            } catch (Exception e) {
                System.out.println("Error. Please check the arguments.\n" +
                        "Usage example: Arguments example: -m \"F F D D L L\"\n" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Write a sequence as argument.\nAdd flag -m to print vector cube moves." +
                    "\nArguments example: -m \"F F D D L L\"");
        }
    }
}
