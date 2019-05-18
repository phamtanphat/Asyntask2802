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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

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
                new Xulytacvu().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

            }
        });
    }
    //Param : tham so truyen vao cho phan doinbackground
    //Progress : tham so truyen vao cho phan progressupdate
    //Result : tham so truyen vao cho phan onPostExecute
    class Xulytacvu extends AsyncTask<String,String,ArrayList<String>> {
        @Override
        protected ArrayList<String> doInBackground(String... strings) {
            ArrayList<String> content = new ArrayList<>();
            try    {
                // create a url object
                URL url = new URL(strings[0]);
                // create a urlconnection object
                URLConnection urlConnection = url.openConnection();
                // wrap the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null){

                    content.add(line + "\n");
//                    publishProgress(line + "\n");
                }
                bufferedReader.close();
            }
            catch(Exception e)    {
                e.printStackTrace();
            }
            return content;
        }


//        @Override
//        protected void onProgressUpdate(String... values) {
//            txtPhantram.append(values[0]);
//            super.onProgressUpdate(values);
//        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            String ketqua = "";
            for (String value : strings){
                ketqua += value;
            }
            //covert string ve dang the mo dau tien o ben trong
            try {
                JSONObject jsonObject = new JSONObject(ketqua);
                JSONObject jsonObject1 =jsonObject.getJSONObject("language");
                JSONObject jsonObject2 = jsonObject1.getJSONObject("vn");
                String name = jsonObject2.getString("name");
                Log.d("BBB",name);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(strings);
        }
    }


}
