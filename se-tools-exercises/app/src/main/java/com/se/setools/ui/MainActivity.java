package com.se.setools.ui;

import android.annotation.SuppressLint;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.se.setools.R;
import com.se.setools.base.BaseActivity;
import com.se.setools.databinding.ActivityMainBinding;
import com.se.setools.ui.main.bookmark.BookmarkFragment;
import com.se.setools.ui.main.history.HistoryFragment;
import com.se.setools.ui.main.home.HomeFragment;
import com.se.setools.ui.main.setting.SettingFragment;

/**
 * Main Activity
 *
 * @version JDK 11.0.11
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static Fragment homeFragment, bookmarkFragment, historyFragment, settingFragment;

    /**
     * Pass binding result to base activity
     * @return for View Binding
     */
    @Override
    protected ActivityMainBinding setViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    /**
     * Create each fragment objects
     * @param
     */
    @Override
    protected void initAfterBinding() {
        // fragment
        homeFragment = new HomeFragment();
        bookmarkFragment = new BookmarkFragment();
        historyFragment = new HistoryFragment();
        settingFragment = new SettingFragment();

        // initial setting (with HomeFragment)
        replaceFragment(homeFragment);

//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.main_frame_layout, homeFragment)
//                .commitAllowingStateLoss();   // or HomeFragment.newInstance()

        initBottomNavigationView();
    }

    /**
     * When click an icon, get ID and replace the corresponding fragment
     *
     */
    private void initBottomNavigationView() {
        binding.mainBnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.main_bnv_home:
                        replaceFragment(homeFragment);
                        return true;
                    case R.id.main_bnv_bookmark:
                        replaceFragment(bookmarkFragment);
                        return true;
                    case R.id.main_bnv_history:
                        replaceFragment(historyFragment);
                        return true;
                    case R.id.main_bnv_setting:
                        replaceFragment(settingFragment);
                        return true;
                }
                return false;
            }
        });
    }
}