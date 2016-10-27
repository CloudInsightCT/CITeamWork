package cn.com.cloudinsight.dao;

import cn.com.cloudinsight.model.FlatTable;
import cn.com.cloudinsight.model.FlatTableExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FlatTableMapper {
    int countByExample(FlatTableExample example);

    int deleteByExample(FlatTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlatTable record);

    int insertSelective(FlatTable record);

    List<FlatTable> selectByExample(FlatTableExample example);

    FlatTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlatTable record, @Param("example") FlatTableExample example);

    int updateByExample(@Param("record") FlatTable record, @Param("example") FlatTableExample example);

    int updateByPrimaryKeySelective(FlatTable record);

    int updateByPrimaryKey(FlatTable record);
    
    List<BigDecimal> getSpecificItemsByColumn(@Param("cols") List<String> cols, @Param("example") FlatTableExample example);  
}