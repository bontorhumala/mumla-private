package se.lublin.mumla.messenger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;
import se.lublin.mumla.R;

public class MessengerListFragment extends Fragment {
    private static final String TAG = MessengerListFragment.class.getName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messenger_list, container, false);

        // Kontak statis
        String[] contacts = {"Resepsionis", "Teknisi", "Restoran"};

        // Inisialisasi ListView
        ListView listView = view.findViewById(R.id.listViewContacts);

        // Gunakan ArrayAdapter untuk menampilkan kontak
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                contacts
        );
        listView.setAdapter(adapter);

        // Tangani klik pada item daftar
        listView.setOnItemClickListener((AdapterView<?> parent, View view1, int position, long id) -> {
            String selectedContact = contacts[position];
            Toast.makeText(requireContext(), "Selected: " + selectedContact, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
