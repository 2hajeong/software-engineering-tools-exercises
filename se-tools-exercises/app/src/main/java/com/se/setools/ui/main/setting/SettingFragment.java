package com.se.setools.ui.main.setting;

import androidx.fragment.app.Fragment;

import com.se.setools.base.BaseFragment;
import com.se.setools.databinding.FragmentSettingBinding;

/**
 * Setting Fragment
 * A simple {@link Fragment} subclass
 *
 * @version JDK 11.0.11
 */
public class SettingFragment extends BaseFragment<FragmentSettingBinding> {

    /**
     * Pass binding result to base fragments
     *
     * @return View Binding
     */
    @Override
    protected FragmentSettingBinding setViewBinding() {
        return FragmentSettingBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initAfterViewBinding() {
    }
}
