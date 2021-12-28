package adopet.project.business.concretes;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.business.abstracts.ImageService;
import adopet.project.core.utilities.cloudinary.CloudinaryService;
import adopet.project.core.utilities.results.*;
import adopet.project.dataAccess.abstracts.ImageDao;
import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private CloudinaryService cloudinaryService;
    private AnimalService animalService;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService, AnimalService animalService) {
        this.imageDao = imageDao;
        this.cloudinaryService = cloudinaryService;
        this.animalService = animalService;
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Resimler listelendi");
    }

    @Override
    public DataResult<Image> getByImageId(int imageId) {
        if (this.imageDao.findById(imageId).isEmpty()) {
            return new ErrorDataResult<Image>("Girdiğiniz sayıda resim yoktur");
        }else {
            return new SuccessDataResult<Image>
                    (this.imageDao.getByImageId(imageId), "Id'sine göre resim listelendi");
        }
    }

    @Override
    public DataResult<Image> getByAnimal_AnimalId(int animalId) {
        return new SuccessDataResult<Image>(this.imageDao.getByAnimal_AnimalId(animalId), "Tek animal getirildi");
    }

    @Override
    public DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrl() {
        return new SuccessDataResult<List<AnimalWithImageDto>>(this.imageDao.getAnimalWithImageUrl(),"Data listelendi");
    }

    @Override
    public DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrlByAnimal_AnimalType_TypeId(int typeId) {
        if (this.imageDao.getAnimalWithImageUrlByAnimal_AnimalType_TypeId(typeId).isEmpty()) {
            return new ErrorDataResult<List<AnimalWithImageDto>>("Girdiğiniz sayıda hayvan türü yoktur");
        }else {
            return new SuccessDataResult<List<AnimalWithImageDto>>
                    (this.imageDao.getAnimalWithImageUrlByAnimal_AnimalType_TypeId(typeId), "Türüne göre hayvanlar listelendi");
        }
    }

    @Override
    public Result upload(int animalId, MultipartFile file) {
        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryService.upload(file).getData();
        Image image = new Image();
        image.setAnimal(animalService.getById(animalId).getData());
        image.setUrl(uploadImage.get("url").toString());

        return add(image);
    }

    @Override
    public Result add(Image image) {
        imageDao.save(image);
        return new SuccessResult("Resim eklendi.");
    }

    @Override
    public Result delete(int imageId) {

        Image image = getByImageId(imageId).getData();

        String[] splitImageUrlArray = image.getUrl().split("/");
        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf(".");
        String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension);

        cloudinaryService.delete(publicIdOfImage);
        imageDao.deleteById(imageId);
        return new SuccessResult("Resim silindi.");
    }
}
