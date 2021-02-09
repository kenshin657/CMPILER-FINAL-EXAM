import java.util.ArrayList;
import java.util.HashMap;

public class ParseTable {
    /**
     * THIS IS WHERE THE GRAMMAR WILL BE CODED
     * **/

    private HashMap<String, Rules> parseTable;

    /**
     * GENERATE THE PARSING TABLE
     * **/
    public ParseTable() {
        this.parseTable = new HashMap<String, Rules>();
        this.parseTable = generateRulesToHashMap();
    }

    private static HashMap<String, Rules> generateRulesToHashMap() {
        HashMap<String, Rules> pTable = new HashMap<String, Rules>();

        String nt0 = "start";
        Rules rules = new Rules();
        rules.addRules("EPSILON", "ft un");
        rules.addRules("LPAREN", "ft un");
        rules.addRules("TERMINALS", "ft un");
        pTable.put(nt0, rules);

        String nt1 = "ft";
        rules = new Rules();
        rules.addRules("EPSILON", "EPSILON");
        rules.addRules("LPAREN", "tm");
        rules.addRules("TERMINALS", "tm");
        pTable.put(nt1, rules);

        String nt2 = "tm";
        rules = new Rules();
        rules.addRules("LPAREN", "pa tops");
        rules.addRules("TERMINALS", "pa tops");
        pTable.put(nt2, rules);

        String nt3 = "pa";
        rules = new Rules();
        rules.addRules("LPAREN", "LPAREN start RPAREN");
        rules.addRules("TERMINALS", "TERMINALS");
        pTable.put(nt3, rules);

        String nt4 = "un";
        rules = new Rules();
        rules.addRules("LPAREN", "tm un");
        rules.addRules("RPAREN", "''");
        rules.addRules("TERMINALS", "tm un");
        rules.addRules("UNION", "UNION ft un");
        rules.addRules("$", "''");
        pTable.put(nt4, rules);

        String nt5 = "tops";
        rules = new Rules();
        rules.addRules("LPAREN", "''");
        rules.addRules("RPAREN", "''");
        rules.addRules("TERMINALS", "''");
        rules.addRules("UNION", "''");
        rules.addRules("TERMINALSOP", "TERMINALSOP");
        rules.addRules("$", "''");
        pTable.put(nt5, rules);

        return pTable;
    }

    public HashMap<String, Rules> getParseTable() {
        return parseTable;
    }
}
