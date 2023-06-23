package com.example.synthese_musicale;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.Touch;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.io.IOException;
import java.io.OutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static OutputStream mmOutStream;
    private byte[] mmBuffer;
    VideoView videoView;
    Fragment page1;
    //int duration = Toast.LENGTH_SHORT;
    private MediaPlayer mediaPlayer1;
    byte tab[];
    public page2() {
        // Required empty public constructor
    }
    public void setpage1(page1 page)
    {
        page1=page;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page2.
     */
    // TODO: Rename and change types and number of parameters
    public static page2 newInstance(String param1, String param2) {
        page2 fragment = new page2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_page2, container, false);
        ImageView TouchePiano1 = view.findViewById(R.id.toucheP1);
        ImageView TouchePiano2 = view.findViewById(R.id.toucheP2);
        ImageView TouchePiano3 = view.findViewById(R.id.toucheP3);
        ImageView TouchePiano4 = view.findViewById(R.id.toucheP4);
        ImageView TouchePiano5 = view.findViewById(R.id.toucheP5);
        ImageView TouchePiano6 = view.findViewById(R.id.toucheP6);
        ImageView TouchePiano7 = view.findViewById(R.id.toucheP7);
        ImageView TouchePiano8 = view.findViewById(R.id.toucheP8);
        ImageView TouchePiano9 = view.findViewById(R.id.toucheP9);
        ImageView TouchePiano10 = view.findViewById(R.id.toucheP10);
        ImageView TouchePiano11 = view.findViewById(R.id.touchePN1);
        ImageView TouchePiano12 = view.findViewById(R.id.touchePN2);
        ImageView TouchePiano13 = view.findViewById(R.id.touchePN3);
        ImageView TouchePiano14 = view.findViewById(R.id.touchePN4);
        ImageView TouchePiano15 = view.findViewById(R.id.touchePN5);
        ImageView TouchePiano16 = view.findViewById(R.id.touchePN6);
        ImageView TouchePiano17 = view.findViewById(R.id.touchePN7);
        ImageView Touchemenu1 = view.findViewById(R.id.toucheMenu1);
        ImageView Touchemenu2 = view.findViewById(R.id.toucheMenu2);


        videoView = view.findViewById(R.id.background);
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.background);
        videoView.setVideoPath(String.valueOf(uri));
        videoView.start();
        Log.i("BT"," Valeur de outstream "+mmOutStream);
        mediaPlayer1 = MediaPlayer.create(getContext(), R.raw.piano1);
        // Toast toast2 = Toast.makeText(this, "test2",duration);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setLooping(true);
                mp.setVolume(0, 0);
            }

        });




        TouchePiano1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'a'};
                        write(tab);

                        TouchePiano1.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano1.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'b'};
                        write(tab);


                        TouchePiano2.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano2.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });

        TouchePiano3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'c'};
                        write(tab);

                        TouchePiano3.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano3.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'d'};
                        write(tab);

                        TouchePiano4.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano4.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche noir
                        tab= new byte[]{'e'};
                        write(tab);

                        TouchePiano5.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano5.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'f'};
                        write(tab);

                        TouchePiano6.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano6.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche noir
                        tab= new byte[]{'g'};
                       write(tab);

                        TouchePiano7.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano7.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        Log.i("Interface","Boutton appuyer");
                        tab= new byte[]{'h'};
                        write(tab);

                        TouchePiano8.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano8.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche noir
                        tab= new byte[]{'i'};
                        write(tab);

                        TouchePiano9.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano9.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'j'};
                        write(tab);

                        TouchePiano10.setImageResource(R.drawable.touche_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano10.setImageResource(R.drawable.touche_base);
                        break;
                }
                return true;
            }
        });
        TouchePiano11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche noir
                        tab= new byte[]{'k'};
                        write(tab);

                        TouchePiano11.setImageResource(R.drawable.touche_noire_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche noir
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano11.setImageResource(R.drawable.touche_noire3);
                        break;
                }
                return true;
            }
        });
        TouchePiano12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'l'};
                        write(tab);

                        TouchePiano12.setImageResource(R.drawable.touche_noire_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche noir
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano12.setImageResource(R.drawable.touche_noire3);
                        break;
                }
                return true;
            }
        });
        TouchePiano13.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'m'};
                        write(tab);

                        TouchePiano13.setImageResource(R.drawable.touche_noire_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche noir
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano13.setImageResource(R.drawable.touche_noire3);
                        break;
                }
                return true;
            }
        });
        TouchePiano14.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche noir
                        tab= new byte[]{'n'};
                        write(tab);

                        TouchePiano14.setImageResource(R.drawable.touche_noire_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche noir
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano14.setImageResource(R.drawable.touche_noire3);
                        break;
                }
                return true;
            }
        });
        TouchePiano15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'o'};
                        write(tab);

                        TouchePiano15.setImageResource(R.drawable.touche_noire_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche noir
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano15.setImageResource(R.drawable.touche_noire3);
                        break;
                }
                return true;
            }
        });
        TouchePiano16.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche
                        tab= new byte[]{'p'};
                        write(tab);

                        TouchePiano16.setImageResource(R.drawable.touche_noire_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche noir
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano16.setImageResource(R.drawable.touche_noire3);
                        break;
                }
                return true;
            }
        });
        TouchePiano17.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Case pour la touche quand appuyer
                        // Change l'image de la touche noir
                        tab= new byte[]{'q'};
                        write(tab);


                        TouchePiano17.setImageResource(R.drawable.touche_noire_appuyer);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Case pour la touche quand relacher
                        // Remet l'image de base de la touche noir
                        tab= new byte[]{' '};
                        write(tab);
                        TouchePiano17.setImageResource(R.drawable.touche_noire3);
                        break;
                }
                return true;
            }
        });
        Touchemenu1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tab= new byte[]{'1'};
                Toast.makeText(getContext(), "Mode 1 ", Toast.LENGTH_SHORT).show();
                write(tab);
                return true;
            }
        });
        Touchemenu2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tab= new byte[]{'2'};
                Toast.makeText(getContext(), "Mode 2 ", Toast.LENGTH_SHORT).show();
                write(tab);
                return true;
            }
        });


        return view;
}
    public void write(byte[] bytes) {
        try {
            mmBuffer = new byte[1024];
            ((com.example.synthese_musicale.page1) page1).mmOutStream.write(bytes);


            // Share the sent message with the UI activity.
            /*Message writtenMsg = handler.obtainMessage(
                    MessageConstants.MESSAGE_WRITE, -1, -1, mmBuffer);
            writtenMsg.sendToTarget();*/
        } catch (IOException e) {
            Log.e("BT", "Error occurred when sending data", e);

            // Send a failure message back to the activity.
            /*Message writeErrorMsg =
                    handler.obtainMessage(MessageConstants.MESSAGE_TOAST);
            Bundle bundle = new Bundle();
            bundle.putString("toast",
                    "Couldn't send data to the other device");
            writeErrorMsg.setData(bundle);
            handler.sendMessage(writeErrorMsg);*/
        }
    }}
