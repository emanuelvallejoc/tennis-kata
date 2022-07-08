package enums;

public enum Scores {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty"),
    DEUCE("Deuce");

    private String value;

    Scores(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
     public static StringBuilder scoresByScore(Integer score){
        var sb = new StringBuilder("");

         switch(score)
         {

             case 1:
                 sb.append(FIFTEEN.value);
                 break;
             case 2:
                 sb.append(THIRTY.value);
                 break;
             case 3:
                 sb.append(FORTY.value);
                 break;
             default:
                 sb.append(LOVE.value);
                 break;

         }

         return sb;
     }

}
