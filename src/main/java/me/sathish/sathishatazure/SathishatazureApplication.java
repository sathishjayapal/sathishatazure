package me.sathish.sathishatazure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.sathish.sathishatazure.configprops.ApplicationProperties;
import me.sathish.sathishatazure.domain.data.Road;
import me.sathish.sathishatazure.domain.service.RoadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//Boot Should have this annotation to scan the ApplicationProperties
@ConfigurationPropertiesScan("me.sathish.sathishatazure.configprops")
@SpringBootApplication
public class SathishatazureApplication {
    public static void main(String[] args) {
        SpringApplication.run(SathishatazureApplication.class, args);
    }
}

@Component
@AllArgsConstructor
@ConfigurationPropertiesScan("me.sathish.sathishatazure.configprops")
class AppInitializer implements CommandLineRunner {
    @Value("${info.myapp.name}")
    private String appVersion;
    private final ApplicationProperties applicationInformation;
    private final RoadService roadService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The property value is " + appVersion);
        System.out.println("The application information is " + applicationInformation.getMyapp().getVersion());
        roadService.createRoad(new Road(null, "Infinite Loop", "Cupertino", "CA"));
        roadService.createRoad(new Road(null, "Apple CircleLet Le", "Cupertino", "CA"));
    }
}
