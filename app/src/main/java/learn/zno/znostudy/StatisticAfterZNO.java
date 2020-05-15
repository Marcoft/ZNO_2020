package learn.zno.znostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import learn.zno.znostudy.Recycler.ExampleAdapter;
import learn.zno.znostudy.Recycler.ExampleItem;
import learn.zno.znostudy.db.DBHelpers;
import learn.zno.znostudy.db.DateDb;

public class StatisticAfterZNO extends AppCompatActivity {


    TextView ans1,ans5,RightAnswers;

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


        /*List<DateDb> dates = dbHelpers.getAllContacts();
        for (DateDb dat : dates) {
            quest.add(dat.getQuestion());
            answe1.add(dat.getAnswer1());
            answe2.add(dat.getAnswer2());
            answe3.add(dat.getAnswer3());
            answe4.add(dat.getAnswer4());
            answe5.add(dat.getAnswer5());
            RightAnswer.add(dat.getAnswer1());
        }*/

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
            mExampleList.add(new ExampleItem("Питання : " + i, quest.get(i-1), answe1.get(i-1), answe5.get(i-1)));
        }

        int c = 0;
        for(int i = 0; i < 20; i ++) {
            if(RightAnswer.get(i).equalsIgnoreCase(result.get(i))){
                c++;
            }
        }
        RightAnswers.setText("Кількість правильних відповідей: " + c);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new ExampleAdapter(mExampleList,RightAnswer,result);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void EndActivity(View view) {
        finish();
    }
}
