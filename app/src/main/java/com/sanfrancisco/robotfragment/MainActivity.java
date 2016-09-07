/*
 *
 */
package com.sanfrancisco.robotfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


public class MainActivity extends FragmentActivity 
        implements MainMenuFragment.OnMainMenuSelectedListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_posts);

        //setActionBar(  findViewById(R.id.toolbar));

        // whether the activity is using the layout version with fragment_container FrameLayout
        // If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {     //is showing a story
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return
            // or else we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            MainMenuFragment firstFragment1 = new MainMenuFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment1.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment1).commit();
        }
    }




    public void fragmentTransactionMgr(int position) {
        // The user selected the headline of an article from the MainMenuFragment
        // Capture the article fragment from the activity layout
        StoryFragment storyFrag1 = (StoryFragment)
                getSupportFragmentManager().findFragmentById(R.id.story_fragment);

        if ( storyFrag1 != null) {
            // If article frag is available, we're in two-pane layout...
            // Call a method in the ArticleFragment to update its content
            storyFrag1.updateStoryView(position);
        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...
            // Create fragment and give it an argument for the selected article
            StoryFragment newStoryPage1 = new StoryFragment();
            Bundle args1 = new Bundle();
            args1.putInt( StoryFragment.ARG_POSITION, position);
            newStoryPage1.setArguments(args1);   //take in contents

            FragmentTransaction ftransaction1 = getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back to parent
            ftransaction1.replace(R.id.fragment_container, newStoryPage1 );
            ftransaction1.addToBackStack(null);
            ftransaction1.commit();        //change to another fragment
        }
    }
}