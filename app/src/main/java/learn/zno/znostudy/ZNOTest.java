package learn.zno.znostudy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import learn.zno.znostudy.db.DBHelpers;
import learn.zno.znostudy.db.DateDb;

public class ZNOTest extends AppCompatActivity {


    TextView t_level,t_name,t_quest;
    Button btn_answ1,btn_answ2,btn_answ3,btn_answ4,btn_answ5,btn_exit,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20;

    int NotEnd = 0;

    String name;
    String typeZno;

    int id;
    List<String> quest = new ArrayList<>();
    List<String> answe1 = new ArrayList<>();
    List<String> answe2 = new ArrayList<>();
    List<String> answe3 = new ArrayList<>();
    List<String> answe4 = new ArrayList<>();
    List<String> answe5 = new ArrayList<>();
    DBHelpers dbHelpers;

    List<String> RightAnswer= new ArrayList<>();
    String Right;

    Random r;

    HashMap<Integer,String> result = new HashMap<>();
    //List<String> result2 = new ArrayList<>();
    int startDate;
    int endEnd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z_n_o_test);
        dbHelpers = new DBHelpers(this);
        r = new Random();

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16 = (Button) findViewById(R.id.btn16);
        btn17 = (Button) findViewById(R.id.btn17);
        btn18 = (Button) findViewById(R.id.btn18);
        btn19 = (Button) findViewById(R.id.btn19);
        btn20 = (Button) findViewById(R.id.btn20);
        btn_answ1 = (Button) findViewById(R.id.btn_answ1);
        btn_answ2 = (Button) findViewById(R.id.btn_answ2);
        btn_answ3 = (Button) findViewById(R.id.btn_answ3);
        btn_answ4 = (Button) findViewById(R.id.btn_answ4);
        btn_answ5 = (Button) findViewById(R.id.btn_answ5);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        t_level = (TextView) findViewById(R.id.t_level);
        t_name = (TextView) findViewById(R.id.t_name);
        t_quest = (TextView) findViewById(R.id.t_quest);

        Intent intent = getIntent();
        if(intent != null){
            name = intent.getStringExtra("name");
            t_name.setText(name);
            typeZno = intent.getStringExtra("ChoiseZNO");
        }

        readDate();
        inMassive.put(1,0);
        inMassive.put(2,0);
        inMassive.put(3,0);
        inMassive.put(4,0);
        inMassive.put(5,0);
        inMassive.put(6,0);
        inMassive.put(7,0);
        inMassive.put(8,0);
        inMassive.put(9,0);
        inMassive.put(10,0);
        inMassive.put(11,0);
        inMassive.put(12,0);
        inMassive.put(13,0);
        inMassive.put(14,0);
        inMassive.put(15,0);
        inMassive.put(16,0);
        inMassive.put(17,0);
        inMassive.put(18,0);
        inMassive.put(19,0);
        inMassive.put(20,0);
        t_level.setText("Питання : 1");
        getDate(1);
    }

    int k = 0;

    private void readDate(){
        DateDb dateDb = null;

       // List<DateDb> dates = dbHelpers.getAllContacts();
       /* for (DateDb dat : dates) {
            quest.add(dat.getQuestion());
            answe1.add(dat.getAnswer1());
            answe2.add(dat.getAnswer2());
            answe3.add(dat.getAnswer3());
            answe4.add(dat.getAnswer4());
            answe5.add(dat.getAnswer5());
            RightAnswer.add(dat.getAnswer1());
        }*/


        if(typeZno.equalsIgnoreCase("main2019")){
             k = 1;
        } else if(typeZno.equalsIgnoreCase("additional2019")){
             k = 21;
        } else if(typeZno.equalsIgnoreCase("main2018")){
             k = 41;
        } else if(typeZno.equalsIgnoreCase("additional2018")){
             k = 61;
        } else if(typeZno.equalsIgnoreCase("main2017")){
             k = 81;
        } else if(typeZno.equalsIgnoreCase("additional2017")){
             k = 101;
        } else if(typeZno.equalsIgnoreCase("main2016")){
             k = 121;
        } else if(typeZno.equalsIgnoreCase("additional2016")){
             k = 141;
        }
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
    }

    public void QuestionButton(View view) {
        switch (view.getId()){
            case R.id.btn1:
                t_level.setText("Питання : 1");
                getDate(1);
                break;
            case R.id.btn2:
                t_level.setText("Питання : 2");
                getDate(2);
                break;
            case R.id.btn3:
                t_level.setText("Питання : 3");
                getDate(3);
                break;
            case R.id.btn4:
                t_level.setText("Питання : 4");
                getDate(4);
                break;
            case R.id.btn5:
                t_level.setText("Питання : 5");
                getDate(5);
                break;
            case R.id.btn6:
                t_level.setText("Питання : 6");
                getDate(6);
                break;
            case R.id.btn7:
                t_level.setText("Питання : 7");
                getDate(7);
                break;
            case R.id.btn8:
                t_level.setText("Питання : 8");
                getDate(8);
                break;
            case R.id.btn9:
                t_level.setText("Питання : 9");
                getDate(9);
                break;
            case R.id.btn10:
                t_level.setText("Питання : 10");
                getDate(10);
                break;
            case R.id.btn11:
                t_level.setText("Питання : 11");
                getDate(11);
                break;
            case R.id.btn12:
                t_level.setText("Питання : 12");
                getDate(12);
                break;
            case R.id.btn13:
                t_level.setText("Питання : 13");
                getDate(13);
                break;
            case R.id.btn14:
                t_level.setText("Питання : 14");
                getDate(14);
                break;
            case R.id.btn15:
                t_level.setText("Питання : 15");
                getDate(15);
                break;
            case R.id.btn16:
                t_level.setText("Питання : 16");
                getDate(16);
                break;
            case R.id.btn17:
                t_level.setText("Питання : 17");
                getDate(17);
                break;
            case R.id.btn18:
                t_level.setText("Питання : 18");
                getDate(18);
                break;
            case R.id.btn19:
                t_level.setText("Питання : 19");
                getDate(19);
                break;
            case R.id.btn20:
                t_level.setText("Питання : 20");
                getDate(20);
                break;
        }
    }

    public void getDate(int id){
        t_quest.setText(quest.get(id-1));
        Right = RightAnswer.get(id-1);
        int random = r.nextInt(5)+1;
        //Toast.makeText(this, "" + random, Toast.LENGTH_SHORT).show();

        if(random == 1){
            btn_answ1.setText(answe1.get(id-1));
            btn_answ2.setText(answe2.get(id-1));
            btn_answ3.setText(answe3.get(id-1));
            btn_answ4.setText(answe4.get(id-1));
            btn_answ5.setText(answe5.get(id-1));
        }else if(random == 2){
            btn_answ1.setText(answe5.get(id-1));
            btn_answ2.setText(answe1.get(id-1));
            btn_answ3.setText(answe2.get(id-1));
            btn_answ4.setText(answe3.get(id-1));
            btn_answ5.setText(answe4.get(id-1));
        }else if(random == 3){
            btn_answ1.setText(answe4.get(id-1));
            btn_answ2.setText(answe5.get(id-1));
            btn_answ3.setText(answe1.get(id-1));
            btn_answ4.setText(answe2.get(id-1));
            btn_answ5.setText(answe3.get(id-1));
        } else if(random == 4){
            btn_answ1.setText(answe3.get(id-1));
            btn_answ2.setText(answe4.get(id-1));
            btn_answ3.setText(answe5.get(id-1));
            btn_answ4.setText(answe1.get(id-1));
            btn_answ5.setText(answe2.get(id-1));
        } else if(random == 5){
            btn_answ1.setText(answe2.get(id-1));
            btn_answ2.setText(answe3.get(id-1));
            btn_answ3.setText(answe4.get(id-1));
            btn_answ4.setText(answe5.get(id-1));
            btn_answ5.setText(answe1.get(id-1));
        }

    }

    HashMap<Integer,Integer> inMassive = new HashMap<>();
    public void putValue(int id,Button btn){
        if(!(inMassive.get(id) == id)){
            inMassive.remove(id);
            inMassive.put(id,id);
            result.put(id,btn.getText().toString());
            NotEnd++;
            if(NotEnd == 20){
                btn_exit.setVisibility(View.VISIBLE);
                btn_exit.setEnabled(true);
            }
        } else{
            result.remove(id);
            result.put(id,btn.getText().toString());
        }
    }



    public  void ChechBut(View view){
        switch (view.getId()){
            case R.id.btn_answ1:
                //if(btn_answ1.getText().toString().equalsIgnoreCase(Right)){
                    if(t_level.getText().toString().equalsIgnoreCase("Питання : 1")){
                        putValue(1,btn_answ1);
                        getDate(2);
                        btn1.setBackgroundResource(R.drawable.sumabutton2);
                        btn1.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 2");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 2")){
                        putValue(2,btn_answ1);
                        getDate(3);
                        btn2.setBackgroundResource(R.drawable.sumabutton2);
                        btn2.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 3");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 3")){
                        putValue(3,btn_answ1);
                        getDate(4);
                        btn3.setBackgroundResource(R.drawable.sumabutton2);
                        btn3.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 4");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 4")){
                        putValue(4,btn_answ1);
                        getDate(5);
                        btn4.setBackgroundResource(R.drawable.sumabutton2);
                        btn4.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 5");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 5")){
                        putValue(5,btn_answ1);
                        getDate(6);
                        btn5.setBackgroundResource(R.drawable.sumabutton2);
                        btn5.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 6");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 6")){
                        putValue(6,btn_answ1);
                        getDate(7);
                        btn6.setBackgroundResource(R.drawable.sumabutton2);
                        btn6.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 7");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 7")){
                        putValue(7,btn_answ1);
                        getDate(8);
                        btn7.setBackgroundResource(R.drawable.sumabutton2);
                        btn7.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 8");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 8")){
                        putValue(8,btn_answ1);
                        getDate(9);
                        btn8.setBackgroundResource(R.drawable.sumabutton2);
                        btn8.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 9");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 9")){
                        putValue(9,btn_answ1);
                        getDate(10);
                        btn9.setBackgroundResource(R.drawable.sumabutton2);
                        btn9.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 10");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 10")){
                        putValue(10,btn_answ1);
                        getDate(11);
                        btn10.setBackgroundResource(R.drawable.sumabutton2);
                        btn10.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 11");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 11")){
                        putValue(11,btn_answ1);
                        getDate(12);
                        btn11.setBackgroundResource(R.drawable.sumabutton2);
                        btn11.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 12");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 12")){
                        putValue(12,btn_answ1);
                        getDate(13);
                        btn12.setBackgroundResource(R.drawable.sumabutton2);
                        btn12.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 13");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 13")){
                        putValue(13,btn_answ1);
                        getDate(14);
                        btn13.setBackgroundResource(R.drawable.sumabutton2);
                        btn13.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 14");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 14")){
                        putValue(14,btn_answ1);
                        getDate(15);
                        btn14.setBackgroundResource(R.drawable.sumabutton2);
                        btn14.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 15");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 15")){
                        putValue(15,btn_answ1);
                        getDate(16);
                        btn15.setBackgroundResource(R.drawable.sumabutton2);
                        btn15.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 16");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 16")){
                        putValue(16,btn_answ1);
                        getDate(17);
                        btn16.setBackgroundResource(R.drawable.sumabutton2);
                        btn16.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 17");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 17")){
                        putValue(17,btn_answ1);
                        getDate(18);
                        btn17.setBackgroundResource(R.drawable.sumabutton2);
                        btn17.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 18");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 18")){
                        putValue(18,btn_answ1);
                        getDate(19);
                        btn18.setBackgroundResource(R.drawable.sumabutton2);
                        btn18.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 19");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 19")){
                        putValue(19,btn_answ1);
                        getDate(20);
                        btn19.setBackgroundResource(R.drawable.sumabutton2);
                        btn19.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 20");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 20")){
                        putValue(20,btn_answ1);
                        btn20.setBackgroundResource(R.drawable.sumabutton2);
                        btn20.setTextColor(Color.WHITE);
                    }
                //}
                break;
            case R.id.btn_answ2:
                //if(btn_answ2.getText().toString().equalsIgnoreCase(Right)){
                    if(t_level.getText().toString().equalsIgnoreCase("Питання : 1")){
                        putValue(1,btn_answ2);
                        getDate(2);
                        btn1.setBackgroundResource(R.drawable.sumabutton2);
                        btn1.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 2");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 2")){
                        putValue(2,btn_answ2);
                        getDate(3);
                        btn2.setBackgroundResource(R.drawable.sumabutton2);
                        btn2.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 3");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 3")){
                        putValue(3,btn_answ2);
                        getDate(4);
                        btn3.setBackgroundResource(R.drawable.sumabutton2);
                        btn3.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 4");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 4")){
                        putValue(4,btn_answ2);
                        getDate(5);
                        btn4.setBackgroundResource(R.drawable.sumabutton2);
                        btn4.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 5");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 5")){
                        putValue(5,btn_answ2);
                        getDate(6);
                        btn5.setBackgroundResource(R.drawable.sumabutton2);
                        btn5.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 6");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 6")){
                        putValue(6,btn_answ2);
                        getDate(7);
                        btn6.setBackgroundResource(R.drawable.sumabutton2);
                        btn6.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 7");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 7")){
                        putValue(7,btn_answ2);
                        getDate(8);
                        btn7.setBackgroundResource(R.drawable.sumabutton2);
                        btn7.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 8");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 8")){
                        putValue(8,btn_answ2);
                        getDate(9);
                        btn8.setBackgroundResource(R.drawable.sumabutton2);
                        btn8.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 9");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 9")){
                        putValue(9,btn_answ2);
                        getDate(10);
                        btn9.setBackgroundResource(R.drawable.sumabutton2);
                        btn9.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 10");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 10")){
                        putValue(10,btn_answ2);
                        getDate(11);
                        btn10.setBackgroundResource(R.drawable.sumabutton2);
                        btn10.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 11");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 11")){
                        putValue(11,btn_answ2);
                        getDate(12);
                        btn11.setBackgroundResource(R.drawable.sumabutton2);
                        btn11.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 12");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 12")){
                        putValue(12,btn_answ2);
                        getDate(13);
                        btn12.setBackgroundResource(R.drawable.sumabutton2);
                        btn12.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 13");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 13")){
                        putValue(13,btn_answ2);
                        getDate(14);
                        btn13.setBackgroundResource(R.drawable.sumabutton2);
                        btn13.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 14");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 14")){
                        putValue(14,btn_answ2);
                        getDate(15);
                        btn14.setBackgroundResource(R.drawable.sumabutton2);
                        btn14.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 15");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 15")){
                        putValue(15,btn_answ2);
                        getDate(16);
                        btn15.setBackgroundResource(R.drawable.sumabutton2);
                        btn15.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 16");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 16")){
                        putValue(16,btn_answ2);
                        getDate(17);
                        btn16.setBackgroundResource(R.drawable.sumabutton2);
                        btn16.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 17");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 17")){
                        putValue(17,btn_answ2);
                        getDate(18);
                        btn17.setBackgroundResource(R.drawable.sumabutton2);
                        btn17.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 18");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 18")){
                        putValue(18,btn_answ2);
                        getDate(19);
                        btn18.setBackgroundResource(R.drawable.sumabutton2);
                        btn18.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 19");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 19")){
                        putValue(19,btn_answ2);
                        getDate(20);
                        btn19.setBackgroundResource(R.drawable.sumabutton2);
                        btn19.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 20");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 20")){
                        putValue(20,btn_answ2);
                        btn20.setBackgroundResource(R.drawable.sumabutton2);
                        btn20.setTextColor(Color.WHITE);
                    }
               // }
                break;
            case R.id.btn_answ3:
                //if(btn_answ3.getText().toString().equalsIgnoreCase(Right)){
                    if(t_level.getText().toString().equalsIgnoreCase("Питання : 1")){
                        putValue(1,btn_answ3);
                        getDate(2);
                        btn1.setBackgroundResource(R.drawable.sumabutton2);
                        btn1.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 2");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 2")){
                        putValue(2,btn_answ3);
                        getDate(3);
                        btn2.setBackgroundResource(R.drawable.sumabutton2);
                        btn2.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 3");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 3")){
                        putValue(3,btn_answ3);
                        getDate(4);
                        btn3.setBackgroundResource(R.drawable.sumabutton2);
                        btn3.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 4");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 4")){
                        putValue(4,btn_answ3);
                        getDate(5);
                        btn4.setBackgroundResource(R.drawable.sumabutton2);
                        btn4.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 5");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 5")){
                        putValue(5,btn_answ3);
                        getDate(6);
                        btn5.setBackgroundResource(R.drawable.sumabutton2);
                        btn5.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 6");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 6")){
                        putValue(6,btn_answ3);
                        getDate(7);
                        btn6.setBackgroundResource(R.drawable.sumabutton2);
                        btn6.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 7");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 7")){
                        putValue(7,btn_answ3);
                        getDate(8);
                        btn7.setBackgroundResource(R.drawable.sumabutton2);
                        btn7.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 8");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 8")){
                        putValue(8,btn_answ3);
                        getDate(9);
                        btn8.setBackgroundResource(R.drawable.sumabutton2);
                        btn8.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 9");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 9")){
                        putValue(9,btn_answ3);
                        getDate(10);
                        btn9.setBackgroundResource(R.drawable.sumabutton2);
                        btn9.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 10");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 10")){
                        putValue(10,btn_answ3);
                        getDate(11);
                        btn10.setBackgroundResource(R.drawable.sumabutton2);
                        btn10.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 11");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 11")){
                        putValue(11,btn_answ3);
                        getDate(12);
                        btn11.setBackgroundResource(R.drawable.sumabutton2);
                        btn11.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 12");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 12")){
                        putValue(12,btn_answ3);
                        getDate(13);
                        btn12.setBackgroundResource(R.drawable.sumabutton2);
                        btn12.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 13");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 13")){
                        putValue(13,btn_answ3);
                        getDate(14);
                        btn13.setBackgroundResource(R.drawable.sumabutton2);
                        btn13.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 14");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 14")){
                        putValue(14,btn_answ3);
                        getDate(15);
                        btn14.setBackgroundResource(R.drawable.sumabutton2);
                        btn14.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 15");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 15")){
                        putValue(15,btn_answ3);
                        getDate(16);
                        btn15.setBackgroundResource(R.drawable.sumabutton2);
                        btn15.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 16");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 16")){
                        putValue(16,btn_answ3);
                        getDate(17);
                        btn16.setBackgroundResource(R.drawable.sumabutton2);
                        btn16.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 17");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 17")){
                        putValue(17,btn_answ3);
                        getDate(18);
                        btn17.setBackgroundResource(R.drawable.sumabutton2);
                        btn17.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 18");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 18")){
                        putValue(18,btn_answ3);
                        getDate(19);
                        btn18.setBackgroundResource(R.drawable.sumabutton2);
                        btn18.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 19");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 19")){
                        putValue(19,btn_answ3);
                        getDate(20);
                        btn19.setBackgroundResource(R.drawable.sumabutton2);
                        btn19.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 20");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 20")){
                        putValue(20,btn_answ3);
                        btn20.setBackgroundResource(R.drawable.sumabutton2);
                        btn20.setTextColor(Color.WHITE);

                    }
                //}
                break;
            case R.id.btn_answ4:
               // if(btn_answ4.getText().toString().equalsIgnoreCase(Right)){
                    if(t_level.getText().toString().equalsIgnoreCase("Питання : 1")){
                        putValue(1,btn_answ4);
                        getDate(2);
                        btn1.setBackgroundResource(R.drawable.sumabutton2);
                        btn1.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 2");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 2")){
                        putValue(2,btn_answ4);
                        getDate(3);
                        btn2.setBackgroundResource(R.drawable.sumabutton2);
                        btn2.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 3");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 3")){
                        putValue(3,btn_answ4);
                        getDate(4);
                        btn3.setBackgroundResource(R.drawable.sumabutton2);
                        btn3.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 4");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 4")){
                        putValue(4,btn_answ4);
                        getDate(5);
                        btn4.setBackgroundResource(R.drawable.sumabutton2);
                        btn4.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 5");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 5")){
                        putValue(5,btn_answ4);
                        getDate(6);
                        btn5.setBackgroundResource(R.drawable.sumabutton2);
                        btn5.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 6");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 6")){
                        putValue(6,btn_answ4);
                        getDate(7);
                        btn6.setBackgroundResource(R.drawable.sumabutton2);
                        btn6.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 7");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 7")){
                        putValue(7,btn_answ4);
                        getDate(8);
                        btn7.setBackgroundResource(R.drawable.sumabutton2);
                        btn7.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 8");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 8")){
                        putValue(8,btn_answ4);
                        getDate(9);
                        btn8.setBackgroundResource(R.drawable.sumabutton2);
                        btn8.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 9");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 9")){
                        putValue(9,btn_answ4);
                        getDate(10);
                        btn9.setBackgroundResource(R.drawable.sumabutton2);
                        btn9.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 10");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 10")){
                        putValue(10,btn_answ4);
                        getDate(11);
                        btn10.setBackgroundResource(R.drawable.sumabutton2);
                        btn10.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 11");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 11")){
                        putValue(11,btn_answ4);
                        getDate(12);
                        btn11.setBackgroundResource(R.drawable.sumabutton2);
                        btn11.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 12");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 12")){
                        putValue(12,btn_answ4);
                        getDate(13);
                        btn12.setBackgroundResource(R.drawable.sumabutton2);
                        btn12.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 13");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 13")){
                        putValue(13,btn_answ4);
                        getDate(14);
                        btn13.setBackgroundResource(R.drawable.sumabutton2);
                        btn13.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 14");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 14")){
                        putValue(14,btn_answ4);
                        getDate(15);
                        btn14.setBackgroundResource(R.drawable.sumabutton2);
                        btn14.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 15");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 15")){
                        putValue(15,btn_answ4);
                        getDate(16);
                        btn15.setBackgroundResource(R.drawable.sumabutton2);
                        btn15.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 16");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 16")){
                        putValue(16,btn_answ4);
                        getDate(17);
                        btn16.setBackgroundResource(R.drawable.sumabutton2);
                        btn16.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 17");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 17")){
                        putValue(17,btn_answ4);
                        getDate(18);
                        btn17.setBackgroundResource(R.drawable.sumabutton2);
                        btn17.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 18");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 18")){
                        putValue(18,btn_answ4);
                        getDate(19);
                        btn18.setBackgroundResource(R.drawable.sumabutton2);
                        btn18.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 19");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 19")){
                        putValue(19,btn_answ4);
                        getDate(20);
                        btn19.setBackgroundResource(R.drawable.sumabutton2);
                        btn19.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 20");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 20")){
                        putValue(20,btn_answ4);
                        btn20.setBackgroundResource(R.drawable.sumabutton2);
                        btn20.setTextColor(Color.WHITE);

                    }
               // }
                break;
            case R.id.btn_answ5:
               // if(btn_answ5.getText().toString().equalsIgnoreCase(Right)){
                    if(t_level.getText().toString().equalsIgnoreCase("Питання : 1")){
                        putValue(1,btn_answ5);
                        getDate(2);
                        btn1.setBackgroundResource(R.drawable.sumabutton2);
                        btn1.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 2");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 2")){
                        putValue(2,btn_answ5);
                        getDate(3);
                        btn2.setBackgroundResource(R.drawable.sumabutton2);
                        btn2.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 3");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 3")){
                        putValue(3,btn_answ5);
                        getDate(4);
                        btn3.setBackgroundResource(R.drawable.sumabutton2);
                        btn3.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 4");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 4")){
                        putValue(4,btn_answ5);
                        getDate(5);
                        btn4.setBackgroundResource(R.drawable.sumabutton2);
                        btn4.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 5");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 5")){
                        putValue(5,btn_answ5);
                        getDate(6);
                        btn5.setBackgroundResource(R.drawable.sumabutton2);
                        btn5.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 6");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 6")){
                        putValue(6,btn_answ5);
                        getDate(7);
                        btn6.setBackgroundResource(R.drawable.sumabutton2);
                        btn6.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 7");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 7")){
                        putValue(7,btn_answ5);
                        getDate(8);
                        btn7.setBackgroundResource(R.drawable.sumabutton2);
                        btn7.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 8");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 8")){
                        putValue(8,btn_answ5);
                        getDate(9);
                        btn8.setBackgroundResource(R.drawable.sumabutton2);
                        btn8.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 9");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 9")){
                        putValue(9,btn_answ5);
                        getDate(10);
                        btn9.setBackgroundResource(R.drawable.sumabutton2);
                        btn9.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 10");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 10")){
                        putValue(10,btn_answ5);
                        getDate(11);
                        btn10.setBackgroundResource(R.drawable.sumabutton2);
                        btn10.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 11");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 11")){
                        putValue(11,btn_answ5);
                        getDate(12);
                        btn11.setBackgroundResource(R.drawable.sumabutton2);
                        btn11.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 12");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 12")){
                        putValue(12,btn_answ5);
                        getDate(13);
                        btn12.setBackgroundResource(R.drawable.sumabutton2);
                        btn12.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 13");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 13")){
                        putValue(13,btn_answ5);
                        getDate(14);
                        btn13.setBackgroundResource(R.drawable.sumabutton2);
                        btn13.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 14");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 14")){
                        putValue(14,btn_answ5);
                        getDate(15);
                        btn14.setBackgroundResource(R.drawable.sumabutton2);
                        btn14.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 15");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 15")){
                        putValue(15,btn_answ5);
                        getDate(16);
                        btn15.setBackgroundResource(R.drawable.sumabutton2);
                        btn15.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 16");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 16")){
                        putValue(16,btn_answ5);
                        getDate(17);
                        btn16.setBackgroundResource(R.drawable.sumabutton2);
                        btn16.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 17");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 17")){
                        putValue(17,btn_answ5);
                        getDate(18);
                        btn17.setBackgroundResource(R.drawable.sumabutton2);
                        btn17.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 18");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 18")){
                        putValue(18,btn_answ5);
                        getDate(19);
                        btn18.setBackgroundResource(R.drawable.sumabutton2);
                        btn18.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 19");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 19")){
                        putValue(19,btn_answ5);
                        getDate(20);
                        btn19.setBackgroundResource(R.drawable.sumabutton2);
                        btn19.setTextColor(Color.WHITE);
                        t_level.setText("Питання : 20");
                    } else if(t_level.getText().toString().equalsIgnoreCase("Питання : 20")){
                        putValue(20,btn_answ5);
                        btn20.setBackgroundResource(R.drawable.sumabutton2);
                        btn20.setTextColor(Color.WHITE);

                    }
               // }
                break;
        }
    }

    public void NextStatistic(View view){
        Intent intent = new Intent(this,StatisticAfterZNO.class);
        intent.putExtra("k",k);
        intent.putExtra("1",result.get(1));
        intent.putExtra("2",result.get(2));
        intent.putExtra("3",result.get(3));
        intent.putExtra("4",result.get(4));
        intent.putExtra("5",result.get(5));
        intent.putExtra("6",result.get(6));
        intent.putExtra("7",result.get(7));
        intent.putExtra("8",result.get(8));
        intent.putExtra("9",result.get(9));
        intent.putExtra("10",result.get(10));
        intent.putExtra("11",result.get(11));
        intent.putExtra("12",result.get(12));
        intent.putExtra("13",result.get(13));
        intent.putExtra("14",result.get(14));
        intent.putExtra("15",result.get(15));
        intent.putExtra("16",result.get(16));
        intent.putExtra("17",result.get(17));
        intent.putExtra("18",result.get(18));
        intent.putExtra("19",result.get(19));
        intent.putExtra("20",result.get(20));
        startActivityForResult(intent,1);
    }

    @Override
    protected void onDestroy() {
        result.clear();
        quest.clear();
        answe1.clear();
        answe2.clear();
        answe3.clear();
        answe4.clear();
        answe5.clear();
        RightAnswer.clear();
        super.onDestroy();
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
