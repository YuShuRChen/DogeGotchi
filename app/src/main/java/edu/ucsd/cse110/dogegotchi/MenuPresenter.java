package edu.ucsd.cse110.dogegotchi;

import android.view.View;

import edu.ucsd.cse110.dogegotchi.doge.Doge;
import edu.ucsd.cse110.dogegotchi.doge.IDogeObserver;

public class MenuPresenter implements IDogeObserver {
    Doge doge;
    View foodMenu;

    public MenuPresenter(Doge doge, View foodMenu) {
        this.doge = doge;
        this.foodMenu = foodMenu;
        foodMenu.findViewById(R.id.HamButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                feed("ham");
            }
        });
        foodMenu.findViewById(R.id.SteakButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                feed("steak");
            }
        });
        foodMenu.findViewById(R.id.TurkeyLegButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                feed("turkey");
            }
        });
    }

    @Override
    public void onStateChange(Doge.State newState) {
        if (newState == Doge.State.SAD) {
            foodMenu.setVisibility(View.VISIBLE);
        }
        else if (newState == Doge.State.EATING) {
            foodMenu.setVisibility(View.GONE);
        }
    }

    public void feed(String food) {
        doge.eat();
    }
}
