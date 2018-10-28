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
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class NewEntryFragment extends Fragment {
    DBAdapter db;
    //Essential
    EditText teamNameEditText;
    EditText teamNumberEditText;
    EditText gameNumberEditText;
    RadioButton redAllianceRadioButton;
    RadioButton blueAllianceRadioButton;
    //Autonomous
    Switch   landedSwitch;
    Switch   claimedDepotSwitch;
    Switch   parkedSwitch;
    Switch   samplingSwitch;
    //TeleOp
    TextView mineralDepot;
    TextView mineralLander;
    Button   depotMinus;
    Button   depotPlus;
    Button   landerMinus;
    Button   landerPlus;
    //End Game
    Switch   hangedFromLanderSwitch;
    RadioButton parkedPartialRadioButton;
    RadioButton parkedFullRadioButton;
    TextView total;
    Button   submit;
    //Misc
    int depotValue;
    int landerValue;
    int totalValue;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_add_new_entry, container, false);
        db = new DBAdapter(getContext());

        //Setup view elements
        depotValue = 0;
        landerValue = 0;
        totalValue = 0;
        teamNameEditText = (EditText) rootView.findViewById(R.id.newentry_editText_team_name);
        teamNumberEditText = (EditText) rootView.findViewById(R.id.newentry_editText_team_number);
        gameNumberEditText = (EditText) rootView.findViewById(R.id.newentry_editText_gamenumber);
        redAllianceRadioButton = (RadioButton) rootView.findViewById(R.id.newentry_red_radiobutton);
        blueAllianceRadioButton = (RadioButton) rootView.findViewById(R.id.newentry_blue_radiobutton);
        landedSwitch = (Switch) rootView.findViewById(R.id.newentry_landed_switch);
        claimedDepotSwitch = (Switch) rootView.findViewById(R.id.newentry_depot_switch);
        parkedSwitch = (Switch) rootView.findViewById(R.id.newentry_parked_switch);
        samplingSwitch = (Switch) rootView.findViewById(R.id.newentry_sampling_switch);
        mineralDepot = (TextView) rootView.findViewById(R.id.newentry_depot_value);
        mineralLander = (TextView) rootView.findViewById(R.id.newentry_lander_value);
        depotMinus = (Button) rootView.findViewById(R.id.newentry_depot_minus_button);
        depotPlus = (Button) rootView.findViewById(R.id.newentry_depot_plus_button);
        landerMinus = (Button) rootView.findViewById(R.id.newentry_minus_lander_button);
        landerPlus = (Button) rootView.findViewById(R.id.newentry_plus_lander_button);
        hangedFromLanderSwitch = (Switch) rootView.findViewById(R.id.newentry_hanged_switch);
        parkedPartialRadioButton = (RadioButton) rootView.findViewById(R.id.newentry_partial_radiobutton);
        parkedFullRadioButton = (RadioButton) rootView.findViewById(R.id.newentry_full_radiobutton);
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
        String teamName = teamNameEditText.getText().toString();
        int teamNumber = Integer.parseInt(teamNumberEditText.getText().toString());
        int gameNumber = Integer.parseInt(gameNumberEditText.getText().toString());
        String allianceColor;
        if (redAllianceRadioButton.isChecked()) {
            allianceColor = "Red";
        }
        else if (blueAllianceRadioButton.isChecked()) {
            allianceColor = "Blue";
        }
        else {
            allianceColor = "No color chosen";
        }
        int total = totalValue;
        boolean landed = landedSwitch.isChecked();
        boolean claimedDepot = claimedDepotSwitch.isChecked();
        boolean parkedAuto = parkedSwitch.isChecked();
        boolean sampling = samplingSwitch.isChecked();
        int mineralDepot = depotValue;
        int mineralLander = landerValue;
        boolean hangedFromLander = hangedFromLanderSwitch.isChecked();
        boolean parkedPartial = parkedPartialRadioButton.isChecked();
        boolean parkedFull = parkedFullRadioButton.isChecked();
        int id;
        if (db.getEntriesCount() == 0) {
            id = 0;
        }
        else {
            id = db.getEntriesCount() + 1;
        }

        EntryInfo entry = new EntryInfo(id, teamName, teamNumber, gameNumber, allianceColor,
                total, landed, claimedDepot, parkedAuto, sampling, mineralDepot, mineralLander,
                hangedFromLander, parkedPartial, parkedFull);
        db.addEntry(entry);
        Toast.makeText(getContext(), "Adding entry to database...", Toast.LENGTH_LONG).show();
        clearElements();
    }

    public void clearElements() {
        depotValue = 0;
        landerValue = 0;
        totalValue = 0;
        teamNameEditText.setText("");
        teamNumberEditText.setText("");
        gameNumberEditText.setText("");
        blueAllianceRadioButton.setChecked(false);
        redAllianceRadioButton.setChecked(false);
        landedSwitch.setChecked(false);
        claimedDepotSwitch.setChecked(false);
        parkedSwitch.setChecked(false);
        samplingSwitch.setChecked(false);
        mineralDepot.setText("");
        mineralLander.setText("");
        hangedFromLanderSwitch.setChecked(false);
        parkedPartialRadioButton.setChecked(false);
        parkedFullRadioButton.setChecked(false);
        total.setText("");
    }
}