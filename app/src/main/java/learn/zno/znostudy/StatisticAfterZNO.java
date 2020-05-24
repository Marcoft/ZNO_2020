package learn.zno.znostudy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import learn.zno.znostudy.Recycler.ExampleAdapter;
import learn.zno.znostudy.Recycler.ExampleItem;
import learn.zno.znostudy.TotalStats.DateDb.DateDbStats;
import learn.zno.znostudy.TotalStats.StatsDb.DateDbTotalStats;
import learn.zno.znostudy.db.DBHelpers;
import learn.zno.znostudy.db.DateDb;

public class StatisticAfterZNO extends AppCompatActivity {


    TextView RightAnswers;

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    DBHelpers dbHelpers;

    List<String> quest = new ArrayList<>();
    List<String> answe1 = new ArrayList<>();
    List<String> answe2 = new ArrayList<>();
    List<String> answe3 = new ArrayList<>();
    List<String> answe4 = new ArrayList<>();
    List<String> answe5 = new ArrayList<>();
    List<String> result = new ArrayList<>();
    List<String> RightAnswer= new ArrayList<>();

    int rightAnswers;

    int k = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_after_z_n_o);

        dbHelpers = new DBHelpers(this);

        RightAnswers = (TextView) findViewById(R.id.RightAnswers);


        mExampleList = new ArrayList<ExampleItem>();
        result.clear();
        Intent intent = getIntent();
        k = intent.getIntExtra("k",1);
        result.add(intent.getStringExtra("1"));
        result.add(intent.getStringExtra("2"));
        result.add(intent.getStringExtra("3"));
        result.add(intent.getStringExtra("4"));
        result.add(intent.getStringExtra("5"));
        result.add(intent.getStringExtra("6"));
        result.add(intent.getStringExtra("7"));
        result.add(intent.getStringExtra("8"));
        result.add(intent.getStringExtra("9"));
        result.add(intent.getStringExtra("10"));
        result.add(intent.getStringExtra("11"));
        result.add(intent.getStringExtra("12"));
        result.add(intent.getStringExtra("13"));
        result.add(intent.getStringExtra("14"));
        result.add(intent.getStringExtra("15"));
        result.add(intent.getStringExtra("16"));
        result.add(intent.getStringExtra("17"));
        result.add(intent.getStringExtra("18"));
        result.add(intent.getStringExtra("19"));
        result.add(intent.getStringExtra("20"));


        DateDb dateDb = null;

        for (int i = k; i < k+20;i ++){
            dateDb = dbHelpers.getDate(i);
            quest.add(dateDb.getQuestion());
            answe1.add(dateDb.getAnswer1());
            answe2.add(dateDb.getAnswer2());
            answe3.add(dateDb.getAnswer3());
            answe4.add(dateDb.getAnswer4());
            answe5.add(dateDb.getAnswer5());
            RightAnswer.add(dateDb.getAnswer1());
        }

        for(int i = 1; i <= 20; i ++) {
            mExampleList.add(new ExampleItem("Питання : " + i, quest.get(i-1), answe1.get(i-1), result.get(i-1)));
        }

        rightAnswers = 0;
        for(int i = 0; i < 20; i ++) {
            if(RightAnswer.get(i).equalsIgnoreCase(result.get(i))){
                rightAnswers++;
            }
        }
        RightAnswers.setText("Кількість правильних відповідей: " + rightAnswers);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new ExampleAdapter(mExampleList,RightAnswer,result);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        addDateInADatabase();
       // mt = new MyTask();  //TODO Another Thread for Adding BD
       // mt.execute();

    }

    MyTask mt;
   private class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            addDateInADatabase(); // Add Bd Date
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }


    int numberStat = 0;
    int endDate = 0;
    private void addDateInADatabase (){
        // Текущее время
        Date currentDate = new Date();
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        // Форматирование времени как "часы:минуты:секунды"
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);

        List<DateDbTotalStats> listDateDbTotalStats = dbHelpers.getAllTotalStats();
        List<DateDbStats> listDateDbStats = dbHelpers.getAllDateFromStats();

        numberStat = listDateDbTotalStats.size();
        endDate = listDateDbStats.size();

        numberStat++;
        endDate++;
        dbHelpers.addDataTotalStats(new DateDbTotalStats("Статистика №" + numberStat, "ЗНО", rightAnswers + "/20", timeText + "  " + dateText, 20, endDate, endDate + 20 ));
        for (int i = 1; i <= 20;i ++){
            dbHelpers.addDataInStats(new DateDbStats(endDate, quest.get(i-1),result.get(i-1), answe1.get(i-1)));
            endDate++;
        }

    }


    @Override
    public void onBackPressed() {
        dbHelpers.close();
        finish();
        super.onBackPressed();
    }

    public void EndActivity(View view) {
        dbHelpers.close();
        finish();
    }
}
