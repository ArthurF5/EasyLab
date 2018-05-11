package com.moliveiralucas.easylab;
//

//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.moliveiralucas.easylab.domain.Cidade;
//import com.moliveiralucas.easylab.domain.Estado;
//import com.moliveiralucas.easylab.repositories.CidadeRepository;
//import com.moliveiralucas.easylab.repositories.EstadoRepository;
//
//@SpringBootApplication
//public class EasyLabApplication implements CommandLineRunner{

//	@Autowired
//	private CidadeRepository cidadeRepository;
//	@Autowired
//	private EstadoRepository estadoRepository;

//	public static void main(String[] args) {
//		SpringApplication.run(EasyLabApplication.class, args);
//		
//	}
//
//	@Override
//	public void run(String... args) throws Exception {

//		Estado est1 = new Estado(null, "Minas Gerais","MG");
//		Estado est2 = new Estado(null, "São Paulo","SP");
//		
//		Cidade c1 = new Cidade(null, "Uberlândia", est1);
//		Cidade c2 = new Cidade(null, "São Paulo", est2);
//		Cidade c3 = new Cidade(null, "Campinas", est2);
//		
//		est1.getCidades().addAll(Arrays.asList(c1));
//		est2.getCidades().addAll(Arrays.asList(c2, c3));
//
//		estadoRepository.saveAll(Arrays.asList(est1, est2));
//		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
//	}
//}

@SpringBootApplication
public class EasyLabApplication {
	public static void main(String[] args) {
		SpringApplication.run(EasyLabApplication.class, args);
	}
}
