package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tablayout.Fragments.Call;
import com.example.tablayout.Fragments.Home;
import com.example.tablayout.Fragments.Message;

public class ViewAdpter extends FragmentStateAdapter {
    public ViewAdpter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new Message();
            case 2:
                return new Call();
            default:
                return new Home();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
