package com.example.vignesh.node_optimizer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vignesh.node_optimizer.Others.register_class;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.vignesh.node_optimizer.Others.register_class;

public class Register_user extends AppCompatActivity {

    FirebaseAuth auth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        auth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }

    public void signup(View view) {
        EditText editText=findViewById(R.id.editText);
        EditText editText1=findViewById(R.id.editText3);
        EditText editText2=findViewById(R.id.editText2);
        EditText editText3=findViewById(R.id.editText4);
        EditText editText4=findViewById(R.id.editText5);

        String phone_no=editText.getText().toString();
        String email=editText1.getText().toString();
        String name=editText4.getText().toString();
        String password=editText2.getText().toString();
        String re_password=editText3.getText().toString();

        if(TextUtils.isEmpty(phone_no)||TextUtils.isEmpty(email)||TextUtils.isEmpty(password)||TextUtils.isEmpty(re_password)||TextUtils.isEmpty(name))
        {
            Toast.makeText(getApplicationContext(),"Please Enter all your credentials",Toast.LENGTH_SHORT).show();
        }
        else if(password.equals(re_password))
        {
            Toast.makeText(getApplicationContext(),"Password's doesnot match",Toast.LENGTH_SHORT).show();
        }
        else
        {
            final register_class register_class = new register_class(name,phone_no,email,password);
            auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                FirebaseUser firebaseUser=auth.getCurrentUser();
                                databaseReference.child(firebaseUser.getUid()).child("profile").setValue(register_class);
                                Toast.makeText(getApplicationContext(),"User registered successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
        }
    }

    public void go_to_login(View view) {
    }
}
