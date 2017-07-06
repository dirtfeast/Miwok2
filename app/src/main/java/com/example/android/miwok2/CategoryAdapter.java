package com.example.android.miwok2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

//  In order to populate pages in the ViewPager, we need an adapter
public class CategoryAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    // fm is the fragment manager that will keep each
    // fragment's state in the adapter across swipes
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
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

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_family);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    } // Close method getPageTitle()

} // Close class CategoryAdapter
