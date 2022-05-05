package com.formacion.bosonit.BS4.application.service;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@Data
@ConfigurationProperties(prefix = "vars")
public class VarService {

    String var1;
    Integer var2;

    @Value("${Var3:\"No tiene Valor\"}")
    String var3;

    public String getVar1(){return var1;}
    public Integer getVar2(){return var2;}
    public String getVar3(){return var3;}

}
