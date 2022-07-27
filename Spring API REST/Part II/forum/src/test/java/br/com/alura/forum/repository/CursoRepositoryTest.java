package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.model.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("teste")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;
    @Autowired
    private TestEntityManager em;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
        String nomeCurso = "Spring Boot";

        Curso spring = new Curso();
        spring.setNome(nomeCurso);
        spring.setCategoria("Programação");
        em.persist(spring);

        Curso curso = repository.findByNome(nomeCurso);
        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void naoDeveriaCarregarUmCursoAoBuscarPeloSeuNome() {
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);
        Assert.assertNull(curso);
    }
}
