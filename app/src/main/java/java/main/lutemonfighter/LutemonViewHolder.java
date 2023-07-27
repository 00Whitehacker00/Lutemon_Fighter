package java.main.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    TextView lutemonName;
    TextView lutemonAttack;
    TextView lutemonDefend;
    TextView lutemonHealth;
    TextView lutemonXP;
    ImageView lutemonImage;
    CheckBox lutemonCheckbox;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        lutemonName = itemView.findViewById(R.id.train_item_name);
        lutemonAttack = itemView.findViewById(R.id.attack);
        lutemonDefend = itemView.findViewById(R.id.defend);
        lutemonHealth = itemView.findViewById(R.id.health);
        lutemonXP = itemView.findViewById(R.id.xp);
        lutemonImage = itemView.findViewById(R.id.train_item_image);
        lutemonCheckbox = itemView.findViewById(R.id.checkBox);
    }
}
