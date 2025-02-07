package com.br.relacao.de.tabelas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.relacao.de.tabelas.models.Login;
import com.br.relacao.de.tabelas.models.Usuario;
import com.br.relacao.de.tabelas.services.LoginService;
import com.br.relacao.de.tabelas.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/")
	public ModelAndView exibirUsuarios() {
		ModelAndView modelAndView = new ModelAndView("usuario.html");
		modelAndView.addObject("usuarios", usuarioService.pegarTodosUsuarios());
		return modelAndView;
	}

	@PostMapping("/")
	public ModelAndView salvarUsuario(@Valid Usuario user, BindingResult bindingUse, @Valid Login log,
			BindingResult bindingLog) {
		ModelAndView modelAndView = new ModelAndView("usuario.html");
		if (bindingUse.hasErrors() || bindingLog.hasErrors()) {
			List<String> msgs = new ArrayList<String>();
			for (ObjectError objetoerro : bindingUse.getAllErrors()) {
				msgs.add(objetoerro.getDefaultMessage());
			}
			modelAndView.addObject("msgs", msgs);
		}else {
			modelAndView.addObject("msgs", loginService.salvarUsuario(user, log));
		}
		return modelAndView;
	}

}
