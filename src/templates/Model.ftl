package ${package_name}.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
* 描述：${table_annotation}Model层
* @author ${author}
* @date ${date}
*/
@Component("${table_name?uncap_first}Model")
public class ${table_name}Model{

	@Resource(name = "${table_name?uncap_first}Dao")
	private I${table_name}Dao ${table_name?uncap_first}Dao;

	/**
     * 总数
     * @param queryMap
     * @return
     */
	public Integer count(Map<String,Object> queryMap){
		return ${table_name?uncap_first}Dao.count(queryMap);
	}

    /**
     * 分页查询
     * @return
     */
    public  List<${table_name}> queryMap(Map<String,Object> queryMap, Integer start, Integer end){
        List<${table_name}> result =  ${table_name?uncap_first}Dao.queryMap(queryMap, start, end);
        return result;
    }
    
    /**
     * 根据id查询
     * @return
     */
    public ${table_name} getById(Integer id){
        return ${table_name?uncap_first}Dao.getById(id);
    }

	public Integer add(${table_name} ${table_name?uncap_first}){
		return ${table_name?uncap_first}Dao.add(${table_name?uncap_first});
	}
	
	public Integer edit(${table_name} ${table_name?uncap_first}){
		return ${table_name?uncap_first}Dao.edit(${table_name?uncap_first});
	}
}