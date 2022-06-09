package cat.dam.codrin.examenuf1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Credits extends AppCompatActivity {

    TextView PuntsTotals;

    TextView btn_sortir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        PuntsTotals = (TextView) findViewById(R.id.PuntsTotals);
        btn_sortir = (Button) findViewById(R.id.btn_sortir);

        String puntsMain = Integer.toString(MainActivity.puntsUsuari);

        PuntsTotals.setText(puntsMain);

        btn_sortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}