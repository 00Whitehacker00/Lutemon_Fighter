package java.main.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText inputName;
/* test 123 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        inputName = findViewById(R.id.textInputName);
    }

    public void addLutemon(View view) {

        String name = inputName.getText().toString();

        RadioGroup lutType = findViewById(R.id.rgLutemonType);

        Lutemon newLutemon = null;
        switch (lutType.getCheckedRadioButtonId()) {
            case R.id.buttonWhite:
                newLutemon = new White(name);
                break;

            case R.id.buttonGREEN:
                newLutemon = new Green(name);
                break;

            case R.id.buttonPINK:
                newLutemon = new Pink(name);
                break;

            case R.id.buttonORANGE:
                newLutemon = new Orange(name);
                break;

            case R.id.buttonBLACK:
                newLutemon = new Black(name);
                break;
        }

        LutemonStorage.getInstance().addLutemon(newLutemon);

        LutemonStorage.getInstance().saveLutemon(this);
        Toast.makeText(this, "Lutemon lisätty", Toast.LENGTH_SHORT).show();
    }
}