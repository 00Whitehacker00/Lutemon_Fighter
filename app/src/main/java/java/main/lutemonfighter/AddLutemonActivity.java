package java.main.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        inputName = findViewById(R.id.textInputName);
    }

    public void addLutemon(View view) {

        String name = inputName.getText().toString();
        String lutemonType = "";

        RadioGroup lutType = findViewById(R.id.rgLutemonType);
        switch (lutType.getCheckedRadioButtonId()) {
            case R.id.buttonWhite:
                lutemonType = "Valkoinen";
                break;

            case R.id.buttonGREEN:
                lutemonType = "Vihreä";
                break;

            case R.id.buttonPINK:
                lutemonType = "Pinkki";
                break;

            case R.id.buttonORANGE:
                lutemonType = "Oranssi";
                break;

            case R.id.buttonBLACK:
                lutemonType = "Musta";
                break;

        }

        Lutemon newLutemon = new Lutemon(name, lutemonType);
        LutemonStorage.getInstance().addLutemon(newLutemon);

        LutemonStorage.getInstance().saveLutemon(this);
        Toast.makeText(this, "Lutemon lisätty", Toast.LENGTH_SHORT).show();
    }
}