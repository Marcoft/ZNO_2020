package learn.zno.znostudy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import learn.zno.znostudy.db.DBHelpers;
import learn.zno.znostudy.db.DateDb;

public class TestStart extends AppCompatActivity {


    ImageView life1,life2,life3;
    TextView t_level,t_quest,ResultScore;
    Button btn_answ1, btn_answ2,btn_answ3,btn_answ4;

    List<String> quest = new ArrayList<>();
    List<String> answe1 = new ArrayList<>();
    List<String> answe2 = new ArrayList<>();
    List<String> answe3 = new ArrayList<>();
    List<String> answe4 = new ArrayList<>();
    List<String> RightAnswer = new ArrayList<>();
    HashMap<Integer,String> YourAnswer = new HashMap<>();
    HashMap<Integer,String> Quest = new HashMap<>();
    HashMap<Integer,String> rightAnswer = new HashMap<>();


    String name_1, name_2,name_3,name_4,name_5,name_6,name_7,name_8,name_9,name_10,name_11,name_12,name_13;
    int i = 1;
    int k = 161;
    int end = 161;

    private void ReadDateBd(){
        DateDb dateDb = null;

        if(name_1.equalsIgnoreCase("true")){
             k = 161;
             end = 191;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_2.equalsIgnoreCase("true")){
             k = 191;
            end = 221;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_3.equalsIgnoreCase("true")){
             k = 221;
            end = 291;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_4.equalsIgnoreCase("true")){
             k = 291;
            end = 392;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_5.equalsIgnoreCase("true")){
             k = 392;
            end = 411;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_6.equalsIgnoreCase("true")){
             k = 411;
            end = 427;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_7.equalsIgnoreCase("true")){
             k = 427;
            end = 471;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_8.equalsIgnoreCase("true")){
             k = 471;
            end = 487;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_9.equalsIgnoreCase("true")){
             k = 487;
            end = 501;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_10.equalsIgnoreCase("true")){
             k = 501;
            end = 506;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }
        if(name_11.equalsIgnoreCase("true")){
             k = 506;
            end = 531;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }

        if(name_12.equalsIgnoreCase("true")){
             k = 531;
            end = 588;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }
        if(name_13.equalsIgnoreCase("true")){
             k = 587;
            end = 602;
            for (int i = k; i < end;i ++){
                dateDb = dbHelpers.getDate(i);
                quest.add(dateDb.getQuestion());
                answe1.add(dateDb.getAnswer1());
                answe2.add(dateDb.getAnswer2());
                answe3.add(dateDb.getAnswer3());
                answe4.add(dateDb.getAnswer4());
                RightAnswer.add(dateDb.getAnswer1());
            }
        }


    }

