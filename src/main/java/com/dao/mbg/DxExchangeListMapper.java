package com.dao.mbg;

import com.model.po.DxExchangeList;
import com.model.po.DxExchangeListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DxExchangeListMapper {
    int countByExample(DxExchangeListExample example);

    int deleteByExample(DxExchangeListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DxExchangeList record);

    int insertSelective(DxExchangeList record);

    List<DxExchangeList> selectByExample(DxExchangeListExample example);

    DxExchangeList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DxExchangeList record, @Param("example") DxExchangeListExample example);

    int updateByExample(@Param("record") DxExchangeList record, @Param("example") DxExchangeListExample example);

    int updateByPrimaryKeySelective(DxExchangeList record);

    int updateByPrimaryKey(DxExchangeList record);
}