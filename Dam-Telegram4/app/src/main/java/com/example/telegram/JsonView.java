package com.example.telegram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class JsonView extends AppCompatActivity {

    private ListView listView;
    private ContAdapter adapter;
    private JSONRead jsonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_json);

        listView=findViewById(R.id.listview);

        adapter=new ContAdapter(createList());
        listView.setAdapter(adapter);

        jsonRead=new JSONRead();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                jsonRead.read("https://jsonkeeper.com/b/RGQS", new IResponse() {
                    @Override
                    public void onSuccess(List<Cont> list) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.updateList(list);
                            }
                        });


                    }

                    @Override
                    public void onError(String errorMessage) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(JsonView.this, errorMessage, Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                });

            }
        });

        thread.start();

    }

    private List<Cont> createList(){
        ArrayList<Cont> lista=new ArrayList<>();

        Cont cont1=new Cont("Eric", 23, "test1@gmail.com");
        Cont cont2=new Cont("Mihaela", 24, "test2@gmail.com");
        Cont cont3=new Cont("Dima", 27, "test3@gmail.com");


        lista.add(cont1);
        lista.add(cont2);
        lista.add(cont3);

        return lista;
    }
}