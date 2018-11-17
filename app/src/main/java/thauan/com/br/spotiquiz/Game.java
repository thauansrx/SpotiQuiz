package thauan.com.br.spotiquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
            "1. Normalmente, quantos litros de sangue uma pessoa tem?\nEm média quantos são retirados em uma doação de sangue?",
            "2. De onde é a invenção do chuveiro elétrico?",
            "3. Qual é o menor e o maior país do mundo?",
            "4. Qual o nome do ex presidente do Brasil que ficou conhecido como Jango?",
            "5. Quantas casas decimais tem o número pi?",
            "6. Atualmente, quantos elementos químicos a tabela periódica possui?",
            "7. Qual o número mínimo de jogadores em uma partida de futebol?",
            "8. Quanto tempo a luz do sol demora para chegar na Terra?",
            "9. Qual personagem folclórico costuma ser agradado pelos caçadores com a oferta de fumo?",
            "10. Em que período da pré-história o fogo foi descoberto?"
    };

    String OpcaoA[] = {
            "Tem entre 2 à 4 litros. São retirados 450 mililitros.",
            "França",
            "Vaticano e Rússia",
            "Jânio Quadros",
            "Duas",
            "113",
            "8",
            "12 minutos",
            "Caipora",
            "Neolítico"
    };

    String OpcaoB[] = {
            "Tem entre 4 à 6 litros. São retirados 450 mililitros.",
            "Inglaterra",
            "Nauru e China",
            "Jacinto Anjos",
            "Centenas",
            "109",
            "10",
            "1 dia",
            "Saci",
            "Paleolítico"
    };

    String OpcaoC[] = {
            "Tem 10 litros. São retirados 2 litros.",
            "Brasil",
            "Mônaco e Canadá",
            "Getúlio Vargas",
            "Trilhares",
            "108",
            "9",
            "12 horas",
            "Lobisomem",
            "Idade dos Metais"
    };

    String OpcaoD[] = {
            "Tem 7 litros. São retirados 1,5 litros.",
            "Austrália",
            "Malta e Estados Unidos",
            "João Figueiredo",
            "Vinte",
            "118",
            "5",
            "8 minutos",
            "Boitatá",
            "Período da Pedra Polida"
    };

    String OpcaoE [] = {
            "Tem 0,5 litros. São retirados 0,5 litros",
            "Itália",
            "São Marino e índia",
            "João Goulart",
            "Milhares",
            "92",
            "7",
            "10 segundos",
            "Negrinho do Pastoreio",
            "Idade Média"
    };

    private int[] listaRespostas = new int[Perguntas.length];
    private int listaGabarito[] = {2,3,1,5,3,4,5,4,1,2};
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
        Intent intent = new Intent(Game.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}