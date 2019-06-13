package com.exam.examsystem.dao;

import com.exam.examsystem.po.UserPo;
import com.exam.examsystem.req.UserRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer userid);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

    UserPo selectByMobilePhone(@Param("mobilePhone") String mobilePhone);

    List<UserPo> selectAllUser(UserRequest filter);

    UserPo selectByLoginname(@Param("loginname") String loginname);

    int removeUserBatch(@Param("ids") String ids,@Param("userid") Integer userid);
}