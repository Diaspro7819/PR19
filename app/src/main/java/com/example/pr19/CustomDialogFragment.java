package com.example.pr19;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;

public class CustomDialogFragment extends DialogFragment {
    private Remove removable;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        removable = (Remove) context;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String phone = getArguments().getString("phone");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Диалоговое окно")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Вы хотите удалить " + phone + "?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removable.remove(phone);
                    }
                })
                .setNegativeButton("Отмена", null)
                .create();
    }
}
