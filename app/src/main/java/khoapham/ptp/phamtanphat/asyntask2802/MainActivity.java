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
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
//            + Hien thi thanh progressbar;
//            + Hien thi text phan tram down load
//            + 1s => 20 phan tram;
//        - Down load xog hien thi tam hinh:
//            + Tat thanh progressbar va text
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Xulytacvu().execute("abc","cdf");

            }
        });
    }
    //Param : tham so truyen vao cho phan doinbackground
    //Progress : tham so truyen vao cho phan progressupdate
    //Result : tham so truyen vao cho phan onPostExecute
    class Xulytacvu extends AsyncTask<String,Integer,String> {
        @Override
        protected void onPreExecute() {
            //Hien thi progressbar
            //Hien thi textview
            progressBar.setVisibility(View.VISIBLE);
            txtPhantram.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... strings) {
            //Cu sau 1s = truyen thang progressupdate 20
//            Log.d("BBB",strings.length);
            //Khi truyen du 100 tra gia tri ve la 1 chuoi download thanh cong
            for (int i = 0 ; i < 5 ; i++){
                publishProgress(20);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Down load thành công";
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            //Nhan gia tri tu doinbackground va gan len cho giao dien
            progressBar.setProgress(progressBar.getProgress() + values[0]);
            txtPhantram.setText(progressBar.getProgress() + "");
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String s) {
            txtPhantram.setText(s);
            super.onPostExecute(s);
        }
    }
    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }
}
