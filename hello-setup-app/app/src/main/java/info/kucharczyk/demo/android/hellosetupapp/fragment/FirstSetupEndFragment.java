package info.kucharczyk.demo.android.hellosetupapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import info.kucharczyk.demo.android.hellosetupapp.MainActivity;
import info.kucharczyk.demo.android.hellosetupapp.R;

public class FirstSetupEndFragment extends Fragment {
    private static final int BACK_STEP_ACTION = R.id.action_firstSetupEndFragment_to_firstSetupFileAccessFragment;

    public FirstSetupEndFragment() {
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

        view.findViewById(R.id.button_step_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishClicked();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_setup_end, container, false);
    }

    private void backClicked() {
        NavHostFragment.findNavController(FirstSetupEndFragment.this)
                .navigate(BACK_STEP_ACTION);
    }

    private void finishClicked() {
        Intent intent = new Intent(this.getContext(), MainActivity.class);
        startActivity(intent);
        this.getActivity().finish();
    }
}