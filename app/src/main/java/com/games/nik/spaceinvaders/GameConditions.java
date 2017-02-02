package com.games.nik.spaceinvaders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class GameConditions extends AppCompatActivity implements View.OnClickListener
{




    LinearLayout LossPage;
    LinearLayout WinPage;
    LinearLayout DrawPage;




//    LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public enum Option{
        ROCK, PAPER, SCISSORS;

        private static final String name = Option.class.getName();
        public void attachTo(Intent intent){
            intent.putExtra(name, ordinal());
        }
        public static Option detachFrom(Intent intent){
            if(!intent.hasExtra(name)) throw new IllegalStateException();
            return values()[intent.getIntExtra(name, -1)];
        }
    }


    public enum Result{
        WIN, LOSS, DRAW
    }

    public static Option userSelection;
    private Result gameResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_two);


        Option result = Option.detachFrom();

    }
}
