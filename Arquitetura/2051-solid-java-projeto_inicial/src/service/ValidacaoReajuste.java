package service;

import java.math.BigDecimal;

import br.com.alura.rh.model.Funcionario;

public interface ValidacaoReajuste {

    void validadar(Funcionario funcionario, BigDecimal aumento);
}
