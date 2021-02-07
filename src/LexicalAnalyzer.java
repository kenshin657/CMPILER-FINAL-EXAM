import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LexicalAnalyzer {

    private static ArrayList<String> readInput() {
        ArrayList<String> inputArray = new ArrayList<String>();
        BufferedReader reader = null;
        String filePath;
        try {
            filePath = "src/input.txt";
            reader = new BufferedReader(new FileReader(filePath));

            String line = reader.readLine();

            while (line != null) {
                inputArray.add(line);
                line =reader.readLine();
            }

            reader.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        return inputArray;
    }

    public static ArrayList<Lex> Tokenize() {
        ArrayList<String> inputArray = readInput();
        ArrayList<Lex> lexical = new ArrayList<Lex>();

        int temp = 0;
        for (String s : inputArray) {
            Lex lex = new Lex();
            temp++;
            String hashKey = s;
            String removedSpace = s;
            removedSpace = removedSpace.replaceAll("\\*", " * ");
            removedSpace = removedSpace.replaceAll("\\+", " + ");
            removedSpace = removedSpace.replaceAll("\\?", " ? ");
            removedSpace = removedSpace.replaceAll("\\(", "( ");
            removedSpace = removedSpace.replaceAll("\\)", " )");
            removedSpace = removedSpace.replaceAll("E", " E ");
            removedSpace = removedSpace.replaceAll("  ", " ");
            lex.setInputKey(hashKey);

            removedSpace = removedSpace.trim();
            String[] strArr = removedSpace.split(" ");

            /*System.out.println("Hash key: " + hashKey);
            System.out.println("Removed Space: " + removedSpace);*/

            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                Token token = new Token(str);
                sb.append(token.tokenType + " ");
            }

            lex.setTokenizedInput(sb.toString());



            lexical.add(lex);
        }

        for (int i = 0; i < lexical.size(); i++) {
            Lex lex1 = lexical.get(i);
            System.out.println("[" + (i+1) + "]: " + "Lexeme: " + lex1.getInputKey() + " Tokenized: " + lex1.getTokenizedInput());
        }

        return lexical;
    }
}
