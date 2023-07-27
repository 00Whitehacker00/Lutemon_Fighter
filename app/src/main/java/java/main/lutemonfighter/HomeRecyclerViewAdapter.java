package java.main.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Lutemon> lutemons;
    private Context context;
    private ArrayList<Integer> selectedLutemons;

    public HomeRecyclerViewAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        sortHomeLutemons();
        selectedLutemons = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_view_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.itemName.setText(lutemon.getName());
        holder.lutemonImage.setImageResource(lutemon.getImage());

        // Set the checkbox state based on whether this lutemon is selected or not
        holder.checkBox.setChecked(selectedLutemons.contains(position));

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int adapterPosition = holder.getAdapterPosition();
                if (isChecked) {
                    // Add this lutemon to the selected list
                    selectedLutemons.add(adapterPosition);
                } else {
                    // Remove this lutemon from the selected list
                    selectedLutemons.remove(Integer.valueOf(adapterPosition));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    private void sortHomeLutemons() {
        Collections.sort(lutemons, new Comparator<Lutemon>() {
            @Override
            public int compare(Lutemon oldLutemon, Lutemon newLutemon) {
                return oldLutemon.getName().compareTo(newLutemon.getName());
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView lutemonImage;
        public TextView itemName;
        public CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lutemonImage = itemView.findViewById(R.id.train_item_image);
            itemName = itemView.findViewById(R.id.train_item_name);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }

    public ArrayList<Lutemon> getSelectedLutemons() {
        ArrayList<Lutemon> selected = new ArrayList<>();
        for (int i = 0; i < selectedLutemons.size(); i++) {
            selected.add(lutemons.get(selectedLutemons.get(i)));
        }
        return selected;
    }
}



