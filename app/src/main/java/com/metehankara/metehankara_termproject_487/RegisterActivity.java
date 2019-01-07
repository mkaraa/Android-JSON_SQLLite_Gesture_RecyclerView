package com.metehankara.metehankara_termproject_487;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    Intent intent;
    Bundle b;
    EditText name,surname,email,password,confirmPassword,age,city,profession;
    TextView warningMsg ;
    Spinner spinner;
    Button createUserBtn;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DatabaseHelper(this);


        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        createUserBtn = findViewById(R.id.createUserBtn);

        name = findViewById(R.id.nameET);
        surname = findViewById(R.id.surnameET);
        email = findViewById(R.id.emailET);
        password = findViewById(R.id.passwordET);
        confirmPassword = findViewById(R.id.confirmPasswordET);
        age = findViewById(R.id.ageET);
        city = findViewById(R.id.cityET);
        profession = findViewById(R.id.professionET);
        warningMsg = findViewById(R.id.warningTxt);
    }

    public void onClickDatabase(View view) {
        boolean res=false;
            String etName = name.getText().toString();
            String etSurname = surname.getText().toString();
            String etEmail = email.getText().toString();
            String etPass = password.getText().toString();
            String etConPass = confirmPassword.getText().toString();
            String etAge = age.getText().toString();
            String etCity = city.getText().toString();
            String etProfesion = profession.getText().toString();

        if(etName.equals(" ") && etSurname.equals(" ") && etEmail.equals(" ") &&etPass.equals(" ") &&etConPass.equals(" ") &&etAge.equals(" ") && etCity.equals(" ") && etProfesion.equals(" ")) {
            warningMsg.setText("Please Fill All Blanks !");
        }
        else if(etPass.equals(etConPass)){
            long result =  CustomerDB.insertContact(dbHelper, etName,etSurname, etEmail,etPass,etConPass,etAge,etCity,etProfesion);
            warningMsg.setText(etName + " is added.");
        }
        else{
            warningMsg.setText("Passwords are not the same.");
        }

    }
    public void onClickWelcomePage(View view){
        intent = new Intent(RegisterActivity.this,WelcomePageActivity.class);
        startActivity(intent);
    }
}
