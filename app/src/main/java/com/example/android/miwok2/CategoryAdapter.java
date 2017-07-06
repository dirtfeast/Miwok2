package com.example.android.miwok2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

//  In order to populate pages in the ViewPager, we need an adapter
public class CategoryAdapter extends FragmentPagerAdapter {

    // fm is the fragment manager that will keep each
    // fragment's state in the adapter across swipes
    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    } // Close constructor CategoryAdapter()

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new ColorsFragment();
            case 2:
                return new FamilyMembersFragment();
            case 3:
                return new PhrasesFragment();
            default:
                return null;
        } // Close switch
    } // Close method getItem()

    @Override
    public int getCount() {
        return 4;
    } // Close method getCount()

} // Close class CategoryAdapter
