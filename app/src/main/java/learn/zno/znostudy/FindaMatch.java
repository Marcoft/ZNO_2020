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

public class FindaMatch extends AppCompatActivity {

    Button btn_1, btn_2,btn_3 ,btn_4, btn_5,btn_6, btn_7, btn_8, btn_9, btn_10;
    ImageView life1, life2, life3;
    TextView RESULT_SCORE, Question;

    int QuestionsId;
    String[] Questions = {"Знайдіть відповідність між авторами та їх творами","Знайдіть відповідність між творами і жанрами творів","Знайдіть відповідність між закоханими парами"
    ,"Знайдіть відповідність між героями з одного твору","Знайдіть відповідність між творами та місцями де відбуваються події","Знайдіть відповідність між авторами та справжніми прізвищами авторів","Знайдіть відповідність між творами та головними героями цих творів"};

    int randomQuest = 0;

    ArrayList<String> Questions_Author_Composition_1 = new ArrayList<String>();
    ArrayList<String> Questions_Author_Composition_2 = new ArrayList<String>();

    ArrayList<String>  Questions_Genre_Composition_1 = new ArrayList<String>();
    ArrayList<String>  Questions_Genre_Composition_2 = new ArrayList<String>();

    ArrayList<String>  Questions_Couplt_Love_1 = new ArrayList<String>();
    ArrayList<String>  Questions_Couplt_Love_2 = new ArrayList<String>();

    ArrayList<String>  Questions_Heroes_1 = new ArrayList<String>();
    ArrayList<String>  Questions_Heroes_2 = new ArrayList<String>();

    ArrayList<String>  Questions_Composition_Places_1 = new ArrayList<String>();
    ArrayList<String>  Questions_Composition_Places_2 = new ArrayList<String>();

    ArrayList<String>  Questions_Author_Surname_1 = new ArrayList<String>();
    ArrayList<String>  Questions_Author_Surname_2 = new ArrayList<String>();

    ArrayList<String>  Questions_MainHeroes_Compostition_1 = new ArrayList<String>();
    ArrayList<String>  Questions_MainHeroes_Compostition_2 = new ArrayList<String>();


    Random random;
    int GuessedAnswers = 0;

