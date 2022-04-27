package com.se.setools.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

/**
 * A class is the BaseFragment that serves as the base template for fragment.
 *
 * @author Nam Seonwoo
 * @version 1.0.0 22/04/27
 * @param <VB> View Binding
 */
public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {
    /**
     * Tag for fragment
     */
    public final String TAG = getClass().getSimpleName();

    /**
     * View Binding
     *
     * @see #setViewBinding()
     * @see #initViewBinding()
     */
    private VB binding;

    /**
     * Set View Binding
     *
     * @return View Binding
     * @since 1.0.0
     */
    protected abstract VB setViewBinding();

    /**
     * Initialize View Binding
     *
     * @since 1.0.0
     */
    public void initViewBinding() {
        binding = setViewBinding();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.initViewBinding();
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        initAfterViewBinding();
    }

    /**
     * Perform tasks to run after onStart() (or ViewBinding)
     * @since 1.0.0
     */
    protected abstract void initAfterViewBinding();

    /**
     * Show the message with Toast
     *
     * @param message Message you want to display
     * @since 1.0.0
     */
    public void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
