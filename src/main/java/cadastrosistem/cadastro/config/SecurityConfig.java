package cadastrosistem.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. ATIVAR CORS
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // 2. DESATIVAR CSRF (Crucial para o erro 403)
                .csrf(csrf -> csrf.disable())

                // 3. REGRAS DE AUTORIZAÇÃO
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Permite login e registo
                        .requestMatchers("/api/imoveis/**").permitAll() // Permite gerir imóveis (temporário para testes)
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Permite a origem do Angular
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));

        // Permite os métodos necessários
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Permite todos os cabeçalhos
        configuration.setAllowedHeaders(List.of("*"));

        // Permite credenciais se necessário futuramente
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Aplica a configuração a todos os endpoints
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
