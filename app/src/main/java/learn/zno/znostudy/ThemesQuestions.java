package learn.zno.znostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThemesQuestions extends AppCompatActivity {

    CheckBox checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9,checkbox10,checkbox11,checkbox12,checkbox13,checkboxAll;
    TextView alltextCheck;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes_questions);

        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
        checkbox5 = (CheckBox) findViewById(R.id.checkbox5);
        checkbox6 = (CheckBox) findViewById(R.id.checkbox6);
        checkbox7 = (CheckBox) findViewById(R.id.checkbox7);
        checkbox8 = (CheckBox) findViewById(R.id.checkbox8);
        checkbox9 = (CheckBox) findViewById(R.id.checkbox9);
        checkbox10 = (CheckBox) findViewById(R.id.checkbox10);
        checkbox11 = (CheckBox) findViewById(R.id.checkbox11);
        checkbox12 = (CheckBox) findViewById(R.id.checkbox12);
        checkbox13 = (CheckBox) findViewById(R.id.checkbox13);
        checkboxAll = (CheckBox) findViewById(R.id.checkboxAll);

        next = (Button) findViewById(R.id.next);
        next.setEnabled(true);
        next.setClickable(true);

        alltextCheck = (TextView) findViewById(R.id.TextCheckAll);


        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkboxAll.isChecked()){
                    checkbox1.setChecked(true);
                    checkbox2.setChecked(true);
                    checkbox3.setChecked(true);
                    checkbox4.setChecked(true);
                    checkbox5.setChecked(true);
                    checkbox6.setChecked(true);
                    checkbox7.setChecked(true);
                    checkbox8.setChecked(true);
                    checkbox9.setChecked(true);
                    checkbox10.setChecked(true);
                    checkbox11.setChecked(true);
                    checkbox12.setChecked(true);
                    checkbox13.setChecked(true);
                    alltextCheck.setText("Прибрати всі галочки");
                }else{
                    alltextCheck.setText("Виділити всі типи питань");
                    checkbox1.setChecked(false);
                    checkbox2.setChecked(false);
                    checkbox3.setChecked(false);
                    checkbox4.setChecked(false);
                    checkbox5.setChecked(false);
                    checkbox6.setChecked(false);
                    checkbox7.setChecked(false);
                    checkbox8.setChecked(false);
                    checkbox9.setChecked(false);
                    checkbox10.setChecked(false);
                    checkbox11.setChecked(false);
                    checkbox12.setChecked(false);
                    checkbox13.setChecked(false);
                }
            }
        });


    }

    public void Next(View view) {
        if (!checkbox1.isChecked() && !checkbox2.isChecked() && !checkbox3.isChecked() && !checkbox4.isChecked() && !checkbox5.isChecked() && !checkbox6.isChecked() &&
                !checkbox7.isChecked() && !checkbox8.isChecked() && !checkbox9.isChecked() && !checkbox10.isChecked() && !checkbox11.isChecked() && !checkbox12.isChecked() &&
                !checkbox13.isChecked()){
            Toast.makeText(this, "Ви нічого не вибрали", Toast.LENGTH_SHORT).show();
        }else{
        Intent intent = new Intent(this, TestStart.class);
        if(checkbox1.isChecked()){
            intent.putExtra("checkbox1", "true");
        }else{
            intent.putExtra("checkbox1", "false");
        }
        if(checkbox2.isChecked()){
            intent.putExtra("checkbox2", "true");
        }else{
            intent.putExtra("checkbox2", "false");
        }
        if(checkbox3.isChecked()){
            intent.putExtra("checkbox3", "true");
        }else{
            intent.putExtra("checkbox3", "false");
        }
        if(checkbox4.isChecked()){
            intent.putExtra("checkbox4", "true");
        }else{
            intent.putExtra("checkbox4", "false");
        }
        if(checkbox5.isChecked()){
            intent.putExtra("checkbox5", "true");
        }else{
            intent.putExtra("checkbox5", "false");
        }
        if(checkbox6.isChecked()){
            intent.putExtra("checkbox6", "true");
        }else{
            intent.putExtra("checkbox6", "false");
        }
        if(checkbox7.isChecked()){
            intent.putExtra("checkbox7", "true");
        }else{
            intent.putExtra("checkbox7", "false");
        }
        if(checkbox8.isChecked()){
            intent.putExtra("checkbox8", "true");
        }else{
            intent.putExtra("checkbox8", "false");
        }
        if(checkbox9.isChecked()){
            intent.putExtra("checkbox9", "true");
        }else{
            intent.putExtra("checkbox9", "false");
        }
        if(checkbox10.isChecked()){
            intent.putExtra("checkbox10", "true");
        }else{
            intent.putExtra("checkbox10", "false");
        }
        if(checkbox11.isChecked()){
            intent.putExtra("checkbox11", "true");
        }else{
            intent.putExtra("checkbox11", "false");
        }
        if(checkbox12.isChecked()){
            intent.putExtra("checkbox12", "true");
        }else{
            intent.putExtra("checkbox12", "false");
        }
        if(checkbox13.isChecked()){
            intent.putExtra("checkbox13", "true");
        }else{
            intent.putExtra("checkbox13", "false");
        }
        startActivityForResult(intent,1);
        next.setEnabled(false);
        next.setClickable(false);
     }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1){
            next.setEnabled(true);
            next.setClickable(true);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void finish(View view) {
        finish();
    }
}
