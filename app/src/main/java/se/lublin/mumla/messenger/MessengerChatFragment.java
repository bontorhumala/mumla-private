package se.lublin.mumla.messenger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import se.lublin.mumla.R;

public class MessengerChatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messenger_chat, container, false);

        // Setup daftar kontak
        ListView listViewContacts = view.findViewById(R.id.listViewContacts);
        String[] contacts = {"Resepsionis", "Teknisi", "Restoran"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                contacts
        );
        listViewContacts.setAdapter(adapter);

        // Setup chat box
        TextView tvChatConversation = view.findViewById(R.id.tvChatConversation);
        EditText editTextMessage = view.findViewById(R.id.editTextMessage);
        Button btnSendMessage = view.findViewById(R.id.btnSendMessage);

        btnSendMessage.setOnClickListener(v -> {
            String message = editTextMessage.getText().toString();
            if (!message.isEmpty()) {
                String currentText = tvChatConversation.getText().toString();
                tvChatConversation.setText(currentText + "\nYou: " + message);
                editTextMessage.setText("");
            }
        });

        return view;
    }
}
