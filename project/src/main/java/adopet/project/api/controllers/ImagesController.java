package adopet.project.api.controllers;

import adopet.project.business.abstracts.ImageService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/images")
@CrossOrigin
public class ImagesController {

    private ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/getall")
    public DataResult<List<Image>> getAll() {
        return this.imageService.getAll();
    }

    @GetMapping("/getByImageId")
    public DataResult<Image> getByImageId(@RequestParam int imageId) {
        return this.imageService.getByImageId(imageId);
    }

    @GetMapping("/getByAnimalId")
    public DataResult<Image> getByAnimal_AnimalId(@RequestParam int animalId) {
        return this.imageService.getByAnimal_AnimalId(animalId);
    }

    @GetMapping("/getAnimalWithImageUrl")
    public DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrl(){
        return this.imageService.getAnimalWithImageUrl();
    }

    @GetMapping("/getAnimalWithImageUrlByTypeId")
    public DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrlByAnimal_AnimalType_TypeId(@RequestParam int typeId) {
        return this.imageService.getAnimalWithImageUrlByAnimal_AnimalType_TypeId(typeId);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam int animalId, @RequestPart("file") MultipartFile file) {
        return this.imageService.upload(animalId, file);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int imageId) {
        return imageService.delete(imageId);
    }
}
