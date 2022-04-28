package com.se.setools.ui.main.home;

import androidx.fragment.app.Fragment;

import com.se.setools.base.BaseFragment;
import com.se.setools.databinding.FragmentHomeBinding;

/**
 * Home Fragment
 * A simple {@link Fragment} subclass
 *
 * @version JDK 11.0.11
 */

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

//    public static Fragment newInstance() {
//        return new HomeFragment();
//    }

    /**
     * Pass binding result to base fragments
     *
     * @return View Binding
     */
    @Override
    protected FragmentHomeBinding setViewBinding() {
        return FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initAfterViewBinding() {
    }
}
