package com.example.progect7_2.UI_Layer.View;

import android.content.pm.PackageManager;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.progect7_2.Data.repository.Repository;
import com.example.progect7_2.R;
import com.example.progect7_2.UI_Layer.viewmodel.ItemsViewModel;
import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment {
    private ItemsViewModel viewModel;
    private final int PERMISSION_REQUEST_CODE = 80;
    private FragmentTransaction transaction;
    private ImageView animAndroid;

    public Fragment1() {
        // Required empty public constructor
    }@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(requireContext());
        Transition exitTransition = inflater.inflateTransition(R.transition.fade);
        setExitTransition(exitTransition);

        Transition enterTransition = inflater.inflateTransition(R.transition.slide_right);
        setEnterTransition(enterTransition);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_1, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        animAndroid = getActivity().findViewById(R.id.androidanim);
        Drawable drawable = animAndroid.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }

        Button button = getActivity().findViewById(R.id.button);
        Bundle bundle =  new Bundle();

        EditText editText = getActivity().findViewById(R.id.editText);

        // 3) SharedPreferencesDS
        TextView itemName = view.findViewById(R.id.textViewfr1);
        ImageView imageView = view.findViewById(R.id.imageViewfr1);

        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemsViewModel.class);

        viewModel.createLocalds(this.getContext());
        viewModel.setLocalName("temnozvezdnik");
        viewModel.setLocalImg(R.drawable.temnozvezdnik);

        viewModel.getLiveData().observe(getViewLifecycleOwner(), item -> {
            if (item != null ) {
                itemName.setText(item.getLocalName());
                imageView.setImageResource(item.getLocalImg());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("MyArg","Привет, "+String.valueOf(editText.getText()));
                navController.navigate(R.id.fragment2, bundle);}
        });

    }








    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fragmententer);
            anim.setDuration(500);
            return anim;
        } else {
            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fragmentexit);
            anim.setDuration(500);
            return anim;
        }
    }


}