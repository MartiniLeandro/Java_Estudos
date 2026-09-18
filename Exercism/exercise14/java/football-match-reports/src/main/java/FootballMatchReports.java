public class FootballMatchReports {    
    public static String onField(int shirtNum) {
        String playerFunction;
        switch (shirtNum) {
            case 1:
                playerFunction = "goalie";
                break;
            case 2:
                playerFunction = "left back";
                break;
            case 3,4:
                playerFunction = "center back";
                break;
            case 5:
                playerFunction = "right back";
                break;
            case 6,7,8:
                playerFunction = "midfielder";
                break;
            case 9:
                playerFunction = "left wing";
                break;
            case 10:
                playerFunction = "striker";
                break;
            case 11:
                playerFunction = "right wing";
                break;
            default:
                playerFunction = "invalid";
                break;
        }
        return playerFunction;
    }
}
