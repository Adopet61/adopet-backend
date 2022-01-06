package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;

import java.util.List;

public interface BaseEntityService<T> { //Generic yapı
    DataResult<List<T>> getAll();
    Result add(T entity);
    Result update(T entity);
}
