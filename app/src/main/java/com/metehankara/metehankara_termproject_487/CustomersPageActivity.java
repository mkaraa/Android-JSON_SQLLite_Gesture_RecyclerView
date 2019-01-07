package com.metehankara.metehankara_termproject_487;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class CustomersPageActivity extends AppCompatActivity {

    RecyclerView recylerContact;

    SQLiteDatabase db;
    List<Customers> data;
    DatabaseHelper dbHelper;
    EditText etKey;
    TextView name,age,pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_page);

        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dbHelper = new DatabaseHelper(this);

        name = findViewById(R.id.cardViewNameTxt);
        age = findViewById(R.id.cardViewAgeTxt);
        pro = findViewById(R.id.cardViewProfessionTxt);

        data = CustomerDB.getAllContact(dbHelper);

        recylerContact = findViewById(R.id.recylerContact);

        LinearLayoutManager layoutManaget = new LinearLayoutManager(this);
        recylerContact.setLayoutManager(layoutManaget);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, data);
        recylerContact.setAdapter(adapter);

    }

    public void onClick(View view){
        Intent intent = new Intent(CustomersPageActivity.this,WelcomePageActivity.class);
        startActivity(intent);
    }
}
