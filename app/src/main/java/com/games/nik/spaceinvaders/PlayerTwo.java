package com.games.nik.spaceinvaders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PlayerTwo extends AppCompatActivity implements View.OnClickListener {

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

        WinPage = (LinearLayout)findViewById(R.id.winPage);
        LossPage = (LinearLayout)findViewById(R.id.lossPage);
        DrawPage = (LinearLayout)findViewById(R.id.drawPage);


//        Button rock = (Button) findViewById(R.id.rock);
//        Button paper = (Button) findViewById(R.id.paper);
//        Button scissors = (Button) findViewById(R.id.scissors);
//
//        rock.setOnClickListener(this);
//        paper.setOnClickListener(this);
//        scissors.setOnClickListener(this);

//        Button home = (Button) findViewById(R.id.home);
//        home.setOnClickListener(this);

        Button rock1 = (Button) findViewById(R.id.rock1);
        Button paper1 = (Button) findViewById(R.id.paper1);
        Button scissors1 = (Button) findViewById(R.id.scissors1);

        rock1.setOnClickListener(this);
        paper1.setOnClickListener(this);
        scissors1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        Intent player2Select = new Intent(this, GameConditions.class);
        switch(v.getId()){
//            case R.id.rock:
//                userSelection = MainActivity.Option.ROCK;
//                Toast.makeText(this, "Rock", Toast.LENGTH_LONG).show();
//                break;
//            case R.id.paper:
//                userSelection = MainActivity.Option.PAPER;
//                Toast.makeText(this, "Paper", Toast.LENGTH_LONG).show();
//                break;
//            case R.id.scissors:
//                userSelection = MainActivity.Option.SCISSORS;
//                Toast.makeText(this, "Scissors", Toast.LENGTH_LONG).show();
//                break;
            case R.id.rock1:
                userSelection = Option.ROCK;
                Option.ROCK.attachTo(player2Select);
//                startActivity(player2Select);
//                Toast.makeText(this, "Rock1", Toast.LENGTH_SHORT).show();
//                MainActivity.userSelection =
                break;
            case R.id.paper1:
                userSelection = Option.PAPER;
                Option.PAPER.attachTo(player2Select);
//                startActivity(player2Select);
//                Toast.makeText(this, "Paper1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scissors1:
                userSelection = Option.SCISSORS;
                Option.SCISSORS.attachTo(player2Select);
//                startActivity(player2Select);
//                Toast.makeText(this, "Scissors1", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.home:
//                setContentView(R.layout.activity_main);
//                break;
        }
//TODO Make intents to go to draw/win/loss activity
        if(MainActivity.userSelection == MainActivity.Option.ROCK && userSelection == Option.ROCK){
            gameResult = Result.DRAW;
//            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.draw_page);
        }
        else if(MainActivity.userSelection == MainActivity.Option.PAPER && userSelection == Option.PAPER){
            gameResult = Result.DRAW;
//            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.draw_page);
            //            View view = inflater.inflate(R.layout.draw_page,null);
        }
        else if(MainActivity.userSelection == MainActivity.Option.SCISSORS && userSelection == Option.SCISSORS){
            gameResult = Result.DRAW;
//            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.draw_page);
        }

        else if(MainActivity.userSelection == MainActivity.Option.ROCK && userSelection == Option.SCISSORS){
            gameResult = Result.WIN;
//            Toast.makeText(this, "WIN", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.win_page);
        }
        else if(MainActivity.userSelection == MainActivity.Option.PAPER && userSelection == Option.ROCK) {
            gameResult = Result.WIN;
//            Toast.makeText(this, "WIN", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.win_page);
        }
        else if(MainActivity.userSelection == MainActivity.Option.SCISSORS && userSelection == Option.PAPER) {
            gameResult = Result.WIN;
//            Toast.makeText(this, "WIN", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.win_page);
        }else{
            gameResult = Result.LOSS;
//            Toast.makeText(this, "WIN", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.loss_page);
        }
    }


}
