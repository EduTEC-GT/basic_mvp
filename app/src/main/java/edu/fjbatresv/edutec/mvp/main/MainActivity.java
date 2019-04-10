package edu.fjbatresv.edutec.mvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.fjbatresv.edutec.mvp.R;

public class MainActivity extends AppCompatActivity implements MainView {

    EditText newTxt;
    TextView resultTxt;
    Button btn;
    MainPresenter presenter;
    MainModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();
        model = new MainModelImpl();
        presenter = new MainPresenterImpl(this, model);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (newTxt.getText().toString() != null && !newTxt.getText().toString().isEmpty()) {
                    presenter.textToUpper(newTxt.getText().toString());
                }
            }
        });
    }

    private void binding() {
        btn = findViewById(R.id.btn);
        resultTxt = findViewById(R.id.result_txt);
        newTxt = findViewById(R.id.new_txt);
    }

    @Override
    public void setText(String text) {
        resultTxt.setText(text);
    }

    @Override
    public void setButtonText(String text) {
        btn.setText(text);
    }

    @Override
    public void cleanEditText() {
        newTxt.setText(null);
    }
}
