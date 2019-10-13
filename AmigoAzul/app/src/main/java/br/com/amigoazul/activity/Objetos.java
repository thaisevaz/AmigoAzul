package br.com.amigoazul.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.amigoazul.R;
import br.com.amigoazul.adapter.ListarObjetosAdapter;
import br.com.amigoazul.adapter.ListarSentimentosAdapter;

public class Objetos extends AppCompatActivity {

    //instanciar outras classes
    Splash_Activity splash_activity = new Splash_Activity();

    List <File> listaArquivos = new ArrayList <>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//esconder a actionBar
        setContentView(R.layout.objetos);

        CARREGAR_FOTOS_OBJETOS();

    }



    //https://www.viralandroid.com/2016/02/android-listview-with-image-and-text.html
    //https://www.tutorialspoint.com/android/android_camera.html
    //https://pt.stackoverflow.com/questions/119792/carregar-imageview-usando-caminho-da-imagem
    //https://stackoverflow.com/questions/8646984/how-to-list-files-in-an-android-directory
    public void CARREGAR_FOTOS_OBJETOS() {
        File diretorio = new File(splash_activity.meuDirObjetos.getAbsolutePath());
        if (diretorio.exists()) {
            Log.e("OBJETOS", "a pasta é " + diretorio.getAbsolutePath());
            File[] files = diretorio.listFiles();
            Log.e("OBJETOS", "total de arquivos no diretorio: " + files.length);
            listaArquivos.clear();
            for (int i = 0; i < files.length; i++) {
                Log.e("OBJETOS", "diretorio completo: " + diretorio + "/" + files[i].getName());
                listaArquivos.add(files[i]);
            }
            //https://acomputerengineer.wordpress.com/2018/04/15/display-image-grid-in-recyclerview-in-android/
            RecyclerView recyclerView = findViewById(R.id.rcrtvw_listarObjetos);

            StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(sglm);

            ListarObjetosAdapter listarObjetosAdapter = new ListarObjetosAdapter(Objetos.this,listaArquivos);
            recyclerView.setAdapter(listarObjetosAdapter);

        }

    }
}
