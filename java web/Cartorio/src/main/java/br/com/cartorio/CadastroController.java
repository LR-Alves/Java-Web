package br.com.cartorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cartorio.model.Cadastro;
import br.com.cartorio.service.CadastroService;

@Controller
public class CadastroController {
	
	@Autowired
	private CadastroService service;
	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listacadastrados")
	public String listacadastrados(Model model){
		
		Iterable<Cadastro> cadastrados = service.obterTodos();
		
		model.addAttribute("cadastrados", cadastrados);
		
		return "listacadastrados";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email")String email, 
			@RequestParam("telefone") String telefone, Model model){
		
		Cadastro novoCadastro = new Cadastro(nome, email, telefone);
		
		service.salvar(novoCadastro);
		
	/* new EmailService().enviar(nome, email); */
		
		Iterable<Cadastro> cadastros = service.obterTodos();
		
		
		model.addAttribute("cadastros", cadastros);
		
		return "listacadastros";
		
	}
	
}