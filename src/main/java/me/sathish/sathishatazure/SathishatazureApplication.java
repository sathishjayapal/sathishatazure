package me.sathish.sathishatazure;

import me.sathish.sathishatazure.configprops.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
//Boot Should have this annotation to scan the ApplicationProperties
@ConfigurationPropertiesScan("me.sathish.sathishatazure.configprops")
public class SathishatazureApplication {
    public static void main(String[] args) {
        SpringApplication.run(SathishatazureApplication.class, args);
    }
}

@Component
class AppInitializer implements CommandLineRunner {
    @Value("${info.myapp.name}")
    private String appVersion;
    @Autowired
    ApplicationProperties applicationInformation;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The property value is " + appVersion);
        System.out.println("The application information is " + applicationInformation.getMyapp().getVersion());
    }
}
