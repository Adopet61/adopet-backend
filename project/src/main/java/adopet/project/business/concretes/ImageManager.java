package adopet.project.business.concretes;

import adopet.project.business.abstracts.ImageService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.ErrorDataResult;
import adopet.project.core.utilities.results.SuccessDataResult;
import adopet.project.dataAccess.abstracts.ImageDao;
import adopet.project.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;

    @Autowired
    public ImageManager(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Resimler listelendi");
    }

    @Override
    public DataResult<List<Image>> getByImageId(int imageId) {
        if (this.imageDao.getByImageId(imageId).isEmpty()) {
            return new ErrorDataResult<List<Image>>("Girdiğiniz sayıda resim yoktur");
        }else {
            return new SuccessDataResult<List<Image>>
                    (this.imageDao.getByImageId(imageId), "Id'sine göre resim listelendi");
        }
    }
}
