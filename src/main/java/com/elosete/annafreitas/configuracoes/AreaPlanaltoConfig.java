package com.elosete.annafreitas.configuracoes;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "areaplanalto")
public class AreaPlanaltoConfig {

    private Limite limite = new Limite();

    public Limite getLimite() {
        return limite;
    }

    public void setLimite(Limite limite) {
        this.limite = limite;
    }

    public static class Limite implements Serializable {
        private Integer x;
        private Integer y;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }

}
