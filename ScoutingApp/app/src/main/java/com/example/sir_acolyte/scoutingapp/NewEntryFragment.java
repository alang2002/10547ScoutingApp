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
    EditText teamName;
    EditText teamNumber;
    EditText gameNumber;
    CheckBox red;
    CheckBox blue;
    Switch   landed;
    Switch   claimedDepot;
    Switch   parked;
    Switch   sampling;
    TextView mineralDepot;
    TextView mineralLander;
    Button   depotMinus;
    Button   depotPlus;
    Button   landerMinus;
    Button   landerPlus;
    Switch   hangedFromLander;
    CheckBox parkedPartial;
    CheckBox parkedFull;
    Button   submit;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_add_new_entry, container, false);

        //Setup view elements
        teamName = (EditText) rootView.findViewById(R.id.newentry_editText_team_name);
        teamNumber = (EditText) rootView.findViewById(R.id.newentry_editText_team_number);
        gameNumber = (EditText) rootView.findViewById(R.id.editentry_editText_gamenumber);
        red = (CheckBox) rootView.findViewById(R.id.newentry_red_checkbox);
        blue = (CheckBox) rootView.findViewById(R.id.newentry_blue_checkbox);
        landed = (Switch) rootView.findViewById(R.id.newentry_landed_switch);
        claimedDepot = (Switch) rootView.findViewById(R.id.newentry_depot_switch);


        return rootView;
    }
}