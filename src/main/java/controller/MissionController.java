package controller;

import model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repo.MissionRepository;

import java.util.List;

/**
 * Created by yb
 * on 6/12/17.
 */

@RestController
@RequestMapping("/mission")
public class MissionController {

    @Autowired
    MissionRepository missionRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Mission create(@RequestBody Mission mission) {

        Mission result = missionRepository.save(mission);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{missionId}")
    public Mission get(@PathVariable String missionId) {
        return missionRepository.findOne(missionId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Mission> getAll() {
        return missionRepository.findAll();
    }

}
