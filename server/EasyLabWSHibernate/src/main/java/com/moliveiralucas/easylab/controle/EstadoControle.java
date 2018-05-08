package com.moliveiralucas.easylab.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.easylab.entidade.Estado;

@RestController
@RequestMapping(value = "/estados")
public class EstadoControle {

	@RequestMapping(method = RequestMethod.GET)
	public List<Estado> listar() {
		Estado est01 = new Estado(1, "Goiás", "GO");
		Estado est02 = new Estado(2, "Mato Grosso", "MT");
		Estado est03 = new Estado(3, "São Paulo", "SP");

		List<Estado> lista = new ArrayList<>();
		lista.add(est01);
		lista.add(est02);
		lista.add(est03);
		return lista;
	}
}
