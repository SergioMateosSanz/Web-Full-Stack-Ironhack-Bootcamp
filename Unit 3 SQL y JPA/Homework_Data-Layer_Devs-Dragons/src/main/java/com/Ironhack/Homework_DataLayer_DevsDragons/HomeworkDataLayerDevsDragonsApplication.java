package com.Ironhack.Homework_DataLayer_DevsDragons;


import com.Ironhack.Homework_DataLayer_DevsDragons.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HomeworkDataLayerDevsDragonsApplication implements CommandLineRunner {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    private static int exitCode;


    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(HomeworkDataLayerDevsDragonsApplication.class, args);
        exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
    }

    @Override
    public void run(String... args) {
        Main.init(leadRepository, accountRepository, opportunityRepository, contactRepository, userRepository);
        Main.mainExecution();
    }

    public static int getExitCode() {
        return exitCode;
    }

    public static void setExitCode(int exitCode) {
        HomeworkDataLayerDevsDragonsApplication.exitCode = exitCode;
    }
}
