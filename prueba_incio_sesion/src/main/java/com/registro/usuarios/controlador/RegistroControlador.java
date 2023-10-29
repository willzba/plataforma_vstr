package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("fecha",new Date());
		return "index";
	}

	@GetMapping("/dasboard")
	public String verPaginaDasboard(Model modelo) {
		modelo.addAttribute("Estadistica", "-----Pagina de estadisticas----");
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "dasboard";
	}

	@GetMapping("/misVideos")
	public String verPaginaMisVideos(Model modelo) {
		modelo.addAttribute("videos", "-----Pagina videos del usuario----");
		return "misVideos";
	}


}
