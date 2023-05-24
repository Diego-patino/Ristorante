package certus.edu.pe.controladores.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", "/inicio", "/logeo", "/login","/rest/**")
		.permitAll()
		.antMatchers("/pedidos/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/pedidos/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/pedidos/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/pedidos/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/pedidos/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		

		.antMatchers("/repartidores/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/repartidores/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/repartidores/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/repartidores/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/repartidores/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		

		.antMatchers("/usuario/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/usuario/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/usuario/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/usuario/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/usuario/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
	
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/home")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
		.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
		.withUser("christian").password(encoder.encode("christian")).roles("LECTOR").and()
		.withUser("diego").password(encoder.encode("diego")).roles("LECTOR","CREADOR").and()
		.withUser("abraham").password(encoder.encode("elena")).roles("LECTOR","DEPURADOR").and()
		.withUser("juan").password(encoder.encode("juan")).roles("EDITOR","LECTOR").and();

	}

}
