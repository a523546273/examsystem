package com.exam.examsystem.dao;

import com.exam.examsystem.po.UserPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer userid);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

    UserPo selectByMobilePhone(@Param("mobilePhone") String mobilePhone);
}