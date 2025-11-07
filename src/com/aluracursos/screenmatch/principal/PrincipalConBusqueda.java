package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.exceptions.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Optional;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de una pelicula: ");
        var busqueda = lectura.nextLine();

        String direccion = "https://www.omdbapi.com/?t=" +
                busqueda.replace(" ", "+") +
                "&apikey=34fda6c7";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);


            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb miTitulooMDB = gson.fromJson(json, TituloOmdb.class);
            System.out.println(miTitulooMDB);


            Titulo miTitulo = new Titulo(miTitulooMDB);
            System.out.println("----Titulo ya convertido: " + miTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Error el URI, verifique la dirección.");
        } catch (ErrorEnConversionDeDuracionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(" ¡Finalizó la ejecución del programa! ");

    }
}
