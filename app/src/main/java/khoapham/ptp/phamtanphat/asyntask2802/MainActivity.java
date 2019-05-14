package khoapham.ptp.phamtanphat.asyntask2802;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    TextView txtPhantram;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.buttonStart);
        txtPhantram = findViewById(R.id.textviewDungluong);
        progressBar = findViewById(R.id.progressbar);

        progressBar.setVisibility(View.GONE);
        txtPhantram.setVisibility(View.GONE);
//        - Truoc khi bat dau down load :
//            + Cho hien thanh progressbar
//        - Trong qua trinh download :
//            + An thanh progressbar;
//            + Hien thi text phan tram down load
//            + 1s => 20 phan tram;
//        - Down load xog hien thi tam hinh:
//            + Tat thanh progressbar va text
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    class Xulytacvu extends AsyncTask<> {

    }

}
