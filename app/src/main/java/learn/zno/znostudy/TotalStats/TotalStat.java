package learn.zno.znostudy.TotalStats;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import learn.zno.znostudy.R;
import learn.zno.znostudy.Recycler.ExampleAdapter;
import learn.zno.znostudy.Recycler.ExampleItem;
import learn.zno.znostudy.TotalStats.DateDb.DateDbStats;
import learn.zno.znostudy.TotalStats.StatsDb.DateDbTotalStats;
import learn.zno.znostudy.db.DBHelpers;

public class TotalStat extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<String> result = new ArrayList<>();
    private List<String> questi = new ArrayList<>();
    private List<String> RightAnswer= new ArrayList<>();

    private SQLiteDatabase sb;
    private DBHelpers dbHelpers;

    private TextView RightAnswers;

    private int endSize = 0;
    private int startSize = 0;
    private int countRightAnswers = 0;

    private Intent intent;
    private String positionStats = "";
    private int NumberQuestions = 1;

    String idText = "";
    String typeTest = "";
    String statsTest= "";
    String dateTest= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_stat);

        mRecyclerView = findViewById(R.id.recyclerView);
        RightAnswers = findViewById(R.id.RightAnswers);

        dbHelpers = new DBHelpers(this);
        sb = dbHelpers.getWritableDatabase();
        mExampleList = new ArrayList<ExampleItem>();

        intent = getIntent();
        if(intent != null) {
            positionStats = intent.getStringExtra("position");
        }

        startSize = 0;
        endSize = 0;
        DateDbTotalStats dateTotalDbStats = null;
        dateTotalDbStats = dbHelpers.getDateTotalStats(positionStats);
            if(dateTotalDbStats != null) {
                idText= dateTotalDbStats.getIdText();
                typeTest= dateTotalDbStats.getTypeTest();
                statsTest= dateTotalDbStats.getStatsTest();
                dateTest= dateTotalDbStats.getDateTest();
                countRightAnswers = dateTotalDbStats.getCountAnswers();
                startSize = dateTotalDbStats.getStartSize();
                endSize = dateTotalDbStats.getEndSize();
            }

        result.clear();
        questi.clear();
        RightAnswer.clear();

        if(endSize >= 2) {

            DateDbStats dateDbStats = null;
            for (int i = startSize; i < endSize; i++) {
                dateDbStats = dbHelpers.getDateFromStats(i);
                result.add(dateDbStats.getYourAnswer());
                questi.add(dateDbStats.getQuestion());
                RightAnswer.add(dateDbStats.getRightAnswer());
            }

            NumberQuestions = 1;
            for (int i = 0; i < endSize - startSize; i++) {
                mExampleList.add(new ExampleItem("Питання : " + NumberQuestions, questi.get(i), RightAnswer.get(i), result.get(i)));
                NumberQuestions++;
            }

            countRightAnswers = 0;
            for (int i = 0; i < endSize - startSize; i++) {
                if (RightAnswer.get(i).equalsIgnoreCase(result.get(i))) {
                    countRightAnswers++;
                }
            }
            RightAnswers.setText("Кількість правильних відповідей: " + countRightAnswers);

            mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);

            mAdapter = new ExampleAdapter(mExampleList, RightAnswer, result);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }


    }

    public void EndActivity(View view) {
        finish();
    }
}
