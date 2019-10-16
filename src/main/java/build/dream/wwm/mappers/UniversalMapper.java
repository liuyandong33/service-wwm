package build.dream.wwm.mappers;

import build.dream.wwm.orm.DeleteModel;
import build.dream.wwm.orm.PagedSearchModel;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.orm.UpdateModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UniversalMapper {
    long insertAutoIncrement(Object domain);

    long insertAllAutoIncrement(List<?> domains);

    long insert(Object domain);

    long insertAll(List<?> domains);

    long delete(@Param("tableName") String tableName, @Param("deleteModel") DeleteModel deleteModel);

    long update(Object domain);

    long universalUpdate(@Param("tableName") String tableName, @Param("updateModel") UpdateModel updateModel);

    long executeUpdate(Map<String, Object> parameters);

    Map<String, Object> find(@Param("columns") String columns, @Param("tableName") String tableName, @Param("searchModel") SearchModel searchModel);

    List<Map<String, Object>> findAll(@Param("columns") String columns, @Param("tableName") String tableName, @Param("searchModel") SearchModel searchModel);

    long count(@Param("tableName") String tableName, @Param("searchModel") SearchModel searchModel);

    long universalCount(Map<String, Object> parameters);

    long pagedCount(@Param("tableName") String tableName, @Param("pagedSearchModel") PagedSearchModel pagedSearchModel);

    List<Map<String, Object>> findAllPaged(@Param("columns") String columns, @Param("tableName") String tableName, @Param("pagedSearchModel") PagedSearchModel pagedSearchModel);

    List<Map<String, Object>> executeQuery(Map<String, Object> parameters);

    Map<String, Object> executeUniqueResultQuery(Map<String, Object> parameters);
}
