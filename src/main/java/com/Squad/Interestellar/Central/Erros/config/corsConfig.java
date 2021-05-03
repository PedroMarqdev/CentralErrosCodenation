@Configuration
@EnableWebMvc
public class corsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");// <- Obrigado Nando Luiz pelo código no stackoverflow!
    }
}
