package khoapham.ptp.phamtanphat.asyntask2802;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                new Xulytacvu().execute();

            }
        });
    }
    //Param : tham so truyen vao cho phan doinbackground
    //Progress : tham so truyen vao cho phan progressupdate
    //Result : tham so truyen vao cho phan onPostExecute
    class Xulytacvu extends AsyncTask<Void,String,String> {

        @Override
        protected void onPreExecute() {
            //Hien thi progressbar
            //Hien thi textview
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... strings) {
            //Cu sau 1s = truyen thang progressupdate 20
            //Khi truyen du 100 tra gia tri ve la 1 chuoi download thanh cong
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //Nhan gia tri tu doinbackground va gan len cho giao dien
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            // Nhan cai chuoi duoc tra ve sau do hient hi len man hinh
            super.onPostExecute(s);
        }
    }

}
