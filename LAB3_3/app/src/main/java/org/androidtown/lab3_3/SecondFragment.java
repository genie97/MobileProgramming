package org.androidtown.lab3_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //Replace second fragment in FrameLayout
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_second,container, false);
        return rootView;
    }
}