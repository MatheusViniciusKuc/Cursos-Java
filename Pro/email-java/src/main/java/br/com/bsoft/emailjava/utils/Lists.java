package br.com.bsoft.emailjava.utils;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static List<String> formatosDeArquivo = new ArrayList<String>() {
        {
            add(".txt");
            add(".xml");
            //add(".zip");
        }
    };
}
