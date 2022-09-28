package me.sathish.sathishatazure;

import lombok.AllArgsConstructor;
import me.sathish.sathishatazure.configprops.ApplicationProperties;
import me.sathish.sathishatazure.domain.JobApplication.service.JobApplicationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

//Boot Should have this annotation to scan the ApplicationProperties
@ConfigurationPropertiesScan("me.sathish.sathishatazure.configprops")
@SpringBootApplication
public class JobTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobTrackerApplication.class, args);
    }
}

@Component
@AllArgsConstructor
@ConfigurationPropertiesScan("me.sathish.sathishatazure.configprops")
class AppInitializer implements CommandLineRunner {

    private final ApplicationProperties applicationInformation;
    private final JobApplicationService roadService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The application information is " + applicationInformation.getMyapp().getVersion());
    }
}
