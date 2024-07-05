package dev.jmv.loadjson;

import dev.jmv.loadjson.model.Employee;
import dev.jmv.loadjson.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import java.util.List;

@SpringBootApplication
public class SbloadjsonApplication implements CommandLineRunner{
    @Value("classpath:data/employees.json")
    Resource resource;
    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SbloadjsonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Employee>> typeReference = new TypeReference<>() {
        };
        try {
            List<Employee> employees = mapper.readValue(resource.getInputStream(), typeReference);
            repository.saveAll(employees);
            System.out.println(repository.findAll());
        }catch (Exception e){
            System.err.println("Error loading data "+e);
        }
    }
}
