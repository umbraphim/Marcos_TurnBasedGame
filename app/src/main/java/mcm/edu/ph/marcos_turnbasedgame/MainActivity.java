package mcm.edu.ph.marcos_turnbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtHeroKitty, txtHeroDmg, txtHeroHP, txtEnemy, txtEnemyDmg, txtEnemyHP, txtTurnCount,
    txtEnemyFP, txtHeroFP;
    Button btnNxtTurn;
    ImageButton RaiseDefense, RaiseDamage, Heal;


    //hero kitty
    String Hero = "Kitty Knight";
    int heroHP = 2500;
    int heroFP = 1500;
    int heroMinDMG = 1000;
    int heroMaxDMG = 1700;

    //enemy
    String enemyName = "Kitty Knight";
    int enemyHP = 4000;
    int enemyFP = 500;
    int enemyMinDMG = 300;
    int enemyMaxDMG = 450;

    //turn count
    int turnNum = 1;
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

        if(){}

    }






}
