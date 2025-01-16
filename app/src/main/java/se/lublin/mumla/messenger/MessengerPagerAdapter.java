package se.lublin.mumla.messenger;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MessengerPagerAdapter extends FragmentPagerAdapter {

    public MessengerPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Tentukan fragment untuk setiap tab
        if (position == 0) {
            return new MessengerChatFragment();
        } else {
            return new MessengerCallFragment();
        }
    }

    @Override
    public int getCount() {
        return 2; // Dua tab: Chat dan Call
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Judul untuk setiap tab
        if (position == 0) {
            return "Chat";
        } else {
            return "Call";
        }
    }
}
