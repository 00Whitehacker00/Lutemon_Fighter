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

public class TrainRecyclerViewAdapter extends RecyclerView.Adapter<TrainRecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private final List<Lutemon> lutemons;

    public TrainRecyclerViewAdapter(Context context, List<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.train_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        // Set the lutemon's name and image in the item view
        holder.nameTextView.setText(lutemon.getName());
        holder.imageView.setImageResource(lutemon.getImage());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameTextView;
        public final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.train_item_name);
            imageView = view.findViewById(R.id.train_item_image);
        }
    }
}
