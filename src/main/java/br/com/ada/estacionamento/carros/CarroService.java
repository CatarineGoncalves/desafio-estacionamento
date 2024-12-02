package br.com.ada.estacionamento.carros;

import br.com.ada.estacionamento.vagas.Vaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    public CarroRepository carroRepository;

    public void cadastrarCarro(Carro carro){

        carroRepository.save(carro);

    }

    public void estacionar(Carro carro)  {
        Vaga vaga = carro.getVaga();

        //se o carro tem uma vaga para ele
        if(vaga == null) {
            throw new IllegalArgumentException("Não possui vaga para esse carro");
        }

        //se tem vaga, se já esta ocupad
        if (vaga.isOcupada()) {
            throw new IllegalArgumentException("A vaga já está ocupada!");
        }

        //carro estacionado em outro lugar
        Carro carroEstacionado = carroRepository.findById(carro.getPlaca()).orElse(null);

        if(carroEstacionado != null && carroEstacionado.getVaga() != null) {
            System.out.println("o carro está em outra vaga");
        }


        vaga.setOcupada(true);
        carro.setVaga(vaga);

        carroRepository.save(carro);
    }

}
