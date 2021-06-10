package com.example.parkingsystemjava.mvp.view.base;

import android.content.Context;
import androidx.annotation.Nullable;
import android.app.Fragment;
import java.lang.ref.WeakReference;

public class FragmentView {
    private final WeakReference<Fragment> fragmentRef;

    public FragmentView(Fragment fragment) {
        fragmentRef = new WeakReference<>(fragment);
    }

    @Nullable
    public Fragment getFragment() {
        return fragmentRef.get();
    }

    @Nullable
    public Context getContext() {
        return getFragment().getContext();
    }
}

