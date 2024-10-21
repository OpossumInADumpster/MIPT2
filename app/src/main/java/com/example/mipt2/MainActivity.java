package com.example.mipt2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    Button btnCount;
    TextView tvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.edUserInput = findViewById(R.id.edUserInput);
        this.btnCount = findViewById(R.id.btnCount);
        this.tvMain = findViewById(R.id.tvMain);
    }

    public void btnCountClick(View view) {
        int result = TextCounter.countSymbols(this.edUserInput.getText().toString());
        Log.i("CountResult", String.valueOf(result));
                this.tvMain.setText(String.valueOf(result));
    }
}