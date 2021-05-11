import com.ch.chMbTest.ChMbApp;
import com.ch.chMbTest.entity.Privilege;
import com.ch.chMbTest.entity.Role;
import com.ch.chMbTest.entity.User;
import com.ch.chMbTest.repository.PrivilegeMapper;
import com.ch.chMbTest.repository.RoleMapper;
import com.ch.chMbTest.repository.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

//自定义数据访问层的单元测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChMbApp.class)
public class daoTest {
    //注入要测试的dao
    @Autowired
    private UserMapper um;
    @Autowired
    private PrivilegeMapper pm;
    @Autowired
    private RoleMapper rm;

    final private Logger logger= LoggerFactory.getLogger(daoTest.class);
    @Test
    public void daoService(){

        //User u=um.Sel(4);
        //System.out.println(u.toString());
        //logger.warn(u.toString());
        List<User> rl=um.GetAll();
        logger.warn("我吐了");
    }
    @Test
    public void insertUser(){
        User u1=new User();
        u1.setId(1);
        u1.setPassWord("54321");
        u1.setRealName("a？");
        u1.setUserName("gogogo0323");

        logger.warn("插入以后 该行的主键为"+String.valueOf(um.add(u1)));

    }

    @Test
    public void updateUser(){
        User u1=new User();
        u1.setId(1);
        u1.setPassWord("54321");
        u1.setRealName("role1role2");
        u1.setUserName("haveroles");
        u1.seteMail("2143@qq.com");
        um.update(u1);

    }

    @Test
    public void deleteById(){
        //um.deleteById(57);
        um.deleteById(56);
        um.deleteById(58);
        um.deleteById(66);
    }

    @Test
    public  void  selectByIdOrName(){
        User u1=new User();
        User u2=um.selectByIdOrUserName(u1);
        logger.warn(String.valueOf(u2==null));
        u1.setUserName("m290");
        u2=um.selectByIdOrUserName(u1);

        u1.setId(90);
        u2=um.selectByIdOrUserName(u1);

    }

    //foreach 测试
    @Test
    public void selectByIdList(){
        List<Integer> l=new ArrayList<>(Arrays.asList(55,67));
        um.selectByIdList(l);

    }

    //foreach测试批量插入
    @Test
    public void insertList(){
        List<User> res=new ArrayList<>();
        for(int i=0;i<3;i++){
            User u=new User();
            u.seteMail("123@ccty.com");
            u.setUserName("nt"+i+"hao");
            u.setRealName("naotan"+i+"hao");
            u.setPassWord("123465");
            res.add(u);

        }
        //返回的行数是影响的行数

        um.insertList(res);
    }

    //foreach实现根据map动态 update
    @Test
    public void updateByMap(){
        //要传入的map
        Map<String,Object> map=new HashMap<>();
        map.put("id",77);
        map.put("passWord","0329tttt");
        um.updateByMap(map);

    }

    //实现一对一的查询
    @Test
    public void selectUserAndRoleById(){
        User res= um.selectUserAndRoleById(1);
        logger.debug("res找到了");
    }

    //实现一对一的查询 resultMap查询
    @Test
    public void selectUserAndRoleById2(){
        User res= um.selectUserAndRoleById2(1);
        logger.debug("res找到了");
    }

    //测试简单的resultMap查询
    @Test
    public void selectById2(){
        User res=um.selectById2(1);
    }

    //实现一对一的查询 嵌套查询
    //执行了两次sql
    @Test
    public void selectUserAndRoleByIdSelect(){
        User res= um.selectUserAndRoleByIdSelect(1);
        logger.warn("调用equals");
        //设置了延迟加载以后 role不被访问就不会初始化 但是因为有些如equals会使得sql加载

        res.equals(null);
        logger.warn("调用getRole");
        Role rr=res.getRole();
        //logger.debug("res找到了");
    }
    //测试嵌套查询
    //
    // 的延迟加载sql 就是如果不去访问role 就不去查sql

    //一对多查询测试 一次sql
    @Test
    public void selctAllUserAndRoles(){
        List<User> res=um.selectAllUserAndRoles();
        logger.warn("res生成了");
    }


    //测试权限表配置
    @Test
    public  void  testPri(){
        Privilege res=pm.selectPrivilegeById(
                3
        );
    }

    //测试根据roleid查询权限
    @Test
    public void testPriRoleId(){
       List< Privilege> res=pm.selectPrivilegeByRoleId(1);

    }
    //测试根据userId查角色
    @Test
    public void testRolePriId(){
        List<Role>  res=rm.selectRoleByUserId(1);
        logger.warn("开始加载sql");
        Role rr=res.get(0);
        logger.warn(rr.toString());

    }

    //测试嵌套查询实现查找所有信息
    @Test
    public void testUserAll(){
        List<User> users=um.selectAllUserAndRolesByUserId();
        logger.warn("延迟加载sql");
        for(User u: users){
            if(u.getId()==1){
                logger.warn("查询user下面的role");
                List<Role> roleList=u.getRoleList();
                for(Role r:roleList){
                    logger.warn("查询role下面的privilege");
                    List<Privilege> privilegeList=r.getPrivilegeList();


                }
            }

        }

    }

    //存储过程1
    @Test
    public void selectUserById(){
        User u=new User();
        u.setId(88);
        logger.warn(
                "初始的user"+
                u.toString()
        );
        um.selectUserById(u);
        logger.warn(
                "查询之后的user"+
                        u.toString()
        );
        String p=u.getPassWord();
        logger.warn(p);

    }

    //存储过程2
    @Test
    public void selectUserPage(){
        //要传入的参数
        Map<String,Object> params=new HashMap<>();
        params.put("userName","gogogo");
        //其实这个分页就是对结果集合的切片

        params.put("offset",0);
        params.put("limit",4);

        List<User> res=um.selectUserPage(params);
        logger.warn("分页查询完毕");
    }

    //存储过程3
    //测试失败了 蛋疼。。
    @Test
    public void insertUserAndRole(){
        User u=new User();
        u.setPassWord("12345");
        u.setRealName("lch");
        u.seteMail("ccty.com");
        u.setUserName("pro3TEst2");
//        Map<String,Object> params=new HashMap<>();
//        params.put("user",u);
//        params.put("roleIds","1,2");


        //u.s
        int r=0;
        int res=um.insertUserAndRoles(u,"1,2");
        logger.warn("分页查询完毕");

    }

    //存储过程4
    @Test
    public void testPro44(){
        um.deleteUserById(101);
    }

    //角色服务测试
    @Test
    public void testSelectRole(){
        Role r= rm.selectRoleById(1);
        logger.warn("分页查询完毕");

    }

    //mybatis一级缓存的研究

}
