package br.edu.ifpb.dac.gerenciadorSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.SystemRoleService;
import br.edu.ifpb.dac.gerenciadorSenha.model.repository.SystemRoleRepository;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.ApiControllerData;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.ApiControllerUser;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.AuthenticationController;
@SuppressWarnings("unused")
@EntityScan("br.edu.ifpb.dac.gerenciadorSenha.model.entity")
@EnableJpaRepositories(basePackages = "br.edu.ifpb.dac.gerenciadorSenha.model.repository")
@ComponentScan({"br.edu.ifpb.dac.gerenciadorSenha.presentation","br.edu.ifpb.dac.gerenciadorSenha.business.service",
"br.edu.ifpb.dac.gerenciadorSenha.presentation.dto","br.edu.ifpb.dac.gerenciadorSenha.model.dtoService", "br.edu.ifpb.dac.gerenciadorSenha.model.Interface",
"br.edu.ifpb.dac.gerenciadorSenha.model.entity","br.edu.ifpb.dac.gerenciadorSenha.config","br.edu.ifpb.dac.gerenciadorSenha.business.service","br.edu.ifpb.dac.gerenciadorSenha.business.Interface"})

@SpringBootApplication
@EnableWebMvc
public class GerenciadorDeSenhaApplication implements WebMvcConfigurer, CommandLineRunner{
	@Autowired
	private SystemRoleService repository;
	
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeSenhaApplication.class, args);
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE", "OPTIONS","PATCH");
	}
	@Override
	public void run(String... args) throws Exception {
		repository.createDefaultValues();
		
	}
}
