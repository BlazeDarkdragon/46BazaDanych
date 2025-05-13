package com.example.a46bazadanych;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Asystent asystent = new Asystent(this);
    Cursor k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tekst = findViewById(R.id.tekst1);


        dodajDane();

        k = asystent.wypiszCalosc();
        StringBuilder sb = new StringBuilder();
        while (k.moveToNext()) {
            int id = k.getInt(0);
            String imie = k.getString(1);
            String nazwisko = k.getString(2);
            String klasa = k.getString(3);
            int wiek = k.getInt(4);
            sb.append(id).append(". ").append(imie).append(" ").append(nazwisko)
                    .append(" ").append(klasa).append(" Wiek: ").append(wiek).append("\n");
        }
        k.close();

        tekst.setText(sb.toString());
    }

    public void dodajDane() {
        int ilosc2 = asystent.policz();
        if (ilosc2 == 0) {
            asystent.dodaj("Jan", "Kowalski", "1PT", 16);
            asystent.dodaj("Ewa", "Nowak", "2PT", 17);
            asystent.dodaj("Stanisław", "Malinowski", "3PT", 18);
        }
    }
}