import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Lex> lexes = LexicalAnalyzer.Tokenize();

        /*for (int i = 0; i < lexes.size(); i++) {
            Lex lex1 = lexes.get(i);
            System.out.println("[" + (i+1) + "]: " + "Lexeme: " + lex1.getInputKey() + " Tokenized: " + lex1.getTokenizedInput());
        }*/

        /*lexes.clear();
        Lex lex = new Lex();
        lex.setInputKey("(0U1)(0U1)*");
        lex.setTokenizedInput("LPAREN TERMINALS UNION TERMINALS RPAREN LPAREN TERMINALS UNION TERMINALS RPAREN TERMINALSOP");
        lexes.add(lex);*/

        ArrayList<String> outputs = SyntaxAnalyzer.ll1Parse(lexes);

        System.out.println("\n\n");
        for (String str : outputs) {
            System.out.println(str);
        }


        try {
            FileWriter fw = new FileWriter("output.txt");

            for (String out : outputs) {
                fw.write(out + "\n");
            }
            fw.close();
        } catch (IOException err)  {
            err.printStackTrace();
        }


    }

}
