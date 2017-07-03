package com.example.android.miwok2;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyMembersFragment extends Fragment {

    // Object to handle playback of mp3 files
    private MediaPlayer mMediaPlayer;

    // Object to invoke audio focus gain and release
    private AudioManager mAudioManager;

    // Object to track audio focus changes
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } // Close if
        } // Close method override onAudioFocusChange()
    }; // Close method AudioManager.OnAudioFocusChangeListener()

    // Listener object triggered upon completion of MediaPlayer mp3 file
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer)
        // mp3 playback finished, release the media player resources, abandon audio focus
        {releaseMediaPlayer();} // Close method override onCompletion()
    }; // Close method  MediaPlayer.OnCompletionListener()

    public FamilyMembersFragment() {
        // Required empty public constructor
    } // Close method FamilyMembersFragment()

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate view from the XML layout resource ID, return that view
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Request Audio Focus and register OnAudioFocusChangeListener
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // ArrayList of miwokWords objects
        // Define English and Miwok words
        final ArrayList<com.example.android.miwok2.Word> miwokWords = new ArrayList<com.example.android.miwok2.Word>();
        miwokWords.add(new com.example.android.miwok2.Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        miwokWords.add(new com.example.android.miwok2.Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        miwokWords.add(new com.example.android.miwok2.Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        miwokWords.add(new com.example.android.miwok2.Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        miwokWords.add(new com.example.android.miwok2.Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        miwokWords.add(new com.example.android.miwok2.Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        miwokWords.add(new com.example.android.miwok2.Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        miwokWords.add(new com.example.android.miwok2.Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        miwokWords.add(new com.example.android.miwok2.Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        miwokWords.add(new com.example.android.miwok2.Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        // Custom WordAdapter class overrides ArrayAdapter
        // Pass context and object
        WordAdapter adapter = new WordAdapter(getActivity(), miwokWords, R.color.category_family);

        // Find the ListView object in the view hierarchy of the Activity
        // There should be a {@link ListView} with the view ID called list,
        // which is declared in the word_list.xml file
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the ListView use the WordAdapter we created above, so that the
        // ListView will display list items for each Word object in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // Implements interface, so I have to define the method
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // Get the {@link Word} object at the given position the user clicked on
                Word word = miwokWords.get(position);

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                // if audio focus granted
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // MediaPlayer to play MP3 file onItemClick
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getmRawResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                } // Close if

            } // Close override method onItemClick()

        }); // Close method call listView.setOnClickListener()

        return rootView;
    } // Close method onCreateView()

    // Clean up the media player
    // Release resources, set to null, abandon audio focus
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        } // Close if
    } // Close method releaseMediaPlayer()

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    } // Close override method onStop()

} // Close class FamilyMembersFragment
