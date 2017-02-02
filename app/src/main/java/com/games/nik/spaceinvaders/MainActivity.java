package com.games.nik.spaceinvaders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//TODO REST STATE~~ for single activity game
//switch activities to the next button and third activity to display results

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    public enum Option {
        ROCK, PAPER, SCISSORS;

        private static final String name = Option.class.getName();

        public void attachTo(Intent intent) {
            intent.putExtra(name, ordinal());
        }

        public static Option detachFrom(Intent intent) {
            if (!intent.hasExtra(name)) throw new IllegalStateException();
            return values()[intent.getIntExtra(name, -1)];
        }
    }


    public enum Result {
        WIN, LOSS, DRAW
    }

    public static Option userSelection;
    private Result gameResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rock = (Button) findViewById(R.id.rock);
        Button paper = (Button) findViewById(R.id.paper);
        Button scissors = (Button) findViewById(R.id.scissors);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);

//        Button rock1 = (Button) findViewById(R.id.rock1);
//        Button paper1 = (Button) findViewById(R.id.paper1);
//        Button scissors1 = (Button) findViewById(R.id.scissors1);
//
//        rock1.setOnClickListener(this);
//        paper1.setOnClickListener(this);
//        scissors1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent player1Select = new Intent(this, PlayerTwo.class);
        switch (v.getId()) {
            case R.id.rock:
                userSelection = Option.ROCK;
//                Toast.makeText(this, "Rock", Toast.LENGTH_LONG).show();
                Option.ROCK.attachTo(player1Select);
                startActivity(player1Select);
                break;
            case R.id.paper:
                userSelection = Option.PAPER;
//                Toast.makeText(this, "Paper", Toast.LENGTH_LONG).show();
                Option.PAPER.attachTo(player1Select);
                startActivity(player1Select);
                break;
            case R.id.scissors:
                userSelection = Option.SCISSORS;
//                Toast.makeText(this, "Scissors", Toast.LENGTH_LONG).show();
                Option.SCISSORS.attachTo(player1Select);
                startActivity(player1Select);
                break;
        }
    }
}
//            case R.id.rock1:
//                userSelection1 = Option.ROCK;
//                Toast.makeText(this, "Rock1", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.paper1:
//                userSelection1 = Option.PAPER;
//                Toast.makeText(this, "Paper1", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.scissors1:
//                userSelection1 = Option.SCISSORS;
//                Toast.makeText(this, "Scissors1", Toast.LENGTH_SHORT).show();
//                break

//
//        if(MainActivity.userSelection == MainActivity.Option.ROCK && PlayerTwo.userSelection == PlayerTwo.Option.ROCK){
//            gameResult = Result.DRAW;
//            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
//        }
//        else if(MainActivity.userSelection == Option.PAPER && PlayerTwo.userSelection == PlayerTwo.Option.PAPER){
//            gameResult = Result.DRAW;
//            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
//        }
//        else if(MainActivity.userSelection == Option.SCISSORS && PlayerTwo.userSelection == PlayerTwo.Option.SCISSORS){
//            gameResult = Result.DRAW;
//            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
//        }
//        else if(userSelection == Option.ROCK && PlayerTwo.userSelection == PlayerTwo.Option.SCISSORS){
//            gameResult = Result.LOSS;
//            Toast.makeText(this, "LOSS", Toast.LENGTH_SHORT).show();
//        }
//        else if(userSelection == Option.PAPER && PlayerTwo.userSelection == PlayerTwo.Option.ROCK) {
//            gameResult = Result.LOSS;
//            Toast.makeText(this, "LOSS", Toast.LENGTH_SHORT).show();
//        }
//        else if(userSelection == Option.SCISSORS && PlayerTwo.userSelection == PlayerTwo.Option.PAPER) {
//            gameResult = Result.LOSS;
//            Toast.makeText(this, "LOSS", Toast.LENGTH_SHORT).show();
//        }else{
//            gameResult = Result.WIN;
//            Toast.makeText(this, "WIN", Toast.LENGTH_SHORT).show();
//        }
//    }



