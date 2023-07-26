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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.itemName.setText(lutemon.getName());
        holder.lutemonImage.setImageResource(lutemon.getImage());
        holder.checkBox.setChecked(false);
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
            lutemonImage = itemView.findViewById(R.id.profilePic);
            itemName = itemView.findViewById(R.id.itemName);
            checkBox = itemView.findViewById(R.id.checkBox);


        }
    }

            // Toast.makeText(this, "Lutemon lisätty treeniareenalle", Toast.LENGTH_SHORT).show();
}

