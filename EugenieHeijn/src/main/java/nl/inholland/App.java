package nl.inholland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class App
{
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

        logger.log(Level.INFO, "--- Exam Question 1 Completed ---");
        logger.log(Level.INFO, "--- Exam Question 2 Completed ---");
        logger.log(Level.INFO, "--- Exam Question 3 Completed ---");
        logger.log(Level.INFO, "--- Exam Question 4 Completed ---");
        logger.log(Level.INFO, "--- Exam Question 5 Completed ---");
        logger.log(Level.INFO, "--- Exam Question 6 Completed ---");
    }
}
