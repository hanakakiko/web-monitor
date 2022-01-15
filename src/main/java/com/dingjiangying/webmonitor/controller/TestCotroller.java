package com.dingjiangying.webmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class TestCotroller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/jdbc")
    public List<Map<String, Object>> taskList(){
        String sql = "select * from task";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/jdbcUpdate")
    public List<Map<String, Object>> add(){
        String sql = "insert into task values ('20220114003','test-3','3',null,'0','1','2')";
        jdbcTemplate.execute(sql);
        sql = "select * from task";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

}
