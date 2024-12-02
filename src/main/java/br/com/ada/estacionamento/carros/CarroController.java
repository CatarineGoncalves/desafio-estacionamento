package br.com.ada.estacionamento.carros;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {

    public final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro){
        service.cadastrarCarro(carro);
        return ResponseEntity.created(null).body(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> estacionar(@RequestBody Carro carro){
        service.estacionar(carro);
        return ResponseEntity.ok(carro);
    }

}
