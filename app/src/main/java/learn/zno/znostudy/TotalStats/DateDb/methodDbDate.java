package learn.zno.znostudy.TotalStats.DateDb;

import java.util.List;

public interface methodDbDate {

    public void addDataInStats (DateDbStats dateDb);
    public DateDbStats getDateFromStats (int id);
    public List<DateDbStats> getAllDateFromStats ();
    public void deleteDateFromStats(int id);

}
