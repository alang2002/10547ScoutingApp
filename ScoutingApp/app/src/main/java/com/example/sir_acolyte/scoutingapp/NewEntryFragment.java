package com.example.sir_acolyte.scoutingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class NewEntryFragment extends Fragment {
    //Essential
    EditText teamName;
    EditText teamNumber;
    EditText gameNumber;
    CheckBox red;
    CheckBox blue;
    //Autonomous
    Switch   landed;
    Switch   claimedDepot;
    Switch   parked;
    Switch   sampling;
    //TeleOp
    TextView mineralDepot;
    TextView mineralLander;
    Button   depotMinus;
    Button   depotPlus;
    Button   landerMinus;
    Button   landerPlus;
    //End Game
    Switch   hangedFromLander;
    CheckBox parkedPartial;
    CheckBox parkedFull;
    TextView total;
    Button   submit;
    //Misc
    int depotValue;
    int landerValue;
    int totalValue;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_add_new_entry, container, false);

        //Setup view elements
        depotValue = 0;
        landerValue = 0;
        totalValue = 0;
        teamName = (EditText) rootView.findViewById(R.id.newentry_editText_team_name);
        teamNumber = (EditText) rootView.findViewById(R.id.newentry_editText_team_number);
        gameNumber = (EditText) rootView.findViewById(R.id.editentry_editText_gamenumber);
        red = (CheckBox) rootView.findViewById(R.id.newentry_red_checkbox);
        blue = (CheckBox) rootView.findViewById(R.id.newentry_blue_checkbox);
        landed = (Switch) rootView.findViewById(R.id.newentry_landed_switch);
        claimedDepot = (Switch) rootView.findViewById(R.id.newentry_depot_switch);
        parked = (Switch) rootView.findViewById(R.id.newentry_parked_switch);
        sampling = (Switch) rootView.findViewById(R.id.newentry_sampling_switch);
        mineralDepot = (TextView) rootView.findViewById(R.id.newentry_depot_value);
        mineralLander = (TextView) rootView.findViewById(R.id.newentry_lander_value);
        depotMinus = (Button) rootView.findViewById(R.id.newentry_depot_minus_button);
        depotPlus = (Button) rootView.findViewById(R.id.newentry_depot_plus_button);
        landerMinus = (Button) rootView.findViewById(R.id.newentry_minus_lander_button);
        landerPlus = (Button) rootView.findViewById(R.id.newentry_plus_lander_button);
        hangedFromLander = (Switch) rootView.findViewById(R.id.newentry_hanged_switch);
        parkedPartial = (CheckBox) rootView.findViewById(R.id.newentry_partial_checkbox);
        parkedFull = (CheckBox) rootView.findViewById(R.id.newentry_full_checkbox);
        total = (TextView) rootView.findViewById(R.id.newentry_total_score);
        submit = (Button) rootView.findViewById(R.id.newentry_submit_button);

        //Setup button handling
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEntry();
            }
        });
        depotMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depotValue = depotValue - 2;
                totalValue = totalValue - 2;
                mineralDepot.setText(Integer.toString(depotValue));
                total.setText(Integer.toString(totalValue));
            }
        });
        depotPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depotValue = depotValue + 2;
                totalValue = totalValue + 2;
                mineralDepot.setText(Integer.toString(depotValue));
                total.setText(Integer.toString(totalValue));
            }
        });
        landerMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                landerValue = landerValue - 5;
                totalValue = totalValue - 5;
                mineralLander.setText(Integer.toString(landerValue));
                total.setText(Integer.toString(totalValue));
            }
        });
        landerPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                landerValue = landerValue + 5;
                totalValue = totalValue + 5;
                mineralLander.setText(Integer.toString(landerValue));
                total.setText(Integer.toString(totalValue));
            }
        });
        return rootView;
    }

    public void addEntry() {

    }
}