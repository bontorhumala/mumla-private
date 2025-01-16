package se.lublin.mumla.auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import se.lublin.mumla.R;
import se.lublin.mumla.app.MumlaActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Validasi dsb. ...

            // Anggap sukses login -> simpan status "sudah login"
            SharedPreferences prefs = getSharedPreferences("my_app_prefs", MODE_PRIVATE);
            prefs.edit()
                    .putString("HOTEL_USERNAME", username)   // username input user
                    .putString("HOTEL_PASSWORD", password)   // password input user
                    .apply();
            prefs.edit().putBoolean("IS_LOGGED_IN", true).apply();

            // Pindah ke MumlaActivity (MainActivity)
            Intent intent = new Intent(LoginActivity.this, MumlaActivity.class);
            startActivity(intent);

            finish(); // tutup LoginActivity supaya tidak bisa "Back" ke login
        });
    }
}
