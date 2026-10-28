package com.thequiett.firstboard.task;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskMapper {

    List<TaskResponse> search(@Param("request") TaskSearchRequest request);
}
