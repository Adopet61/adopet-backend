package adopet.project.api.controllers;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.entities.concretes.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/animals")
@CrossOrigin
public class AnimalsControler {

    private AnimalService animalService;

    @Autowired
    public AnimalsControler(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/getall")
    public List<Animal> getAll() {
        return this.animalService.getAll();
    }
}
