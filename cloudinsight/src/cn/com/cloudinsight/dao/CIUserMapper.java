package cn.com.cloudinsight.dao;

import cn.com.cloudinsight.model.CIUser;
import cn.com.cloudinsight.model.CIUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CIUserMapper {
    int countByExample(CIUserExample example);

    int deleteByExample(CIUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(CIUser record);

    int insertSelective(CIUser record);

    List<CIUser> selectByExample(CIUserExample example);

    CIUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") CIUser record, @Param("example") CIUserExample example);

    int updateByExample(@Param("record") CIUser record, @Param("example") CIUserExample example);

    int updateByPrimaryKeySelective(CIUser record);

    int updateByPrimaryKey(CIUser record);
}