package org.wltea.analyzer.dao;

import lombok.Data;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

@Data
public class MysqlConnectionPool {

    private List<Connection> accessList = new LinkedList<>();

    private List<Connection> usingList = new LinkedList<>();
}
