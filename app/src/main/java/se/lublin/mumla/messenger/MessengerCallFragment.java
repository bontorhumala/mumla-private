package se.lublin.mumla.messenger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import se.lublin.mumla.R;
import se.lublin.mumla.app.MumlaActivity;

public class MessengerCallFragment extends Fragment {
    private static final String TAG = MessengerCallFragment.class.getName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messenger_call, container, false);

        Button callButton = view.findViewById(R.id.buttonStartCall);
        EditText phoneNumberInput = view.findViewById(R.id.editTextPhoneNumber);

        callButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberInput.getText().toString();
            MumlaActivity activity = (MumlaActivity) getActivity();
            if (activity != null && !phoneNumber.isEmpty()) {
                // activity.startCall(phoneNumber);
                Log.d(TAG, "Call to: " + phoneNumber);
            }
        });

        return view;
    }
}
