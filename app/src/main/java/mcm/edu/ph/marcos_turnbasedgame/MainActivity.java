package mcm.edu.ph.marcos_turnbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtHeroKitty, txtHeroDmg, txtHeroHP, txtEnemy, txtEnemyDmg, txtEnemyHP, txtTurnCount,
    txtEnemyFP, txtHeroFP, txtStatus, txtHeroDF, txtEnemyDF;
    Button btnNxtTurn;
    ImageButton RaiseDefense, RaiseDamage, Heal;


    //hero kitty
    String Hero = "Kitty Knight";
    int heroHP = 2500;
    int heroFP = 1500;
    int heroDF = 1000;
    int heroMinDMG = 1000;
    int heroMaxDMG = 1700;

    //enemy
    String enemyName = "Kitty Knight";
    int enemyHP = 4000;
    int enemyFP = 500;
    int enemyDF = 450;
    int enemyMinDMG = 300;
    int enemyMaxDMG = 450;

    //turn count
    int turnNumber = 1;
    int buttonCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHeroKitty = findViewById(R.id.txtHeroKitty);
        txtEnemy = findViewById(R.id.txtEnemy);
        txtHeroHP = findViewById(R.id.txtHeroHP);
        txtEnemyHP = findViewById(R.id.txtEnemyHP);
        txtHeroDmg = findViewById(R.id.txtHeroDmg);
        txtEnemyDmg = findViewById(R.id.txtEnemyDmg);
        txtHeroFP = findViewById(R.id.txtHeroFP);
        txtEnemyFP = findViewById(R.id.txtEnemyFP);
        btnNxtTurn = findViewById(R.id.btnNxtTurn);

        txtTurnCount = findViewById(R.id.txtTurnCount);

        txtHeroKitty.setText(Hero);
        txtHeroHP.setText(String.valueOf(heroHP));
        txtHeroFP.setText(String.valueOf(heroFP));

        txtEnemy.setText(enemyName);
        txtEnemyHP.setText(String.valueOf(enemyHP));
        txtEnemyFP.setText(String.valueOf(enemyFP));

        txtHeroDmg.setText(String.valueOf(heroMinDMG)+ "-"+ String.valueOf(heroMaxDMG));
        txtEnemyDmg.setText(String.valueOf(enemyMinDMG)+ "-"+ String.valueOf(enemyMaxDMG));

        RaiseDamage = findViewById(R.id.btnRaiseATK);
        RaiseDefense = findViewById(R.id.btnRaiseDefense);
        Heal = findViewById(R.id.btnHeal);

        btnNxtTurn.setOnClickListener(this);
        RaiseDefense.setOnClickListener(this);
        RaiseDamage.setOnClickListener(this);
        Heal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txtTurnCount.findViewById(R.id.txtTurnCount);
        Random random = new Random();
        int heroDmg = random.nextInt(heroMaxDMG - heroMinDMG) + heroMinDMG;
        int enemyDmg = random.nextInt(enemyMaxDMG - enemyMinDMG) + enemyMinDMG;

        if(turnNumber % 2 != 1){
            RaiseDamage.setEnabled(false);
            RaiseDefense.setEnabled(false);
            Heal.setEnabled(false);
        }
        else if(turnNumber % 2 == 1){
            RaiseDamage.setEnabled(true);
            RaiseDefense.setEnabled(true);
            Heal.setEnabled(true);
        }
        if(buttonCount > 0){
            RaiseDefense.setEnabled(false);
            RaiseDamage.setEnabled(false);
            Heal.setEnabled(false);
        }
        else if(buttonCount == 0){
            RaiseDefense.setEnabled(true);
            RaiseDamage.setEnabled(true);
            Heal.setEnabled(true);
        }

        switch(v.getId()){
            case R.id.btnHeal:
                heroHP = heroHP + 200;
                heroFP = heroFP + 200;
                turnNumber++;
                txtHeroHP.setText(String.valueOf(heroHP));
                txtHeroFP.setText(String.valueOf(heroFP));
                btnNxtTurn.setText("Next Turn ("+String.valueOf(turnNumber)+")");

                txtStatus.setText("Kitty Knight restored HP and FP!");
                break;
        }

        switch (v.getId()) {
            case R.id.btnRaiseDefense:
                heroDF = heroDF + 100;
                enemyDF = enemyDF - 25;
                turnNumber++;
                txtHeroDF.setText(String.valueOf(heroDF));
                txtEnemyDF.setText(String.valueOf(enemyDF));
                btnNxtTurn.setText("Next Turn "+ String.valueOf(turnNumber)+")");

                txtStatus.setText("Kitty Knight raised its DF and lowered the enemy DF!");
                break;
        }
        switch (v.getId()){
            case R.id.btnRaiseATK:
                heroDmg = heroDmg + 150;
                enemyHP = enemyHP - 200;
                turnNumber++;
                txtEnemyHP.setText(String.valueOf(enemyHP));
                txtHeroDmg.setText(String.valueOf(heroDmg));
                btnNxtTurn.setText("Next Turn ("+ String.valueOf(turnNumber)+")");

                txtStatus.setText("Kitty Knight has raised its ATK and attacked! It dealt "+String.valueOf(200)+" to their enemy. ");

                if(enemyHP < 0 ){
                    txtStatus.setText("Kitty Knight has dealt the finishing blow!");
                    heroHP = 2500;
                    enemyHP = 4000;
                    turnNumber = 1;
                    btnNxtTurn.setText("RESET");

                    break;
                }
        }

    }
}
