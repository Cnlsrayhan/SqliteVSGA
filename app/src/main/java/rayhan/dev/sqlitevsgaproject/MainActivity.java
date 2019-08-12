package rayhan.dev.sqlitevsgaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    private DataBaseHelper dbHelper;

    private Button btnStore, btnGetall;
    private EditText etname;
    private TextView tvnames;
    private ArrayList<String> arrayList;
    private ListView listViewSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  File storagePath =
        //          getApplication().getFilesDir();

        //   String myDbPath = storagePath + "/" + "myfriends";
        //  Log.i("DB", "Path : " + myDbPath);

        //db = SQLiteDatabase.openDatabase(myDbPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);

        //    db.close();
        //}

        final DataBaseHelper dbHelper = new DataBaseHelper(this);
        tvnames = (TextView) findViewById(R.id.tvnames);

        btnStore = (Button) findViewById(R.id.btnStore);
        btnGetall = (Button) findViewById(R.id.btnget);
        etname = (EditText) findViewById(R.id.etname);

        listViewSiswa = (ListView) findViewById(R.id.listViewSiswa);


        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.addStudentDetail(etname.getText().toString());
                etname.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully !", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList = dbHelper.getAllStudentsList();
                tvnames.setText("");
                for (int i = 0; i < arrayList.size(); i++){
                    tvnames.setText(tvnames.getText().toString()+","+arrayList.get(i));
                }

                }

        });

    }
}