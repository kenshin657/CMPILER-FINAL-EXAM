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
        rules.addRules("epsilon", "epsilon");
        rules.addRules("LPAREN", "LPAREN start RPAREN to");
        rules.addRules("TERMINALS", "tm");
        pTable.put(nt0, rules);

        String nt1 = "tm";
        rules = new Rules();
        rules.addRules("TERMINALS", "TERMINALS to");
        pTable.put(nt1, rules);

        String nt2 = "to";
        rules = new Rules();
        rules.addRules("RPAREN", "''");
        rules.addRules("TERMINALSOP", "TERMINALSOP re");
        rules.addRules("UNION", "un");
        rules.addRules("$", "''");
        pTable.put(nt2, rules);

        String nt3 = "un";
        rules = new Rules();
        rules.addRules("UNION", "UNION ep");
        pTable.put(nt3, rules);

        String nt4 = "ep";
        rules = new Rules();
        rules.addRules("LPAREN", "start");
        rules.addRules("TERMINALS", "start");
        rules.addRules("EPSILON", "EPSILON");
        pTable.put(nt4, rules);

        String nt5 = "re";
        rules = new Rules();
        rules.addRules("LPAREN", "start");
        rules.addRules("TERMINALS", "start");
        rules.addRules("RPAREN", "''");
        rules.addRules("UNION", "un");
        rules.addRules("$", "''");
        pTable.put(nt5, rules);

        return pTable;
    }

    public HashMap<String, Rules> getParseTable() {
        return parseTable;
    }
}
