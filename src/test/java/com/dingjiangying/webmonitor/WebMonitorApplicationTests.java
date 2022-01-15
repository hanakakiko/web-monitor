package com.dingjiangying.webmonitor;

import com.dingjiangying.webmonitor.po.TaskPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class WebMonitorApplicationTests {

    @Autowired
    private TaskPo taskPo;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
//        System.out.println(task);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
