package cli;

public class CLI {
    public static void printColorLn(ANSI color, String ... str){
        StringBuilder sb = new StringBuilder(color.value);

        for(String s: str){
            sb.append(s + " ");
        }

        sb.append(ANSI.RESET.value);

        System.out.println(sb.toString());

    }

}
