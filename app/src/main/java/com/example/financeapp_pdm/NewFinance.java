package com.example.financeapp_pdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.financeapp_pdm.SQLite.DAOFinance;
import com.example.financeapp_pdm.SQLite.Finance;

public class NewFinance extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button btn_save;
    TextView etxt_name;
    TextView etxt_price;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_finance);
//        Spinner spinner = (Spinner) findViewById(R.id.sp_type);
        Spinner spinner = findViewById(R.id.sp_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener(this);

        btn_save = findViewById(R.id.btn_save);
        etxt_name = findViewById(R.id.etxt_name);
        etxt_price = findViewById(R.id.etxt_price);
        this.activity = this;
        this.btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float price = Float.parseFloat(etxt_price.getText().toString());
                String choice = spinner.getSelectedItem().toString();
                Finance finance = new Finance(price, etxt_name.getText().toString(), choice);
                DAOFinance.insertFinance(activity, finance);
                String msg = "Salvo com Sucesso";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fg_bottonNavNew, new BottonNavFragment());
        ft.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
//        String choice = parent.getItemAtPosition(pos).toString();
//        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

}