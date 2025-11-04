package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;


public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(180);
        System.out.println("Duración de la Pelicula" + miPelicula.getDuracionEnMinutos());

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        System.out.println("Suma de Evaluaciones: " + miPelicula.getSumaDeLasEvaluaciones());
        System.out.println("Total de las evaluaciones: " + miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());


        Serie lost = new Serie("Lost", 2000);
        lost.muestraFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duración de la serie: " + lost.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.setDuracionEnMinutos(200);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(otraPelicula);
        calculadora.incluye(lost);
        System.out.println(calculadora.getTiempoTotal());
        System.out.println("--------------------");
        System.out.println("Tiempo necesario para ver tus titulos estas vacaciones: " + calculadora.getTiempoTotal() + " minutos.");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        System.out.println("------Evaluacion de Pelicula de ScreenMatch: ------");
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);
        System.out.println("------Evaluacion de episiodios de series de ScreenMatch: ------");
        filtroRecomendacion.filtra(episodio);


        System.out.println("-------------- Lista de Pelicualas con ArrayList --------------");

        var peliculaDeBruno = new Pelicula("El señor de los anillos.", 2001);
        peliculaDeBruno.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño de la lista es: " + listaDePeliculas.size());
        System.out.println("La primera película es: " + listaDePeliculas.get(0).getNombre());

        System.out.println("Los Id's que se muestran son referencia de los objetos en memoria.");
        System.out.println(listaDePeliculas);


        System.out.println("------------- to String ------------");
        System.out.println(listaDePeliculas.toString());

        System.out.println("toString de la Pelicula: " + listaDePeliculas.get(0).toString());










        //otraPelicula.muestraFichaTecnica();

        //direccion en memoria de los objetos
        //System.out.println(miPelicula);
        //System.out.println(otraPelicula);

    }
}
