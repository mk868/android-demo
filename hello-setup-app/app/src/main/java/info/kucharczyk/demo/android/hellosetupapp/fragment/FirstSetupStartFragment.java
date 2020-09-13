package info.kucharczyk.demo.android.hellosetupapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import info.kucharczyk.demo.android.hellosetupapp.R;

public class FirstSetupStartFragment extends Fragment {
    private static final int NEXT_STEP_ACTION = R.id.action_FirstSetupStartFragment_to_FirstSetupBluetoothFragment;

    public FirstSetupStartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_step_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitClicked();
            }
        });

        view.findViewById(R.id.button_step_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextClicked();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_setup_start, container, false);
    }

    private void exitClicked() {
        this.getActivity().finishAndRemoveTask();
    }

    private void nextClicked() {
        NavHostFragment.findNavController(FirstSetupStartFragment.this)
                .navigate(NEXT_STEP_ACTION);
    }
}