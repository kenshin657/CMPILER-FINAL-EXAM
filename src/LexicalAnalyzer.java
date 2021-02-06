import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
            String removedSpace = s.replaceAll("\\s","");
            lex.setInputKey(hashKey);

            /*System.out.println("Hash key: " + hashKey);
            System.out.println("Removed Space: " + removedSpace);*/

            char[] array = removedSpace.toCharArray();

            StringBuilder sb = new StringBuilder();
            for (char c : array) {
                Token token = new Token(Character.toString(c));
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
