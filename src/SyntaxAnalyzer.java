import java.sql.SQLOutput;
import java.util.*;

public class SyntaxAnalyzer {

    public static ArrayList<String> ll1Parse(ArrayList<Lex> lexicals) {
        ParseTable parseTable = new ParseTable();
        HashMap<String, Rules> pTable = parseTable.getParseTable();
        ArrayList<String> output = new ArrayList<String>();

        //System.out.println("SIZE: " + lexicals.size());

        for (Lex lex : lexicals) {
            String input = lex.getInputKey();
            String inputTokens = lex.getTokenizedInput();

            Stack<String> ruleStack = new Stack<String>();
            Stack<String> inputStack = new Stack<String>();

            ruleStack.push("$");
            ruleStack.push("start");
            String[] tokenArr = inputTokens.split(" ");

            inputStack.push("$");
            List<String> tmp = Arrays.asList(tokenArr);
            Collections.reverse(tmp);
            for (int i = 0; i < tmp.size(); i++) {
                inputStack.push(tmp.get(i));
            }

            //System.out.println("Initial Input Stack: " + inputStack);

            while (!inputStack.isEmpty()) {
                String ruleTop = ruleStack.peek();
                String inputTop = inputStack.peek();

                /*System.out.println("Top Rule Stack: " + ruleTop);
                System.out.println("Top Input Stack: " + inputTop);*/

                if (ruleTop.toUpperCase().equals(ruleTop)) {
                    if (ruleTop.equals(inputTop)) {
                        ruleStack.pop();
                        inputStack.pop();
                        //System.out.println();
                        if (ruleTop.equals("$") && inputTop.equals("$")) {
                            //System.out.println("ACCEPTED");
                            input = input + " - ACCEPT";
                            output.add(input);
                            break;
                        } else
                            continue;
                    } else if (ruleTop.equals("''")) {
                        ruleStack.pop();
                        //System.out.println();
                        continue;
                    }
                    else {
                        input = input + " - REJECT";
                        output.add(input);
                        break;
                    }
                }

                Rules rules = pTable.get(ruleTop);

                boolean isExisting = true;
                for (Map.Entry<String, String> hMap: rules.getRules().entrySet()) {
                    //System.out.println("TOP: " + hMap.getKey() + " InputTop: " + inputTop);
                    if (hMap.getKey().equals(inputTop)) {
                        //System.out.println("REACHED HERE");
                        String replace = hMap.getValue();

                        String[] tmpArr = replace.split(" ");
                        List<String> lst = Arrays.asList(tmpArr);
                        Collections.reverse(lst);
                        ruleStack.pop();
                        for (int i = 0; i < lst.size(); i++) {
                            ruleStack.push(lst.get(i));
                        }
                        /*System.out.println("RuleStack: " + ruleStack);
                        System.out.println("Input Stack: " + inputStack);
                        System.out.println();*/

                        isExisting = true;
                        break;
                    }
                    else
                        isExisting = false;
                }
                if (!isExisting) {
                    //System.out.println("REJECTED");
                    input = input + " - REJECT";
                    output.add(input);
                    break;
                }
            }

        }

        return output;
    }

}
