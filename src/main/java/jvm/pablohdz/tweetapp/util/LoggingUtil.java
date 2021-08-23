package jvm.pablohdz.tweetapp.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

@Configuration
public class LoggingUtil {

    @Bean
    public void initLogManager() throws IOException {
        LogManager.getLogManager()
                .readConfiguration(
                        new FileInputStream("src/main/resources/logging.properties"));
    }
}
