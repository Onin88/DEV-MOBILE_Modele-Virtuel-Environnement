package com.example.virtualmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ConstructionActivity extends AppCompatActivity {

    private ArrayList<Piece> bat = new ArrayList<Piece>();
    private Mur tabMur[] = new Mur[4];
    private int OrientationClique = 0;
    private int nbPiece = 0;
    private Orientation o;
    private ImageView image;

    private int x;

    private Button beast;
    private Button bnorth;
    private Button bwest;
    private Button bsouth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_construction);
        Toast.makeText(ConstructionActivity.this, "Vous entrez dans le mode construction ", Toast.LENGTH_SHORT).show();
        beast = findViewById(R.id.buttonEast);
        bwest = findViewById(R.id.buttonWest);
        bsouth = findViewById(R.id.buttonSouth);
        bnorth = findViewById(R.id.buttonNorth);
    }


    /**---------- Fonction OnClick ----------**/

    public void ajoutOrientationNord(View view){
        o = Orientation.N;
        OrientationClique++;
        Toast.makeText(ConstructionActivity.this, "Vous avez choisi le mur Nord : "+this.o, Toast.LENGTH_SHORT).show();
    }
    public void ajoutOrientationSud(View view){
        o = Orientation.S;
        OrientationClique++;
        Toast.makeText(ConstructionActivity.this, "Vous avez choisi le mur Sud : "+this.o, Toast.LENGTH_SHORT).show();
    }
    public void ajoutOrientationEst(View view){
        o = Orientation.E;
        OrientationClique++;
        Toast.makeText(ConstructionActivity.this, "Vous avez choisi le mur Est : "+this.o, Toast.LENGTH_SHORT).show();
    }
    public void ajoutOrientationOuest(View view){
        o = Orientation.O;
        OrientationClique++;
        Toast.makeText(ConstructionActivity.this, "Vous avez choisi le mur Ouest : "+this.o, Toast.LENGTH_SHORT).show();
    }


    public void ajoutImageView(View view){ // il faut qu'après clique cela ouvre le gestinnaire de fichier et qu'il puisse aller chercher l'image dans son ordi.
        image = new ImageView(this);
        //image.setImageResource(R.);
    }

    //Fonction qui ajoute une jointure d'une piece à une autre
    public void ajoutJointurePiece(View view){
        this.x = this.nbPiece++;
    }


    //Fonction qui range le tableau de Mur dans l'ordre des Orientations N S E O
    public Mur[] rangerTabMur(Mur tab[]){
        Mur bonTab[] = new Mur[4];
        for(int i = 0; i < 4; i++){
            if(tab[i].getO() == Orientation.N) { //SI NORD ALORS RANGE 1er EMPLACEMENT
                bonTab[0] = tab[i];
            }else if (tab[i].getO() == Orientation.S){ //SI S ALORS RANGE 2eme EMPLACEMENT
                bonTab[1] = tab[i];
            }else if (tab[i].getO() == Orientation.E){ //SI E ALORS RANGE 3eme EMPLACEMENT
                bonTab[2] = tab[i];
            }else if (tab[i].getO() == Orientation.O){ //SI O ALORS RANGE 4eme EMPLACEMENT
                bonTab[3] = tab[i];
            }
        }
        return bonTab;
    }

    //Création d'un mur avec données récupérées au dessus et ajout du mur à la pièce correspondante
    public void validerMur(View view){
        Mur mur = new Mur(this.o, this.image); //créé le nouveau mur avec les paramètres rentrés.

        this.tabMur[OrientationClique%4] = mur; // A chaque fois que c'est validé ajoute le mur nouvellement créé dans le tableau de mur

        switch(mur.getO()){  // SWITCH qui permet de rendre les boutons d'orientation non cliquable si le mur en question a déjà été créé
            case N:
                this.bnorth.setClickable(false);
                break;
            case S:
                this.bsouth.setClickable(false);
                break;
            case E:
                this.beast.setClickable(false);
                break;
            case O:
                this.bwest.setClickable(false);
                break;
        }

        if(this.OrientationClique % 4 == 0){ // à chaque fois que les 4 murs sont créés
            tabMur = rangerTabMur(tabMur);
            this.nbPiece++;
            Piece p = new Piece(tabMur[0], tabMur[1], tabMur[2], tabMur[3], this.nbPiece);
            this.bat.add(p);

            //Tous les boutons d'orientation sont de renouveau cliquable
            this.bnorth.setClickable(true);
            this.bsouth.setClickable(true);
            this.beast.setClickable(true);
            this.bwest.setClickable(true);
        }

        Toast.makeText(ConstructionActivity.this, "Le mur n° "+OrientationClique+" a été ajouté avec succès à la pièce n° "+(this.nbPiece+1)+" !", Toast.LENGTH_SHORT).show();
    }

    //Fonction quitter la page
    public void fini(View view){
        this.finish();
        Toast.makeText(ConstructionActivity.this, "Vous quittez le mode construction !", Toast.LENGTH_SHORT).show();
    }
}
