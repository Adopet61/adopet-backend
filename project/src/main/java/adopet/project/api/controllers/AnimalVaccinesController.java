package adopet.project.api.controllers;

import adopet.project.business.abstracts.AnimalVaccineService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.AnimalVaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/animalVaccines")
public class AnimalVaccinesController {

    private AnimalVaccineService animalVaccineService;

    @Autowired
    public AnimalVaccinesController(AnimalVaccineService animalVaccineService) {
        this.animalVaccineService = animalVaccineService;
    }

    @GetMapping("/getallAnimalVaccines")
    public DataResult<List<AnimalVaccine>> getAll() {
        return this.animalVaccineService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody AnimalVaccine animalVaccine )  {
        return this.animalVaccineService.add(animalVaccine);

    }

}
