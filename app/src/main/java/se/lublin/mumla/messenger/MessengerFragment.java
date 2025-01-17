package se.lublin.mumla.messenger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import se.lublin.mumla.R;
import se.lublin.mumla.channel.ChannelListFragment;
import se.lublin.mumla.channel.ChatTargetProvider;

public class MessengerFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener, ChatTargetProvider {
    private static final String TAG = MessengerFragment.class.getName();

    private ChatTarget mChatTarget;
    /** Chat target listeners, notified when the chat target is changed. */
    private List<OnChatTargetSelectedListener> mChatTargetListeners = new ArrayList<OnChatTargetSelectedListener>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messenger, container, false);

        // Tambahkan ChannelListFragment ke container kiri
        ChannelListFragment listFragment = new ChannelListFragment();
        Bundle listArgs = new Bundle();
        listArgs.putBoolean("pinned", false);
        listFragment.setArguments(listArgs);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.channelListContainer, listFragment)
                .commit();

        // Setup ViewPager
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        MessengerPagerAdapter adapter = new MessengerPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        return view;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Log.d(TAG, "Preference changed: " + key);
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        preferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public ChatTarget getChatTarget() {
        return mChatTarget;
    }

    @Override
    public void setChatTarget(ChatTarget target) {
        mChatTarget = target;
        for(OnChatTargetSelectedListener listener : mChatTargetListeners)
            listener.onChatTargetSelected(target);
    }

    @Override
    public void registerChatTargetListener(OnChatTargetSelectedListener listener) {
        mChatTargetListeners.add(listener);
    }

    @Override
    public void unregisterChatTargetListener(OnChatTargetSelectedListener listener) {
        mChatTargetListeners.remove(listener);
    }
}
