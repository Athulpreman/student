package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class viewstudent extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    String admino,nam,rolln,colleg;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstudent);

        e1=(EditText)findViewById(R.id.enter);
        e2=(EditText)findViewById(R.id.name1);
        e3=(EditText)findViewById(R.id.rollno1);
        e4=(EditText)findViewById(R.id.college1);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("students");

        b1=(Button)findViewById(R.id.search);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                admino=e1.getText().toString();

                Query query=databaseReference.orderByChild("a1").equalTo(admino);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot studentDatasnapshot : dataSnapshot.getChildren())
                        {
                            addst ob=studentDatasnapshot.getValue(addst.class);
                            String sname=ob.n1;
                            String sroll=ob.r1;
                            String sclg=ob.c1;

                            e2.setText(sname);
                            e3.setText(sroll);
                            e4.setText(sclg);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
