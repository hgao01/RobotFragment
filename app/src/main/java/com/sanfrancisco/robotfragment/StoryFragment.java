/*
 *
 */
package com.sanfrancisco.robotfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StoryFragment extends Fragment {

    final static String ARG_POSITION = "position";  //number of the position 0->

    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container1,
                             Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment = container1
        return inflater.inflate(R.layout.story_view, container1, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point, so we can safely call the method
        // below that sets the story text.
        Bundle state1 = getArguments();
        if (state1 != null) {              // a tory was already shown, somehow
            // Set article based on argument passed in
            updateStoryView(state1.getInt(ARG_POSITION));  // show it again
        } else if (mCurrentPosition != -1) {                // a row was selected newly
            // Set article based on saved instance state defined during onCreateView
            updateStoryView(mCurrentPosition);              // show selected row
        }
    }

    public void updateStoryView(int position) {
        TextView story1 = (TextView) getActivity().findViewById(R.id.story);
        story1.setText(Ipsum.Stories[position]);  //take in contents, in case it is changed
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle nowState1) {  //current, to be lost
        super.onSaveInstanceState(nowState1);
        // Save the current story selection in case we need to recreate this fragment instance
        nowState1.putInt(ARG_POSITION, mCurrentPosition);
    }
}