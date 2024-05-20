package com.example.jpaadvance;

import com.example.jpaadvance.dao.AppDAO;
import com.example.jpaadvance.entity.Instructor;
import com.example.jpaadvance.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaadvanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaadvanceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
            findInstructor(appDAO);
//            deleteInstructor(appDAO);
        };
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id =2;
        appDAO.deleteInstructorById(id);
        System.out.println("Deteted");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorByID(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Bac", "Pham", "hobac@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/bomobun", "coding");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);

        appDAO.save(tempInstructor);

        System.out.println("Done");
    }

}
