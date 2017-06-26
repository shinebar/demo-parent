package com.wjs.service;

import com.google.common.base.Optional;
import com.wjs.entity.Account;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * Created by 341039 on 2016/12/21.
 */
public class AccountService2 {

    private final Logger logger= LoggerFactory.getLogger(AccountService2.class);

    @Autowired
    private TransactionTemplate template;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void insertName(){
        final Map<String ,Object> paramMap=new HashedMap();

        String sql="insert into account (name) values (:name) ";
        for(int i=0;i<100;i++){
            paramMap.put("name", "name"+i);
           int j= jdbcTemplate.update(sql,paramMap);
            logger.info(" insert into account values ()  {} ",j);
        }

    }

    @Cacheable(value="accountCache")
    public Account getAccountByName(String accountName) {
       logger.info("real querying acount ......{}",accountName);
        Optional<Account> accountOptional= getFromDB(accountName);
        if (!accountOptional.isPresent()){
            throw new IllegalStateException("can not find account by account name{}");
        }

        return accountOptional.get();
    }

    @CacheEvict(value = "accountCache",key = "#account.getName()")
    public void updateAccount(Account account){
        updateDB(account);
    }

    @CacheEvict(value="accountCache",key = "#account.getName()")
    public void reload(){

    }
    private void updateDB(Account account) {
        logger.info("real update db....{}", account.getName());
    }


    private Optional<Account> getFromDB(String accountName) {
        logger.info(" real querying db ..... {}",accountName);
         String sql="select * from account where 1=1 and name=:name";
        Object execute;
        Map<String,String> paramMap=new HashedMap();
        paramMap.put("name",accountName);
        execute = jdbcTemplate.queryForObject(sql, paramMap, new RowMapper<Account>() {
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
               return  new Account(resultSet.getString("name"));
            }
        });
        return Optional.fromNullable((Account) execute);
    }



}
