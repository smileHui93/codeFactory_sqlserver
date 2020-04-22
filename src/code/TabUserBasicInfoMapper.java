package com.mapper.sqlserver;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.entity.TabUserBasicInfo;

/**
* 描述：代理商信息 Dao层
* @author linhuang
* @date 2020/04/19
*/
@Repository
public interface TabUserBasicInfoMapper {

	TabUserBasicInfo getById(Integer id);
	
	Integer count(@Param("queryMap") Map<String,Object> queryMap);
	
	List<TabUserBasicInfo> queryMap(@Param("queryMap") Map<String,Object> queryMap,
				@Param("start") Integer start,@Param("end") Integer end);
	
	Integer add(TabUserBasicInfo tabUserBasicInfo);
	
	Integer edit(TabUserBasicInfo tabUserBasicInfo);
}