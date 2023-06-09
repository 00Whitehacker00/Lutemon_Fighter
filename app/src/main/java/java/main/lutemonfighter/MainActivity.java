package java.main.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        LutemonStorage.getInstance().loadLutemon(context);
        Toast.makeText(context, context.getFilesDir().toString(), Toast.LENGTH_LONG).show();

        Button buttonMoveLutemons = findViewById(R.id.buttonMoveLutemons);
        buttonMoveLutemons.setOnClickListener(listener);
    }

    public void buttonAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void buttonListLutemons(View view) {
        Intent intent = new Intent(this, ListLutemonActivity.class);
        startActivity(intent);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            switch (view.getId()) {
                case R.id.buttonMoveLutemons:
                    Intent intent = new Intent(view.getContext(), TabActivity.class);
                    startActivity(intent);
                    return;
            }
            LutemonLocation location = LutemonLocation.HOME;

        }
    };
}

/*
Tiedosto : data/data/java.main.lutemonfighter/files/lutemons.data
 */