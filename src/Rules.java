import java.util.HashMap;

public class Rules {
    private HashMap<String, String> rules;

    public Rules () {
        this.rules = new HashMap<String, String>();
    }

    public void addRules(String terminal, String rule) {
        this.rules.put(terminal, rule);
    }

    public HashMap<String, String> getRules() {
        return rules;
    }
}
