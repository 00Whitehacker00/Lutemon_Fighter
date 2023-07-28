package java.main.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private List<Lutemon> lutemons;
    private Context context;

    public HomeRecyclerViewAdapter(Context context, List<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        sortHomeLutemons();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_view_fragment, parent, false);
        return new ViewHolder(view, lutemons); // Pass the lutemons list to the ViewHolder constructor
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Check for null Lutemon object before accessing its properties
        Lutemon lutemon = lutemons.get(position);
        if (lutemon != null) {
            holder.itemName.setText(lutemon.getName());
            holder.lutemonImage.setImageResource(lutemon.getImage());

            // Set the CheckBox state based on the isSelected field
            holder.setChecked(lutemon.isSelected());
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    private void sortHomeLutemons() {
        Collections.sort(lutemons, new Comparator<Lutemon>() {
            @Override
            public int compare(Lutemon oldLutemon, Lutemon newLutemon) {
                if (oldLutemon == null && newLutemon == null) {
                    return 0; // Both are null, so consider them equal
                } else if (oldLutemon == null) {
                    return 1; // Null is considered greater than non-null
                } else if (newLutemon == null) {
                    return -1; // Non-null is considered greater than null
                } else {
                    return oldLutemon.getName().compareTo(newLutemon.getName());
                }
            }
        });
    }

    public void moveToTraining(List<Lutemon> selectedLutemons) {
        for (Lutemon lutemon : selectedLutemons) {
            lutemon.setIsInTraining(true);
            lutemons.remove(lutemon);
            LutemonStorage.getInstance().addTrainingLutemon(lutemon);
        }
        notifyDataSetChanged();
    }

    public void moveToFighting(List<Lutemon> selectedLutemons) {
        for (Lutemon lutemon : selectedLutemons) {
            lutemon.setIsInTraining(false);
            lutemons.remove(lutemon);
            LutemonStorage.getInstance().addFightingLutemon(lutemon);
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView lutemonImage;
        public TextView itemName;
        public CheckBox checkBox;
        private List<Lutemon> lutemons; // Add this member variable

        public ViewHolder(@NonNull View itemView, List<Lutemon> lutemons) {
            super(itemView);
            this.lutemons = lutemons; // Initialize the member variable
            lutemonImage = itemView.findViewById(R.id.profilePic);
            itemName = itemView.findViewById(R.id.itemName);
            checkBox = itemView.findViewById(R.id.checkBox);

            // Set an OnCheckedChangeListener for the CheckBox
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // Check for null Lutemon object before accessing its properties
                    Lutemon lutemon = lutemons.get(getAdapterPosition());
                    if (lutemon != null) {
                        lutemon.setSelected(isChecked);
                    }
                }
            });
        }

        // Method to set the checked state of the CheckBox
        public void setChecked(boolean isChecked) {
            checkBox.setChecked(isChecked);
        }
    }
}
