import com.yao.mybatis.models.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Jack Yao on 2022/2/19 4:55 PM
 */

public class MybatisDemo {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try{
            reader = Resources.getResourceAsReader("config/Configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            User user = (User) session.selectOne(
                    "com.yao.mybatis.models.UserMapper.GetUserByID",1
            );
            if (user != null){
                String userInfo = "名字：" + user.getName() +
                        ", 所屬部門："+user.getDept()+", 主頁："+user.getWebsite();
                System.out.println(userInfo);
            }
        }finally {
            session.close();
        }
    }
}
