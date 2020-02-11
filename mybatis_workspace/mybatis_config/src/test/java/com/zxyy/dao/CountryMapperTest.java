package com.zxyy.dao;

import com.zxyy.domain.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){
        try{
            //通过字符输入流读取mybatis-config配置文件，里面是连接数据库的参数和mapper的配置
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //再通过工厂构建对象，获取工厂对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFindAll(){
        //通过工厂对象，创建一个sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //通过id找到SQL语句,并执行
            List<Country> list = sqlSession.selectList("findAll");
            printData(list);
        }finally {
            sqlSession.close();
        }
    }

    //遍历集合并打印
    public <E> void printData(List<E> list){
        for (E e : list) {
            System.out.println(e.toString());
        }
    }
}
