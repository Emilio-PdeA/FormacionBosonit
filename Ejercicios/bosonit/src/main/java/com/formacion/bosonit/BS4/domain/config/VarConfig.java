package com.formacion.bosonit.BS4.domain.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "config")
public class VarConfig {

    //@Value("${PRUEBA1}")
    String prb1;


    Integer prb2;

    public String getPrb1() {
        return prb1;
    }

    public void setPrb1(String prb1) {
        this.prb1 = prb1;
    }

    public Integer getPrb2() {
        return prb2;
    }

    public void setPrb2(Integer prb2) {
        this.prb2 = prb2;
    }

    @Override
    public String toString() {
        return "VarConfig{" +
                "prb1='" + prb1 + '\'' +
                ", prb2=" + prb2 +
                '}';
    }
}