    private void AddDate(){
        Questions_Author_Composition_1.clear();
        Questions_Author_Composition_2.clear();
        Questions_Author_Composition_1.add("Григорій Сковорода"); Questions_Author_Composition_2.add("De libertate");
        Questions_Author_Composition_1.add("Іван Котляревський"); Questions_Author_Composition_2.add("Енеїда");
        Questions_Author_Composition_1.add("Пантелеймон Куліш"); Questions_Author_Composition_2.add("Чорна рада");
        Questions_Author_Composition_1.add("Тарас Шевченко"); Questions_Author_Composition_2.add("Кавказ");
        Questions_Author_Composition_1.add("Іван Карпенко-Карий"); Questions_Author_Composition_2.add("Мартин Боруля");
        Questions_Author_Composition_1.add("Іван Франко"); Questions_Author_Composition_2.add("Захар Беркут");
        Questions_Author_Composition_1.add("Михайло Коцюбинський"); Questions_Author_Composition_2.add("Тіні забутих предків");
        Questions_Author_Composition_1.add("Василь Стефаник"); Questions_Author_Composition_2.add("Камінний хрест");
        Questions_Author_Composition_1.add("Леся Українка"); Questions_Author_Composition_2.add("Лісова пісня");
        Questions_Author_Composition_1.add("Микола Вороний"); Questions_Author_Composition_2.add("Блакитна Панна");
        Questions_Author_Composition_1.add("Олександр Олесь"); Questions_Author_Composition_2.add("Чари ночі");
        Questions_Author_Composition_1.add("Павло Тичина"); Questions_Author_Composition_2.add("Пам’яті тридцяти");
        Questions_Author_Composition_1.add("Микола Хвильовий"); Questions_Author_Composition_2.add("Я (Романтика)");
        Questions_Author_Composition_1.add("Юрій Яновський"); Questions_Author_Composition_2.add("Майстер корабля");
        Questions_Author_Composition_1.add("Валер’ян Підмогильний"); Questions_Author_Composition_2.add("Місто");
        Questions_Author_Composition_1.add("Остап Вишня"); Questions_Author_Composition_2.add("Сом");
        Questions_Author_Composition_1.add("Микола Куліш"); Questions_Author_Composition_2.add("Мина Мазайло");
        Questions_Author_Composition_1.add("Володимир Сосюра"); Questions_Author_Composition_2.add("Любіть Україну");
        Questions_Author_Composition_1.add("Олександр Довженко"); Questions_Author_Composition_2.add("Зачарована Десна");
        Questions_Author_Composition_1.add("Андрій Малишко"); Questions_Author_Composition_2.add("Пісня про рушник");
        Questions_Author_Composition_1.add("Олесь Гончар"); Questions_Author_Composition_2.add("Модри камень");
        Questions_Author_Composition_1.add("Василь Симоненко"); Questions_Author_Composition_2.add("Лебеді материнства");
        Questions_Author_Composition_1.add("Василь Голобородько"); Questions_Author_Composition_2.add("Наша мова");
        Questions_Author_Composition_1.add("Іван Драч"); Questions_Author_Composition_2.add("Балада про соняшник");
        Questions_Author_Composition_1.add("Дмитро Павличко"); Questions_Author_Composition_2.add("Два кольори");
        Questions_Author_Composition_1.add("Ліна Костенко"); Questions_Author_Composition_2.add("Маруся Чурай");
        Questions_Author_Composition_1.add("Іван Багряний"); Questions_Author_Composition_2.add("Тигролови");
        Questions_Author_Composition_1.add("Євген Маланюк"); Questions_Author_Composition_2.add("Уривок з поеми");

        Questions_Genre_Composition_1.clear();
        Questions_Genre_Composition_2.clear();
        Questions_Genre_Composition_1.add("Повість минулих літ"); Questions_Genre_Composition_2.add("літопис");
        Questions_Genre_Composition_1.add("Енеїда"); Questions_Genre_Composition_2.add("бурлескно-травестійна поема");
        Questions_Genre_Composition_1.add("Наталка Полтавка"); Questions_Genre_Composition_2.add("соціально-побутова драма");
        Questions_Genre_Composition_1.add("Слово про похід Ігорів"); Questions_Genre_Composition_2.add("ліро-епічна героїчна поема");
        Questions_Genre_Composition_1.add("Маруся"); Questions_Genre_Composition_2.add("соціально-побутова повість");
        Questions_Genre_Composition_1.add("Чорна рада"); Questions_Genre_Composition_2.add("історичний роман");
        Questions_Genre_Composition_1.add("Кавказ"); Questions_Genre_Composition_2.add("сатирична поема");
        Questions_Genre_Composition_1.add("І мертвим і живим…"); Questions_Genre_Composition_2.add("поема-послання");
        Questions_Genre_Composition_1.add("Хіба ревуть воли як ясла повні?"); Questions_Genre_Composition_2.add("соціально-психологічний роман");
        Questions_Genre_Composition_1.add("Мартин Боруля"); Questions_Genre_Composition_2.add("трагікомедія");
        Questions_Genre_Composition_1.add("Лісова пісня"); Questions_Genre_Composition_2.add("драма-феєрія");
        Questions_Genre_Composition_1.add("Мойсей"); Questions_Genre_Composition_2.add("філософська ліро-епічна поема-притча");
        Questions_Genre_Composition_1.add("Зачарована Десна"); Questions_Genre_Composition_2.add("кіноповість");
        Questions_Genre_Composition_1.add("Valse mélancolique"); Questions_Genre_Composition_2.add("музична новела");
        Questions_Genre_Composition_1.add("Тигролови"); Questions_Genre_Composition_2.add("пригодницький роман");
        Questions_Genre_Composition_1.add("Сом"); Questions_Genre_Composition_2.add("усмішка");
        Questions_Genre_Composition_1.add("Засвіт встали козаченьки"); Questions_Genre_Composition_2.add("усна народна пісня");
        Questions_Genre_Composition_1.add("Маруся Богуславка"); Questions_Genre_Composition_2.add("дума");
        Questions_Genre_Composition_1.add("Бджола та Шершень"); Questions_Genre_Composition_2.add("байка");
        Questions_Genre_Composition_1.add("Захар Беркут"); Questions_Genre_Composition_2.add("історична повість");
        Questions_Genre_Composition_1.add("Камінний хрест"); Questions_Genre_Composition_2.add("психологічна новела\"");
        Questions_Genre_Composition_1.add("Чари ночі"); Questions_Genre_Composition_2.add("романс");
        Questions_Genre_Composition_1.add("Пам’яті тридцяти"); Questions_Genre_Composition_2.add("вірш-реквіємa");
        Questions_Genre_Composition_1.add("У теплі дні збирання винограду…"); Questions_Genre_Composition_2.add("сонет");
        Questions_Genre_Composition_1.add("Майстер корабля"); Questions_Genre_Composition_2.add("автобіографічний роман");
        Questions_Genre_Composition_1.add("Місто"); Questions_Genre_Composition_2.add("урбаністичний роман");
        Questions_Genre_Composition_1.add("Мина Мазайло"); Questions_Genre_Composition_2.add("сатирична комедія");
        Questions_Genre_Composition_1.add("Господи, гніву пречистого..."); Questions_Genre_Composition_2.add("вірш-медитація");
        Questions_Genre_Composition_1.add("Балада про соняшник"); Questions_Genre_Composition_2.add("модерна балада");
        Questions_Genre_Composition_1.add("Маруся Чурай"); Questions_Genre_Composition_2.add("роман у віршах");

        Questions_Couplt_Love_1.clear();
        Questions_Couplt_Love_2.clear();
        Questions_Couplt_Love_1.add("Лукаш"); Questions_Couplt_Love_2.add("Мавка");
        Questions_Couplt_Love_1.add("Василь Кравчина"); Questions_Couplt_Love_2.add("Олеся Запорожець");
        Questions_Couplt_Love_1.add("Іван Палійчук"); Questions_Couplt_Love_2.add("Марічка Гутенюк");
        Questions_Couplt_Love_1.add("Гриць Бобренко"); Questions_Couplt_Love_2.add("Маруся Чурай");
        Questions_Couplt_Love_1.add("Петро"); Questions_Couplt_Love_2.add("Наталка Полтавка");
        Questions_Couplt_Love_1.add("Микола Гуляницький"); Questions_Couplt_Love_2.add("Марися Боруля");
        Questions_Couplt_Love_1.add("Лаврін"); Questions_Couplt_Love_2.add("Мелашка");
        Questions_Couplt_Love_1.add("Карпо Кайдаш"); Questions_Couplt_Love_2.add("Мотря Довбишівна");
        Questions_Couplt_Love_1.add("Петро Шрам"); Questions_Couplt_Love_2.add("Леся Черевань");
        Questions_Couplt_Love_1.add("Чіпка"); Questions_Couplt_Love_2.add("Галя Гудзівна");
        Questions_Couplt_Love_1.add("Михайло"); Questions_Couplt_Love_2.add("Софія");
        Questions_Couplt_Love_1.add("Григорій Многогрішний"); Questions_Couplt_Love_2.add("Наталка Сірко");
        Questions_Couplt_Love_1.add("Мокій"); Questions_Couplt_Love_2.add("Уля");
        Questions_Couplt_Love_1.add("Ігор"); Questions_Couplt_Love_2.add("Ярославна");
        Questions_Couplt_Love_1.add("Еней"); Questions_Couplt_Love_2.add("Дідона");
        Questions_Couplt_Love_1.add("Степан Радченко"); Questions_Couplt_Love_2.add("Зоська");
        Questions_Couplt_Love_1.add("москаль Іван"); Questions_Couplt_Love_2.add("Катерина");
        Questions_Couplt_Love_1.add("Максим"); Questions_Couplt_Love_2.add("Мирослава");


        Questions_Heroes_1.clear();
        Questions_Heroes_2.clear();
        Questions_Heroes_1.add("Хорив"); Questions_Heroes_2.add("Либідь");
        Questions_Heroes_1.add("Овлур"); Questions_Heroes_2.add("Кончак");
        Questions_Heroes_1.add("Анхіз"); Questions_Heroes_2.add("Венера");
        Questions_Heroes_1.add("Горпина Терпелиха"); Questions_Heroes_2.add("Тетерваковський");
        Questions_Heroes_1.add("Яким Сомко"); Questions_Heroes_2.add("Кирило Тур");
        Questions_Heroes_1.add("Маруся Кайдашиха"); Questions_Heroes_2.add("Мелашка");
        Questions_Heroes_1.add("Чіпка Варениченко"); Questions_Heroes_2.add("Максим Ґудзь");
        Questions_Heroes_1.add("Гервасій Гуляницький"); Questions_Heroes_2.add("Націєвський");
        Questions_Heroes_1.add("Тугар Вовк"); Questions_Heroes_2.add("Захар Беркут");
        Questions_Heroes_1.add("Датан"); Questions_Heroes_2.add("Авірон");
        Questions_Heroes_1.add("Іван Палійчук"); Questions_Heroes_2.add("Палагна");
        Questions_Heroes_1.add("Іван Дідух"); Questions_Heroes_2.add("кум Михайло");
        Questions_Heroes_1.add("Килина"); Questions_Heroes_2.add("Мавка");
        Questions_Heroes_1.add("Андрюша"); Questions_Heroes_2.add("доктор Тагабат");
        Questions_Heroes_1.add("Зекія"); Questions_Heroes_2.add("Сев");
        Questions_Heroes_1.add("Лука Гнідий"); Questions_Heroes_2.add("Тамара Василівна");
        Questions_Heroes_1.add("Мотрона Розторгуєва"); Questions_Heroes_2.add("Уля");
        Questions_Heroes_1.add("Одарка Єрмолаївна"); Questions_Heroes_2.add("Петро Семенович");
        Questions_Heroes_1.add("Маруся Чурай"); Questions_Heroes_2.add("Грицько Бобренко");
        Questions_Heroes_1.add("Денис Сірко"); Questions_Heroes_2.add("Григорій Многогрішний");
        Questions_Heroes_1.add("Софія"); Questions_Heroes_2.add("Михайло");

        Questions_Composition_Places_1.clear();
        Questions_Composition_Places_2.clear();
        Questions_Composition_Places_1.add("Наталка Полтавка"); Questions_Composition_Places_2.add("під Полтавою");
        Questions_Composition_Places_1.add("Кайдашева сім’я"); Questions_Composition_Places_2.add("у Семигорах");
        Questions_Composition_Places_1.add("Хіба ревуть воли, як ясла повні?"); Questions_Composition_Places_2.add("у Пісках");
        Questions_Composition_Places_1.add("Чорна рада"); Questions_Composition_Places_2.add("на хуторі Хмарище, у Києві, у Ніжині");
        Questions_Composition_Places_1.add("Intermezzo"); Questions_Composition_Places_2.add("біля Кононівки");
        Questions_Composition_Places_1.add("Лісова пісня"); Questions_Composition_Places_2.add("на Волині");
        Questions_Composition_Places_1.add("Місто"); Questions_Composition_Places_2.add("у Києві");
        Questions_Composition_Places_1.add("Сом"); Questions_Composition_Places_2.add("на річці Оскіл");
        Questions_Composition_Places_1.add("Мина Мазайло"); Questions_Composition_Places_2.add("у Харкові");
        Questions_Composition_Places_1.add("Зачарована Десна"); Questions_Composition_Places_2.add("на березі Десни");
        Questions_Composition_Places_1.add("Маруся Чурай"); Questions_Composition_Places_2.add("у Полтаві, Києві");
        Questions_Composition_Places_1.add("Тигролови"); Questions_Composition_Places_2.add("Сибір");

        Questions_Author_Surname_1.clear();
        Questions_Author_Surname_2.clear();
        Questions_Author_Surname_1.add("Панас Мирний"); Questions_Author_Surname_2.add("Рудченко Панас Якович");
        Questions_Author_Surname_1.add("Олександр Олесь"); Questions_Author_Surname_2.add("Кандиба Олександр Іванович");
        Questions_Author_Surname_1.add("Іван Карпенко-Карий"); Questions_Author_Surname_2.add("Тобілевич Іван Карпович");
        Questions_Author_Surname_1.add("Григорій Квітка-Основ'яненко"); Questions_Author_Surname_2.add("Квітка Григорій Федорович");
        Questions_Author_Surname_1.add("Іван Нечуй-Левицький"); Questions_Author_Surname_2.add("Левицький Іван Семенович");
        Questions_Author_Surname_1.add("Микола Хвильовий"); Questions_Author_Surname_2.add("Фітільов Микола Григорович");
        Questions_Author_Surname_1.add("Остап Вишня"); Questions_Author_Surname_2.add("Павло Губенко");
        Questions_Author_Surname_1.add("Іван Багряний"); Questions_Author_Surname_2.add("Лозов’ягін Іван Павлович");
        Questions_Author_Surname_1.add("Леся Українка"); Questions_Author_Surname_2.add("Косач (Квітка) Лариса Петрівна");

        Questions_MainHeroes_Compostition_1.clear();
        Questions_MainHeroes_Compostition_2.clear();
        Questions_MainHeroes_Compostition_1.add("Енеїда"); Questions_MainHeroes_Compostition_2.add("Еней");
        Questions_MainHeroes_Compostition_1.add("Наталка Полтавка"); Questions_MainHeroes_Compostition_2.add("Петро");
        Questions_MainHeroes_Compostition_1.add("Чорна рада"); Questions_MainHeroes_Compostition_2.add("Петро Шраменко");
        Questions_MainHeroes_Compostition_1.add("Кайдашева сім’я"); Questions_MainHeroes_Compostition_2.add("Лаврін та Карпо");
        Questions_MainHeroes_Compostition_1.add("Хіба ревуть воли, як ясла повні?"); Questions_MainHeroes_Compostition_2.add("Чіпка Варениченко");
        Questions_MainHeroes_Compostition_1.add("Мартин Боруля"); Questions_MainHeroes_Compostition_2.add("Палажка");
        Questions_MainHeroes_Compostition_1.add("Мойсей"); Questions_MainHeroes_Compostition_2.add("Єгова");
        Questions_MainHeroes_Compostition_1.add("Захар Беркут"); Questions_MainHeroes_Compostition_2.add("Тугар Вовк");
        Questions_MainHeroes_Compostition_1.add("Тіні забутих предків"); Questions_MainHeroes_Compostition_2.add("Іван Палійчук");
        Questions_MainHeroes_Compostition_1.add("Камінний хрест"); Questions_MainHeroes_Compostition_2.add("Іван Дідух");
        Questions_MainHeroes_Compostition_1.add("Лісова пісня"); Questions_MainHeroes_Compostition_2.add("Лукаш");
        Questions_MainHeroes_Compostition_1.add("Я (Романтика)"); Questions_MainHeroes_Compostition_2.add("Андрюша");
        Questions_MainHeroes_Compostition_1.add("Місто"); Questions_MainHeroes_Compostition_2.add("Степан Радченко");
        Questions_MainHeroes_Compostition_1.add("Мина Мазайло"); Questions_MainHeroes_Compostition_2.add("Мокій");
        Questions_MainHeroes_Compostition_1.add("Тигролови"); Questions_MainHeroes_Compostition_2.add("Григорій Многогрішний");
        Questions_MainHeroes_Compostition_1.add("Три зозулі з поклоном"); Questions_MainHeroes_Compostition_2.add("Михайло");
        Questions_MainHeroes_Compostition_1.add("Маруся Чурай"); Questions_MainHeroes_Compostition_2.add("Гриць Бобренко");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finda_match);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_10 = (Button) findViewById(R.id.btn_10);
        life1 = (ImageView) findViewById(R.id.life1);
        life2 = (ImageView) findViewById(R.id.life2);
        life3 = (ImageView) findViewById(R.id.life3);
        RESULT_SCORE = (TextView) findViewById(R.id.RESULT_SCORE);
        Question = (TextView) findViewById(R.id.Question);

