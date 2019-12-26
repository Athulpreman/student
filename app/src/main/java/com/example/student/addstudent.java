package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addstudent extends AppCompatActivity {
    EditText name, rollno, admission, college;
    Button button;
    String n, r, a, c;
    addst ad;
    ProgressBar pb;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);

        name = (EditText) findViewById(R.id.name);
        rollno = (EditText) findViewById(R.id.rollno);
        admission = (EditText) findViewById(R.id.admission);
        college = (EditText) findViewById(R.id.college);
        button = (Button)findViewById(R.id.submit);
        ad=new addst();
        pb=(ProgressBar)findViewById(R.id.pro);
        reference= FirebaseDatabase.getInstance().getReference().child("students");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setVisibility(View.VISIBLE);
                n=name.getText().toString();
                r=rollno.getText().toString();
                a=admission.getText().toString();
                c=college.getText().toString();

                ad.setN1(n);
                ad.setR1(r);
                ad.setA1(a);
                ad.setC1(c);

                reference.push().setValue(ad);

                Toast.makeText(getApplicationContext(), "success",Toast.LENGTH_LONG).show();

                pb.setVisibility(View.INVISIBLE);

                name.setText("");
                rollno.setText("");
                admission.setText("");
                college.setText("");
            }
        });

    }
}