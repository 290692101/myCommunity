package com.ch.chMbTest.type;

//自定义mybatis的枚举类型处理器
//处理枚举类型Enabled

import com.ch.chMbTest.entity.Enabled;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* 数据库中的数据类型 */
//@MappedJdbcTypes(JdbcType.BIGINT)
////
/////* 转化后的数据类型 */
//@MappedTypes({Enabled.class})

public class EnabledTypeHandler implements TypeHandler<Enabled> {
    //一个私有的哈希表来表示映射关系
    private final Map<Integer,Enabled> enabledMap=new HashMap<>();

    //在构造器里初始化映射map
    public EnabledTypeHandler (){
        for(Enabled enabled:Enabled.values()){//遍历枚举类
            //以枚举类对应的数值为key 枚举类自身为value
            enabledMap.put(enabled.getValue(),enabled);
        }

    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Enabled enabled, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,enabled.getValue());
    }

    @Override
    public Enabled getResult(ResultSet resultSet, String columnName) throws SQLException {
        //这个是根据列名返回的
        Integer value=resultSet.getInt(columnName);
        return enabledMap.get(value);
    }

    @Override
    public Enabled getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        //这个应该是将列中存储的int值转换为 实体类中的枚举类型
        //所以map中的key为int value为枚举类型
        Integer value=resultSet.getInt(columnIndex);

        return enabledMap.get(value);
    }

    @Override
    public Enabled getResult(CallableStatement callableStatement, int i) throws SQLException {

        Integer value=callableStatement.getInt(i);
        return enabledMap.get(value);
    }
}
