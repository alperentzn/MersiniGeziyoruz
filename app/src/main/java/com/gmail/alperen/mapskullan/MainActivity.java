package com.gmail.alperen.mapskullan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {


    /**
     * Spinner içerisine koyacagımız elemanları tanımlıyoruz.
     */
    private String[] ılceler = {"AKDENİZ", "ANAMUR", "AYDINCIK", "BOZYAZI", "ÇAMLIYAYLA", "ERDEMLİ", "GÜLNAR", "MEZİTLİ", "MUT", "SİLİFKE", "TARSUS", "TOROSLAR", "YENİSEHİR"};

    /**
     * Spinner ve adapterini tanımlıyoruz.
     */
    private Spinner spinnerılceler;
    private ArrayAdapter<String> dataAdapterFolIlceler;
    Button btngezz;

    private GoogleApiClient client;

    @Override
    /**
     * Bu metod uygulama çalıştırıldıgında çalışacak olan metodtur.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /**
         * Xml kısmında tanımlanan spinner burda tanımladıklarımızla eşleştiriyoruz.
         */
        spinnerılceler = (Spinner) findViewById(R.id.ılceler);
        btngezz=(Button)findViewById(R.id.btngez);

        /**
         * Spinner için adapterli hazırlıyoruz
         * Listenecek verilerin görünümünü hazırlıyoruz.
         * hazırladıgımız adapteri Spinnera ekliyorz.
         */
        dataAdapterFolIlceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ılceler);
        dataAdapterFolIlceler.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerılceler.setAdapter(dataAdapterFolIlceler);

        /**
         * Listelerden bir eleman secildiginde yapılacakları tanımlıyoruz.
         */
        spinnerılceler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                /**
                 * Hangi ilçe seçilmişse o adaptere ekleniyor.
                 */
                if (parent.getSelectedItem().toString().equals(ılceler[0]))
                    dataAdapterFolIlceler=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,ılceler);
                dataAdapterFolIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerılceler.setAdapter(dataAdapterFolIlceler);

                btngezz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent yeni = new Intent(MainActivity.this,mapsactivty.class);
                        startActivity(yeni);

                    }


                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerılceler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { ///burada if else işlemleri yapılacak.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                /**
                 * Seçilen ilçeyi Ekranda gösteriyoruz.
                 */
                Toast.makeText(getBaseContext(),""+spinnerılceler.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}


