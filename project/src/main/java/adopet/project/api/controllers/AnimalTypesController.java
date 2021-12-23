package adopet.project.api.controllers;

import adopet.project.business.abstracts.AnimalTypeService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.AnimalBreed;
import adopet.project.entities.concretes.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/animalTypes")
public class AnimalTypesController {

    private AnimalTypeService animalTypeService;

    @Autowired
    public AnimalTypesController(AnimalTypeService animalTypeService) {
        this.animalTypeService = animalTypeService;
    }

    @GetMapping("/getAllTypes")
    public DataResult<List<AnimalType>> getAll() {
        return this.animalTypeService.getAll();
    }

    @GetMapping("/getByTypeId")
    public DataResult<AnimalType> getByTypeId(@RequestParam int typeId) {
        return this.animalTypeService.getByTypeId(typeId);
    }
    @PostMapping("/add")
    public Result add(@RequestBody AnimalType animalType)  {
        return this.animalTypeService.add(animalType);
    }
    @PostMapping("/update")
    public Result update(@RequestBody AnimalType animalType){
        return this.animalTypeService.update((animalType));
    }

}
