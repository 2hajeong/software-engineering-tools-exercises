package com.se.setools.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.se.setools.R;

/**
 * A class is the BaseActivity that serves as the base template for activity.
 *
 * @author Nam Seonwoo
 * @version 1.0.0 22/04/27
 * @param <VB> View Binding
 */
public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {
    /**
     * Tag for each activity
     */
    public final String TAG = getClass().getSimpleName();

    /**
     * View Binding
     *
     * @see #setViewBinding()
     * @see #initViewBinding()
     */
    public VB binding;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initViewBinding();
        setContentView(binding.getRoot());
        initAfterBinding();
    }

    /**
     * Perform tasks to run after onCreate() (or ViewBinding)
     *
     * @since 1.0.0
     */
    protected abstract void initAfterBinding();

    /**
     * Show the message with Toast
     *
     * @param message Message you want to display
     * @since 1.0.0
     */
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Start new activity
     *
     * @param className Activity you want to change (or start)
     * @since 1.0.0
     */
    public void startNextActivity(Class<?> className) {
        Intent intent = new Intent(this, className);
        startActivity(intent);
    }

    /**
     * Start new activitiy and delete all records associated activity stack
     *
     * @param className Activity you want to change (or start)
     * @since 1.0.0
     */
    public void startNextActivityWithClear(Class<?> className) {
        Intent intent = new Intent(this, className);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /**
     * Replace the fragment in main fraime on MainActivity
     *
     * @param fragment Fragment you want to replace
     * @since 1.0.0
     */
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame_layout, fragment)
                .commitAllowingStateLoss();
    }
}
