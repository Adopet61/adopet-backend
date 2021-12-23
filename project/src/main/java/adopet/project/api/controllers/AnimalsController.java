package adopet.project.api.controllers;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.Animal;
import adopet.project.entities.concretes.AnimalBreed;
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

    @GetMapping("/getByInfertilityStatus")
    public DataResult<List<Animal>> getByInfertilityStatus(@RequestParam String infertilityStatus) {
        return this.animalService.getByInfertilityStatus(infertilityStatus);
    }

    @GetMapping("/getByAnimalNameContains")
    public DataResult<List<Animal>> getByAnimalNameContains(@RequestParam String animalName){
        return this.animalService.getByAnimalNameContains(animalName);
    }

    @GetMapping("/getByAnimalNameStartsWith")
    public DataResult<List<Animal>> getByAnimalNameStartsWith(@RequestParam String animalName){
        return this.animalService.getByAnimalNameStartsWith(animalName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Animal>> getall(int pageNo, int pageSize){
        return this.animalService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Animal>> getAllSorted() {
        return this.animalService.getAllSorted();
    }

    @GetMapping("/getByTypeId")
    public DataResult<List<Animal>> getByAnimalType_TypeId(@RequestParam int typeId) {
        return this.animalService.getByAnimalType_TypeId(typeId);
    }

    @GetMapping("/getByBreedId")
    public DataResult<List<Animal>> getByAnimalBreed_BreedId(@RequestParam int breedId) {
        return this.animalService.getByAnimalBreed_BreedId(breedId);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Animal animal) {
        return this.animalService.add(animal);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Animal animal){
        return this.animalService.update((animal));
    }
}