    DBHelpers dbHelpers;
    int Score = 0;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_start);
        dbHelpers = new DBHelpers(this);
        r = new Random();
        t_level = (TextView) findViewById(R.id.t_level);
        t_quest = (TextView) findViewById(R.id.t_quest);
        ResultScore = (TextView) findViewById(R.id.RESULT_SCORE);
        btn_answ1 = (Button) findViewById(R.id.btn_answ1);
        btn_answ2 = (Button) findViewById(R.id.btn_answ2);
        btn_answ3 = (Button) findViewById(R.id.btn_answ3);
        btn_answ4 = (Button) findViewById(R.id.btn_answ4);
        life1 = (ImageView) findViewById(R.id.life1);
        life2 = (ImageView) findViewById(R.id.life2);
        life3 = (ImageView) findViewById(R.id.life3);



        Intent intent = getIntent();
        if(intent != null) {
            name_1 = String.valueOf(intent.getStringExtra("checkbox1"));
            name_2 = String.valueOf(intent.getStringExtra("checkbox2"));
            name_3 = String.valueOf(intent.getStringExtra("checkbox3"));
            name_4 = String.valueOf(intent.getStringExtra("checkbox4"));
            name_5 = String.valueOf(intent.getStringExtra("checkbox5"));
            name_6 = String.valueOf(intent.getStringExtra("checkbox6"));
            name_7 = String.valueOf(intent.getStringExtra("checkbox7"));
            name_8 = String.valueOf(intent.getStringExtra("checkbox8"));
            name_9 = String.valueOf(intent.getStringExtra("checkbox9"));
            name_10 = String.valueOf(intent.getStringExtra("checkbox10"));
            name_11 = String.valueOf(intent.getStringExtra("checkbox11"));
            name_12 = String.valueOf(intent.getStringExtra("checkbox12"));
            name_13 = String.valueOf(intent.getStringExtra("checkbox13"));
        }

        ReadDateBd();

        randTest = r.nextInt(quest.size());
        t_level.setText("Питання : " + i);
        ResultScore.setText("0");
        Score = 0;
        t_quest.setText(quest.get(randTest));

        int random = r.nextInt(4)+1;
        if(random == 1){
            btn_answ1.setText(answe1.get(randTest));
            btn_answ2.setText(answe2.get(randTest));
            btn_answ3.setText(answe3.get(randTest));
            btn_answ4.setText(answe4.get(randTest));
        }else if(random == 2){
            btn_answ1.setText(answe4.get(randTest));
            btn_answ2.setText(answe1.get(randTest));
            btn_answ3.setText(answe2.get(randTest));
            btn_answ4.setText(answe3.get(randTest));
        }else if(random == 3){
            btn_answ1.setText(answe3.get(randTest));
            btn_answ2.setText(answe4.get(randTest));
            btn_answ3.setText(answe1.get(randTest));
            btn_answ4.setText(answe2.get(randTest));
        } else if(random == 4){
            btn_answ1.setText(answe2.get(randTest));
            btn_answ2.setText(answe3.get(randTest));
            btn_answ3.setText(answe4.get(randTest));
            btn_answ4.setText(answe1.get(randTest));
        }
    }
    int randTest = 0;
    private void NewQuest(){
        i++;
        randTest = r.nextInt(quest.size());
        t_level.setText("Питання : " + i);
        t_quest.setText(quest.get(randTest));

        int random = r.nextInt(4)+1;
        if(random == 1){
            btn_answ1.setText(answe1.get(randTest));
            btn_answ2.setText(answe2.get(randTest));
            btn_answ3.setText(answe3.get(randTest));
            btn_answ4.setText(answe4.get(randTest));
        }else if(random == 2){
            btn_answ1.setText(answe4.get(randTest));
            btn_answ2.setText(answe1.get(randTest));
            btn_answ3.setText(answe2.get(randTest));
            btn_answ4.setText(answe3.get(randTest));
        }else if(random == 3){
            btn_answ1.setText(answe3.get(randTest));
            btn_answ2.setText(answe4.get(randTest));
            btn_answ3.setText(answe1.get(randTest));
            btn_answ4.setText(answe2.get(randTest));
        } else if(random == 4){
            btn_answ1.setText(answe2.get(randTest));
            btn_answ2.setText(answe3.get(randTest));
            btn_answ3.setText(answe4.get(randTest));
            btn_answ4.setText(answe1.get(randTest));
        }
    }


    int z = 0;
    int index = 0;
    public void ChechBut(View view) {
        switch (view.getId()){
            case R.id.btn_answ1:
                Quest.put(index,t_quest.getText().toString());
                YourAnswer.put(index,btn_answ1.getText().toString());
                rightAnswer.put(index,RightAnswer.get(randTest));
                index++;
            if(RightAnswer.get(randTest).equalsIgnoreCase(btn_answ1.getText().toString())){
                NewQuest();
                Score++;
                ResultScore.setText(""+Score);
            }else {
                if(z == 0){
                    life1.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 1){
                    life2.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 2){
                    life3.setImageResource(R.drawable.life_out);
                    btn_answ1.setEnabled(false);
                    btn_answ2.setEnabled(false);
                    btn_answ3.setEnabled(false);
                    btn_answ4.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            NextStatistic();
                        }
                    }, 1000);
                }
                NewQuest();
            }
                break;
            case R.id.btn_answ2:
                Quest.put(index,t_quest.getText().toString());
                YourAnswer.put(index,btn_answ2.getText().toString());
                rightAnswer.put(index,RightAnswer.get(randTest));
                index++;
            if(RightAnswer.get(randTest).equalsIgnoreCase(btn_answ2.getText().toString())){
                NewQuest();
                Score++;
                ResultScore.setText(""+Score);
            }else {
                if(z == 0){
                    life1.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 1){
                    life2.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 2){
                    life3.setImageResource(R.drawable.life_out);
                    btn_answ1.setEnabled(false);
                    btn_answ2.setEnabled(false);
                    btn_answ3.setEnabled(false);
                    btn_answ4.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            NextStatistic();
                        }
                    }, 1000);
                }
                NewQuest();
            }
                break;
            case R.id.btn_answ3:
                Quest.put(index,t_quest.getText().toString());
                YourAnswer.put(index,btn_answ3.getText().toString());
                rightAnswer.put(index,RightAnswer.get(randTest));
                index++;
            if(RightAnswer.get(randTest).equalsIgnoreCase(btn_answ3.getText().toString())){
                NewQuest();
                Score++;
                ResultScore.setText(""+Score);
            }else {
                if(z == 0){
                    life1.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 1){
                    life2.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 2){
                    life3.setImageResource(R.drawable.life_out);
                    btn_answ1.setEnabled(false);
                    btn_answ2.setEnabled(false);
                    btn_answ3.setEnabled(false);
                    btn_answ4.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            NextStatistic();
                        }
                    }, 1000);
                }
                NewQuest();
            }
                break;
           case R.id.btn_answ4:
               Quest.put(index,t_quest.getText().toString());
               YourAnswer.put(index,btn_answ4.getText().toString());
               rightAnswer.put(index,RightAnswer.get(randTest));
               index++;
            if(RightAnswer.get(randTest).equalsIgnoreCase(btn_answ4.getText().toString())){
                NewQuest();
                Score++;
                ResultScore.setText(""+Score);
            }else {
                if(z == 0){
                    life1.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 1){
                    life2.setImageResource(R.drawable.life_out);
                    z++;
                }else if(z == 2){
                    life3.setImageResource(R.drawable.life_out);
                    btn_answ1.setEnabled(false);
                    btn_answ2.setEnabled(false);
                    btn_answ3.setEnabled(false);
                    btn_answ4.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            NextStatistic();
                        }
                    }, 1000);
                }
                NewQuest();
            }
                break;
        }
    }


    public void NextStatistic(){
        Intent intent = new Intent(this,StatisticAfterTest.class);
        //intent.putExtra("list_k.size",list_k.size());
        //for(int i = 0; i < list_k.size();i++){
          //  intent.putExtra(i + "k",list_k.get(i));
            //intent.putExtra(i + "end",list_end.get(i));
        //}
        intent.putExtra("YourAnswer.size",YourAnswer.size());
        for(int i = 0; i < YourAnswer.size();i++){
            intent.putExtra(String.valueOf(i),YourAnswer.get(i));
            intent.putExtra(String.valueOf(i + "k"),Quest.get(i));
            intent.putExtra(String.valueOf(i + "r"),rightAnswer.get(i));
        }
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1)
            finish();
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void finish(View view) {
        finish();
    }
}
