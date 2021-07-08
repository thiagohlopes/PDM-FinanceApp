package com.example.financeapp_pdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.financeapp_pdm.RecyclerView.FinanceAdapter;
import com.example.financeapp_pdm.SQLite.DAOFinance;
import com.example.financeapp_pdm.SQLite.Finance;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_finance;
    private FinanceAdapter financeAdapter;
    private ArrayList<Finance> finances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rv_finance = findViewById(R.id.rv_finance);
        finances= DAOFinance.getAllPizzas(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rv_finance.setLayoutManager(layoutManager);
        this.rv_finance.setHasFixedSize(true);
        this.financeAdapter = new FinanceAdapter(finances, this);
        this.rv_finance.setAdapter(this.financeAdapter);

    }
}