package cat.dam.codrin.examenuf1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView img_esquerra_r1c1;
    ImageView img_esquerra_r1c2;
    ImageView img_esquerra_r2c1;
    ImageView img_esquerra_r2c2;

    ImageView img_dreta_r1c1;
    ImageView img_dreta_r1c2;
    ImageView img_dreta_r2c1;
    ImageView img_dreta_r2c2;
    ImageButton greater;
    ImageButton less;
    ImageButton equal;

    TextView tv_punts;

    Button btn_sortir;

    static Random rand = new Random();

    public static int puntsUsuari = 0;
    static int nTaulaEsquerra = 0;
    static int nTaulaDreta = 0;

    static ArrayList<Dracs> animals = new ArrayList<Dracs>();

    public void Inserir_Animals(){

        Bitmap bmImg0 = BitmapFactory.decodeResource(getResources(),R.drawable.i00);
        animals.add(0, new Dracs(bmImg0, 1));
        Bitmap bmImg1 = BitmapFactory.decodeResource(getResources(),R.drawable.drac);
        animals.add(1, new Dracs(bmImg1,1));
        Bitmap bmImg2 = BitmapFactory.decodeResource(getResources(),R.drawable.rodons2);
        animals.add(2, new Dracs(bmImg2, 3));
        Bitmap bmImg3 = BitmapFactory.decodeResource(getResources(),R.drawable.rodons);
        animals.add(3, new Dracs(bmImg3, 2));
        Bitmap bmImg4 = BitmapFactory.decodeResource(getResources(),R.drawable.cairuts2);
        animals.add(4, new Dracs(bmImg4, 3));
        Bitmap bmImg5 = BitmapFactory.decodeResource(getResources(),R.drawable.cairuts);
        animals.add(5, new Dracs(bmImg5, 2));
        Bitmap bmImg6 = BitmapFactory.decodeResource(getResources(),R.drawable.i00);
        animals.add(6, new Dracs(bmImg6, 1));
        Bitmap bmImg7 = BitmapFactory.decodeResource(getResources(),R.drawable.drac);
        animals.add(7, new Dracs(bmImg7, 1));
        Bitmap bmImg8 = BitmapFactory.decodeResource(getResources(),R.drawable.rodons2);
        animals.add(8, new Dracs(bmImg8, 3));
        Bitmap bmImg9 = BitmapFactory.decodeResource(getResources(),R.drawable.rodons);
        animals.add(9, new Dracs(bmImg9, 2));
        Bitmap bmImg10 = BitmapFactory.decodeResource(getResources(),R.drawable.cairuts2);
        animals.add(10, new Dracs(bmImg10, 3));

    }
    public void InserirTaulaEsquerra(ImageView img_esquerra_r1c1,ImageView img_esquerra_r1c2,ImageView img_esquerra_r2c1,ImageView img_esquerra_r2c2){

        int punts = 0;

        int numRand,casella1,casella2,casella3,casella4;

        numRand = rand.nextInt(10);

        casella1 = numRand;

        img_esquerra_r1c1.setImageBitmap(animals.get(casella1).getImatge()); //Aconseguim la imatge del objecte animal
        punts += animals.get(casella1).getPuntuacio(); //Aconseguim els punts del objecte animal

        numRand = rand.nextInt(10);
        casella2 = numRand;
        img_esquerra_r1c2.setImageBitmap(animals.get(casella2).getImatge());
        punts += animals.get(casella2).getPuntuacio();

        numRand = rand.nextInt(10);
        casella3 = numRand;
        img_esquerra_r2c1.setImageBitmap(animals.get(casella3).getImatge());
        punts += animals.get(casella3).getPuntuacio();

        numRand = rand.nextInt(10);
        casella4 = numRand;
        img_esquerra_r2c2.setImageBitmap(animals.get(casella4).getImatge());
        punts += animals.get(casella4).getPuntuacio();

        System.out.println("Taula esquerra: " + punts);

        nTaulaEsquerra = punts;
    }

    public void InserirTaulaDreta(ImageView img_dreta_r1c1,ImageView img_dreta_r1c2,ImageView img_dreta_r2c1,ImageView img_dreta_r2c2){
        int punts = 0;

        int numRand,casella1,casella2,casella3,casella4;

        numRand = rand.nextInt(10);

        casella1 = numRand;
        img_dreta_r1c1.setImageBitmap(animals.get(casella1).getImatge());
        punts += animals.get(casella1).getPuntuacio();

        numRand = rand.nextInt(10);
        casella2 = numRand;
        img_dreta_r1c2.setImageBitmap(animals.get(casella2).getImatge());
        punts += animals.get(casella2).getPuntuacio();

        numRand = rand.nextInt(10);
        casella3 = numRand;
        img_dreta_r2c1.setImageBitmap(animals.get(casella3).getImatge());
        punts += animals.get(casella3).getPuntuacio();

        numRand = rand.nextInt(10);
        casella4 = numRand;
        img_dreta_r2c2.setImageBitmap(animals.get(casella4).getImatge());
        punts += animals.get(casella4).getPuntuacio();

        nTaulaDreta = punts;

        System.out.println("Taula dreta: " + punts);
    }

    public void Resultat(int eleccioUser){

        boolean encertat = false;

        int conclusio = 0;

        if(nTaulaEsquerra > nTaulaDreta){
            conclusio = 1;
        }
        else if(nTaulaEsquerra < nTaulaDreta){
            conclusio = 3;
        }
        else{
            conclusio = 2;
        }

        if(eleccioUser == conclusio){
            encertat = true;
        }
        else{
            encertat = false;
        }

        Usuari_punts(encertat);

    }


    public void Usuari_punts(boolean encertat){

        String punts = tv_punts.getText().toString();
        int puntsConversio = Integer.parseInt(punts);
        puntsUsuari = puntsConversio;

        if(encertat){
            puntsConversio++;
            tv_punts.setText(Integer.toString(puntsConversio));
        }else{
            puntsConversio = 0;
            tv_punts.setText(Integer.toString(puntsConversio));
        }

    }

    public void SessioJoc(){
        InserirTaulaEsquerra(img_esquerra_r1c1,img_esquerra_r1c2,img_esquerra_r2c1,img_esquerra_r2c2);
        InserirTaulaDreta(img_dreta_r1c1,img_dreta_r1c2,img_dreta_r2c1,img_dreta_r2c2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_esquerra_r1c1 = (ImageView) findViewById(R.id.img_esquerra_r1c1);
        img_esquerra_r1c2 = (ImageView) findViewById(R.id.img_esquerra_r1c2);
        img_esquerra_r2c1 = (ImageView) findViewById(R.id.img_esquerra_r2c1);
        img_esquerra_r2c2 = (ImageView) findViewById(R.id.img_esquerra_r2c2);
        img_dreta_r1c1 = (ImageView) findViewById(R.id.img_dreta_r1c1);
        img_dreta_r1c2 = (ImageView) findViewById(R.id.img_dreta_r1c2);
        img_dreta_r2c1 = (ImageView) findViewById(R.id.img_dreta_r2c1);
        img_dreta_r2c2 = (ImageView) findViewById(R.id.img_dreta_r2c2);
        greater = (ImageButton) findViewById(R.id.greater);
        equal = (ImageButton) findViewById(R.id.equal);
        less = (ImageButton) findViewById(R.id.less);
        tv_punts = (TextView) findViewById(R.id.tv_punts);
        btn_sortir = (Button) findViewById(R.id.btn_sortir);

        Inserir_Animals();
        SessioJoc();


        greater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero = 1;
                Resultat(numero);
                SessioJoc();
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero = 2;
                Resultat(numero);
                SessioJoc();
            }
        });

        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero = 3;
                Resultat(numero);
                SessioJoc();
            }
        });

        btn_sortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Credits.class));
                finish();
            }
        });

    }

}