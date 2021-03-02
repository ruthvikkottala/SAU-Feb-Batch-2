package auaop;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages="auaop")
public class Config {
	@Bean
	public Rectangle rectangle() {
		return new Rectangle();
	}

}
