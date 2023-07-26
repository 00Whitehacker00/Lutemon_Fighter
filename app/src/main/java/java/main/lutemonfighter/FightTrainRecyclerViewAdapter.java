package java.main.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FightTrainRecyclerViewAdapter extends RecyclerView.Adapter<FightTrainRecyclerViewAdapter.ViewHolder> {

    private List<Lutemon> lutemons;
    private Context context;

    public FightTrainRecyclerViewAdapter(Context context, List<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
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
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView lutemonImage;
        public TextView itemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lutemonImage = itemView.findViewById(R.id.profilePic);
            itemName = itemView.findViewById(R.id.itemName);
        }
    }
}
