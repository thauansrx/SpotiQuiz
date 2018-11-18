package thauan.com.br.spotiquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    /**
     * Created by Thauan Trindade on 16/11/2018.
     */

    private RadioGroup radioGroup;
    private TextView textoPergunta;
    private RadioButton opcaoA;
    private RadioButton opcaoB;
    private RadioButton opcaoC;
    private RadioButton opcaoD;
    private RadioButton opcaoE;
    private Button botaoProximo;

    String Perguntas[] = {
            "1. A qual música pertence o trecho a seguir? \"É preciso amar as pessoas Como se não houvesse amanhã\"?",
            "2. Qual a música do U2 que teve o clipe filmado no Rio de Janeiro?",
            "3. Eu descobri que é azul a cor da parede da casa de Deus... \" é um trecho de qual música da banda Charlie Brown Jr.?",
            "4. Qual cantor substituiu Dinho Ouro Preto após a sua saída da banda em 1993?",
            "5. Os Ramones ganharam um Disco de Ouro por causa de um de seus discos. Qual é ele?",
            "6. \"Eu não tenho carro / Não tenho teto / E se ficar comigo é porque gosta\" é o trecho de qual música?",
            "7. \"Eu vou fazer um leilão / Quem dá mais pelo meu coração / Me ajude voltar a viver / Eu prefiro que seja você\" é o trecho de uma música cantada por qual dupla?",
            "8. \"All you need is love / All you need is love / All you need is love, love / Love is all you need\": qual o título desta música e quem a canta?",
            "9. Qual é o nome do álbum lançado no segundo semestre de 2018 da cantora Anitta?",
            "10. Qual a playlist que mais fez sucesso no Brasil e no mundo no primeiro semestre de 2018?"
    };

    String OpcaoA[] = {
            "É preciso",
            "Elevation",
            "Só por uma Noite",
            "Badauí",
            "Pleasant Dreams",
            "Construção de Chico Buarque.",
            "Edson e Hudson",
            "Everybody needs love - The Rolling Stones",
            "Solo",
            "Today's Top Hits"
    };

    String OpcaoB[] = {
            "Sereníssima",
            "Vertigo",
            "Não uso sapato",
            "Cazuza",
            "Ramones",
            "Lepo Lepo de Psirico",
            "Rionegro e Solimões",
            "Love Story - Taylor Swift.",
            "Bang",
            "Top 100 tracks currently on Spotify"
    };

    String OpcaoC[] = {
            "Será",
            "Gone",
            "Como Tudo Deve Ser",
            "Murilo Lima",
            "Mondo Bizarro",
            "Se é pra beber, eu bebo de Gusttavo Lima",
            "Cesar Menotti e Fabiano",
            "I love you - Paul McCartney.",
            "Meu Lugar",
            "Sertanejo"
    };

    String OpcaoD[] = {
            "Pais e Filhos",
            "Magnificent",
            "Lugar ao Sol",
            "Chorão",
            "Adios Amigos",
            "Tchuco no Tchaco de Parangolé",
            "Jorge e Matheus",
            "All you need is love - The Beatles.",
            "Ritmo Perfeito",
            "Noite eletrônica"
    };

    String OpcaoE [] = {
            "Faroeste cabloco",
            "Walk On",
            "Longe de você",
            "João Bosco",
            "Acid Eaters",
            "Nenhuma das alternativas",
            "Fernando e Sorocaba",
            "Candy Shop - 50cent",
            "Medicina",
            "Novidades da semana"
    };

    private int[] listaRespostas = new int[Perguntas.length];
    private int listaGabarito[] = {4,5,4,3,3,2,3,4,1,1};
    private int respostasCorretas = 0;
    private int numeroPergunta = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        botaoProximo    = (Button) findViewById(R.id.buttonProximoId);
        radioGroup      = (RadioGroup) findViewById(R.id.radioGroup);
        textoPergunta   = (TextView) findViewById(R.id.TextoPerguntaId);
        opcaoA          = (RadioButton) findViewById(R.id.radioOpcaoA);
        opcaoB          = (RadioButton) findViewById(R.id.radioOpcaoB);
        opcaoC          = (RadioButton) findViewById(R.id.radioOpcaoC);
        opcaoD          = (RadioButton) findViewById(R.id.radioOpcaoD);
        opcaoE          = (RadioButton) findViewById(R.id.radioOpcaoE);

        botaoProximo.setEnabled(false);

        atualizaPerguntas(botaoProximo);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){

                    case R.id.radioOpcaoA:
                        Log.d("s", "Opcao n1!");
                        listaRespostas[numeroPergunta-1] = 1;
                        break;

                    case R.id.radioOpcaoB:
                        Log.d("s", "Opcao n2!");
                        listaRespostas[numeroPergunta-1] = 2;
                        break;

                    case R.id.radioOpcaoC:
                        Log.d("s", "Opcao n3!");
                        listaRespostas[numeroPergunta-1] = 3;
                        break;

                    case R.id.radioOpcaoD:
                        Log.d("s", "Opcao n4!");
                        listaRespostas[numeroPergunta-1] = 4;
                        break;

                    case R.id.radioOpcaoE:
                        Log.d("s", "Opcao n5!");
                        listaRespostas[numeroPergunta-1] = 5;
                        break;
                }
                botaoProximo.setEnabled(true);
            }
        });

    }

    public void atualizaPerguntas(View view){

        if (numeroPergunta == Perguntas.length){

            opcaoA.setEnabled(false);
            opcaoB.setEnabled(false);
            opcaoC.setEnabled(false);
            opcaoD.setEnabled(false);
            opcaoE.setEnabled(false);
            radioGroup.clearCheck();
            confereResultado();

        }else {
            textoPergunta.setText(Perguntas[numeroPergunta]);

            opcaoA.setText(OpcaoA[numeroPergunta]);
            opcaoB.setText(OpcaoB[numeroPergunta]);
            opcaoC.setText(OpcaoC[numeroPergunta]);
            opcaoD.setText(OpcaoD[numeroPergunta]);
            opcaoE.setText(OpcaoE[numeroPergunta]);

            numeroPergunta++;
            radioGroup.clearCheck();
            botaoProximo.setEnabled(false);
        }

    }

    public void confereResultado(){
        int contadorLista = 0;

        for (int numero : listaRespostas){
            System.out.println(numero);

            if (numero == listaGabarito[contadorLista]){
                respostasCorretas++;
                System.out.println("Resposta Correta");
            }else {
                System.out.println("Resposta Errada");
            }
            contadorLista++;
        }
        alertaResultado(botaoProximo);
    }

    public void alertaResultado(View view){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Game.this);
        alertDialog.setTitle("ACABOU!!!");
        alertDialog.setMessage("Você acertou " + respostasCorretas + " questões!");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                voltaTelaInicio();
            }
        });
        alertDialog.show();


    }

    public void voltaTelaInicio(){
        Intent intent = new Intent(Game.this, Home.class);
        startActivity(intent);
        finish();
    }

}
