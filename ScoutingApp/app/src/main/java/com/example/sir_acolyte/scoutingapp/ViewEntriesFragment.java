package com.example.sir_acolyte.scoutingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewEntriesFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_view_entries, container, false);
        DBAdapter db = new DBAdapter(getContext());

        ExpandableListView entriesListView = (ExpandableListView) rootView.findViewById(R.id.viewentries_expandableListView);
        entriesListView.setAdapter(new OurExpandableAdapterEntries(getContext()));

        if (db.getEntriesCount() == 0) {
            return rootView;
        }

        return rootView;
    }

    class OurExpandableAdapterEntries extends BaseExpandableListAdapter {
        private Context senderContext;
        DBAdapter db = new DBAdapter(getContext());
        private ArrayList<EntryInfo> groups = new ArrayList<>();

        public OurExpandableAdapterEntries(Context context) {
            senderContext = context;
            groups.addAll(db.getAllEntries());
        }

        @Override
        public int getGroupCount() {
            return groups.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups.get(groupPosition).getTeamName() + " - Game " + groups.get(groupPosition).getGameNumber();
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return groups.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) senderContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
            }

            TextView view = (TextView) convertView.findViewById(android.R.id.text1);
            view.setText((String) getGroup(groupPosition));

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) senderContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_entries, null);
            }

            EntryInfo info = (EntryInfo) getChild(groupPosition, childPosition);

            ((TextView) convertView.findViewById(R.id.viewentries_teamname)).setText(info.getTeamName());
            ((TextView) convertView.findViewById(R.id.viewentries_teamnumber)).setText(String.valueOf(info.getTeamNumber()));
            ((TextView) convertView.findViewById(R.id.viewentries_gamenumber)).setText(String.valueOf(info.getGameNumber()));
            ((TextView) convertView.findViewById(R.id.viewentries_alliancecolor)).setText(info.getAllianceColor());
            ((TextView) convertView.findViewById(R.id.viewentries_landed)).setText(info.getLandedString());
            ((TextView) convertView.findViewById(R.id.viewentries_claimed)).setText(info.getClaimedString());
            ((TextView) convertView.findViewById(R.id.viewentries_parked_auto)).setText(info.getParkedAutoString());
            ((TextView) convertView.findViewById(R.id.viewentries_sampling)).setText(info.getSampledString());
            ((TextView) convertView.findViewById(R.id.viewentries_minerals_depot)).setText(String.valueOf(info.getMineralDepot()));
            ((TextView) convertView.findViewById(R.id.viewentries_minerals_lander)).setText(String.valueOf(info.getMineralLander()));
            ((TextView) convertView.findViewById(R.id.viewentries_hanged)).setText(info.getHangedString());
            ((TextView) convertView.findViewById(R.id.viewentries_parked_partial)).setText(info.getParkedPartialString());
            ((TextView) convertView.findViewById(R.id.viewentries_parked_full)).setText(info.getParkedFullString());
            ((TextView) convertView.findViewById(R.id.viewentries_total)).setText(String.valueOf(info.getTotalScore()));

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
}
