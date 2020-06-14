package labs.dadm.myshoppingapplicationexam2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    //Create variables
    EditText loginEmail, loginPassword;
    Button login;
    ProgressBar loginProgressBar;
    private FirebaseAuth loginFAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize variables
        loginEmail = findViewById(R.id.editTxtLoginEmail);
        loginPassword = findViewById(R.id.editTxtLoginPassword);
        login = findViewById(R.id.btnLogin);
        loginProgressBar = findViewById(R.id.loginProgressBar);
        loginFAuth = FirebaseAuth.getInstance();

        //Validates entered login-info
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sLoginEmail = loginEmail.getText().toString().trim();
                String sLoginPassword = loginPassword.getText().toString().trim();

                if(TextUtils.isEmpty(sLoginEmail)) {
                    loginEmail.setError("Please enter your email");
                    return;
                }

                if(TextUtils.isEmpty(sLoginPassword)) {
                    loginPassword.setError("Please enter your password");
                    return;
                }

                //Show progressbar while performing login
                loginProgressBar.setVisibility(View.VISIBLE);

                //Control if entered login-info is already stored in firebase
                loginFAuth.signInWithEmailAndPassword(sLoginEmail, sLoginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Login.this, "You are logged in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Navigation.class));
                        }
                        else {
                            Toast.makeText(Login.this, "Error - " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            loginProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}