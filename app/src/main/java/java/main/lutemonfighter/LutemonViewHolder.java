package java.main.lutemonfighter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    TextView lutemonName;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        lutemonName = itemView.findViewById(R.id.fullName);

    }
}