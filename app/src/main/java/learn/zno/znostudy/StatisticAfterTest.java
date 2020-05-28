package learn.zno.znostudy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

public class StatisticAfterTest extends AppCompatActivity {

    TextView RightAnswers;

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    DBHelpers dbHelpers;


    List<String> result = new ArrayList<>();
    List<String> questi = new ArrayList<>();
    List<String> RightAnswer= new ArrayList<>();

    int rightAnswer = 0;
    int allQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_after_test);
        dbHelpers = new DBHelpers(this);
        RightAnswers = (TextView) findViewById(R.id.RightAnswers);

        mExampleList = new ArrayList<ExampleItem>();
        result.clear();
        Intent intent = getIntent();
        allQuestion = intent.getIntExtra("YourAnswer.size",0);

        for(int i = 0; i < intent.getIntExtra("YourAnswer.size",1);i++){
            result.add(intent.getStringExtra(String.valueOf(i)));
            questi.add(intent.getStringExtra(String.valueOf(i + "k")));
            RightAnswer.add(intent.getStringExtra(String.valueOf(i + "r")));
        }


       for(int i = 1; i <= intent.getIntExtra("YourAnswer.size",1)  ; i ++) {
            mExampleList.add(new ExampleItem("Питання : " + i, questi.get(i-1), RightAnswer.get(i-1), result.get(i-1)));
        }

        rightAnswer = 0;
        for(int i = 0; i < intent.getIntExtra("YourAnswer.size",1); i ++) {
            if(RightAnswer.get(i).equalsIgnoreCase(result.get(i))){
                rightAnswer++;
            }
        }
        RightAnswers.setText("Кількість правильних відповідей: " + rightAnswer);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new ExampleAdapter(mExampleList,RightAnswer,result);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        addDateInADatabase();

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

        LoadPreferences();

        numberStat = lastPositionNumber;
        endDate = lastPositionDate;

        if(numberStat == 0){
            numberStat++;
        }
        if(endDate == 0){
            endDate++;
        }
        dbHelpers.addDataTotalStats(new DateDbTotalStats("Статистика №" + numberStat, "Тест", rightAnswer + "/" + allQuestion, timeText + "  " + dateText, allQuestion,endDate,endDate + allQuestion));
        for (int i = 1; i <= allQuestion;i ++){
            dbHelpers.addDataInStats(new DateDbStats(endDate, questi.get(i-1),result.get(i-1), RightAnswer.get(i-1)));
            endDate++;
        }
        numberStat++;

        lastPositionNumber = numberStat;
        lastPositionDate = endDate;

        saveActivityPreferences();

    }

    int lastPositionNumber = 0;
    int lastPositionDate = 0;
    private void saveActivityPreferences() {
        SharedPreferences sPref = getSharedPreferences("SavedPosition", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt("lastPositionNumber", lastPositionNumber);
        editor.putInt("lastPositionDate", lastPositionDate);
        editor.apply();
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("SavedPosition", MODE_PRIVATE);
        lastPositionNumber = sharedPreferences.getInt("lastPositionNumber",0);
        lastPositionDate = sharedPreferences.getInt("lastPositionDate",0);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void EndActivity(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelpers.close();
    }
}
