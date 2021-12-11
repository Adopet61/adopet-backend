package adopet.project.api.controllers;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.core.utilities.results.DataResult;
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
    public DataResult<List<Animal>> getAll() {
        return this.animalService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Animal> getById(@RequestParam int animalId) {
        return this.animalService.getById(animalId);
    }

    @GetMapping("/getbygender")
    public DataResult<List<Animal>> getByGender(@RequestParam String gender) {
        return this.animalService.getByGender(gender);
    }

    @GetMapping("/getbyyearofbirth")
    public DataResult<List<Animal>> getByYearOfBirth(@RequestParam int yearOfBirth) {
        return this.animalService.getByYearOfBirth(yearOfBirth);
    }

    @GetMapping("/getbyinfertilitystatus")
    public DataResult<List<Animal>> getByInfertilityStatus(@RequestParam String infertilityStatus) {
        return this.animalService.getByInfertilityStatus(infertilityStatus);
    }
    @GetMapping("/getbyanimalnamecontains")
    public DataResult<List<Animal>> getByAnimalNameContains(@RequestParam String animalName){
        return this.animalService.getByAnimalNameContains(animalName);
    }

    @GetMapping("/getbyanimalnamestartswith")
    public DataResult<List<Animal>> getByAnimalNameStartsWith(@RequestParam String animalName){
        return this.animalService.getByAnimalNameStartsWith(animalName);
    }

    @GetMapping("/getallbypage")
    public DataResult<List<Animal>> getall(int pageNo, int pageSize){
        return this.animalService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getalldesc")
    public DataResult<List<Animal>> getAllSorted() {
        return this.animalService.getAllSorted();
    }
}
