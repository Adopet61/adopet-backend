package adopet.project.api.controllers;

import adopet.project.business.abstracts.AnimalBreedService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.AnimalBreed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/animalBreeds")
public class AnimalBreedsController {

    private AnimalBreedService animalBreedService;

    @Autowired
    public AnimalBreedsController(AnimalBreedService animalBreedService) {
        this.animalBreedService = animalBreedService;
    }

    @GetMapping("/getAllBreeds")
    public DataResult<List<AnimalBreed>> getAll() {
        return this.animalBreedService.getAll();
    }

    @GetMapping("/getByBreedId")
    public DataResult<AnimalBreed> getByBreedId(@RequestParam int breedId) {
        return this.animalBreedService.getByBreedId(breedId);
    }

    @GetMapping("/getByTypeId")
    public DataResult<List<AnimalBreed>> getByAnimalType_TypeId(@RequestParam int typeId) {
        return this.animalBreedService.getByAnimalType_TypeId(typeId);
    }
    @PostMapping("/add")
    public Result add(@RequestBody AnimalBreed animalBreed )  {
        return this.animalBreedService.add(animalBreed);
    }

    @PutMapping("/update")
    public Result update(@RequestBody AnimalBreed animalBreed){
        return this.animalBreedService.update(animalBreed);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int breedId){
        return this.animalBreedService.delete(breedId);
    }

}
