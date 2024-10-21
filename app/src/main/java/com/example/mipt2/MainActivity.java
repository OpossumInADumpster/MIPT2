package com.example.mipt2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    Button btnCount;
    TextView tvMain;

    Spinner spSelectOptions;


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
       // this.spSelectOptions = findViewById(R.id.spSelectOptions);

        this.spSelectOptions =  (Spinner) findViewById(R.id.spSelectOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.selection_options,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectOptions.setAdapter(adapter);
    }

    public void btnCountClick(View view) {
        if (this.spSelectOptions.getSelectedItem().equals("Symbols")) {
            int result = TextCounter.countSymbols(this.edUserInput.getText().toString());
            Log.i("CountResult", String.valueOf(result));
            this.tvMain.setText(String.valueOf(result));
        }
        else
        {
            Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT).show();
        }

    }
}