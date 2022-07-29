package br.com.bsoft.emailjava.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.activation.DataHandler;
import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import br.com.bsoft.emailjava.utils.Lists;

@Service
public class ConversorDeAnexos {

    private List<EmpresaAndAnexos> empresasEAnexos;
    private Integer ultimoId = 1;

    public ConversorDeAnexos(List<EmpresaAndAnexos> empresasEAnexos) {
        this.empresasEAnexos = empresasEAnexos;
    }

    public void renderizarAnexos() throws MessagingException, IOException {
        for (EmpresaAndAnexos empresaAndAnexos : empresasEAnexos) {
            for (DataHandler anexo : empresaAndAnexos.getAnexos()) {
                for (String type : Lists.formatosDeArquivo) {
                    if (anexo.getName().contains(type)) {
                        String nomeSemTipo = anexo.getName().replace(type, "");
                        conversorTxtAndXML(anexo, empresaAndAnexos.getEmpresa(), nomeSemTipo, type);
                    }
                }

            }
        }

    }

    // "Arquivos\\" + empresa.getNome() + "\\" + ultimoId + "_" + empresa.getId() +
    // "_" + nomeArquivo + type)
    // "Arquivos\\" + empresa.getNome() + "\\" +
    // new FileOutputStream(new File(diretorio + "\\" + nomeArquivo + type)));
    private void conversorTxtAndXML(DataHandler anexo, Empresa empresa, String nomeArquivo, String type)
            throws UnsupportedEncodingException, IOException {
        String diretorio = "Arquivos\\" + empresa.getNome();
        String nomeDoArquivo = diretorio + "\\" + ultimoId + "_" + empresa.getId() + "_" + nomeArquivo + type;
        criarDiretorioInexistente(new File(diretorio));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream(new File(nomeDoArquivo)));

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(anexo.getInputStream(), "UTF-8"));

        List<String> lista = bufferedReader.lines().toList();
        for (String string : lista) {
            bufferedWriter.write(string);
        }
        bufferedWriter.close();
        bufferedReader.close();
        bufferedWriter.close();

    }

    private void criarDiretorioInexistente(File diretorio) {
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
    }
}
