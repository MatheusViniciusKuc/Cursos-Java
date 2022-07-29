package br.com.bsoft.emailjava.model;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bsoft.emailjava.repository.EmailRepository;

@Controller
@RequestMapping("Erro")
public class teste {

    @Autowired
    EmailRepository emailRepository;
    @Autowired
    private LeitorDeEmail leitor;

    @GetMapping
    public String este() {
        List<Email> emails = emailRepository.findAll();
        List<EmpresaAndAnexos> empresasAndAnexos = new ArrayList<>();
        // ConversorDeAnexos c = new ConversorDeAnexos();
        // c.renderizarAnexos(email.getEmail(), email.getPassword());
        try {
            for (Email email : emails) {
                List<DataHandler> anexos = new ArrayList<>();
                anexos = leitor.leitorDeArquivos(email.getEmail(), email.getPassword());
                EmpresaAndAnexos empresaAndAnexos = new EmpresaAndAnexos(email.getEmpresa(), anexos);
                empresasAndAnexos.add(empresaAndAnexos);
            }
            ConversorDeAnexos conversorDeAnexos = new ConversorDeAnexos(empresasAndAnexos);
            conversorDeAnexos.renderizarAnexos();
            return "home";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
