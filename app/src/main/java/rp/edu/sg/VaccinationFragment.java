package rp.edu.sg;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VaccinationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VaccinationFragment extends Fragment {

    TextView tvVacc;
    Button btnVaccEdit;
    FloatingActionButton btnVaccSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);
        tvVacc = view.findViewById(R.id.tvVaccination);
        btnVaccEdit = view.findViewById(R.id.btnFragVaccinationEdit);
        btnVaccSearch = view.findViewById(R.id.btnV);

        btnVaccEdit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Edit Vacc");
            builder.setView(inflater.inflate(R.layout.dialog_edit, null))
                    .setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) (dialog, which) -> {
                        Dialog d = (Dialog) dialog;
                        EditText etDialog = d.findViewById(R.id.etDialog);
                        tvVacc.setText(etDialog.getText().toString());
                        dialog.dismiss();
                    }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) (dialog, which) -> {
                        Log.d("dialog", "onClick: cancel");
                        dialog.cancel();
                    });
            builder.create().show();
        });
        return view;
    }
}