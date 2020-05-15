package learn.zno.znostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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



    }

    public void Choise(View view){
        Intent intent  = new Intent(this,ZNOTest.class);
        switch (view.getId()){
            case R.id.main2019:
                intent.putExtra("ChoiseZNO","main2019");
                intent.putExtra("name","ЗНО 2019 року з української літератури – основна сесія");
                startActivity(intent);
                break;
            case R.id.additional2019:
                intent.putExtra("ChoiseZNO","additional2019");
                intent.putExtra("name","ЗНО 2019 року з української літератури – додаткова сесія");
                startActivity(intent);
                break;
            case R.id.main2018:
                intent.putExtra("ChoiseZNO","main2018");
                intent.putExtra("name","ЗНО 2018 року з української  літератури – основна сесія");
                startActivity(intent);
                break;
            case R.id.additional2018:
                intent.putExtra("ChoiseZNO","additional2018");
                intent.putExtra("name","ЗНО 2018 року з української літератури – додаткова сесія");
                startActivity(intent);
                break;
            case R.id.main2017:
                intent.putExtra("ChoiseZNO","main2017");
                intent.putExtra("name","ЗНО 2017 року з української літератури – основна сесія");
                startActivity(intent);
                break;
            case R.id.additional2017:
                intent.putExtra("ChoiseZNO","additional2017");
                intent.putExtra("name","ЗНО 2017 року з української літератури – додаткова сесія");
                startActivity(intent);
                break;
            case R.id.main2016:
                intent.putExtra("ChoiseZNO","main2016");
                intent.putExtra("name","ЗНО 2016 року з української літератури – основна сесія");
                startActivity(intent);
                break;
            case R.id.additional2016:
                intent.putExtra("ChoiseZNO","additional2016");
                intent.putExtra("name","ЗНО 2016 року з української літератури – додаткова сесія");
                startActivity(intent);
                break;
        }
    }

    public void finish(View view) {
        finish();
    }
}
