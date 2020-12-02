package org.jxgm.health;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;


class HealthSportApplicationTests {

/*    @Test
    void contextLoads() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthSport?useUnicode=true&characterEncoding=utf-8", "root", "luo123456");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from easyuser");
        User user = new User();
        while (resultSet.next()){
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setRole(resultSet.getString(5));
            user.setState(resultSet.getBoolean(6));
        }
        System.out.println(user);
    }*/

   /* @Test
    void test001(){
        int x = 10;
        int y = 0;
        int z = x / y; //算术异常
        System.out.println(z);
    }*/

/*   @Test
   void test003(){
       List<Integer> list = Arrays.asList(1,2,3,4,5,6);
       list.add(7);
       System.out.println(list);
   }*/

//    @Test
//    void test004(){
//        short s1 = 1;
////        s1 = (short) (s1 + 1);
//
//        s1 += 1;
//    }

    @Test
    void test005(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,60);
        String token = JWT.create()
                .withHeader(new HashMap<>()) //header
                .withClaim("id", "1") //payload
                .withClaim("username", "admin")
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256("!tokenadkjfdsf"));
        System.out.println(token);
    }

    @Test
    void test006(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!tokenadkjfdsf")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJleHAiOjE2MDYxMjc0MDIsInVzZXJuYW1lIjoiYWRtaW4ifQ.icLDntAn338WKYkEQsGJ1vi4KhdNCqm0x4JOppl4mqc");
        String username = verify.getClaim("id").asString();
        System.out.println(username);
    }
}

