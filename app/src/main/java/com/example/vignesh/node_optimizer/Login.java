package com.example.vignesh.node_optimizer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();
    }

    public void do_login(View v)
    {
        EditText editText=findViewById(R.id.editText);
        EditText editText1=findViewById(R.id.editText2);

        String email=editText.getText().toString();
        String password=editText1.getText().toString();

        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password))
        {
            Toast.makeText(getApplicationContext(),"Enter your credentials",Toast.LENGTH_SHORT).show();
        }
        else
        {
            auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"do_login successful",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void go_to_signup(View view) {
        Intent intent=new Intent(getApplicationContext(),Register_user.class);
        startActivity(intent);
        finish();
    }
}
