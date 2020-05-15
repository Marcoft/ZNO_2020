package learn.zno.znostudy.db;

import java.util.List;

public interface methodDb {
    public void addData(DateDb dateDb);
    public DateDb getDate(int id);
    public List<DateDb> getAllContacts();
}
