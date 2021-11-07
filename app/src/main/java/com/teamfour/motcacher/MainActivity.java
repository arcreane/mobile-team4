package com.teamfour.motcacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    String[] lesmots = { "hello", "Hey", "Ceh", "Lol","Mini" };

    //les Lettres
    public String letters = "none,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V, W,X,Y,Z";
    public String[] leslettres = letters.split(","); //Liste des lettres
    public TextView lemot; //Le mot qui s'affiche quand tu choisi les lettres

    //Voir videos sur GridView & Adapter
    public GridView[] word = {}; //la Grille des mots cacher
    public List<Integer> theword = new ArrayList<Integer>();

    Random random = new Random();// Déclarer un hazard
    private static final String TAG = "MyActivity"; //pas important mais c'est pour savoir le nom de l'activité



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> randomletters = new ArrayList<String>();
        lemot = findViewById(R.id.textView);
        lemot.setText("");

        //Remplir la grille avec 80 lettres
        for (int i=0;i<80;i++)
        {
           randomletters.add( leslettres[getRandomNumber()] );

        }


       //Voir vidéos sur les GridView et Adapters
        GridView gd = findViewById(R.id.grid);
        ArrayAdapter<String> LetterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,randomletters);
        gd.setAdapter(LetterAdapter);

        //Detecter les action fais sur la grille
        gd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {

                //Savoir ce que tu as fais sur la grille et la position de ton action
                int action = me.getActionMasked();
                float currentXPosition = me.getX();
                float currentYPosition = me.getY();
                int position = gd.pointToPosition((int) currentXPosition, (int) currentYPosition);

                //Si ton doigt se deplace dans la grille fais cela
                if (action == MotionEvent.ACTION_MOVE) {
                    // Verifier si on duplique pas
                    if( !theword.contains(position)){
                        theword.add(  position  );
                        lemot.append(gd.getItemAtPosition(position).toString());
                    }
                }



                return true;
            }
        });




    }








    public int getRandomNumber()
    {
        int randomNumber = random.nextInt(27-1) + 1;
        return randomNumber;
    }

 


    }
