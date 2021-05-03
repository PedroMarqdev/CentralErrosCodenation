@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");// <- Obrigado Nando Luiz pelo código no stackoverflow!
    }
}
