package br.anhembi.spring01.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.AppUser;

@RestController
@RequestMapping("/produto")
public class produtoController {

    @GetMapping
    public String hello() {
        return "Bom dia!";
    }

    @GetMapping("/{valor}")
    public String multiplica(@PathVariable int valor) {
        return "Resposta: "+ (valor * 2);
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody AppUser user) {
        if(user.getName().equals("emerson") && 
            user.getPassword().equals("1234")) {
            return ResponseEntity.ok("Acesso liberado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
