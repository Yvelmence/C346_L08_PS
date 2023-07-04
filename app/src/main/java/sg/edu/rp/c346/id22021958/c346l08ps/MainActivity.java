package sg.edu.rp.c346.id22021958.c346l08ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etName, etYear;
    Button btnIns, btnShow;
    RadioButton star1, star2, star3, star4, star5;
    ListView lv;
    ArrayList<Songs> al = new ArrayList<>();
    ArrayAdapter<Songs> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etName = findViewById(R.id.etName);
        etYear = findViewById(R.id.etYear);

        btnIns = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);

        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        star4 = findViewById(R.id.star4);
        star5 = findViewById(R.id.star5);

        lv = findViewById(R.id.lv);

        aa = new ArrayAdapter<Songs>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);


        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(MainActivity.this);
                String newSong = etTitle.getText().toString();
                String newSinger = etName.getText().toString();
                int newYear = Integer.parseInt(etYear.getText().toString());

                String rating;
                if(checkedRadio)
            }
        });

    }

}