public class Token {
    enum TokenType{
        EPSILON,
        STAR,
        PLUS,
        LPAREN,
        RPAREN,
        QUESTION,
        UNION,
        TERMINAL,
        ERROR,
    }

    public TokenType tokenType;
    public String lexeme;

    public Token(String word) {
        this.tokenType = identifyToken(word);
        this.lexeme = word;
    }


    private static TokenType identifyToken(String word) {
        int state = 0; // start state
        char[] ch = word.toCharArray();

        for(char c : ch) {
            switch (c) {
                case '*':
                    state = 1;
                    break;
                case  '+':
                    state = 2;
                    break;
                case 'E':
                    state = 3;
                    break;
                case '(':
                    state = 4;
                    break;
                case ')':
                    state = 5;
                    break;
                case '?':
                    state = 6;
                    break;
                case 'U':
                    state = 7;
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    state = 8;
                    break;

                default:
                    state = 999; //deadstate
                    break;
            }
        }

    if (state == 1)
        return TokenType.STAR;
    else if (state == 2)
        return TokenType.PLUS;
    else if (state == 3)
        return TokenType.EPSILON;
    else if (state == 4)
        return TokenType.LPAREN;
    else if (state == 5)
        return TokenType.RPAREN;
    else if (state == 6)
        return TokenType.QUESTION;
    else if (state == 7)
        return TokenType.UNION;
    else if (state == 8)
        return TokenType.TERMINAL;
    else if (state == 999)
        return TokenType.ERROR;
    else
        return TokenType.ERROR;
    }
}
