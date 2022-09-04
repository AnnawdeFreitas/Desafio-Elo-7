package com.elosete.modelo;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Objects;

public class Posicao implements Serializable {

    private static final long serialVersionUID = -1507597262787255195L;
    private Integer x;
    private Integer y;

    @ConstructorProperties({ "x", "y" })
    public Posicao(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Boolean eMaiorOuIgualA(Posicao este) {
        return this.getX().compareTo(este.getX()) >= 0 &&
                this.getY().compareTo(este.getY()) >= 0;
    }

    public Boolean eMenorOuIgualA(Posicao este) {
        return this.getX().compareTo(este.getX()) >= 0 &&
                this.getY().compareTo(este.getY()) >= 0;
    }

    public Integer compareCom(Posicao este) {
        Integer resultado = this.getX().compareTo(este.getX());
        if (resultado == 0) {
            return this.getY().compareTo(este.getY());
        } else {
            return resultado;
        }
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Posicao)) {
            return false;
        }
        Posicao este = (Posicao) objeto;
        return Objects.equals(x, este.x) &&
                Objects.equals(y, este.y);
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString() {
        return (" ' " + x + " , " + y + " ' ");
    }

}