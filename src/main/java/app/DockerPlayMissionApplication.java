package app;

import model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import repo.MissionRepository;

@SpringBootApplication
@EnableMongoRepositories({"repo"})
public class DockerPlayMissionApplication implements CommandLineRunner {

    @Autowired
    MissionRepository missionRepository;

    public static void main(String[] args) {
        SpringApplication.run(DockerPlayMissionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        missionRepository.deleteAll();

        Mission mission = new Mission();
        mission.setName("Mission Imposable");
        mission.setId("1");
        mission.setDescription("Docker Containers and MicroServices - Mission Imposable");
        mission.setPointValue(2);

        missionRepository.save(mission);

        for (Mission mission1 : missionRepository.findAll()) {
            System.out.println(mission1.toString());
        }

    }
}
