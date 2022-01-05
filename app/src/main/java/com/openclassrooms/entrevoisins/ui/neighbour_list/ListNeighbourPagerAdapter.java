package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        //return NeighbourFragment.newInstance();
         if(position== 0){
             return new NeighbourFragment();
         }
        if(position== 1){
            return new NeighbourFragmentFavoris();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 2;
    }}
