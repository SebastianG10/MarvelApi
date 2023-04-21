package com.juansebastiangarciahincapie.marvelapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.juansebastiangarciahincapie.marvelapi.service.marvel.model.Result;
import com.juansebastiangarciahincapie.marvelapi.service.marvel.model.Root;

import java.net.URL;

import cafsoft.foundation.HTTPURLResponse;
import cafsoft.foundation.URLComponents;
import cafsoft.foundation.URLQueryItem;
import cafsoft.foundation.URLSession;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLComponents comp = new URLComponents();
        comp.setScheme("https");
        comp.setHost("gateway.marvel.com");
        comp.setPath("/v1/public/characters");
        comp.setQueryItems(new URLQueryItem[]{
                new URLQueryItem("hash", "c9e9457d4061f013c4595a1eb5eacd26"),
                new URLQueryItem("ts", "2001"),
                new URLQueryItem("apikey","b1e40bd0089910f132340589ad757a50"),
                new URLQueryItem("name","iron Man")

        });
        Log.d("Url", comp.getURL().toString());

        URL url = comp.getURL();
        URLSession.getShared().dataTask(url, (data, response, error) ->{
            HTTPURLResponse resp = (HTTPURLResponse) response;
            if(error == null){
                if(resp.getStatusCode() == 200){
                    Log.d("resp", data.toText());
                }

            }else{
                Log.d("Error", "error de red");
            }
        }).resume();
    }

    public void showInfo(Root root){
        if(root != null){
            if (root.data.getResults().size() > 0){
                Result result = root.data.getResults().get(0);
                Log.d("Message",result.description);
            }
        }

    }
}