package com.avik.SearchAutoCompleteSuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.avik.SearchAutoCompleteSuggestion.utilities.SearchController;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] words = {"dogs", "dock", "dig", "dance", "docker", "don't", "dart", "dag"};

        EditText etInput = findViewById(R.id.etInput);
        TextView textView = findViewById(R.id.tvSuggestedWords);
        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<String> suggestedWords =
                        SearchController.getSuggestedWordsFromList(Arrays.asList(words),
                                charSequence.toString());
                StringBuilder sb = new StringBuilder();
                for(String word : suggestedWords){
                    sb.append(word);
                    sb.append(" ");
                }

                textView.setText(sb.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}