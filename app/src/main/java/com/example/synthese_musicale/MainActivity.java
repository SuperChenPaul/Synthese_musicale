package com.example.synthese_musicale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    protected boolean test = true;
    Fragment page1;
    Fragment page2;
    protected OutputStream mmOutStream;
    private void lanceFragment(Fragment fragment) {
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page1 = new page1();
        ((com.example.synthese_musicale.page1) page1).test = test;

        page2 = new page2();
        ((com.example.synthese_musicale.page2) page2).setpage1(((com.example.synthese_musicale.page1) page1));

        lanceFragment(new page1());

}
}