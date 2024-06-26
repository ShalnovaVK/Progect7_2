package com.example.progect7_2.UI_Layer.View;

import android.content.Intent;
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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.R;
import com.example.progect7_2.UI_Layer.viewmodel.ItemsViewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.example.progect7_2.UI_Layer.viewmodel.ItemDetailViewModel;

public class Fragment5 extends Fragment {
    private String[] dikovinki = { "Красноплодник", "Цветы скорби","Гриб Руккхашава", "Личинка жировика","Лотос Кальпалата",
            "Лотос Нилотпала","Падисара","Скарабей", "Тришираит","Ламповый колокольчик",
            "Радужная роза","Темнозвездник","Подблок обнаружения", "Источник первой росы" };
    private int[] imageList = {R.drawable.cactus, R.drawable.cvetyskorbi, R.drawable.grib, R.drawable.lichinkazhirovika,
            R.drawable.lotus1, R.drawable.lotus2, R.drawable.padissara, R.drawable.skarabej,
            R.drawable.trishirait,R.drawable.lampovyjkolokolchik,R.drawable.raduzhnajaroza,
            R.drawable.temnozvezdnik, R.drawable.podblokobnaruzhenija, R.drawable.istochnikpervojrosy};
    private ItemsViewModel viewModel;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dikovinki.length; i++) {
            map.put(dikovinki[i], imageList[i]);
        }
        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemsViewModel.class);
        viewModel.createList(this.getContext(), map);
        int itemId = getArguments().getInt("itemId");

        viewModel.getLiveData().observe(getViewLifecycleOwner(), item -> {
            if (item != null ) {
                TextView itemName = view.findViewById(R.id.textView);
                ImageView itemDescription = view.findViewById(R.id.imageView);
                List<Cathegory> list= item.getAllCategories();
                for(Cathegory s : list){
                    if (s.img == itemId){
                        itemName.setText(s.catName);
                        itemDescription.setImageResource(s.img);
                    }
                }

            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        Button button = getActivity().findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.fragment4);
            }
        });



        Button button2 = getActivity().findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView itemName = view.findViewById(R.id.textView);
                shareText(itemName.getText().toString());
            }
        });
    }
    private void shareText(String text) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent, "Поделиться через"));
    }
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fragmentexit);
            anim.setDuration(1000);
            return anim;
        } else {
            Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fragmententer);
            anim.setDuration(500);
            return anim;
        }
    }
}