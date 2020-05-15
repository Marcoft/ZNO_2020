package learn.zno.znostudy;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class OneExtra extends AppCompatActivity {

    Button one, two, three, four , five , start;
    ImageView life1,life2,life3;
    TextView RESULT_SCORE, Question;

    String Questions = "Знайдіть зайвого героя твору";

    ArrayList<String> variantWrong = new ArrayList<>();
    ArrayList<String> variant2 = new ArrayList<>();
    ArrayList<String> variant3 = new ArrayList<>();
    ArrayList<String> variant4 = new ArrayList<>();
    ArrayList<String> variant5 = new ArrayList<>();

    private void AddDate(){

        variantWrong.add("Бурунда"); variant2.add("Кий"); variant3.add("Щек"); variant4.add("Либідь"); variant5.add("Хорив");
        variantWrong.add("Еол"); variant2.add("Ігор"); variant3.add("Овлур"); variant4.add("Кончак"); variant5.add("Ярославна");
        variantWrong.add("Бурунда"); variant2.add("Анхіз"); variant3.add("Низ"); variant4.add("Турн"); variant5.add("Сівілла");
        variantWrong.add("Михайло"); variant2.add("Наталка Полтавка"); variant3.add("Петро"); variant4.add("Тетерваковський"); variant5.add("Макогоненко");
        variantWrong.add("Кончак"); variant2.add("Яким Сомко"); variant3.add("Павло Тетеря"); variant4.add("Іван Брюховецький"); variant5.add("Кирило Тур");
        variantWrong.add("Явдоха"); variant2.add("Омелько"); variant3.add("Карпо"); variant4.add("Маруся"); variant5.add("Мотря");
        variantWrong.add("Красовський"); variant2.add("Мотря Жуківна"); variant3.add("Максим Ґудзь"); variant4.add("Явдоха"); variant5.add("Христя");
        variantWrong.add("Єгошуа"); variant2.add("Мартин Боруля"); variant3.add("Палажка"); variant4.add("Марися"); variant5.add("Степан");
        variantWrong.add("Гагін"); variant2.add("Тугар Вовк"); variant3.add("Мирослава"); variant4.add("Максим Беркут"); variant5.add("Бурунда");
        variantWrong.add("Анхіз"); variant2.add("Азазель"); variant3.add("Єгова"); variant4.add("Датан"); variant5.add("Авірон");
        variantWrong.add("Мотря Жуківна"); variant2.add("Марічка Гутенюк"); variant3.add("Палагна"); variant4.add("Юра"); variant5.add("Чугайстир");
        variantWrong.add("Мольфар"); variant2.add("Килина"); variant3.add("Мавка"); variant4.add("Лістовик"); variant5.add("Перелесник");
        variantWrong.add("Ілля"); variant2.add("Я"); variant3.add("доктор Тагабат"); variant4.add("Андрюша"); variant5.add("Дегенерат");
        variantWrong.add("Явдоха"); variant2.add("Тайах"); variant3.add("Сев"); variant4.add("То-Ма-Кі"); variant5.add("Богдан");
        variantWrong.add("Денис Сірко"); variant2.add("Левко"); variant3.add("Нюся"); variant4.add("Мусінька"); variant5.add("Зоська");
        variantWrong.add("Зоська"); variant2.add("Рина"); variant3.add("Мокій"); variant4.add("Уля"); variant5.add("Баронова-Козино");
        variantWrong.add("Кирило Тур"); variant2.add("Маруся Чурай"); variant3.add("Грицько Бобренко"); variant4.add("Іван Іскра"); variant5.add("Мартин Пушкар");
        variantWrong.add("Максим Ґудзь"); variant2.add("Мартин Пушкар"); variant3.add("Богдан Хмельницький"); variant4.add("Семен Горбань"); variant5.add("Галя Вишняківна");
        variantWrong.add("Микола"); variant2.add("Софія"); variant3.add("Михайло"); variant4.add("Левко"); variant5.add("Марфа Яркова");
        variantWrong.add("Андрюша"); variant2.add("Денис Сірко"); variant3.add("Гриць"); variant4.add("Медвин"); variant5.add("Фійона");
        variantWrong.add("Фійона"); variant2.add("боєць-розвідник"); variant3.add("Ілля"); variant4.add("Тереза"); variant5.add("Терезина мати");
        variantWrong.add("Націєвський"); variant2.add("Вигорський"); variant3.add("Рита"); variant4.add("Тамара Василівна"); variant5.add("Лука Гнідий");
        variantWrong.add("Сев"); variant2.add("Грицько Чупруненко"); variant3.add("Чіпка Варениченко"); variant4.add("Іван Вареник"); variant5.add("Мотря Жуківна");
        variantWrong.add("Мартин Пушкар"); variant2.add("баба Оришка"); variant3.add("Василь Порох"); variant4.add("Лушня"); variant5.add("Чижик");
        variantWrong.add("Мелашка"); variant2.add("Петро Шраменко"); variant3.add("Михайло Черевань"); variant4.add("Меланія"); variant5.add("Матвій Гвинтовка");
        variantWrong.add("Єгова"); variant2.add("Зевс"); variant3.add("Юнона"); variant4.add("Венера"); variant5.add("Еол");
        variantWrong.add("Азазель"); variant2.add("Палант"); variant3.add("Еванд"); variant4.add("Латин"); variant5.add("Лавінія");
        variantWrong.add("Василь Порох"); variant2.add("Святослав Ольгович"); variant3.add("Всеволод Святославич"); variant4.add("князь Рильський"); variant5.add("Гзак");
        variantWrong.add("Латин"); variant2.add("Ольга"); variant3.add("Святослав"); variant4.add("Древляни"); variant5.add("Свенельд");
    }

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_extra);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        start = (Button) findViewById(R.id.start);

        life1 = (ImageView) findViewById(R.id.life1);
        life2 = (ImageView) findViewById(R.id.life2);
        life3 = (ImageView) findViewById(R.id.life3);

        RESULT_SCORE = (TextView) findViewById(R.id.RESULT_SCORE);
        Question = (TextView) findViewById(R.id.Question);

        r = new Random();
        AddDate();
    }

    ArrayList<String> answers = new ArrayList<>();
    int numberAnsw = 0;

    private void newGame(){
        answers.clear();
        numberAnsw = r.nextInt(variant2.size());
        answers.add(variantWrong.get(numberAnsw));
        answers.add(variant2.get(numberAnsw));
        answers.add(variant3.get(numberAnsw));
        answers.add(variant4.get(numberAnsw));
        answers.add(variant5.get(numberAnsw));
        Collections.shuffle(answers);
        one.setText(answers.get(0));
        two.setText(answers.get(1));
        three.setText(answers.get(2));
        four.setText(answers.get(3));
        five.setText(answers.get(4));

        one.setClickable(true); one.setEnabled(true);
        two.setClickable(true); two.setEnabled(true);
        three.setClickable(true); three.setEnabled(true);
        four.setClickable(true); four.setEnabled(true);
        five.setClickable(true); five.setEnabled(true);
    }

    public void startGame(View view) {
        start.setVisibility(View.GONE);
        Question.setText(Questions);
        newGame();
    }

    int life_i = 0;
    private void loseLife(){
        if (life_i == 0) {
            life1.setImageResource(R.drawable.life_out);
            life_i++;
            newGame();
        } else if (life_i == 1) {
            life2.setImageResource(R.drawable.life_out);
            life_i++;
            newGame();
        } else if (life_i == 2) {
            life3.setImageResource(R.drawable.life_out);
            one.setEnabled(false);
            one.setClickable(false);
            two.setEnabled(false);
            two.setClickable(false);
            three.setEnabled(false);
            three.setClickable(false);
            four.setEnabled(false);
            four.setClickable(false);
            five.setEnabled(false);
            five.setClickable(false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        }
    }

    int score = 0;
    public void ClickExtra(View view) {
        switch (view.getId()){
            case R.id.one:
            if(one.getText().toString().equalsIgnoreCase(variantWrong.get(numberAnsw))){
                score++;
                RESULT_SCORE.setText(String.valueOf(score));
                newGame();
            }else{
                loseLife();
            }
                break;
            case R.id.two:
                if(two.getText().toString().equalsIgnoreCase(variantWrong.get(numberAnsw))){
                    score++;
                    RESULT_SCORE.setText(String.valueOf(score));
                    newGame();
                }else{
                    loseLife();
                }
                break;
            case R.id.three:
                if(three.getText().toString().equalsIgnoreCase(variantWrong.get(numberAnsw))){
                    score++;
                    RESULT_SCORE.setText(String.valueOf(score));
                    newGame();
                }else{
                    loseLife();
                }
                break;
            case R.id.four:
                if(four.getText().toString().equalsIgnoreCase(variantWrong.get(numberAnsw))){
                    score++;
                    RESULT_SCORE.setText(String.valueOf(score));
                    newGame();
                }else{
                    loseLife();
                }
                break;
            case R.id.five:
                if(five.getText().toString().equalsIgnoreCase(variantWrong.get(numberAnsw))){
                    score++;
                    RESULT_SCORE.setText(String.valueOf(score));
                    newGame();
                }else{
                    loseLife();
                }
                break;
        }
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void finish(View view) {
        finish();
    }


}