package br.com.security.controller;

import br.com.security.domain.commitment.CommitmentRepository;
import br.com.security.domain.commitment.Commitments;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/commitment")
public class Commitment {
    private Long id;
    private String description;
    private DateTimeFormat dateCommitmentInitial;
    private DateTimeFormat dateCommitmentFinal;

    @Autowired
    private CommitmentRepository repository;
    @PostMapping
    public String registerCommitment(@RequestBody @Valid Commitments commitments){
        repository.save(commitments);
        return "Compromisso cadastrado com sucesso! =)";
    }

    @GetMapping
    public List<Commitments> ListCommiment() {return repository.findAll();}

    @GetMapping("/{idUser}")
    public ArrayList<Commitments> ListCommimentById(@PathVariable("idUser") long idUser) {
        var commitments = repository.findAll();
        ArrayList<Commitments> commitmentsUser = new ArrayList<>();

        for(Commitments commitment : commitments){
            if (commitment.getIdUser() == idUser){
                commitmentsUser.add(commitment);
            }
        }
        return commitmentsUser;
    }
}
