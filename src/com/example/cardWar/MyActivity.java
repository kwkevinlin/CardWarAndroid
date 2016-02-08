package com.example.cardWar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    ImageView cardView1, cardView2;
    Button playButton;
    TextView score1View, score2View;
    int num1, num2, sIndex1, sIndex2, score1 = 0, score2 = 0;
    Random rand = new Random();
    int[] cards = {R.drawable.cardaceofclubs, R.drawable.cardaceofdiamonds, R.drawable.cardaceofhearts, R.drawable.cardaceofspades, R.drawable.card2ofclubs, R.drawable.card2ofdiamonds, R.drawable.card2ofhearts, R.drawable.card2ofspades, R.drawable.card3ofclubs, R.drawable.card3ofdiamonds, R.drawable.card3ofhearts, R.drawable.card3ofspades, R.drawable.card4ofclubs, R.drawable.card4ofdiamonds, R.drawable.card4ofhearts, R.drawable.card4ofspades, R.drawable.card5ofclubs, R.drawable.card5ofdiamonds, R.drawable.card5ofhearts, R.drawable.card5ofspades, R.drawable.card6ofclubs, R.drawable.card6ofdiamonds, R.drawable.card6ofhearts, R.drawable.card6ofspades, R.drawable.card7ofclubs, R.drawable.card7ofdiamonds, R.drawable.card7ofhearts, R.drawable.card7ofspades, R.drawable.card8ofclubs, R.drawable.card8ofdiamonds, R.drawable.card8ofhearts, R.drawable.card8ofspades, R.drawable.card9ofclubs, R.drawable.card9ofdiamonds, R.drawable.card9ofhearts, R.drawable.card9ofspades, R.drawable.card10ofclubs, R.drawable.card10ofdiamonds, R.drawable.card10ofhearts, R.drawable.card10ofspades, R.drawable.cardjackofclubs, R.drawable.cardjackofdiamonds, R.drawable.cardjackofhearts, R.drawable.cardjackofspades, R.drawable.cardqueenofclubs, R.drawable.cardqueenofdiamonds, R.drawable.cardqueenofhearts, R.drawable.cardqueenofspades, R.drawable.cardkingofclubs, R.drawable.cardkingofdiamonds, R.drawable.cardkingofhearts, R.drawable.cardkingofspades};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Linking variables to view
        cardView1 = (ImageView)findViewById(R.id.imageViewCard1);
        cardView2 = (ImageView)findViewById(R.id.imageViewCard2);
        playButton = (Button)findViewById(R.id.playButton);
        score1View = (TextView)findViewById(R.id.score1TView);
        score2View = (TextView)findViewById(R.id.score2TView);

    }

    public void playCard(View view) {

        //Suite order: clubs, diamonds, hearts, spades

        //Card 1
        num1 = rand.nextInt(13) + 1;
        sIndex1 = rand.nextInt(4) + 1;
        System.out.println("Card1 num: " + num1 + ", suite: " + sIndex1);
        cardView1.setImageResource(cards[num1 * 4 + sIndex1 - 5]); //-4 because ace = [0 - 3], 1 = [4 - 7]
                                                                 //-1 because starts at 0
                                                                 //thus total -5
        //Card 2
        num2 = rand.nextInt(13) + 1;
        sIndex2 = rand.nextInt(4) + 1;
        System.out.println("Card2 num: " + num2 + ", suite: " + sIndex2);
        cardView2.setImageResource(cards[num2 * 4 + sIndex2 - 5]);

        if (num1 > num2) {
            score1++;
            score1View.setText("Score" + score1);
        } else if (num1 < num2) {
            score2++;
            score2View.setText("Score: " + score2);
        } else {
            if (sIndex1 > sIndex2) {
                score1++;
                score1View.setText("Score: " + score1);
            } else {
                score2++;
                score2View.setText("Score: " + score2);
            }
        }
    }
}
