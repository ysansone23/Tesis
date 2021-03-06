package com.uade.tesis.evaluator.students;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.uade.tesis.R;
import com.uade.tesis.evaluator.AnswersActivity;
import com.uade.tesis.evaluator.ResponseActivity;
import com.uade.tesis.evaluator.utils.BaseButtonsAdapter;
import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity implements BaseButtonsAdapter.ButtonClickListener {

    private static final String TITLE = "title";

    public static Intent getIntent(@NonNull final Context context, @Nullable final String title) {
        final Intent intent = new Intent(context, StudentsActivity.class);
        intent.putExtra(TITLE, title);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_list);
        findViewById(R.id.buttons_list_fab).setVisibility(View.GONE);

        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getIntent().getStringExtra(TITLE));
        }

        final Button exam = (Button) findViewById(R.id.exam);
        exam.setText(getIntent().getStringExtra(TITLE));
        exam.setVisibility(View.VISIBLE);
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent intent = ResponseActivity.getIntent(StudentsActivity.this, String.valueOf(exam.getText()),
                    "https://docs.google.com/forms/d/1MKp9fYsNm6gHR8owgf20pOtyCdAxnQ1F04yjTWA6Vh8/edit?uiv=0", false);
                startActivity(intent);
            }
        });

        final View viewById = findViewById(R.id.action_divider);
        viewById.setVisibility(View.VISIBLE);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.buttons_list);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final List<String> students = new ArrayList<>();
        students.add("Juan Martin Alonso");
        students.add("Lucas Gonzales");
        students.add("Martina Blanco");
        students.add("Leonardo Fuentes");
        students.add("Florencia Martinez");

        final List<Button> buttons = new ArrayList<>();
        Button button;
        for (int i = 0; i < students.size(); i++) {

            button = new Button(this);
            button.setText(students.get(i));
            button.setVisibility(View.INVISIBLE);
            buttons.add(button);
        }
        recyclerView.setAdapter(new BaseButtonsAdapter(buttons, this));
    }

    @Override
    public void onButtonClick(final String title) {
        final Intent intent = AnswersActivity.getIntent(this, title);
        startActivity(intent);
    }
}
