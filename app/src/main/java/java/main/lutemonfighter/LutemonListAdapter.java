package java.main.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons;

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        sortLutemons();
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        //holder.lutemonName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getLutemonType() + ")");
        holder.lutemonName.setText(LutemonStorage.getInstance().getLutemonWithoutRemove(position).getName() + " (" + lutemons.get(position).getLutemonType() + ")");
        holder.lutemonAttack.setText("Hyökkäys: " + LutemonStorage.getInstance().getLutemonWithoutRemove(position).getAttack());
        holder.lutemonDefend.setText("Puolustus: " + LutemonStorage.getInstance().getLutemonWithoutRemove(position).getDefend());
        holder.lutemonHealth.setText("Elämä: " + LutemonStorage.getInstance().getLutemonWithoutRemove(position).getHealth() + "/" + LutemonStorage.getInstance().getLutemonWithoutRemove(position).getMaxHealth());
        holder.lutemonXP.setText("Kokemus: " + LutemonStorage.getInstance().getLutemonWithoutRemove(position).getExperience());

        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());

        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    LutemonStorage.getInstance().removeLutemon(pos);
                    notifyItemRemoved(pos);
                }
            }
        });

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if (pos != RecyclerView.NO_POSITION) {  // tarkistaa onko alkio vielä olemassa
                    if(holder.lutemonName.getVisibility() == View.VISIBLE) {
                        holder.editName.setText(holder.lutemonName.getText());  // editointikentässä sama asia kuin nimessä
                        holder.lutemonName.setVisibility(View.GONE);
                        holder.editName.setVisibility(View.VISIBLE); // nimi piiloon edittext näkyviin

                    }
                    else {
                        Lutemon lutemon = LutemonStorage.getInstance().getLutemonWithoutRemove(pos); // hakee oikea alkio listasta
                        lutemon.setName(holder.editName.getText().toString());  // asettaa muokkaus nimen päälle / vaihtaa nimen arvo
                        notifyItemChanged(pos);
                    }
                }

            }

        });

    }

    @Override
    public int getItemCount() {
        return LutemonStorage.getInstance().getItemCount();
    }

    private void sortLutemons() {
        Collections.sort(lutemons, new Comparator<Lutemon>() {
            @Override
            public int compare(Lutemon oldLutemon, Lutemon newLutemon) {
                return oldLutemon.getName().compareTo(newLutemon.getName());
            }
        });
    }
}
