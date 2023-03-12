package com.example.projektb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;



public class LahkaObtiaznost extends AppCompatActivity implements View.OnTouchListener {
    private Handler handler = new Handler();
    private float bodkaY, resetBodky;
    TextView poletextove, thermoCount, zadanie;
    private int teplota= 0,teplotaZadanie, cisloZadania, limitZvolenych;
    private int pocetZvolenych=0;
    private ImageView bodka, prve, druhe, tretie, stvrte, piate,sieste,siedme,osme;
    ImageButton mcred, mcblue;
    private boolean hore, dole, zistovanie, pridavaj, zaplnenie;
    double [] kamienky = {0,0,0,0,0,0,0,0};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_actual);
        poletextove= (TextView) findViewById(R.id.poletextove);
        zadanie = (TextView) findViewById(R.id.zadanie);
        thermoCount = (TextView) findViewById(R.id.thermoCount);
        mcred = (ImageButton) findViewById(R.id.mcred);
        mcblue = (ImageButton) findViewById(R.id.mcblue);
        bodka = (ImageView) findViewById(R.id.bodka);
        prve = (ImageView) findViewById(R.id.prve);
        druhe = (ImageView) findViewById(R.id.druhe);
        tretie = (ImageView) findViewById(R.id.tretie);
        stvrte = (ImageView) findViewById(R.id.strvrte);
        piate = (ImageView) findViewById(R.id.piate);
        sieste = (ImageView) findViewById(R.id.sieste);
        siedme = (ImageView) findViewById(R.id.siedme);
        osme = (ImageView) findViewById(R.id.osme);
        // zistovanie miesta Bodky zadanie.setText(Float.toString(bodkaY));
        resetBodky = bodka.getY();

        cisloZadania = 1;

        // objekty
        zadania Armida1 = new zadania();

        mcblue.setOnTouchListener(this); //"this" ukazuje na objekt
        mcred.setOnTouchListener(this);

        thermoCount.setText("Teplota je: " + teplota+ "\n");

        //Metody:
        zmenaZadania1();

        pohybBodky();
        //nahravanieModre();
        //nahravanieCervene();
        //kontrola();
    }

    private void kontrola() {
        if(pocetZvolenych==limitZvolenych){
            zaplnenie=true;
        }
        else{zaplnenie=false;}
        if((teplota == teplotaZadanie)&&(zaplnenie)){

            cisloZadania += 1;
            resetMetoda();
            if(hore||dole){zmenaZadania1();}
        }
    }


    public void reset(View view){
        resetMetoda();
    }

    private void resetMetoda() {
        bodka.setY(resetBodky);
        for(int i=0; i <8; i++){
            if(kamienky[i] == 1){
                kamienky[i] =0;
                zresetovanieObrazkov();}}
    }

    private void zresetovanieObrazkov() {
        if(kamienky[0]!=2){prve.setImageResource(R.drawable.mcgrey);
        }
        if(kamienky[1]!=2){druhe.setImageResource(R.drawable.mcgrey);

        }
        if(kamienky[2]!=2) {tretie.setImageResource(R.drawable.mcgrey);
        }
        if(kamienky[3]!=2){stvrte.setImageResource(R.drawable.mcgrey);

        }
        if(kamienky[4]!=2){piate.setImageResource(R.drawable.mcgrey);
        }
        if(kamienky[5]!=2){sieste.setImageResource(R.drawable.mcgrey);

        }
        if(kamienky[6]!=2){siedme.setImageResource(R.drawable.mcgrey);
        }
        if(kamienky[7]!=2){osme.setImageResource(R.drawable.mcgrey);
        }
        bodka.setY(resetBodky);
        teplota = 0;
        thermoCount.setText("Teplota je: " + teplota+ "°C");
        pocetZvolenych = 0;
    }


    private void zmenaZadania1() { // toto je editovatelna metoda, tu možem pridavať koľko chcem zadani
        if(cisloZadania==1){
            zadanie.setText(zadania.ziskajArmida5());
            teplotaZadanie = 8;// teplota zo zadania
            limitZvolenych=8;//pocet volnych policok na ktorych to musi hrac hrat
            zresetovanieObrazkov();
        }
        if(cisloZadania==2){
            onTextAppeared();//metoda ktora po 5 sekundach vymeni zadanie
        }
        if(cisloZadania==3){
            zadanie.setText(zadania.ziskajArmida6());
            zresetovanieObrazkov();
            osme.setImageResource(R.drawable.mcblack);
            kamienky[7]= 2;
            teplotaZadanie = 3;
            limitZvolenych=7;
        }
        if(cisloZadania==4){
            onTextAppeared();//metoda ktora po 4 sekundach vymeni zadanie
        }
        if(cisloZadania==5){zadanie.setText(zadania.ziskajArmida7());
            kamienky[7]= 0;
            zresetovanieObrazkov();
            teplotaZadanie = 6;
            limitZvolenych=8;}
        if(cisloZadania==6){
            onTextAppeared();}
        if(cisloZadania==7){zadanie.setText(zadania.ziskajArmida8()); // zdroj textu zadania
            zresetovanieObrazkov();
            siedme.setImageResource(R.drawable.mcblack);
            kamienky[6]= 2;
            osme.setImageResource(R.drawable.mcblack);
            kamienky[7]= 2;
            teplotaZadanie = 4;
            limitZvolenych=6;} // kolko je volnych
        if(cisloZadania==8){zadanie.setText(zadania.ziskajArmida9());
            zresetovanieObrazkov();
            piate.setImageResource(R.drawable.mcblack);
            kamienky[4]= 2;
            sieste.setImageResource(R.drawable.mcblack);
            kamienky[5]= 2;
            siedme.setImageResource(R.drawable.mcblack);
            kamienky[6]= 2;
            osme.setImageResource(R.drawable.mcblack);
            kamienky[7]= 2;
            teplotaZadanie = 0;
            limitZvolenych=4;}
        if(cisloZadania==9){
            zresetovanieObrazkov();
            zadanie.setText("Vyhral si, skús ťažšiu obtiažnosť ;) ");//metoda ktora po 4 sekundach vymeni zadanie
        }}

    // Metoda na casovanie
    private void onTextAppeared() {
        zadanie.setText("Správne, zvládneš ďalší?"); // sprava v oneskoreni
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cisloZadania +=1;
                zmenaZadania1();
            }
        }, 4000); // cas medzi zadaniami
    }

    private void pohybBodky() {
        bodkaY = bodka.getY();// riesim kde sa na y nachadza
        if(hore){
            bodkaY= bodkaY-30;
            teplota += 1;
            bodka.setY(bodkaY);
            thermoCount.setText("Teplota je: " + teplota+"°C");
            nahravanieCervene();
            kontrola();
        }

        if(dole){
            bodkaY= bodkaY+30;
            teplota -= 1;
            //thermoCount.append(teplota+ "°C");
            bodka.setY(bodkaY);
            thermoCount.setText("Teplota je: " + teplota+ "°C");
            nahravanieModre();
            kontrola();

        }
        // riesenie hranic bodky aby nesiel mimo teplomera
        if(bodkaY < 55){bodkaY = 55;
            teplota -= 1;}

        bodka.setY(bodkaY);
        if(bodkaY > 660){bodkaY = 660;
            teplota += 1;}

        bodka.setY(bodkaY);

    }
    private void nahravanieModre() {
        while(hore||dole){
            if(kamienky[0]==0){prve.setImageResource(R.drawable.mcblue);
                kamienky[0]= 1;
                pocetZvolenych +=1;
                break;}
            if(kamienky[1]==0){druhe.setImageResource(R.drawable.mcblue);
                kamienky[1]= 1;
                pocetZvolenych += 1;
                break;}
            if(kamienky[2]==0){tretie.setImageResource(R.drawable.mcblue);
                kamienky[2]= 1;
                pocetZvolenych += 1;
                break;}
            if(kamienky[3]==0){stvrte.setImageResource(R.drawable.mcblue);
                kamienky[3]= 1;
                pocetZvolenych += 1;
                break;}
            if(kamienky[4]==0){piate.setImageResource(R.drawable.mcblue);
                kamienky[4]= 1;
                pocetZvolenych += 1;
                break;}
            if(kamienky[5]==0){sieste.setImageResource(R.drawable.mcblue);
                kamienky[5]= 1;
                pocetZvolenych += 1;
                break;}
            if(kamienky[6]==0){siedme.setImageResource(R.drawable.mcblue);
                kamienky[6]= 1;
                pocetZvolenych += 1;
                break;}
            if(kamienky[7]==0){osme.setImageResource(R.drawable.mcblue);
                kamienky[7]= 1;
                pocetZvolenych += 1;
                break;}
            else{
                for(int i = 0; i <8; i++){
                    if(kamienky[i] == 1){
                        kamienky[i] =0;
                        pocetZvolenych = 0;
                    }zresetovanieObrazkov();}
            }
        }}
    private void nahravanieCervene() {
        while(hore||dole){
            if(kamienky[0]==0){prve.setImageResource(R.drawable.mcred);
                kamienky[0]= 1;
                pocetZvolenych += 1;
                break;
            }
            if(kamienky[1]==0){druhe.setImageResource(R.drawable.mcred);
                kamienky[1]= 1;
                pocetZvolenych += 1;
                break;
            }
            if(kamienky[2]==0){tretie.setImageResource(R.drawable.mcred);
                kamienky[2]= 1;
                pocetZvolenych += 1;
                break;
            }
            if(kamienky[3]==0){stvrte.setImageResource(R.drawable.mcred);
                kamienky[3]= 1;
                pocetZvolenych += 1;
                break;
            }
            if(kamienky[4]==0){piate.setImageResource(R.drawable.mcred);
                kamienky[4]= 1;
                pocetZvolenych += 1;
                break;
            }
            if(kamienky[5]==0){sieste.setImageResource(R.drawable.mcred);
                kamienky[5]= 1;
                pocetZvolenych += 1;
                break;
            }
            if(kamienky[6]==0){siedme.setImageResource(R.drawable.mcred);
                kamienky[6]= 1;
                pocetZvolenych += 1;
                break;
            }
            if(kamienky[7]==0){osme.setImageResource(R.drawable.mcred);
                kamienky[7]= 1;
                pocetZvolenych += 1;
                break;
            }
            else{
                for(int i=0; i <8; i++){
                    if(kamienky[i] == 1){
                        kamienky[i] =0;}
                    zresetovanieObrazkov();
                }}
        }
    }

    public void domenu(View view){
        startActivity(new Intent(getApplicationContext(), VolenieObtiaznosti.class));

    }

    @Override
    public boolean onTouch (View v, MotionEvent event){
        if(event.getAction()== MotionEvent.ACTION_DOWN){ // action up- spusti pri odtlaceni tlacitka
            switch(v.getId()){
                case R.id.mcred:
                    hore=true;
                    pohybBodky(); // call pohybBodky() directly
                    break;
                case R.id.mcblue:
                    dole=true;
                    pohybBodky(); // call pohybBodky() directly
                    break;
            }
            return super.onTouchEvent(event);
        }
        else{
            dole=false;
            hore=false;
        }
        return false;
    }

}