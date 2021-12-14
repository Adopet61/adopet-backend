package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;

import java.util.List;

public interface BaseEntityService<T> {
    DataResult<List<T>> getAll();
}
