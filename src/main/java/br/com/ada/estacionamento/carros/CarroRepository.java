package br.com.ada.estacionamento.carros;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends CrudRepository<Carro, String> {
 List<Carro> findByMarca(String Marca);
 List<Carro> findByModelo(String Modelo);
 List<Carro> findByVagaIsNull();

}
