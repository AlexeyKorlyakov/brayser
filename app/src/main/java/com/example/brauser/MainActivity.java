package com.example.brauser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.WebView);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl("https://www.google.com");
        web.setWebViewClient(new WebViewClient());
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v -> {
            EditText searchEditText = findViewById(R.id.searchEditText);
            String searchText = searchEditText.getText().toString();
            web.findAllAsync(searchText);
        });
        web.setFindListener((activeMatchOrdinal, numberOfMatches,
                             isDoneCounting) -> {
            if (numberOfMatches > 0) {
                web.findNext(true);
            } else {
                Toast.makeText(MainActivity.this, "Ничего не найдено",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }}

