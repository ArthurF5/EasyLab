package com.moliveiralucas.EasyLab.servico;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moliveiralucas.EasyLab.model.Convenio;
import com.moliveiralucas.EasyLab.negocio.ConvenioNegocio;

@RestController
public class ConvenioServico {

	ConvenioNegocio mConvenioNegocio = new ConvenioNegocio();
	Gson mGson = new Gson();
	
	@RequestMapping(value = "/cadastrarConvenio/{convenio}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String cadastrarConvenio(@PathVariable String convenio) {
		Convenio mConvenio = new Convenio();
		mConvenio.setConvenio(convenio);
		return mGson.toJson(mConvenioNegocio.cadastrarConvenio(mConvenio));
	}
	
	@RequestMapping(value = "/alterarConvenio/{id_Convenio}_{convenio}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String alterarConvenio(@PathVariable String id_Convenio, @PathVariable String convenio) {
		Convenio mConvenio = new Convenio();
		mConvenio.setId_Convenio(Integer.parseInt(id_Convenio));
		mConvenio.setConvenio(convenio);
		return mGson.toJson(mConvenioNegocio.alterarConvenio(mConvenio));
	}
	
	@RequestMapping(value = "/excluirConvenio/{id_Convenio}_{convenio}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String excluirConvenio(@PathVariable String id_Convenio, @PathVariable String convenio) {
		Convenio mConvenio = new Convenio();
		mConvenio.setId_Convenio(Integer.parseInt(id_Convenio));
		mConvenio.setConvenio(convenio);
		return mGson.toJson(mConvenioNegocio.excluirConvenio(mConvenio));
	}
	
	@RequestMapping(value = "/consultarConvenio/{parametroBusca}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	public @ResponseBody String consultarConvenio(@PathVariable String parametroBusca) {
		return mGson.toJson(mConvenioNegocio.consultarConvenio(parametroBusca));
	}
}
