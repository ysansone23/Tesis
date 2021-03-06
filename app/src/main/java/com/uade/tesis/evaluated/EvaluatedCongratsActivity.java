package com.uade.tesis.evaluated;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.uade.tesis.R;
import com.uade.tesis.commons.MainActivity;

public class EvaluatedCongratsActivity extends AppCompatActivity {

    private static final String TITLE = "title";
    private static final String SUBTITLE = "subtitle";

    public static Intent getIntent(final Context context, final String title, final String subtitle) {
        final Intent intent = new Intent(context, EvaluatedCongratsActivity.class);
        intent.putExtra(TITLE, title);
        intent.putExtra(SUBTITLE, subtitle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_congrats);
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(null);
        }

        initView();
    }

    private void initView() {
        final ImageView image = (ImageView) findViewById(R.id.evaluated_congrats_image);
        final TextView title = (TextView) findViewById(R.id.evaluated_congrats_title);
        final TextView subtitle = (TextView) findViewById(R.id.evaluated_congrats_subtitle);
        final Button action = (Button) findViewById(R.id.evaluated_congrats_action);

        final Drawable drawable = getResources().getDrawable(R.drawable.ilus_congrats, getTheme());
        image.setImageDrawable(drawable);
        title.setText(getIntent().getStringExtra(TITLE));
        subtitle.setText(getIntent().getStringExtra(SUBTITLE));
        action.setText("Aceptar");
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent intent = new Intent(EvaluatedCongratsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
