package me.sathish.sathishatazure.configprops;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ConfigurationProperties(prefix = "info")
@ConstructorBinding
@Validated
public class ApplicationProperties {
    public ApplicationProperties(MyApp myapp) {
        this.myapp = myapp;
    }

    private final MyApp myapp;

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "myapp.version=" + myapp.getVersion() +
                '}';
    }

    public MyApp getMyapp() {
        return myapp;
    }

    /**
     * This has to be a static class to refer the member variables
     **/
    public static class MyApp {
        @Pattern(regexp = "^[0-9]\\.[0-9]\\.[0-9]$")
        private final String version;
        @NotEmpty
        private final String author;

        public MyApp(String version, String author) {
            this.version = version;
            this.author = author;
        }

        public String getVersion() {
            return version;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "MyApp{" +
                    "version='" + version + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }
}

