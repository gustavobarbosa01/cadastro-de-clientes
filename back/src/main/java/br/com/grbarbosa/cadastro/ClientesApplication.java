package br.com.grbarbosa.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesApplication {

//    @Autowired
//    private ClienteRepository repository;
//
//    @Bean
//    public CommandLineRunner run(){
//        return args -> {
//            Cliente cliente = Cliente.builder()
//                    .cpf("00000000000")
//                    .nome("Gustavo Rodrigo Barbosa")
//                    .email("contato@email.com")
//                    .endereco("Rua José Batista de Almeida Sobrinho")
//                    .build();
//            repository.save(cliente);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}
