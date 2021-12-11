package adopet.project.api.controllers;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.entities.concretes.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/animals")
@CrossOrigin
public class AnimalsController {

    private AnimalService animalService;

    @Autowired
    public AnimalsController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/getall")
    public List<Animal> getAll() {
        return this.animalService.getAll();
    }

    @GetMapping("/getbyid")
    public Animal getById(@RequestParam int animalId) {
        return this.animalService.getById(animalId);
    }
}
