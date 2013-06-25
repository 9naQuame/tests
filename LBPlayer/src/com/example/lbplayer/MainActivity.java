package com.example.lbplayer;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity {
	TabHost tHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_bar);
        
        tHost = (TabHost) findViewById(android.R.id.tabhost);
        tHost.setup();
        
        /** Defining Tab Change Listener event. This is invoked when tab is changed */
        TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				FragmentManager fm =   getSupportFragmentManager();
				PlayerFragment player = (PlayerFragment) fm.findFragmentByTag("player");
				SongFragment songs = (SongFragment) fm.findFragmentByTag("songs");
				SettingFragment settings = (SettingFragment) fm.findFragmentByTag("setting");
				
				FragmentTransaction ft = fm.beginTransaction();
				
				/** Detaches the player fragment if exists */
				if(player!=null) ft.detach(player);
				
				/** Detaches the songs fragment if exists */
				if(songs!=null) ft.detach(songs);
				
				/** Detaches the settings fragment if exists */
				if(settings!=null) ft.detach(settings);
				
				/** If current tab is Player */
				if(tabId.equalsIgnoreCase("player")){
					
					if(player==null){		
						/** Create player and adding to fragmenttransaction */
						ft.add(R.id.realtabcontent,new PlayerFragment(), "player");						
					}
					
					else{
						/** Bring to the front, if already exists in the fragmenttransaction */
						ft.attach(player);						
					}
					
				}
				else if(tabId.equalsIgnoreCase("songs")){	/** If current tab is Songs */
					
					if(songs==null){		
						/** Create player and adding to fragmenttransaction */
						ft.add(R.id.realtabcontent,new SongFragment(), "songs");						
					}
					
					else{
						/** Bring to the front, if already exists in the fragmenttransaction */
						ft.attach(songs);						
					}
				}
				else{	/** If current tab is Settings */
					if(settings==null){
						/** Create settings and adding to fragmenttransaction */
						ft.add(R.id.realtabcontent,new SettingFragment(), "setting");						
					}else{
						/** Bring to the front, if already exists in the fragmenttransaction */
						ft.attach(settings);						
					}
				}
				ft.commit();				
			}
		};
		
		
		/** Setting tabchangelistener for the tab */
		tHost.setOnTabChangedListener(tabChangeListener);
                
		/** Defining tab builder for Player tab */
        TabHost.TabSpec tSpecPlayer = tHost.newTabSpec("player");
        tSpecPlayer.setIndicator("Player",getResources().getDrawable(R.drawable.android));        
        tSpecPlayer.setContent(new TabContent(getBaseContext()));
        tHost.addTab(tSpecPlayer);
        
        /** Defining tab builder for Songs tab */
        TabHost.TabSpec tSpecSong = tHost.newTabSpec("songs");
        tSpecSong.setIndicator("Songs",getResources().getDrawable(R.drawable.apple));        
        tSpecSong.setContent(new TabContent(getBaseContext()));
        tHost.addTab(tSpecSong);
        
        /** Defining tab builder for Settings tab */
        TabHost.TabSpec tSpecSetting = tHost.newTabSpec("setting");
        tSpecSetting.setIndicator("Settings",getResources().getDrawable(R.drawable.apple));        
        tSpecSetting.setContent(new TabContent(getBaseContext()));
        tHost.addTab(tSpecSetting);
        
     }   
 	
}

