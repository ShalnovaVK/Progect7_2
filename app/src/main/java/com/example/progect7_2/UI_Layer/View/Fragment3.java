package com.example.progect7_2.UI_Layer.View;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.Data.repository.Repository;
import com.example.progect7_2.R;
import com.example.progect7_2.UI_Layer.viewmodel.ItemsViewModel;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.example.progect7_2.UI_Layer.viewmodel.ItemDetailViewModel;

public class Fragment3 extends Fragment {
    private ItemsViewModel viewModel;


    public Fragment3() {
        // Required empty public constructor
    }


    @Override
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
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        TextView textView = getActivity().findViewById(R.id.textView3);


        Intent intent = getActivity().getIntent();

        // Проверяем, содержит ли intent текстовые данные
        if (intent != null && Intent.ACTION_SEND.equals(intent.getAction()) && intent.getType() != null) {
            if ("text/plain".equals(intent.getType())) {
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedText != null) {
                    // Обработка полученного текста (например, отображение на экране)

                    textView.setText(sharedText);
                }
            }
        }


        TextView textView3 = getActivity().findViewById(R.id.textViewfr3);
        ImageView imageView3 = getActivity().findViewById(R.id.imageViewfr3);
        Map<String, Integer> map = new HashMap<>();
        map.put("Хорошего дня!", R.drawable.mika);
        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemsViewModel.class);
        viewModel.createList(this.getContext(), map);
        viewModel.getLiveData().observe(getViewLifecycleOwner(), item -> {
            if (item != null ) {
                List<Cathegory> list= item.getAllCategories();
                for(Cathegory s : list){
                    if (s.img == R.drawable.mika){
                        textView3.setText(s.catName);
                        imageView3.setImageResource(s.img);
                    }
                }
            }
        });
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(SkyWalker.class).build();
        WorkManager.getInstance().enqueue(workRequest);


        Button button = getActivity().findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.fragment4);
            }
        });
    }
   /* public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fragmententer);
            anim.setDuration(500);
            return anim;
        } else {
            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fragmentexit);
            anim.setDuration(500);
            return anim;
        }
    }*/
}