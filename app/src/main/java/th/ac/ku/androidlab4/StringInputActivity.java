package th.ac.ku.androidlab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StringInputActivity extends AppCompatActivity {

    private EditText inputEditText;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_input);

        initInstance();
    }

    private void initInstance() {
        inputEditText = (EditText) findViewById(R.id.et_input);
        okButton = (Button) findViewById(R.id.btn_ok);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOk();
            }
        });
    }

    private void onClickOk() {
        String result = inputEditText.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("data", result);

        setResult(RESULT_OK, intent);
        finish();
    }
}
