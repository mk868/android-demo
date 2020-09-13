package info.kucharczyk.demo.android.hellosetupapp.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import info.kucharczyk.demo.android.hellosetupapp.R;

public class FirstSetupFileAccessFragment extends Fragment {
    private static final int BACK_STEP_ACTION = R.id.action_firstSetupFileAccessFragment_to_FirstSetupBluetoothFragment;
    private static final int NEXT_STEP_ACTION = R.id.action_firstSetupFileAccessFragment_to_firstSetupEndFragment;

    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 3;

    public FirstSetupFileAccessFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_step_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backClicked();
            }
        });

        view.findViewById(R.id.button_step_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClicked();
            }
        });

        view.findViewById(R.id.button_grant_access).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grantAccessClicked();
            }
        });

        updateNextButton();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_setup_file_access, container, false);
    }

    private void backClicked() {
        NavHostFragment.findNavController(this)
                .navigate(BACK_STEP_ACTION);
    }

    private void nextClicked() {
        NavHostFragment.findNavController(this)
                .navigate(NEXT_STEP_ACTION);
    }

    private void grantAccessClicked() {
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORAGE);
    }

    private void updateNextButton() {
        final View view = this.getView();
        boolean granted = true;

        if (ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            granted = false;
        }

        view.findViewById(R.id.button_step_next).setEnabled(granted);
        view.findViewById(R.id.button_grant_access).setEnabled(!granted);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
            updateNextButton();
        }
    }
}