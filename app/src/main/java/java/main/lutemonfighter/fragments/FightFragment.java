package java.main.lutemonfighter.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.main.lutemonfighter.Lutemon;
import java.main.lutemonfighter.LutemonStorage;
import java.main.lutemonfighter.R;

import java.util.List;

public class FightFragment extends Fragment {

    private TextView fightLogTextView;
    private Button startFightButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fight, container, false);

        fightLogTextView = view.findViewById(R.id.textViewFightLog);
        startFightButton = view.findViewById(R.id.buttonStartFight);

        startFightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFight();
            }
        });

        return view;
    }

    private void startFight() {
        final List<Lutemon> fightingLutemons = LutemonStorage.getInstance().getFightingLutemons();
        final StringBuilder fightLog = new StringBuilder();

        final int maxRounds = 10;

        HandlerThread handlerThread = new HandlerThread("FightThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());

        Runnable fightRunnable = new Runnable() {
            @Override
            public void run() {
                for (int currentRound = 1; currentRound <= maxRounds; currentRound++) {
                    if (fightingLutemons.size() >= 2) {
                        Lutemon lutemon1 = fightingLutemons.get(0);
                        Lutemon lutemon2 = fightingLutemons.get(1);

                        // Update lutemon stats before the fight logic
                        int experienceGained = 2;
                        lutemon1.setExperience(lutemon1.getExperience() + experienceGained);
                        int attackGained = lutemon1.getExperience() / 2;
                        lutemon1.setAttack(lutemon1.getAttack() + attackGained);

                        fightLog.append(currentRound).append(": ").append(lutemon1.getName()).append("(").append(lutemon1.getLutemonType()).append(")")
                                .append(" att: ").append(lutemon1.getAttack()).append("; def: ").append(lutemon1.getDefend())
                                .append("; exp: ").append(lutemon1.getExperience()).append("; health: ").append(lutemon1.getHealth())
                                .append("/").append(lutemon1.getMaxHealth()).append("\n");

                        fightLog.append(currentRound).append(": ").append(lutemon2.getName()).append("(").append(lutemon2.getLutemonType()).append(")")
                                .append(" att: ").append(lutemon2.getAttack()).append("; def: ").append(lutemon2.getDefend())
                                .append("; exp: ").append(lutemon2.getExperience()).append("; health: ").append(lutemon2.getHealth())
                                .append("/").append(lutemon2.getMaxHealth()).append("\n");

                        boolean lutemon1Defends = lutemon2.defense(lutemon1.getAttack());

                        if (lutemon1Defends) {
                            fightLog.append(lutemon2.getName()).append("(").append(lutemon2.getLutemonType()).append(") managed to avoid death.").append("\n");
                        } else {
                            fightLog.append(lutemon2.getName()).append("(").append(lutemon2.getLutemonType()).append(") died.").append("\n");
                            fightingLutemons.remove(lutemon2);
                        }

                        Lutemon temp = lutemon1;
                        lutemon1 = lutemon2;
                        lutemon2 = temp;
                    } else {
                        break;
                    }
                }

                // Update the TextView on the main (UI) thread
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fightLog.append("The battle is over.").append("\n");
                        fightLogTextView.setText(fightLog.toString());
                    }
                });
            }
        };

        // Start the fight on the background thread
        handler.post(fightRunnable);
    }
}