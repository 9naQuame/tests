package com.example.lbplayer;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;


public class SongFragment extends ListFragment{
	public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.lb_playlist, container, false);
        
        ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String, String>>();
        
        MusicManager player = new MusicManager();
        
        this.songsList = player.getPlayList();
        
        for (int i = 0; i < songsList.size(); i++) {
			HashMap<String, String> song = songsList.get(i);
			songsListData.add(song);
		}
        
        ListAdapter adapter = new SimpleAdapter(getActivity(), songsListData,
				R.layout.lb_playlist_item, new String[] { "songTitle" }, new int[] {
						R.id.songTitle });

		setListAdapter(adapter);
/*
		// selecting single ListView item
		ListView lv = getListView();
		// listening to single listitem click
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting listitem index
				int songIndex = position;
				
				// Starting new intent
				Intent in = new Intent(getActivity(),
						MainActivity.class);
				// Sending songIndex to PlayerActivity
				in.putExtra("songIndex", songIndex);
				setResult(100, in);
				// Closing PlayListView
				finish();
			}
		});*/
        
		return view;
	}
	
}