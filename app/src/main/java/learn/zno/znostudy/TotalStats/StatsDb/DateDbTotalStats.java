package learn.zno.znostudy.TotalStats.StatsDb;

public class DateDbTotalStats {

    private String idText;
    private String typeTest;
    private String statsTest;
    private String dateTest;
    private int CountAnswers;
    private int startSize;
    private int endSize;

    public DateDbTotalStats(){

    }

    public DateDbTotalStats(String idText, String typeTest, String statsTest, String dateTest,int CountAnswers,int startSize,int endSize) {
        this.idText = idText;
        this.typeTest = typeTest;
        this.statsTest = statsTest;
        this.dateTest = dateTest;
        this.CountAnswers = CountAnswers;
        this.startSize = startSize;
        this.endSize = endSize;
    }

    public String getIdText() {
        return idText;
    }

    public String getTypeTest() {
        return typeTest;
    }

    public String getStatsTest() {
        return statsTest;
    }

    public String getDateTest() {
        return dateTest;
    }

    public int getCountAnswers() {
        return CountAnswers;
    }

    public int getStartSize() {
        return startSize;
    }

    public int getEndSize() {
        return endSize;
    }

    public void setIdText(String idText) {
        this.idText = idText;
    }

    public void setTypeTest(String typeTest) {
        this.typeTest = typeTest;
    }

    public void setStatsTest(String statsTest) {
        this.statsTest = statsTest;
    }

    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }

    public void setCountAnswers(int countAnswers) {
        CountAnswers = countAnswers;
    }

    public void setStartSize(int startSize) {
        this.startSize = startSize;
    }

    public void setEndSize(int endSize) {
        this.endSize = endSize;
    }
}
