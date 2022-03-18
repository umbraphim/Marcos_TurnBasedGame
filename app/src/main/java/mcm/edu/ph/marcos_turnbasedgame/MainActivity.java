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
    String enemyName = "Witch";
    int enemyHP = 3000;
    int enemyFP = 500;
    int enemyDF = 450;
    int enemyMinDMG = 300;
    int enemyMaxDMG = 450;

    //turn count
    int turnNumber = 1;

    int buttonCount = 0;
    int statuscounter = 0;
    boolean status = false;


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
        txtStatus = findViewById(R.id.txtStatus);

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

        switch(v.getId()) {
            case R.id.btnHeal:
               if(heroHP <= 2500){
                   heroHP = heroHP + 200;
                   heroFP = heroFP + 200;
                   turnNumber++;
                   txtHeroHP.setText(String.valueOf(heroHP));
                   txtHeroFP.setText(String.valueOf(heroFP));
                   btnNxtTurn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                   txtStatus.setText("Kitty Knight restored HP and FP!");
               }
                status = true;
                statuscounter = 1;
                if(heroFP <= 1500){
                    heroHP = heroHP + 200;
                    heroFP = heroFP + 200;
                    turnNumber++;
                    txtHeroHP.setText(String.valueOf(heroHP));
                    txtHeroFP.setText(String.valueOf(heroFP));
                    btnNxtTurn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                    txtStatus.setText("Kitty Knight restored HP and FP!");
                }
                status = true;
                statuscounter = 1;
                break;


            case R.id.btnRaiseDefense:
                if(heroDF == 100){
                heroDF = heroDF + 100;
                enemyDF = enemyDF - 25;
                turnNumber++;
                txtHeroDF.setText(String.valueOf(heroDF));
                txtEnemyDF.setText(String.valueOf(enemyDF));
                btnNxtTurn.setText("Next Turn " + String.valueOf(turnNumber) + ")");

                txtStatus.setText("Kitty Knight raised its DF and lowered the enemy DF!");
            }
                if(enemyDF >= 450){
                    heroDF = heroDF + 100;
                    enemyDF = enemyDF - 25;
                    turnNumber++;
                    txtHeroDF.setText(String.valueOf(heroDF));
                    txtEnemyDF.setText(String.valueOf(enemyDF));
                    btnNxtTurn.setText("Next Turn " + String.valueOf(turnNumber) + ")");

                    txtStatus.setText("Kitty Knight raised its DF and lowered the enemy DF!");
                }
                status = true;
                statuscounter = 4;
                break;


            case R.id.btnRaiseATK:
                if(enemyHP <= 3000) {
                    heroDmg = heroDmg + 150;
                    enemyHP = enemyHP - 200;
                    turnNumber++;
                    txtEnemyHP.setText(String.valueOf(enemyHP));
                    txtHeroDmg.setText(String.valueOf(heroDmg));
                    btnNxtTurn.setText("Next Turn (" + String.valueOf(turnNumber) + ")");

                    txtStatus.setText("Kitty Knight has raised its ATK and attacked! It dealt " + String.valueOf(200) + " to their enemy. ");
                }
                status = true;
                statuscounter = 4;
                turnNumber = 1;

                if (enemyHP < 0) {
                    txtStatus.setText("Kitty Knight has dealt the finishing blow!");
                    heroHP = 2500;
                    enemyHP = 3000;
                    turnNumber = 1;
                    btnNxtTurn.setText("RESTART");
                }
                buttonCount = 12;
                break;


            case R.id.btnNxtTurn:
                if(turnNumber % 2 == 1) { //hero turn
                    enemyHP = enemyHP - heroDmg;
                    turnNumber++;
                    txtEnemyHP.setText(String.valueOf(enemyHP));
                    btnNxtTurn.setText("Next Turn(" + String.valueOf(turnNumber) + ")");

                    txtStatus.setText("Kitty Knight has dealt " + String.valueOf(heroDmg) + " damage to the enemy.");
                }
                   if(enemyHP < 0){
                       txtStatus.setText("Kitty Knight has dealt "+String.valueOf(heroDmg)+" to enemy and did the final blow. Kitty is victorious!");
                       heroHP = 2500;
                       enemyHP = 3000;
                       turnNumber = 1;
                       buttonCount = 0;
                       btnNxtTurn.setText("RESET");
                }
                   else if(turnNumber %2 !=1 ) {
                       if (status == true) {
                           heroHP = heroHP - enemyDmg;
                           turnNumber++;
                           txtHeroHP.setText(String.valueOf(heroHP));

                           txtStatus.setText("The enemy has dealt " + String.valueOf(enemyDmg) + " to Kitty Knight!");
                           if (statuscounter == 0) {
                               status = false;
                           }
                       }
                       else{
                           enemyHP = enemyHP - heroDmg;
                           turnNumber++;
                           txtHeroHP.setText(String.valueOf(enemyHP));
                           btnNxtTurn.setText("Next Turn ("+String.valueOf(turnNumber)+")");

                           txtStatus.setText("Kitty Knight has dealt "+String.valueOf(enemyDmg)+" to enemy!");

                           if(heroHP<0){
                               txtStatus.setText("The enemy has defeated Kitty Knight! You Lose!");
                               heroHP = 2500;
                               enemyHP = 3000;
                               turnNumber = 1;
                               buttonCount = 0;
                               btnNxtTurn.setText("RESET");
                           }
                       }
                   }
                    break;
                   }
        }

    }

