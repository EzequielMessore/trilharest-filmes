package com.opensanca.trilharest.filmes.filmes;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class FilmeTest {

    @Test
    public void foraDeExibicaoSeDatasNulas() {
        Filme filme = new Filme(null, null, null, null, null, null);
        LocalDate referencia = LocalDate.of(2017, 10, 21);
        boolean resultado = filme.emExibicao(referencia);

        Assert.assertFalse(resultado);
    }

    @Test
    public void emExibicaoSeDentroDeIntervaloDeDatas() {
        Filme filme = new Filme(
                null,
                null,
                null,
                null,
                LocalDate.of(2017,10,1),
                LocalDate.of(2017,10,30)
        );

        LocalDate referencia = LocalDate.of(2017, 10, 21);
        boolean resultado = filme.emExibicao(referencia);

        Assert.assertTrue(resultado);
    }

    @Test
    public void foraDeExibicaoSeForaDoIntervaloDeDatas() {
        Filme filme = new Filme(
                null,
                null,
                null,
                null,
                LocalDate.of(2016,10,1),
                LocalDate.of(2016,10,30)
        );

        LocalDate referencia = LocalDate.of(2017, 10, 21);
        boolean resultado = filme.emExibicao(referencia);

        Assert.assertFalse(resultado);
    }

    @Test
    public void foraExibicaoSeFimExibicaoNulo() {
        Filme filme = new Filme(
                null,
                null,
                null,
                null,
                LocalDate.of(2016,10,1),
                null
        );

        LocalDate referencia = LocalDate.of(2017, 10, 21);
        boolean resultado = filme.emExibicao(referencia);

        Assert.assertFalse(resultado);
    }

    @Test
    public void foraExibicaoSeInicioExibicaoNulo() {
        Filme filme = new Filme(
                null,
                null,
                null,
                null,
                null,
                LocalDate.of(2016,10,30)
        );

        LocalDate referencia = LocalDate.of(2017, 10, 21);
        boolean resultado = filme.emExibicao(referencia);

        Assert.assertFalse(resultado);
    }

    @Test
    public void emExibicaoSeInicioExatamenteHoje() {
        Filme filme = new Filme(
                null,
                null,
                null,
                null,
                LocalDate.of(2017,10,21),
                LocalDate.of(2017,10,21)
        );

        LocalDate referencia = LocalDate.of(2017, 10, 21);
        boolean resultado = filme.emExibicao(referencia);

        Assert.assertTrue(resultado);
    }

    @Test
    public void emExibicaoSeFimExatamenteHoje() {
        Filme filme = new Filme(
                null,
                null,
                null,
                null,
                LocalDate.of(2017,10,20),
                LocalDate.of(2017,10,21)
        );

        LocalDate referencia = LocalDate.of(2017, 10, 21);
        boolean resultado = filme.emExibicao(referencia);

        Assert.assertTrue(resultado);
    }
}
