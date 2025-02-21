package com.example.svsvdvdv.semiprojectv1.repository;

import com.example.svsvdvdv.semiprojectv1.domain.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

    @Insert("insert into members (userid, userpwd, name, email) values (#{userid},#{userpwd},#{name},#{email})")
    int insertMember(MemberDTO member);
}
