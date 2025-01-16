package se.lublin.mumla.messenger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import se.lublin.mumla.R;
import se.lublin.mumla.app.MumlaActivity;

public class MessengerChatFragment extends Fragment {
    private static final String TAG = MessengerChatFragment.class.getName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messenger_chat, container, false);

        EditText messageInput = view.findViewById(R.id.editTextMessage);
        Button sendButton = view.findViewById(R.id.buttonSendMessage);

        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString();
            MumlaActivity activity = (MumlaActivity) getActivity();
            if (activity != null && !message.isEmpty()) {
                // activity.sendMessage(message);
                Log.d(TAG, "Send message: " + message);
            }
        });

        return view;
    }
}
