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

public class StatisticAfterTest extends AppCompatActivity {

    TextView ans1,ans5,RightAnswers;

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    DBHelpers dbHelpers;

    //List<String> quest = new ArrayList<>();
    //List<String> answe1 = new ArrayList<>();
    //List<String> answe2 = new ArrayList<>();
    //List<String> answe3 = new ArrayList<>();
    //List<String> answe4 = new ArrayList<>();

    List<String> result = new ArrayList<>();
    List<String> questi = new ArrayList<>();
    List<String> RightAnswer= new ArrayList<>();


    List<Integer> k = new ArrayList<>();
    List<Integer> end = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_after_test);
        dbHelpers = new DBHelpers(this);
        RightAnswers = (TextView) findViewById(R.id.RightAnswers);


        mExampleList = new ArrayList<ExampleItem>();
        result.clear();
        Intent intent = getIntent();
        /*for(int i = 0; i < intent.getIntExtra("list_k.size",1);i++){
            k.add(intent.getIntExtra(i + "k",1));
            end.add(intent.getIntExtra(i + "end",1));
        }*/

        for(int i = 0; i < intent.getIntExtra("YourAnswer.size",1);i++){
            result.add(intent.getStringExtra(String.valueOf(i)));
            questi.add(intent.getStringExtra(String.valueOf(i + "k")));
            RightAnswer.add(intent.getStringExtra(String.valueOf(i + "r")));
        }


       /* DateDb dateDb = null;

        for(int j = 0; j < questi.size(); j ++){
            for(int l = 0; l < k.size();l ++){
                 for (int i = k.get(l); i < end.get(l);i ++){
                     dateDb = dbHelpers.getDate(i);
                     if(dateDb.getQuestion().equalsIgnoreCase(questi.get(j))){
                         quest.add(dateDb.getQuestion());
                         answe1.add(dateDb.getAnswer1());
                         answe2.add(dateDb.getAnswer2());
                         answe3.add(dateDb.getAnswer3());
                         answe4.add(dateDb.getAnswer4());
                         RightAnswer.add(dateDb.getAnswer1());
                     }
                 }
            }
        }*/

       for(int i = 1; i <= intent.getIntExtra("YourAnswer.size",1)  ; i ++) {
            mExampleList.add(new ExampleItem("Питання : " + i, questi.get(i-1), RightAnswer.get(i-1), result.get(i-1)));
        }

        int c = 0;
        for(int i = 0; i < intent.getIntExtra("YourAnswer.size",1); i ++) {
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
