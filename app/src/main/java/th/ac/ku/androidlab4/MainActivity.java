package th.ac.ku.androidlab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button numberButton;
    private Button stringButton;
    private static int NUMBER_CODE = 1;
    private static int STRING_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();
    }

    private void initInstance() {
        numberButton = (Button) findViewById(R.id.btn_num);
        stringButton = (Button) findViewById(R.id.btn_str);

        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickNumber();
            }
        });
        stringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickString();
            }
        });
    }


    private void onClickNumber(){
        Intent intent = new Intent(this, NumberInputActivity.class);

        startActivityForResult(intent, NUMBER_CODE);
    }

    private void onClickString(){
        Intent intent = new Intent(this, StringInputActivity.class);

        startActivityForResult(intent, STRING_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == NUMBER_CODE){
                int num = data.getIntExtra("data", 0);
                num++;
                Toast.makeText(this, num + "", Toast.LENGTH_SHORT).show();
            }else if (requestCode == STRING_CODE){
                String text = data.getStringExtra("data");
                text = text.toUpperCase();
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
