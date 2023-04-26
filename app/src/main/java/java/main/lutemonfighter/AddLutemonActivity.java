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

        Lutemon newLutemon = null;
        switch (lutType.getCheckedRadioButtonId()) {
            case R.id.buttonWhite:
                newLutemon = new White(name);
                lutemonType = "Valkoinen";
                break;

            case R.id.buttonGREEN:
                newLutemon = new Green(name);
                lutemonType = "Vihreä";
                break;

            case R.id.buttonPINK:
                newLutemon = new Pink(name);
                lutemonType = "Pinkki";
                break;

            case R.id.buttonORANGE:
                newLutemon = new Orange(name);
                lutemonType = "Oranssi";
                break;

            case R.id.buttonBLACK:
                newLutemon = new Black(name);
                lutemonType = "Musta";
                break;
        }

        LutemonStorage.getInstance().addLutemon(newLutemon);

        LutemonStorage.getInstance().saveLutemon(this);
        Toast.makeText(this, "Lutemon lisätty", Toast.LENGTH_SHORT).show();
    }
}