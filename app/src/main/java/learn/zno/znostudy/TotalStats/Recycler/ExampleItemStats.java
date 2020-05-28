package learn.zno.znostudy.TotalStats.Recycler;

public class ExampleItemStats {

    private String idText;
    private String typeTest;
    private String statsTest;
    private String dateTest;

    public ExampleItemStats(String idText, String typeTest, String statsTest, String dateTest) {
        this.idText = idText;
        this.typeTest = typeTest;
        this.statsTest = statsTest;
        this.dateTest = dateTest;
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

}
