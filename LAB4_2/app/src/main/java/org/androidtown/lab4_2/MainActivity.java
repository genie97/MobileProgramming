package org.androidtown.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    boolean isPageOpen = false;
    Animation translateLeft;
    Animation translateRight;
    LinearLayout slidingPage;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI
        slidingPage = (LinearLayout) findViewById(R.id.slidingPage);
        button = (Button) findViewById(R.id.button);

        //animation
        translateLeft = AnimationUtils.loadAnimation(this, R.anim.left_slide);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.right_slide);

        //animation listener
        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translateLeft.setAnimationListener(animationListener);
        translateRight.setAnimationListener(animationListener);
    }

    //Button listener
    public void onButtonClicked(View v) {
        //close
        if (isPageOpen) {
            slidingPage.startAnimation(translateRight);
        }
        //open
        else {
            slidingPage.setVisibility(View.VISIBLE);
            slidingPage.startAnimation(translateLeft);
        }
    }

    //animation listener
    private class SlidingPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            //from closing to opening
            if (isPageOpen) {
                slidingPage.setVisibility(View.INVISIBLE);
                button.setText("OPEN PAGE");
                isPageOpen = false;
            }
            //from opening to closing
            else {
                button.setText("CLOSE PAGE");
                isPageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        @Override
        public void onAnimationStart(Animation animation) {

        }
    }
}
