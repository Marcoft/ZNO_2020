package learn.zno.znostudy.TotalStats.StatsDb;

import java.util.List;


public interface methodDbTotalStats {

    public void addDataTotalStats (DateDbTotalStats dateDb);
    public DateDbTotalStats getDateTotalStats(String id);
    public List<DateDbTotalStats> getAllTotalStats ();
    public List<DateDbTotalStats> getAllTotalStatsAndSort (String name);
    public void deleteDateTotalStats(String id);

}
