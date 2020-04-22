package ${daoPackageName};

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ${entityPackageName}.${table_name};

/**
* 描述：${table_annotation} Dao层
* @author ${author}
* @date ${date}
*/
@Repository
public interface ${table_name}Mapper {

	${table_name} getById(Integer id);
	
	Integer count(@Param("queryMap") Map<String,Object> queryMap);
	
	List<${table_name}> queryMap(@Param("queryMap") Map<String,Object> queryMap,
				@Param("start") Integer start,@Param("end") Integer end);
	
	Integer add(${table_name} ${table_name?uncap_first});
	
	Integer edit(${table_name} ${table_name?uncap_first});
}