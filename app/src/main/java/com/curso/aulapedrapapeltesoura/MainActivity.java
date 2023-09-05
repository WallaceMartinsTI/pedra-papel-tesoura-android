package com.curso.aulapedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        verificarGanhador("pedra");
    };

    public void selecionarPapel(View view) {
        verificarGanhador("papel");
    };

    public void selecionarTesoura(View view) {
        verificarGanhador("tesoura");
    };

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);

        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp) {
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        };

        return escolhaApp;
    };

    int pontosApp = 0;
    int pontosJogador = 0;

    private void verificarGanhador(String escolhaUsuario) {
        String escolhaApp = gerarEscolhaAleatoriaApp();

        TextView campoPontosApp = findViewById(R.id.pontos_app);
        TextView campoPontosJogador = findViewById(R.id.pontos_jogador);

        TextView textEmpate = findViewById(R.id.text_empate);

        if(
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ) {
            campoPontosApp.setText(Integer.toString(++pontosApp));
            textEmpate.setText("");
        } else if(
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
            (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ) {
            campoPontosJogador.setText(Integer.toString(++pontosJogador));
            textEmpate.setText("");
        } else {
            textEmpate.setText("Empatou!");
        };
    };

    public void limparPontos(View view) {
        // Get fields
        TextView campoPontosApp = findViewById(R.id.pontos_app);
        TextView campoPontosJogador = findViewById(R.id.pontos_jogador);
        TextView textEmpate = findViewById(R.id.text_empate);
        ImageView imagemApp = findViewById(R.id.image_app);

        // Send data to layout
        imagemApp.setImageResource(R.drawable.padrao);
        campoPontosApp.setText(Integer.toString(0));
        campoPontosJogador.setText(Integer.toString(0));
        textEmpate.setText("");

        // Reset pontuation
        this.pontosApp = 0;
        this.pontosJogador = 0;
    };
}