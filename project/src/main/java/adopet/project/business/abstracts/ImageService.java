package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.Image;

import java.util.List;

public interface ImageService {
    DataResult<List<Image>> getAll();
    DataResult<List<Image>> getByImageId(int imageId);
}
