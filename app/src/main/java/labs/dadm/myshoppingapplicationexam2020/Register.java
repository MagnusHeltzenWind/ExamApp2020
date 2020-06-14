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

public class Register extends AppCompatActivity {

    //Create variables
    EditText registerName, registerEmail, registerPassword;
    Button register;
    ProgressBar registerProgressBar;
    private FirebaseAuth registerFAuth; //Used to register user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize variables
        registerName = findViewById(R.id.editTxtRegisterName);
        registerEmail = findViewById(R.id.editTxtRegisterEmail);
        registerPassword = findViewById(R.id.editTxtRegisterPassword);
        register = findViewById(R.id.btnRegister);
        registerProgressBar = findViewById(R.id.registerProgressBar);
        registerFAuth = FirebaseAuth.getInstance();

        //Validates entered registering-info
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sRegisterEmail = registerEmail.getText().toString().trim();
                String sRegisterPassword = registerPassword.getText().toString().trim();

                if (TextUtils.isEmpty(sRegisterEmail)) {
                    registerEmail.setError("Please enter an email");
                    return;
                }

                if (TextUtils.isEmpty(sRegisterPassword)) {
                    registerPassword.setError("Please enter a password");
                    return;
                }

                //Controls more than six characters for security purpose
                if (sRegisterPassword.length() < 6) {
                    registerPassword.setError("The password must contain at least six characters");
                    return;
                }

                registerProgressBar.setVisibility(View.VISIBLE);

                //Register the user in firebase
                registerFAuth.createUserWithEmailAndPassword(sRegisterEmail,sRegisterPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "User created successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Navigation.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error - " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            registerProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}