package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.dto.TopicoDto;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso != null) {
            return TopicoDto.converter(topicoRepository.findByCursoNome(nomeCurso));
        }
        return TopicoDto.converter(topicoRepository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@Valid @RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{topicoId}")
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long topicoId) {
        Optional<Topico> topico = topicoRepository.findById(topicoId);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{topicoId}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long topicoId,
            @Valid @RequestBody AtualizacaoTopicoForm form) {
        Optional<Topico> topicoOp = topicoRepository.findById(topicoId);
        if (topicoOp.isPresent()) {
            Topico topico = form.atualizar(topicoId, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{topicoId}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long topicoId) {
        Optional<Topico> topico = topicoRepository.findById(topicoId);
        if (topico.isPresent()) {
            topicoRepository.deleteById(topicoId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
