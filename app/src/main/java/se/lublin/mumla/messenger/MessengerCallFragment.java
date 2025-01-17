package se.lublin.mumla.messenger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import se.lublin.mumla.R;

public class MessengerCallFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messenger_call, container, false);

        // Setup input nomor dan tombol panggilan
        EditText etPhoneNumber = view.findViewById(R.id.etPhoneNumber);
        Button btnMakeCall = view.findViewById(R.id.btnMakeCall);

        btnMakeCall.setOnClickListener(v -> {
            String phoneNumber = etPhoneNumber.getText().toString();
            if (!phoneNumber.isEmpty()) {
                Toast.makeText(requireContext(), "Calling " + phoneNumber, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
