package br.edu.fateczl.decompor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private EditText etNumero;
    private TextView tvRes;

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

        etNumero = findViewById(R.id.etNumero);
        tvRes = findViewById(R.id.tvRes);

        Button btnDecompor = findViewById(R.id.btnDecompor);
        btnDecompor.setOnClickListener(op -> decompor());
    }


    private void decompor() {
        int numero = Integer.parseInt(etNumero.getText().toString());

        if (numero < 100 || numero > 999) {
            tvRes.setText("Número inválido. Por favor, insira um número entre 100 e 999.");
        } else {
            int centena = numero / 100;
            int dezena = (numero / 10) % 10;
            int unidade = numero % 10;

            tvRes.setText("CENTENA = " + centena + "\nDEZENA = " + dezena + "\nUNIDADE = " + unidade );
        }
    }
}