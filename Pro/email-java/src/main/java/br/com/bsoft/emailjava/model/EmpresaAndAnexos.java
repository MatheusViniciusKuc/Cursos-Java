package br.com.bsoft.emailjava.model;

import java.util.List;

import javax.activation.DataHandler;

import lombok.Getter;

@Getter
public class EmpresaAndAnexos {

    private Empresa empresa;
    private List<DataHandler> anexos;

    public EmpresaAndAnexos(Empresa empresa, List<DataHandler> anexos) {
        this.empresa = empresa;
        this.anexos = anexos;
    }
}
