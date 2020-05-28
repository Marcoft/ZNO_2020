package learn.zno.znostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChoiseZNOYear extends AppCompatActivity {

    Button main2019, additional2019, main2018 , additional2018, main2017 , additional2017, main2016 , additional2016;
    String extraGo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise_z_n_o_year);

        main2019 = (Button) findViewById(R.id.main2019);
        additional2019 = (Button) findViewById(R.id.additional2019);
        main2018 = (Button) findViewById(R.id.main2018);
        additional2018 = (Button) findViewById(R.id.additional2018);
        main2017 = (Button) findViewById(R.id.main2017);
        additional2017 = (Button) findViewById(R.id.additional2017);
        main2016 = (Button) findViewById(R.id.main2016);
        additional2016 = (Button) findViewById(R.id.additional2016);

        main2019.setEnabled(true);
        main2019.setClickable(true);
        additional2019.setEnabled(true);
        additional2019.setClickable(true);
        main2018.setEnabled(true);
        main2018.setClickable(true);
        additional2018.setEnabled(true);
        additional2018.setClickable(true);
        main2017.setEnabled(true);
        main2017.setClickable(true);
        additional2017.setEnabled(true);
        additional2017.setClickable(true);
        main2016.setEnabled(true);
        main2016.setClickable(true);
        additional2016.setEnabled(true);
        additional2016.setClickable(true);

    }

    public void Choise(View view){
        Intent intent  = new Intent(this,ZNOTest.class);
        switch (view.getId()){
            case R.id.main2019:
                intent.putExtra("ChoiseZNO","main2019");
                intent.putExtra("name","ЗНО 2019 року з української літератури – основна сесія");
                startActivityForResult(intent,1);
                main2019.setEnabled(false);
                main2019.setClickable(false);
                break;
            case R.id.additional2019:
                intent.putExtra("ChoiseZNO","additional2019");
                intent.putExtra("name","ЗНО 2019 року з української літератури – додаткова сесія");
                startActivityForResult(intent,2);
                additional2019.setEnabled(false);
                additional2019.setClickable(false);
                break;
            case R.id.main2018:
                intent.putExtra("ChoiseZNO","main2018");
                intent.putExtra("name","ЗНО 2018 року з української  літератури – основна сесія");
                startActivityForResult(intent,3);
                main2018.setEnabled(false);
                main2018.setClickable(false);
                break;
            case R.id.additional2018:
                intent.putExtra("ChoiseZNO","additional2018");
                intent.putExtra("name","ЗНО 2018 року з української літератури – додаткова сесія");
                startActivityForResult(intent,4);
                additional2018.setEnabled(false);
                additional2018.setClickable(false);
                break;
            case R.id.main2017:
                intent.putExtra("ChoiseZNO","main2017");
                intent.putExtra("name","ЗНО 2017 року з української літератури – основна сесія");
                startActivityForResult(intent,5);
                main2017.setEnabled(false);
                main2017.setClickable(false);
                break;
            case R.id.additional2017:
                intent.putExtra("ChoiseZNO","additional2017");
                intent.putExtra("name","ЗНО 2017 року з української літератури – додаткова сесія");
                startActivityForResult(intent,6);
                additional2017.setEnabled(false);
                additional2017.setClickable(false);
                break;
            case R.id.main2016:
                intent.putExtra("ChoiseZNO","main2016");
                intent.putExtra("name","ЗНО 2016 року з української літератури – основна сесія");
                startActivityForResult(intent,7);
                main2016.setEnabled(false);
                main2016.setClickable(false);
                break;
            case R.id.additional2016:
                intent.putExtra("ChoiseZNO","additional2016");
                intent.putExtra("name","ЗНО 2016 року з української літератури – додаткова сесія");
                startActivityForResult(intent,8);
                additional2016.setEnabled(false);
                additional2016.setClickable(false);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1){
            main2019.setEnabled(true);
            main2019.setClickable(true);
        }
        if (requestCode == 2){
            additional2019.setEnabled(true);
            additional2019.setClickable(true);
        }
        if (requestCode == 3){
            main2018.setEnabled(true);
            main2018.setClickable(true);
        }
        if (requestCode == 4){
            additional2018.setEnabled(true);
            additional2018.setClickable(true);
        }
        if (requestCode == 5){
            main2017.setEnabled(true);
            main2017.setClickable(true);
        }
        if (requestCode == 6){
            additional2017.setEnabled(true);
            additional2017.setClickable(true);
        }
        if (requestCode == 7){
            main2016.setEnabled(true);
            main2016.setClickable(true);
        }
        if (requestCode == 8){
            additional2016.setEnabled(true);
            additional2016.setClickable(true);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void finish(View view) {
        finish();
    }
}