        AddDate();

        random = new Random();
        startGame();
    }

    private void newGame(){
        if(btn_1.getVisibility() == View.INVISIBLE && btn_2.getVisibility() == View.INVISIBLE && btn_3.getVisibility() == View.INVISIBLE &&
                btn_4.getVisibility() == View.INVISIBLE && btn_5.getVisibility() == View.INVISIBLE && btn_6.getVisibility() == View.INVISIBLE &&
                btn_7.getVisibility() == View.INVISIBLE && btn_8.getVisibility() == View.INVISIBLE && btn_9.getVisibility() == View.INVISIBLE &&
                btn_10.getVisibility() == View.INVISIBLE) {
            AddDate();
            startGame();
        }
    }

    ArrayList<String> answers_1 = new ArrayList<>();
    ArrayList<String> answers_2 = new ArrayList<>();

    private void setRandomQuestions(ArrayList<String> Questions_Author_Composition_1, ArrayList<String> Questions_Author_Composition_2){

        answers_1.clear();
        answers_2.clear();

        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();

        randomQuest = random.nextInt(Questions_Author_Composition_1.size());
        arrayList.add(Questions_Author_Composition_1.get(randomQuest));
        answers_1.add(Questions_Author_Composition_1.get(randomQuest));
        arrayList2.add(Questions_Author_Composition_2.get(randomQuest));
        answers_2.add(Questions_Author_Composition_2.get(randomQuest));
        Questions_Author_Composition_1.remove(randomQuest);
        Questions_Author_Composition_2.remove(randomQuest);

        randomQuest = random.nextInt(Questions_Author_Composition_1.size());
        arrayList.add(Questions_Author_Composition_1.get(randomQuest));
        answers_1.add(Questions_Author_Composition_1.get(randomQuest));
        arrayList2.add(Questions_Author_Composition_2.get(randomQuest));
        answers_2.add(Questions_Author_Composition_2.get(randomQuest));
        Questions_Author_Composition_1.remove(randomQuest);
        Questions_Author_Composition_2.remove(randomQuest);

        randomQuest = random.nextInt(Questions_Author_Composition_1.size());
        arrayList.add(Questions_Author_Composition_1.get(randomQuest));
        answers_1.add(Questions_Author_Composition_1.get(randomQuest));
        arrayList2.add(Questions_Author_Composition_2.get(randomQuest));
        answers_2.add(Questions_Author_Composition_2.get(randomQuest));
        Questions_Author_Composition_1.remove(randomQuest);
        Questions_Author_Composition_2.remove(randomQuest);

        randomQuest = random.nextInt(Questions_Author_Composition_1.size());
        arrayList.add(Questions_Author_Composition_1.get(randomQuest));
        answers_1.add(Questions_Author_Composition_1.get(randomQuest));
        arrayList2.add(Questions_Author_Composition_2.get(randomQuest));
        answers_2.add(Questions_Author_Composition_2.get(randomQuest));
        Questions_Author_Composition_1.remove(randomQuest);
        Questions_Author_Composition_2.remove(randomQuest);

        randomQuest = random.nextInt(Questions_Author_Composition_1.size());
        arrayList.add(Questions_Author_Composition_1.get(randomQuest));
        answers_1.add(Questions_Author_Composition_1.get(randomQuest));
        arrayList2.add(Questions_Author_Composition_2.get(randomQuest));
        answers_2.add(Questions_Author_Composition_2.get(randomQuest));
        Questions_Author_Composition_1.remove(randomQuest);
        Questions_Author_Composition_2.remove(randomQuest);

        Collections.shuffle(arrayList);
        Collections.shuffle(arrayList2);

        btn_1.setText(arrayList.get(0));
        btn_2.setText(arrayList2.get(0));


        btn_3.setText(arrayList.get(1));
        btn_4.setText(arrayList2.get(1));


        btn_5.setText(arrayList.get(2));
        btn_6.setText(arrayList2.get(2));


        btn_7.setText(arrayList.get(3));
        btn_8.setText(arrayList2.get(3));


        btn_9.setText(arrayList.get(4));
        btn_10.setText(arrayList2.get(4));

        arrayList.clear();
        arrayList2.clear();
    }


    private void startGame(){
        QuestionsId = random.nextInt(Questions.length);
        if(QuestionsId == 0){
            Question.setText(Questions[0]);
            setRandomQuestions(Questions_Author_Composition_1,Questions_Author_Composition_2);

        } else if(QuestionsId == 1){
            Question.setText(Questions[1]);
            setRandomQuestions(Questions_Genre_Composition_1,Questions_Genre_Composition_2);

        } else if(QuestionsId == 2){
            Question.setText(Questions[2]);
            setRandomQuestions(Questions_Couplt_Love_1,Questions_Couplt_Love_2);

        } else if(QuestionsId == 3){
            Question.setText(Questions[3]);
            setRandomQuestions(Questions_Heroes_1,Questions_Heroes_2);

        } else if(QuestionsId == 4){
            Question.setText(Questions[4]);
            setRandomQuestions(Questions_Composition_Places_1,Questions_Composition_Places_2);

        } else if(QuestionsId == 5){
            Question.setText(Questions[5]);
            setRandomQuestions(Questions_Author_Surname_1,Questions_Author_Surname_2);

        } else if(QuestionsId == 6){
            Question.setText(Questions[6]);
            setRandomQuestions(Questions_MainHeroes_Compostition_1,Questions_MainHeroes_Compostition_2);

        }

        btn_1.setEnabled(true); btn_1.setClickable(true); btn_1.setVisibility(View.VISIBLE);
        btn_2.setEnabled(true); btn_2.setClickable(true); btn_2.setVisibility(View.VISIBLE);
        btn_3.setEnabled(true); btn_3.setClickable(true); btn_3.setVisibility(View.VISIBLE);
        btn_4.setEnabled(true); btn_4.setClickable(true); btn_4.setVisibility(View.VISIBLE);
        btn_5.setEnabled(true); btn_5.setClickable(true); btn_5.setVisibility(View.VISIBLE);
        btn_6.setEnabled(true); btn_6.setClickable(true); btn_6.setVisibility(View.VISIBLE);
        btn_7.setEnabled(true); btn_7.setClickable(true); btn_7.setVisibility(View.VISIBLE);
        btn_8.setEnabled(true); btn_8.setClickable(true); btn_8.setVisibility(View.VISIBLE);
        btn_9.setEnabled(true); btn_9.setClickable(true); btn_9.setVisibility(View.VISIBLE);
        btn_10.setEnabled(true); btn_10.setClickable(true); btn_10.setVisibility(View.VISIBLE);

    }

    String firstCard = "";
    Button hiddenButton = null;
    int life_i = 0;
    int right = 0;
    private  void returnCardAfterFalse(Button btn1){
        right = 0;
        if(firstCard.equalsIgnoreCase("")){
            firstCard = btn1.getText().toString();
            hiddenButton = btn1;
            btn1.setVisibility(View.INVISIBLE);  btn1.setClickable(false);    btn1.setEnabled(false);
        }else{
            for(int i = 0; i < answers_1.size();i++) {
                if (firstCard.equalsIgnoreCase(answers_1.get(i)) && btn1.getText().toString().equalsIgnoreCase(answers_2.get(i))) {
                    GuessedAnswers++;
                    RESULT_SCORE.setText(""+GuessedAnswers);
                    btn1.setVisibility(View.INVISIBLE);
                    btn1.setClickable(false);
                    btn1.setEnabled(false);
                    hiddenButton.setVisibility(View.INVISIBLE);
                    hiddenButton.setClickable(false);
                    hiddenButton.setEnabled(false);
                    firstCard = "";
                    hiddenButton = null;
                    right = 1;
                    newGame();
                } else if (firstCard.equalsIgnoreCase(answers_2.get(i)) && btn1.getText().toString().equalsIgnoreCase(answers_1.get(i))) {
                    GuessedAnswers++;
                    RESULT_SCORE.setText(""+GuessedAnswers);
                    btn1.setVisibility(View.INVISIBLE);
                    btn1.setClickable(false);
                    btn1.setEnabled(false);
                    hiddenButton.setVisibility(View.INVISIBLE);
                    hiddenButton.setClickable(false);
                    hiddenButton.setEnabled(false);
                    firstCard = "";
                    hiddenButton = null;
                    right = 1;
                    newGame();
                }
            }
                if(right == 0) {
                    btn1.setVisibility(View.VISIBLE);  btn1.setClickable(true);    btn1.setEnabled(true);
                    hiddenButton.setVisibility(View.VISIBLE);  hiddenButton.setClickable(true);    hiddenButton.setEnabled(true);
                    firstCard = "";
                    hiddenButton = null;
                    if (life_i == 0) {
                        life1.setImageResource(R.drawable.life_out);
                        life_i++;
                    } else if (life_i == 1) {
                        life2.setImageResource(R.drawable.life_out);
                        life_i++;
                    } else if (life_i == 2) {
                        life3.setImageResource(R.drawable.life_out);
                        btn_1.setEnabled(false);
                        btn_2.setEnabled(false);
                        btn_3.setEnabled(false);
                        btn_4.setEnabled(false);
                        btn_5.setEnabled(false);
                        btn_6.setEnabled(false);
                        btn_7.setEnabled(false);
                        btn_8.setEnabled(false);
                        btn_9.setEnabled(false);
                        btn_10.setEnabled(false);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, 1000);
                    }
                }
            }
        }


    public void ClickAndCheck(View view) {
    switch (view.getId()){
        case R.id.btn_1:
            returnCardAfterFalse(btn_1);
            break;
        case R.id.btn_2:
            returnCardAfterFalse(btn_2);
            break;
        case R.id.btn_3:
            returnCardAfterFalse(btn_3);
            break;
        case R.id.btn_4:
            returnCardAfterFalse(btn_4);
            break;
        case R.id.btn_5:
            returnCardAfterFalse(btn_5);
            break;
        case R.id.btn_6:
            returnCardAfterFalse(btn_6);
            break;
        case R.id.btn_7:
            returnCardAfterFalse(btn_7);
            break;
        case R.id.btn_8:
            returnCardAfterFalse(btn_8);
            break;
        case R.id.btn_9:
            returnCardAfterFalse(btn_9);
            break;
        case R.id.btn_10:
            returnCardAfterFalse(btn_10);
            break;
        }
    }



    public void finish(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
