package csci.baseballapp;

import android.app.ListFragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class BoxFragment extends Fragment {
    Gameplay game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_box, container, false);
        Bundle args = getArguments();
        game = (Gameplay) args.getSerializable("gameBundleKey");

        MYSQLiteHelper db = new MYSQLiteHelper(this.getActivity());
        db.test();
        for(int i = 0; i < game.m_away.m_roster.size(); i++){
            db.createPlayerStats(game.m_away.m_roster.get(i));
        }
        for(int i = 0; i < game.m_home.m_roster.size(); i++){
            db.createPlayerStats(game.m_home.m_roster.get(i));
        }


        List<Player> homePlayers = db.getAllPlayersFromTeam(1);
        List<Player> visPlayers = db.getAllPlayersFromTeam(2);
        List<Player> homePitchers = db.getAllPitchersFromTeam(1);
        List<Player> visPitchers = db.getAllPitchersFromTeam(2);
        ArrayAdapter<Player> homeAdapter, visAdapter, homeAdapterPitch, visAdapterPitch;


        //List<Player> homePlayers = game.m_home.m_roster;
        //List<Player> visPlayers = game.m_away.m_roster;
        //ArrayAdapter<Player> homeAdapter, visAdapter;

        homeAdapter = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, homePlayers);
        visAdapter = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, visPlayers);
        homeAdapterPitch = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, homePitchers);
        visAdapterPitch = new ArrayAdapter<Player> (this.getActivity(), android.R.layout.simple_list_item_1, visPitchers);

        ListView visList = (ListView) rootView.findViewById(R.id.visTeamBox);
        visList.setAdapter(visAdapter);
        ListView homeList = (ListView) rootView.findViewById(R.id.homeTeamBox);
        homeList.setAdapter(homeAdapter);
        ListView visListPitch = (ListView) rootView.findViewById(R.id.visTeamPitchBox);
        visListPitch.setAdapter(visAdapterPitch);
        ListView homeListPitch = (ListView) rootView.findViewById(R.id.homeTeamPitchBox);
        homeListPitch.setAdapter(homeAdapterPitch);

        TextView homeName = (TextView) rootView.findViewById(R.id.homeTeamNameBox);
        homeName.setText(game.m_home.m_teamName);
        TextView visName = (TextView) rootView.findViewById(R.id.visTeamNameBox);
        visName.setText(game.m_away.m_teamName);
        TextView homeNamePitch = (TextView) rootView.findViewById(R.id.homeTeamNamePitchBox);
        homeNamePitch.setText(game.m_home.m_teamName);
        TextView visNamePitch = (TextView) rootView.findViewById(R.id.visTeamNamePitchBox);
        visNamePitch.setText(game.m_away.m_teamName);


        return rootView;
    }

}
