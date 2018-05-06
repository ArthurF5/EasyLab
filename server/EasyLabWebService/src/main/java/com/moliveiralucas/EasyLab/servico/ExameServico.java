package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.RestController;

import com.moliveiralucas.EasyLab.negocio.ExameNegocio;

@RestController
public class ExameServico {
	ExameNegocio mExameNegocio = new ExameNegocio();
}
