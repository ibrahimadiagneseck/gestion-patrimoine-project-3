package sn.douanes.gestionstockpostgres.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import sn.douanes.gestionstockpostgres.filter.CsrfCookieFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(List.of("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                })).csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact","/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests)->requests

//
//                                .requestMatchers("/FonctionAgents").hasRole("USER")
//                                .requestMatchers("/AjouterFonctionAgent").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamFonctionAgent").hasRole("USER")
//                                .requestMatchers("/ModifierFonctionAgent").hasRole("USER")
//                                .requestMatchers("/SupprimerFonctionAgentById/*").hasRole("USER")
//
//                                .requestMatchers("/CorpsAgents").hasRole("USER")
//                                .requestMatchers("/AjouterCorpsAgent").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamCorpsAgent").hasRole("USER")
//                                .requestMatchers("/ModifierCorpsAgent").hasRole("USER")
//                                .requestMatchers("/SupprimerCorpsAgentById/*").hasRole("USER")
//
//                                .requestMatchers("/TypeUniteDouanieres").hasRole("USER")
//                                .requestMatchers("/AjouterTypeUniteDouaniere").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamTypeUniteDouaniere").hasRole("USER")
//                                .requestMatchers("/ModifierTypeUniteDouaniere").hasRole("USER")
//                                .requestMatchers("/SupprimerTypeUniteDouaniereById/*").hasRole("USER")
//
//                                .requestMatchers("/MarqueVehicules").hasRole("USER")
//                                .requestMatchers("/AjouterMarqueVehicule").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamMarqueVehicule").hasRole("USER")
//                                .requestMatchers("/ModifierMarqueVehicule").hasRole("USER")
//                                .requestMatchers("/SupprimerMarqueVehiculeById/*").hasRole("USER")
//
//                                .requestMatchers("/TypeVehicules").hasRole("USER")
//                                .requestMatchers("/AjouterTypeVehicule").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamTypeVehicule").hasRole("USER")
//                                .requestMatchers("/ModifierTypeVehicule").hasRole("USER")
//                                .requestMatchers("/SupprimerTypeVehiculeById/*").hasRole("USER")
//
//                                .requestMatchers("/Prestataires").hasRole("USER")
//                                .requestMatchers("/AjouterPrestataires").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamPrestataires").hasRole("USER")
//                                .requestMatchers("/ModifierPrestataires").hasRole("USER")
//                                .requestMatchers("/SupprimerPrestatairesById/*").hasRole("USER")
//
//                                .requestMatchers("/SecteurActivite").hasRole("USER")
//                                .requestMatchers("/AjouterSecteurActivite").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamSecteurActivite").hasRole("USER")
//                                .requestMatchers("/ModifierSecteurActivite").hasRole("USER")
//                                .requestMatchers("/SupprimerSecteurActiviteById/*").hasRole("USER")
//
//                                .requestMatchers("/PrestatairesSecteurs").hasRole("USER")
//                                .requestMatchers("/AjouterPrestatairesSecteurs").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamPrestatairesSecteur").hasRole("USER")
//                                .requestMatchers("/ModifierPrestatairesSecteur").hasRole("USER")
//                                .requestMatchers("/SupprimerPrestatairesSecteurById/*").hasRole("USER")
//
//                                .requestMatchers("/UniteDouanieres").hasRole("USER")
//                                .requestMatchers("/AjouterUniteDouaniere").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamUniteDouaniere").hasRole("USER")
//                                .requestMatchers("/ModifierUniteDouaniere").hasRole("USER")
//                                .requestMatchers("/SupprimerUniteDouaniereById/*").hasRole("USER")
//
//                                .requestMatchers("/Sections").hasRole("USER")
//                                .requestMatchers("/AjouterSections").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamSections").hasRole("USER")
//                                .requestMatchers("/ModifierSections").hasRole("USER")
//                                .requestMatchers("/SupprimerSectionsById/*").hasRole("USER")
//
//                                .requestMatchers("/TypeObjets").hasRole("USER")
//                                .requestMatchers("/AjouterTypeObjet").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamTypeObjet").hasRole("USER")
//                                .requestMatchers("/ModifierTypeObjet").hasRole("USER")
//                                .requestMatchers("/SupprimerTypeObjetById/*").hasRole("USER")
//
//                                .requestMatchers("/Agents").hasRole("USER")
//                                .requestMatchers("/AjouterAgent").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamAgent").hasRole("USER")
//                                .requestMatchers("/ModifierAgent").hasRole("USER")
//                                .requestMatchers("/SupprimerAgentById/*").hasRole("USER")
//
//                                .requestMatchers("/BordereauLivraisons").hasRole("USER")
//                                .requestMatchers("/AjouterBordereauLivraison").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamBordereauLivraison").hasRole("USER")
//                                .requestMatchers("/ModifierBordereauLivraison").hasRole("USER")
//                                .requestMatchers("/SupprimerBordereauLivraisonById/*").hasRole("USER")
//
//                                .requestMatchers("/BonEntrees").hasRole("USER")
//                                .requestMatchers("/AjouterBonEntree").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamBonEntree").hasRole("USER")
//                                .requestMatchers("/ModifierBonEntree").hasRole("USER")
//                                .requestMatchers("/SupprimerBonEntreeById/*").hasRole("USER")
//
//                                .requestMatchers("/ArticleBonEntrees").hasRole("USER")
//                                .requestMatchers("/AjouterArticleBonEntree").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamArticleBonEntree").hasRole("USER")
//                                .requestMatchers("/ModifierArticleBonEntree").hasRole("USER")
//                                .requestMatchers("/SupprimerArticleBonEntree/*").hasRole("USER")
//
//                                .requestMatchers("/Pays").hasRole("USER")
//                                .requestMatchers("/AjouterPays").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamPays").hasRole("USER")
//                                .requestMatchers("/ModifierPays").hasRole("USER")
//                                .requestMatchers("/SupprimerPaysById/*").hasRole("USER")
//
//                                .requestMatchers("/Vehicules").hasRole("USER")
//                                .requestMatchers("/AjouterVehicule").hasRole("USER")
//                                .requestMatchers("/AjouterRequestParamVehicule").hasRole("USER")
//                                .requestMatchers("/ModifierVehicule").hasRole("USER")
//                                .requestMatchers("/SupprimerVehiculeById/*").hasRole("USER")

                                 .requestMatchers("/**").permitAll()

                )
                .oauth2ResourceServer(oauth2ResourceServerCustomizer ->
                        oauth2ResourceServerCustomizer.jwt(jwtCustomizer -> jwtCustomizer.jwtAuthenticationConverter(jwtAuthenticationConverter)));
        return http.build();
    }


}