package adopet.project.api.controllers;

import adopet.project.business.abstracts.ImageService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<Image>> getByImageId(@RequestParam int imageId) {
        return this.imageService.getByImageId(imageId);
    }

    @GetMapping("/getAnimalWithImageUrl")
    public DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrl(){
        return this.imageService.getAnimalWithImageUrl();
    }
}
